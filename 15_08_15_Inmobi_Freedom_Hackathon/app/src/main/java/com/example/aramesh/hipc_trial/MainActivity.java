package com.example.aramesh.hipc_trial;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;


    private CharSequence mTitle;

    int flag = 0;

    private RadioGroup radioUTGroup;
    private RadioButton radioUTButton; //UserType
    private Button btnDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);

        Intent intent;
        intent = new Intent(MainActivity.this,
                LoginActivity.class);
        startActivity(intent);
        addListenerOnButton();
        finish();
    }

    public void addListenerOnButton() {

        radioUTGroup = (RadioGroup) findViewById(R.id.radioGroup);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioUTGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioUTButton = (RadioButton) findViewById(selectedId);

                if (radioUTButton.getText() == "Admin")
                {
                    Intent intent;
                    intent = new Intent(MainActivity.this,
                            AdminActivity.class);
                    startActivity(intent);
                    addListenerOnButton();
                    finish();
                }

                Toast.makeText(MainActivity.this,
                        radioUTButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });

    }


}
