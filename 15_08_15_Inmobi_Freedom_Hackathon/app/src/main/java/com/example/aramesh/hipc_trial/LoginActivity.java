package com.example.aramesh.hipc_trial;import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class LoginActivity extends Activity {
    // Declare Variables
    Button loginbutton;
    Button signup;
    String usernametxt;
    String passwordtxt;
    EditText password;
    EditText username;
    EditText mobNum;
     RadioGroup radioUTGroup;
     RadioButton radioUTButton; //UserType


    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from main.xml
        setContentView(R.layout.loginsignup);
        // Locate EditTexts in main.xml
      //  username = (EditText) findViewById(R.id.username);
     //   password = (EditText) findViewById(R.id.password);
        mobNum = (EditText) findViewById(R.id.mobnum);
        // Locate Buttons in main.xml
        loginbutton = (Button) findViewById(R.id.login);
        signup = (Button) findViewById(R.id.signup);

        radioUTGroup = (RadioGroup) findViewById(R.id.radioGroup);

        // Login Button Click Listener
        signup.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // Retrieve the text entered from the EditText
               // usernametxt = username.getText().toString();
           //     passwordtxt = password.getText().toString();

                // Send data to Parse.com for verification
//                ParseUser.logInInBackground(usernametxt, passwordtxt,
//                        new LogInCallback() {
//                            public void done(ParseUser user, ParseException e) {
//                                if (user != null) {
//                                    // If user exist and authenticated, send user to Welcome.class

                int selectedId = radioUTGroup.getCheckedRadioButtonId();


                if(radioUTGroup.getCheckedRadioButtonId()!=-1){
                    int id= radioUTGroup.getCheckedRadioButtonId();
                    View radioButton = radioUTGroup.findViewById(id);
                    int radioId = radioUTGroup.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) radioUTGroup.getChildAt(radioId);
                    String selection = (String) btn.getText();

                // find the radiobutton by returned id
                radioUTButton = (RadioButton) findViewById(selectedId);


                if (selection.equals("Admin")) {

                    Intent intent = new Intent(
                            LoginActivity.this,
                            AdminActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),
                            "Successfully entered , please signup as admin.",
                            Toast.LENGTH_LONG).show();
                    finish();
                }
                else if (selection.equals("User"))
                {
                    Intent intent = new Intent(
                            LoginActivity.this,
                            UserActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),
                            "Successfully entered , please signup as user .",
                            Toast.LENGTH_LONG).show();
                    finish();
                }}
//                                } else {
//                                    Toast.makeText(
//                                            getApplicationContext(),
//                                            "No such user exist, please signup",
//                                            Toast.LENGTH_LONG).show();
//                                }
//                            }
//                        });
            }
        });
        // Sign up Button Click Listener
        loginbutton.setOnClickListener(new OnClickListener() {

            HTTPRequest req= new HTTPRequest();

            public void onClick(View arg0) {
                // Retrieve the text entered from the EditText
            //    usernametxt = username.getText().toString();
             //   passwordtxt = password.getText().toString();

                // Force user to fill up the form
                if (mobNum.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please complete the sign up form",
                            Toast.LENGTH_LONG).show();

                }
                else {

//                    // Save new user data into Parse.com Data Storage
//                    ParseUser user = new ParseUser();
//                    user.setUsername(usernametxt);
//                    user.setPassword(passwordtxt);
//                    user.signUpInBackground(new SignUpCallback() {
//                        public void done(ParseException e) {
//                            if (e == null) {
//                                // Show a simple Toast message upon successful registration
//
                    try {
                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                        StrictMode.setThreadPolicy(policy);
                        Toast.makeText(getApplicationContext(),
                                "phoneNumber="+mobNum.getText()+"",
                                Toast.LENGTH_SHORT).show();

                        StringBuffer response = req.sendPost("phoneNumber="+mobNum.getText()+"","http://10.14.120.130/server/login.php",1);
                        Toast.makeText(getApplicationContext(), "\nSending 'POST' request to URL : " + response, Toast.LENGTH_LONG).show();

                        if(response.toString().equals("admin"))
                        {
                            Intent intent = new Intent(
                                    LoginActivity.this,
                                    Admin_Dashboard.class);
                            startActivity(intent);
                        }


                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }

//                               Toast.makeText(getApplicationContext(),
//                                        "Successfully Logged in.",
//                                       Toast.LENGTH_SHORT).show();
//                            } else {
//                                Toast.makeText(getApplicationContext(),
//                                        "Sign up Error", Toast.LENGTH_LONG)
//                                        .show();
//                            }
//                        }
//                    });
                }

            }
        });

    }
}