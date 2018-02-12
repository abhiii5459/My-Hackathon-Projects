package com.example.aramesh.hipc_trial;import android.app.Activity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import javax.net.ssl.HttpsURLConnection;

public class HTTPRequest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_screen);
        Toast.makeText(getApplicationContext(),
                "INSTASADASDAS",
                Toast.LENGTH_SHORT).show();
        Bundle bundle = getIntent().getExtras();
        String phoneNumber = bundle.getString("phoneNumber");
        String orgId = bundle.getString("orgId");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

//        HttpClient httpClient = new DefaultHttpClient();
//        // replace with your url
//        HttpPost httpPost = new HttpPost("http://10.14.120.130/server/suRegister.php");
//
//
//        //Post Data
//        List<HashMap> nameValuePair = new ArrayList<HashMap>(2);
//        nameValuePair.add(new BasicNameValuePair("phoneNumber", phoneNumber));
//        nameValuePair.add(new BasicNameValuePair("orgId", orgId));
//
//
//        //Encoding POST data
//        try {
//            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
//        } catch (UnsupportedEncodingException e) {
//            // log exception
//            e.printStackTrace();
//        }
//
//        //making POST request.
//        try {
//            HttpResponse response = httpClient.execute(httpPost);
//            // write response to log
//            Toast.makeText(getApplicationContext(),
//                    "Http Post Response:"+response.toString(),
//                    Toast.LENGTH_LONG).show();
//
//        } catch (ClientProtocolException e) {
//            // Log exception
//            e.printStackTrace();
//        } catch (IOException e) {
//            // Log exception
//            e.printStackTrace();
//        }

       // makePostRequest();
        try
        {
            String urlParameters = "orgId="+orgId+"&phoneNumber="+phoneNumber;
            sendPost(urlParameters,"http://10.14.120.130/server/suRegister.php",0);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public StringBuffer sendPost(String urlParameters,String url,int n) throws Exception {

       // String url = "http://10.14.120.130/server/suRegister.php";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        //String urlParameters =

        // Send post request
        con.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        //System.out.println("Post parameters : " + urlParameters);
       // System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        if(n==0) {
            Toast.makeText(getApplicationContext(), "\nSending 'POST' request to URL : " + response, Toast.LENGTH_LONG).show();

        }
        in.close();

        //print result
        System.out.println(response.toString());

        return  response;
    }


}