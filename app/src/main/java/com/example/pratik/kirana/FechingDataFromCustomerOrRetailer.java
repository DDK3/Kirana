package com.example.pratik.kirana;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;


public class FechingDataFromCustomerOrRetailer {

    private String UsernameRetailer, UsernameCustomer, urlGettingAllDetails;

    public JSONArray GetAllDetails(String username_retailer, String username_customer) {

        UsernameRetailer = username_retailer;
        UsernameCustomer = username_customer;

        String urlGettingAllDetailsForRetailer = "http://192.168.43.35:80/kirana/getting_all_details_of_retailer.php?username="+UsernameRetailer;
        String urlGettingAllDetailsForCustomer = "http://192.168.43.35:80/kirana/getting_all_details_of_customer.php?username="+UsernameCustomer;

        if (UsernameRetailer == null){
            urlGettingAllDetails = urlGettingAllDetailsForCustomer;
        } else {
            urlGettingAllDetails = urlGettingAllDetailsForRetailer;
        }

        Log.e("url!!!", urlGettingAllDetails);

        HttpEntity httpEntity = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(urlGettingAllDetails);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray = null;

        if (httpEntity != null) {

            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                Log.e("Entity Response :", entityResponse);

                jsonArray = new JSONArray(entityResponse);

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

        }

        Log.e("Pratik", String.valueOf(jsonArray));

        return jsonArray;

    }

}
