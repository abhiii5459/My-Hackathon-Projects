package com.example.aramesh.hipc_trial;

/**
 * Created by aramesh on 15/08/15.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AdminActivityLogin extends Activity {

    // Declare Variable
    Button logout,back_btn,submit_btn;

    TextView txtmobnum;
    TextView txtorgid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.admin_screen);

        // Retrieve current user from Parse.com
        // ParseUser currentUser = ParseUser.getCurrentUser();

        // Convert currentUser into String
        //String struser = currentUser.getUsername().toString();

        // Locate TextView in welcome.xml
        txtmobnum = (TextView) findViewById(R.id.mobnum);
        txtorgid = (TextView) findViewById(R.id.orgId);

//
//        // Set the currentUser String into TextView
//
//        // Locate Button in welcome.xml
//        logout = (Button) findViewById(R.id.logout);

        //Locate Back Button
        back_btn = (Button)findViewById(R.id.backbtn);
        submit_btn = (Button)findViewById(R.id.submit);
        // Back Button Click Listener

        back_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.loginsignup);
                finish();
            }
        });

        // Submit Button Click Listener
        submit_btn.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // Logout current user
                Bundle bundle = new Bundle();

                bundle.putString("phoneNumber",txtmobnum.getText()+"");
                bundle.putString("orgId",txtorgid.getText()+"");
                Intent myIntent = new Intent();
                myIntent.setClass(AdminActivityLogin.this, HTTPRequest.class);

                myIntent.putExtras(bundle);


                startActivity(myIntent);
                //  ParseUser.logOut();
                finish();
            }
        });
    }
}
