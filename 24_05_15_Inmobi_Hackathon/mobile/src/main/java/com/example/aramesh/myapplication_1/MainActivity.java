//package com.example.aramesh.myapplication_1;
//
//import android.support.v7.app.ActionBarActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//
//
//public class MainActivity extends ActionBarActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
package com.example.aramesh.myapplication_1;

/**
 * Created by aramesh on 23/05/15.
 */

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.System.exit;

public class MainActivity extends Activity implements AccelerometerListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check onResume Method to start accelerometer listener
    }

    public void onAccelerationChanged(float x, float y, float z) {
        // TODO Auto-generated method stub

    }

    int count =0;
    public void onShake(float force) {

        // Do your stuff here

        // Called when Motion Detected
//        Toast.makeText(getBaseContext(), "Motion detected",
//                Toast.LENGTH_SHORT).show();
        count++;
        Toast.makeText(getBaseContext(),"Motion detected.Number of shakes="+count,Toast.LENGTH_SHORT).show();
        if(count==15) {
            count=0;
            Intent i = getBaseContext().getPackageManager()
                    .getLaunchIntentForPackage(getBaseContext().getPackageName());
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            Bundle savedInstanceState = null;
//          //  System.exit(2);
//            startActivity(i);
           // Intent i = new Intent(this, WrapperActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
            AccelerometerManager.stopListening();

            startActivity(i);
        //    setContentView(R.layout.activity_main);

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getBaseContext(), "onResume Accelerometer Started",
                Toast.LENGTH_SHORT).show();

        //Check device supported Accelerometer senssor or not
        if (AccelerometerManager.isSupported(this)) {

          //  Toast.makeText(getBaseContext(),"This is happening",Toast.LENGTH_SHORT).show();
            //Start Accelerometer Listening
            AccelerometerManager.startListening(this);
        }
    }

    int countdel=0;
    int countdel2=0;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        String phoneNumber="+917795295605";
        String message="5 backspaces";
        String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
                new Intent(SENT), 0);

        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
                new Intent(DELIVERED), 0);

        switch (keyCode) {
            case KeyEvent.KEYCODE_DEL:
            {
                Toast.makeText(getBaseContext(), "Reached DEL",
                        Toast.LENGTH_SHORT).show();
                countdel++;
                Log.i("MainActivity","Countdel="+(countdel+""));
                if(countdel==5)
                {
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
                    count=0;
                    moveTaskToBack(true);
                    count=0;
//                Intent i = getBaseContext().getPackageManager()
//                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
////            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////            Bundle savedInstanceState = null;
////          //  System.exit(2);
////            startActivity(i);
//                // Intent i = new Intent(this, WrapperActivity.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                //  AccelerometerManager.stopListening();
//
//                startActivity(i);
                }
         /* This is a sample for handling the Enter button */
                return true;
        }
            case KeyEvent.KEYCODE_BACK:
            {
                onDestroy();
                return false;
            }
        }
        return false;
    }
   // @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//
//
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_DEL: {
//                event.startTracking();
////                Toast.makeText(getBaseContext(), "Reached DEL",
////                        Toast.LENGTH_SHORT).show();
//
////                countdel2++;
////                if(countdel2==1)
////            {
////                Toast.makeText(getBaseContext(), "STOP SMOKING BITCH",
////                        Toast.LENGTH_SHORT).show();
////            }
//                return true;
//
//            }
//
//        }
//        return super.onKeyDown(keyCode, event);
//
//    }

    public void startAlert(View view) {
        String phoneNumber="+917795295605";
        String message="Wrong key typed";
        String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
                new Intent(SENT), 0);

        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
                new Intent(DELIVERED), 0);
        EditText text = (EditText) findViewById(R.id.time);
        String text2=text.getText().toString();
        //int i = Integer.parseInt(text.getText().toString());
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
//        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
//                + (i * 1000), pendingIntent);
//        Toast.makeText(this, "Alarm set in " + i + " seconds",
//                Toast.LENGTH_LONG).show();
        if(text2.contentEquals("Alskdjfhg"))
        {
            Toast.makeText(this,"you're fine",Toast.LENGTH_LONG).show();
            count=0;

            Intent i = getBaseContext().getPackageManager()
                    .getLaunchIntentForPackage(getBaseContext().getPackageName());
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            Bundle savedInstanceState = null;
//          //  System.exit(2);
//            startActivity(i);
            // Intent i = new Intent(this, WrapperActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            //   AccelerometerManager.stopListening();

            startActivity(i);
            moveTaskToBack(true);

        }
        else if((!text2.contentEquals("Alskdjfhg"))||(count==14 && text2.length()<9))
        {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
            count=0;
            moveTaskToBack(true);
            count=0;
            Intent i = getBaseContext().getPackageManager()
                    .getLaunchIntentForPackage(getBaseContext().getPackageName());
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            Bundle savedInstanceState = null;
//          //  System.exit(2);
//            startActivity(i);
            // Intent i = new Intent(this, WrapperActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
          //  AccelerometerManager.stopListening();

            startActivity(i);

        }
    }

//    @Override
//    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
//
//
//        if (keyCode == KeyEvent.KEYCODE_DEL)
//        {
//            Toast.makeText(getBaseContext(), "Reached long del",
//                    Toast.LENGTH_SHORT).show();
//            countdel++;
//            if(countdel>1)
//            {
//                Toast.makeText(getBaseContext(), "STOP SMOKING BITCH",
//                        Toast.LENGTH_SHORT).show();
//            }
//            // do your stuff here
//            return true;
//        }
//        return super.onKeyLongPress(keyCode, event);
//    }

    @Override
    public void onStop() {
        super.onStop();

        //Check device supported Accelerometer senssor or not
        if (AccelerometerManager.isListening()) {

            //Start Accelerometer Listening
            AccelerometerManager.startListening(this);

            Toast.makeText(getBaseContext(), "onStop Accelerometer maintained.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Sensor", "Service  destroy");

        //Check device supported Accelerometer senssor or not
        if (AccelerometerManager.isListening()) {

            //Start Accelerometer Listening
            AccelerometerManager.stopListening();

            Toast.makeText(getBaseContext(), "onDestroy Accelerometer Stopped",
                    Toast.LENGTH_SHORT).show();
        }
        exit(-2);

    }

}