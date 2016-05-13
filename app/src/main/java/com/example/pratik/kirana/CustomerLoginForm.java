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

public class CustomerLoginForm extends AppCompatActivity {

    Button buttonLoginCustomer;
    TextView textViewSignUpCustomer;
    EditText editTextUsernameCustomer, editTextPasswordCustomer;
    ImageView imageViewOnLoginPageCustomer;
    ProgressDialog progressDialog;
    String CustomerLoginUrl = "http://192.168.43.35:80/kirana/customer_login.php";
    String UsernameCustomer, PasswordCustomer, response;

    private static final long GET_DATA_INTERVAL = 2000;
    int images[] = { R.drawable.i6, R.drawable.i5, R.drawable.i7, R.drawable.i8, R.drawable.i9, R.drawable.i11, R.drawable.i13,
            R.drawable.i14, R.drawable.i15, R.drawable.i16 };
    int index=0;

    Handler hand = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewSignUpCustomer = (TextView) findViewById(R.id.textViewSignUpCustomer);

        editTextUsernameCustomer = (EditText) findViewById(R.id.editTextUsernameCustomer);
        editTextPasswordCustomer = (EditText) findViewById(R.id.editTextPasswordCustomer);

        imageViewOnLoginPageCustomer = (ImageView) findViewById(R.id.imageViewOnLoginPageCustomer);

        buttonLoginCustomer = (Button) findViewById(R.id.buttonLoginCustomer);

        buttonLoginCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomerLogin().execute();
            }
        });


        textViewSignUpCustomer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent i = new Intent(CustomerLoginForm.this, CustomerSignUpForm.class);
                startActivity(i);
            }
        });

        hand.postDelayed(r, GET_DATA_INTERVAL);
    }

    class CustomerLogin extends AsyncTask<String,Void,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            UsernameCustomer = editTextUsernameCustomer.getText().toString();
            PasswordCustomer = editTextPasswordCustomer.getText().toString();

            progressDialog = new ProgressDialog(CustomerLoginForm.this);
            progressDialog.setMessage("Processing...");
            progressDialog.setIndeterminate(false);
            progressDialog.setTitle("Logging In");
            progressDialog.show();

        }

        @Override
        protected String doInBackground(String... params) {
            response = null;

            try {
                URL url = new URL(CustomerLoginUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(1000 * 15);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String DATA = URLEncoder.encode("usernameCustomer","UTF-8") + "=" + URLEncoder.encode(UsernameCustomer,"UTF-8") +"&"+
                        URLEncoder.encode("passwordCustomer","UTF-8")+ "=" + URLEncoder.encode(PasswordCustomer,"UTF-8");

                bufferedWriter.write(DATA);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                response = "";
                String line;

                while((line = bufferedReader.readLine()) != null){
                    response += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.e("Log",response);

            return response;
        }

        @Override
        protected void onPostExecute(String s) {

            progressDialog.dismiss();
            if (s.equals("Success")){
                Toast.makeText(CustomerLoginForm.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CustomerLoginForm.this, GridMainActivity.class);
                intent.putExtra("username_customer",UsernameCustomer);
                startActivity(intent);
            }
            else {
                Toast.makeText(CustomerLoginForm.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    Runnable r = new Runnable() {

        public void run() {
            // TODO Auto-generated method stub
            imageViewOnLoginPageCustomer.setBackgroundDrawable(getResources().getDrawable(images[index++]));
            if(index == images.length)
                index = 0;
            hand.postDelayed(r, GET_DATA_INTERVAL);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        //getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId())
        {
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
