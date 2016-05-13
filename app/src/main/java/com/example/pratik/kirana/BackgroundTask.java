package com.example.pratik.kirana;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String,Void,String> {

    String SelectedUrlForCustomer, SelectedUrlForRetailer;
    AlertDialog alertDialog;
    ProgressDialog progressDialog;
    Context ctx;
    //String response;
    int timeOutMillis = 1000 * 15;
    String idOfCustomer,idOfRetailer;
    //int a;

    BackgroundTask(Context ctx){ this.ctx = ctx; }

    @Override
    protected void onPreExecute() {

        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setMessage("Login Information...");

        progressDialog = new ProgressDialog(ctx);
        progressDialog.setTitle("Processing...");
        progressDialog.setMessage("Registering...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    @Override
    protected String doInBackground(String... params) {
        final String RetailerRegistrationUrl = "http://192.168.43.35:80/kirana/retailer_sign_up.php";
        final String CustomerRegistrationUrl = "http://192.168.43.35:80/kirana/customer_sign_up.php";

        String method = params[0];
        switch (method) {
            case "RetailerRegistration":
                String RetailerFirstName = params[1];
                String RetailerLastName = params[2];
                String RetailerUsername = params[3];
                String RetailerPassword = params[4];
                String RetailerMobileNo = params[5];
                String RetailerDateOfBirth = params[6];
                String RetailerArea = params[7];
                String FromUpdateOrNotRetailer = params[8];
                idOfRetailer = params[9];

                final String RetailerUpdateUrl = "http://192.168.43.35:80/kirana/update_retailer.php?idOfRetailer="+idOfRetailer;

                Log.e("!@!@!@!@!@!",idOfRetailer);
                Log.e("url!@!@!@",idOfRetailer);

                try {


                    if (FromUpdateOrNotRetailer == null){
                        SelectedUrlForRetailer = RetailerRegistrationUrl;
                    } else {
                        SelectedUrlForRetailer = RetailerUpdateUrl;
                    }

                    URL url = new URL(SelectedUrlForRetailer);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setConnectTimeout(timeOutMillis);

                    OutputStream OS = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                    String data = URLEncoder.encode("r_first_name", "UTF-8") + "=" + URLEncoder.encode(RetailerFirstName, "UTF-8") + "&" +
                            URLEncoder.encode("r_last_name", "UTF-8") + "=" + URLEncoder.encode(RetailerLastName, "UTF-8") + "&" +
                            URLEncoder.encode("r_username", "UTF-8") + "=" + URLEncoder.encode(RetailerUsername, "UTF-8") + "&" +
                            URLEncoder.encode("r_password", "UTF-8") + "=" + URLEncoder.encode(RetailerPassword, "UTF-8") + "&" +
                            URLEncoder.encode("r_mobile_no", "UTF-8") + "=" + URLEncoder.encode(RetailerMobileNo, "UTF-8") + "&" +
                            URLEncoder.encode("r_date_of_birth", "UTF-8") + "=" + URLEncoder.encode(RetailerDateOfBirth, "UTF-8") + "&" +
                            URLEncoder.encode("r_area", "UTF-8") + "=" + URLEncoder.encode(RetailerArea, "UTF-8");

                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    OS.close();

                    InputStream IS = httpURLConnection.getInputStream();
                    IS.close();
                    return "Retailer Registration Success...";

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "CustomerRegistration": {
                String CustomerFirstName = params[1];
                String CustomerLastName = params[2];
                String CustomerUsername = params[3];
                String CustomerPassword = params[4];
                String CustomerMobileNo = params[5];
                String CustomerDateOfBirth = params[6];
                String CustomerArea = params[7];
                String FromUpdateOrNotCustomer = params[8];
                idOfCustomer = params[9];

                final String CustomerUpdateUrl = "http://192.168.43.35:80/kirana/update_customer.php?idOfCustomer="+idOfCustomer;

                Log.e("!@!@!@!@!@!",idOfCustomer);
                Log.e("url!@!@!@",idOfCustomer);

                if (FromUpdateOrNotCustomer == null){
                    SelectedUrlForCustomer = CustomerRegistrationUrl;
                } else {
                    SelectedUrlForCustomer = CustomerUpdateUrl;
                }

                try {

                    URL url = new URL(SelectedUrlForCustomer);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setConnectTimeout(timeOutMillis);

                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                    String data = URLEncoder.encode("c_first_name", "UTF-8") + "=" + URLEncoder.encode(CustomerFirstName, "UTF-8") + "&" +
                            URLEncoder.encode("c_last_name", "UTF-8") + "=" + URLEncoder.encode(CustomerLastName, "UTF-8") + "&" +
                            URLEncoder.encode("c_username", "UTF-8") + "=" + URLEncoder.encode(CustomerUsername, "UTF-8") + "&" +
                            URLEncoder.encode("c_password", "UTF-8") + "=" + URLEncoder.encode(CustomerPassword, "UTF-8") + "&" +
                            URLEncoder.encode("c_mobile_no", "UTF-8") + "=" + URLEncoder.encode(CustomerMobileNo, "UTF-8") + "&" +
                            URLEncoder.encode("c_date_of_birth", "UTF-8") + "=" + URLEncoder.encode(CustomerDateOfBirth, "UTF-8") + "&" +
                            URLEncoder.encode("c_area", "UTF-8") + "=" + URLEncoder.encode(CustomerArea, "UTF-8");

                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    inputStream.close();

                    return "Customer Registration Success...";

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) { super.onProgressUpdate(values); }

    @Override
    protected void onPostExecute(String result) {

        progressDialog.dismiss();
        switch (result) {
            case "":
                Toast.makeText(ctx, "Updation Failed", Toast.LENGTH_SHORT).show();
                break;
            case "Retailer Registration Success...":
                Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
                break;
            case "Customer Registration Success...":
                Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
                break;
            default:
                alertDialog.setMessage(result);
                alertDialog.show();
                break;
        }

        //a = Integer.parseInt(result);
    }

}
