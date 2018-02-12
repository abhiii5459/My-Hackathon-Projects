package com.example.aramesh.hipc_trial;

/**
 * Created by aramesh on 15/08/15.
 */


import java.util.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Admin_Dashboard extends Activity {

    // Declare Variable
    Button logout,back_btn,submit_btn;

    TextView txtmobnum;
    TextView txtorgid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.admin_dashboard);
        final Spinner categories = (Spinner) findViewById(R.id.categories);
        categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedCategory = parentView.getItemAtPosition(position).toString();
                if (selectedCategory.equals("Blood")) {
                    String[] populated = getResources().getStringArray(R.array.spinner_bg);
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(Admin_Dashboard.this, android.R.layout.simple_spinner_dropdown_item, populated);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    final Spinner populate = (Spinner) findViewById(R.id.populated);
                    populate.setAdapter(dataAdapter);
                } else {
                    String[] populated = {};
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(Admin_Dashboard.this, android.R.layout.simple_spinner_dropdown_item, populated);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    final Spinner populate = (Spinner) findViewById(R.id.populated);
                    populate.setAdapter(dataAdapter);
                }
                //Toast.makeText(MainActivity.this,  selectedCategory , Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
            public void request(View view) {
                final Spinner populate = (Spinner) findViewById(R.id.populated);
                String selectedBloodGroup = (String)populate.getSelectedItem();
                Map Bloodchart = new HashMap();
                Bloodchart.put("ABP","OP ON AP BP BN ABP ABN");
                Bloodchart.put("ABN","ON AN BN ABN");
                Bloodchart.put("AP","OP ON AP AN");
                Bloodchart.put("AN","ON AN");
                Bloodchart.put("BP","OP ON BP BP");
                Bloodchart.put("BN","ON BN");
                Bloodchart.put("OP", "OP ON");
                Bloodchart.put("ON", "ON");


                String stri= (Bloodchart.get(selectedBloodGroup)).toString();

                Toast.makeText(Admin_Dashboard.this, stri, Toast.LENGTH_SHORT).show();


                String stri2= (String) (Bloodchart.get(selectedBloodGroup));
                HTTPRequest req= new HTTPRequest();

                try {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                    StrictMode.setThreadPolicy(policy);

                    StringBuffer response = req.sendPost("bloodGroups="+stri,"http://10.14.120.130/server/getListOfDonors.php",1);
                    Toast.makeText(getApplicationContext(), "\nSending 'POST' request to URL : " + response+"", Toast.LENGTH_LONG).show();

//                    if(response.toString().equals("admin"))
//                    {
//                        Intent intent = new Intent(
//                                Admin_Dashboard.this,
//                                Admin_Dashboard.class);
//                        startActivity(intent);
//                    }


                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }


