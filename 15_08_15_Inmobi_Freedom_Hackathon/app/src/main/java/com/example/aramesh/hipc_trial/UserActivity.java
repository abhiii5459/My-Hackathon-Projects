package com.example.aramesh.hipc_trial;

/**
 * Created by aramesh on 15/08/15.
 */


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class UserActivity extends Activity  {

    // Declare Variable
    Button logout,back_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.user_screen);


        Spinner spinner = (Spinner) findViewById(R.id.spinner_bg);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_bg, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_sex);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.spinner_sex, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);
        // Retrieve current user from Parse.com
        // ParseUser currentUser = ParseUser.getCurrentUser();



        Spinner spinner3 = (Spinner) findViewById(R.id.spinnerloc);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.spinnerloc, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner3.setAdapter(adapter3);
        // Convert currentUser into String
        //String struser = currentUser.getUsername().toString();

        // Locate TextView in welcome.xml
//        TextView txtuser = (TextView) findViewById(R.id.txtuser);
//
//        // Set the currentUser String into TextView
//        txtuser.setText("You are logged in "); //as " + struser);
//
//        // Locate Button in welcome.xml
//        logout = (Button) findViewById(R.id.logout);

        //Locate Back Button
        back_btn = (Button)findViewById(R.id.backbtn);

        // Back Button Click Listener

        back_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.loginsignup);
                finish();
            }
        });

//        // Logout Button Click Listener
//        logout.setOnClickListener(new OnClickListener() {
//
//            public void onClick(View arg0) {
//                // Logout current user
//                //  ParseUser.logOut();
//                finish();
//            }
//        });
    }
}