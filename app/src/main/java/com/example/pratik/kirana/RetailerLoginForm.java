package com.example.pratik.kirana;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class RetailerLoginForm extends AppCompatActivity {

    EditText editTextUsernameRetailer, editTextPasswordRetailer;
    Button buttonLoginRetailer;
    TextView textViewSignUpRetailer;
    ImageView imageViewOnLoginPageRetailer;
    String UsernameRetailer, PasswordRetailer;
    ProgressDialog progressDialog;
    final String RetailerLoginUrl = "http://192.168.43.35:80/kirana/retailer_login.php";
    int timeOutMillis = 1000 * 15;
    //String b;

    private static final long GET_DATA_INTERVAL = 2000;
    int images[] = { R.drawable.i6, R.drawable.i5, R.drawable.i7,
            R.drawable.i8, R.drawable.i9, R.drawable.i11, R.drawable.i13,
            R.drawable.i14, R.drawable.i15, R.drawable.i16 };
    int index=0;

    Handler hand = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_login_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageViewOnLoginPageRetailer = (ImageView) findViewById(R.id.imageViewOnLoginPageRetailer);
        editTextUsernameRetailer = (EditText) findViewById(R.id.editTextUsernameRetailer);
        editTextPasswordRetailer = (EditText) findViewById(R.id.editTextPasswordRetailer);
        textViewSignUpRetailer = (TextView) findViewById(R.id.textViewSignUpRetailer);
        buttonLoginRetailer = (Button) findViewById(R.id.buttonLoginRetailer);


        buttonLoginRetailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                String method = "RetailerLogin";
                BackgroundTask backgroundTask = new BackgroundTask(RetailerLoginForm.this);
                backgroundTask.execute(method, UsernameRetailer, PasswordRetailer);

                startActivity(new Intent(RetailerLoginForm.this,RetailerSignUpForm.class));*/
                /*b = String.valueOf(backgroundTask.a);
                if (b.equals("Login_Failed")) {
                    Toast.makeText(RetailerLoginForm.this,"Login Failed", Toast.LENGTH_LONG).show();
                }else {
                    startActivity(new Intent(RetailerLoginForm.this,RetailerSignUpForm.class));
                }*/
                new RetailerLogin().execute();
            }
        });

        textViewSignUpRetailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RetailerLoginForm.this, RetailerSignUpForm.class);
                startActivity(i);
            }
        });

        hand.postDelayed(r, GET_DATA_INTERVAL);

    }


    class RetailerLogin extends AsyncTask<String,Void,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            UsernameRetailer = editTextUsernameRetailer.getText().toString();
            PasswordRetailer = editTextPasswordRetailer.getText().toString();

            progressDialog = new ProgressDialog(RetailerLoginForm.this);
            progressDialog.setTitle("Processing...");
            progressDialog.setMessage("Registering...");
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            String response;
            response = null;
            try {

                URL url = new URL(RetailerLoginUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(timeOutMillis);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data = URLEncoder.encode("usernameRetailer", "UTF-8") + "=" + URLEncoder.encode(UsernameRetailer, "UTF-8") + "&" +
                        URLEncoder.encode("passwordRetailer", "UTF-8") + "=" + URLEncoder.encode(PasswordRetailer, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                response = "";

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();


            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();

            Log.e("Log", s);

            if (s.equals("Failed")){
                Toast.makeText(RetailerLoginForm.this, "Username or Password is Incorrect", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(RetailerLoginForm.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RetailerLoginForm.this, ListOfItemCustomerActivity.class);
                intent.putExtra("Username of Retailer",UsernameRetailer);
                intent.putExtra("UserName", UsernameRetailer);
                intent.putExtra("user_retailer", UsernameRetailer);
                startActivity(intent);
            }
        }
    }

    Runnable r = new Runnable() {

        public void run() {
            // TODO Auto-generated method stub
            imageViewOnLoginPageRetailer.setBackgroundDrawable(getResources().getDrawable(images[index++]));

            if(index == images.length)
                index = 0;
            hand.postDelayed(r, GET_DATA_INTERVAL);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.action_refresh:
                return true;

            case R.id.action_help:
                return true;

            case R.id.action_logout:
                return true;

            case R.id.action_exit:
                appExit();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void appExit() {
        // TODO Auto-generated method stub
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
