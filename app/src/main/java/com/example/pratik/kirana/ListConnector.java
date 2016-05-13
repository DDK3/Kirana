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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ListConnector {

    String type, UsernameOfRetailer, url, tpOfItem;
    String data, dataToSendWithAreaPhpFile, dataToSendWithArea, spinnerValue;
    String area;
    String valueFromSpinner;


    public JSONArray GettingAllItems(String typeOfItem, String retailerUsername, String areaOfRetailer, String tpOfItem, String valueFromSpinner) {

        this.dataToSendWithAreaPhpFile = tpOfItem;
        type = typeOfItem;
        UsernameOfRetailer = retailerUsername;
        area = areaOfRetailer;
        this.tpOfItem= tpOfItem;
        this.valueFromSpinner = valueFromSpinner;

        if (type == null && UsernameOfRetailer == null){
            try {
                dataToSendWithArea = URLEncoder.encode(dataToSendWithAreaPhpFile, "UTF-8");
                spinnerValue = URLEncoder.encode(valueFromSpinner,"UTF-8");

            } catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }


        if (typeOfItem != null){
            try {
                data = URLEncoder.encode(type, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        String urlGettingItemRelatively = "http://192.168.43.35:80/kirana/getting_item_relatively.php?type="+data;
        String urlGettingItemByRetailer = "http://192.168.43.35:80/kirana/getting_item_by_retailer.php?username="+UsernameOfRetailer;
        String urlGettingItemByArea = "http://192.168.43.35:80/kirana/getting_item_by_area.php?area="+spinnerValue+"&type="+dataToSendWithArea;

        if (typeOfItem != null){
            url = urlGettingItemRelatively;
        } else if (retailerUsername != null){
            url = urlGettingItemByRetailer;
        } else {
            url = urlGettingItemByArea;
        }

        Log.d("urlCheck", url);

        HttpEntity httpEntity = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);

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
