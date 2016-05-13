package com.example.pratik.kirana;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListOfItemCustomerActivity extends AppCompatActivity {

    private ListView customerListView;
    FloatingActionButton fabInListActivity;
    public String typeOfItem = null;
    public String UserNameOfRetailer = null;
    public String AreaOfRetailer = null;
    public String areaR, typeR, typ, typeOfItemInListOfItemCustomerActivity, UserName;
    Button buttonFilterByArea, buttonFilterByType;
    Spinner spinnerViewInListActivity;
    public String valueGotBySpinner, username, username_retailer, username_customer;
    JSONArray jsonArrayFromDatabase;
    public String user_retailer;

    public int r_id;
    public String r_first_name, r_last_name, r_username, r_password, r_mobile_no, r_date_of_birth, r_area;

    public int c_id;
    public String c_first_name, c_last_name, c_username, c_password, c_mobile_no, c_date_of_birth, c_area;

    String[] areaSpinnerInListActivity = {"Select Area", "Jaipur", "Lakshman Nagar", "Mahad", "Alibag", "Murud"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_item_customer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        customerListView = (ListView) findViewById(R.id.customerListView);
        fabInListActivity = (FloatingActionButton) findViewById(R.id.fabInListActivity);
        buttonFilterByArea = (Button) findViewById(R.id.buttonFilterByArea);
        buttonFilterByType = (Button) findViewById(R.id.buttonFilterByType);
        spinnerViewInListActivity = (Spinner) findViewById(R.id.spinnerViewInListActivity);

        buttonFilterByType.setVisibility(View.INVISIBLE);
        buttonFilterByType.setEnabled(false);/*
        spinnerViewInListActivity.setVisibility(View.INVISIBLE);
        spinnerViewInListActivity.setEnabled(false);*/

        spinnerViewInListActivity.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, areaSpinnerInListActivity));

        typeOfItem = getIntent().getStringExtra("Type Of Item");
        typ = getIntent().getStringExtra("typ");
        UserNameOfRetailer = getIntent().getStringExtra("Username of Retailer");
        UserName = getIntent().getStringExtra("UserName");
        AreaOfRetailer = getIntent().getStringExtra("Area Of Retailer");
        username = getIntent().getStringExtra("username");
        username_retailer = getIntent().getStringExtra("username_retailer");
        user_retailer = getIntent().getStringExtra("user_retailer");

        username_customer = getIntent().getStringExtra("username_of_customer");

        if (username_customer == null){
            Log.e("!!!!","username customer is null");
        } else {
            Log.e("!!!!",username_customer);
        }


//        Log.e("@!@!@!", username_customer);

        typeR = typeOfItem;
        areaR = /*AreaOfRetailer*/valueGotBySpinner;

        if (username != null){
            UserNameOfRetailer = username;
        } else if (username_retailer != null){
            UserNameOfRetailer = username_retailer;
        }

        if (UserNameOfRetailer != null) {
            fabInListActivity.setVisibility(View.VISIBLE);
            fabInListActivity.setEnabled(true);

            buttonFilterByArea.setVisibility(View.INVISIBLE);
            buttonFilterByArea.setEnabled(false);
            buttonFilterByType.setVisibility(View.INVISIBLE);
            buttonFilterByType.setEnabled(false);
            spinnerViewInListActivity.setVisibility(View.INVISIBLE);
            spinnerViewInListActivity.setEnabled(false);
        } else {
            fabInListActivity.setVisibility(View.INVISIBLE);
            fabInListActivity.setEnabled(false);
        }

        buttonFilterByArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valueGotBySpinner = spinnerViewInListActivity.getSelectedItem().toString();

                if (valueGotBySpinner.equals("Select Area")) {
                    Toast.makeText(ListOfItemCustomerActivity.this, "Please first select Area", Toast.LENGTH_SHORT).show();
                } else {
                    buttonFilterByArea.setVisibility(View.INVISIBLE);
                    buttonFilterByArea.setEnabled(false);
                    spinnerViewInListActivity.setVisibility(View.INVISIBLE);
                    spinnerViewInListActivity.setEnabled(false);

                    areaR = /*AreaOfRetailer*/valueGotBySpinner;
                    typeR = null;
                    typeOfItemInListOfItemCustomerActivity = typ;

                    new GetItemForCustomer().execute(new ListConnector());
                    Log.e("buttonFilterByArea", " Clicked buttonFilterByArea");

                    buttonFilterByType.setVisibility(View.VISIBLE);
                    buttonFilterByType.setEnabled(true);
                }

            }
        });

/*
        spinnerViewInListActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                valueGotBySpinner = spinnerViewInListActivity.getSelectedItem().toString();
            }
        });
*/


        buttonFilterByType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonFilterByType.setVisibility(View.INVISIBLE);
                buttonFilterByType.setEnabled(false);

                typeR = typeOfItem;
                areaR = null;
                typeOfItemInListOfItemCustomerActivity = null;

                new GetItemForCustomer().execute(new ListConnector());
                Log.e("buttonFilterByType", " Clicked buttonFilterByType");

                buttonFilterByArea.setVisibility(View.VISIBLE);
                buttonFilterByArea.setEnabled(true);
                spinnerViewInListActivity.setVisibility(View.VISIBLE);
                spinnerViewInListActivity.setEnabled(true);
            }
        });

        fabInListActivity.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfItemCustomerActivity.this, AddItemActivity.class);
                intent.putExtra("Username", UserNameOfRetailer);
                intent.putExtra("UserName", UserName);
                Log.e("qwerty",UserName);
                startActivity(intent);
            }
        });

        new GetItemForCustomer().execute(new ListConnector());

    }

    private class GetItemForCustomer extends AsyncTask<ListConnector, Long, JSONArray>{

        @Override
        protected JSONArray doInBackground(ListConnector... params) {
            if (typeOfItem != null){
                return params[0].GettingAllItems(typeR, null, null, typeOfItemInListOfItemCustomerActivity, valueGotBySpinner);
            } else if (UserNameOfRetailer != null){
                return params[0].GettingAllItems(null, UserNameOfRetailer, null, typeOfItemInListOfItemCustomerActivity, valueGotBySpinner);
            } else {
                return params[0].GettingAllItems(null, null, areaR, typeOfItemInListOfItemCustomerActivity, valueGotBySpinner);
            }
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            super.onPostExecute(jsonArray);
            if (jsonArray != null) {
                setListViewAdapter(jsonArray);
            } else {
                Toast.makeText(ListOfItemCustomerActivity.this, "The data is not available", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setListViewAdapter(final JSONArray jsonArray) {
        this.customerListView.setAdapter(new GetAllItemListViewAdapter(jsonArray, this));

        customerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {

                    JSONObject jsonObject = jsonArray.getJSONObject(position);

                    if (fabInListActivity.isEnabled()) {
                        Intent intent = new Intent(ListOfItemCustomerActivity.this, ItemDetailsRetailerActivity.class);
                        intent.putExtra("id", jsonObject.getInt("id"));
                        intent.putExtra("Name Of Item", jsonObject.getString("product_name"));
                        intent.putExtra("Brand Of Item", jsonObject.getString("brand"));
                        intent.putExtra("Price Of Item", jsonObject.getString("price"));
                        intent.putExtra("Mobile No Of Retailer", jsonObject.getString("mobile"));
                        intent.putExtra("Area Of Retailer", jsonObject.getString("area"));
                        intent.putExtra("Description Of Item", jsonObject.getString("discription"));
                        intent.putExtra("Username Of Retailer", jsonObject.getString("username"));
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(ListOfItemCustomerActivity.this, ItemDetailsCustomerActivity.class);
                        intent.putExtra("id", jsonObject.getInt("id"));
                        intent.putExtra("Name Of Item", jsonObject.getString("product_name"));
                        intent.putExtra("Brand Of Item", jsonObject.getString("brand"));
                        intent.putExtra("Price Of Item", jsonObject.getString("price"));
                        intent.putExtra("Mobile No Of Retailer", jsonObject.getString("mobile"));
                        intent.putExtra("Area Of Retailer", jsonObject.getString("area"));
                        intent.putExtra("Description Of Item", jsonObject.getString("discription"));
                        intent.putExtra("Username Of Retailer", jsonObject.getString("username"));
                        startActivity(intent);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private class GetAllDetailsReturn extends AsyncTask<FechingDataFromCustomerOrRetailer, Long, JSONArray>{

        @Override
        protected JSONArray doInBackground(FechingDataFromCustomerOrRetailer... params) {
            if (user_retailer != null){
                return params[0].GetAllDetails(user_retailer, null);
            } else {
                return params[0].GetAllDetails(null, username_customer);
            }

        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            super.onPostExecute(jsonArray);
            jsonArrayFromDatabase = jsonArray;
            Log.e("jsonArrayDipeshPratik", String.valueOf(jsonArrayFromDatabase));

            if (user_retailer != null){
                Toast.makeText(ListOfItemCustomerActivity.this, "Not Null", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ListOfItemCustomerActivity.this, "Null", Toast.LENGTH_SHORT).show();
            }

            if (user_retailer != null){
                try {
                    r_id = jsonArray.getJSONObject(0).getInt("r_id");
                    r_first_name = jsonArray.getJSONObject(0).getString("r_first_name");
                    r_last_name = jsonArray.getJSONObject(0).getString("r_last_name");
                    r_username = jsonArray.getJSONObject(0).getString("r_username");
                    r_password = jsonArray.getJSONObject(0).getString("r_password");
                    r_mobile_no = jsonArray.getJSONObject(0).getString("mobile_no");
                    r_date_of_birth = jsonArray.getJSONObject(0).getString("r_date_of_birth");
                    r_area = jsonArray.getJSONObject(0).getString("r_area");

                    Log.e("&&&&&", r_id+" " + r_mobile_no);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.e("QWERTYRETAILER",r_id+r_first_name+r_last_name+r_date_of_birth);
                Intent intent = new Intent(ListOfItemCustomerActivity.this, ProfileInformation.class);
                intent.putExtra("r_id", r_id);
                intent.putExtra("r_first_name", r_first_name);
                intent.putExtra("r_last_name", r_last_name);
                intent.putExtra("r_username", r_username);
                intent.putExtra("r_password", r_password);
                intent.putExtra("r_mobile_no", r_mobile_no);
                intent.putExtra("r_date_birth_of_birth", r_date_of_birth);
                intent.putExtra("r_area", r_area);
                intent.putExtra("retailer", "retailer");
                startActivity(intent);

            } else if (username_customer != null) {
                try {
                    c_id = jsonArray.getJSONObject(0).getInt("c_id");
                    c_first_name = jsonArray.getJSONObject(0).getString("c_first_name");
                    c_last_name = jsonArray.getJSONObject(0).getString("c_last_name");
                    c_username = jsonArray.getJSONObject(0).getString("c_username");
                    c_password = jsonArray.getJSONObject(0).getString("c_password");
                    c_mobile_no = jsonArray.getJSONObject(0).getString("mobile_no");
                    c_date_of_birth = jsonArray.getJSONObject(0).getString("c_date_of_birth");
                    c_area = jsonArray.getJSONObject(0).getString("c_area");

                    Log.e("000000", c_id+" " + c_mobile_no);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.e("QWERTYCUSTOMER",c_id+c_first_name+c_last_name+c_date_of_birth);

                Intent intent = new Intent(ListOfItemCustomerActivity.this, ProfileInformation.class);
                intent.putExtra("c_id", c_id);
                intent.putExtra("c_first_name", c_first_name);
                intent.putExtra("c_last_name", c_last_name);
                intent.putExtra("c_username", c_username);
                intent.putExtra("c_password", c_password);
                intent.putExtra("c_mobile_no", c_mobile_no);
                intent.putExtra("c_date_of_birth", c_date_of_birth);
                intent.putExtra("c_area", c_area);
                intent.putExtra("customer", "customer");
                startActivity(intent);

            } else {
                Toast.makeText(ListOfItemCustomerActivity.this, "All Null", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        getMenuInflater().inflate(R.menu.overflow_menu_at_list_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId())
        {
            case R.id.action_help:
                return true;

            case R.id.action_logout:
                if (username_retailer != null){
                    startActivity(new Intent(ListOfItemCustomerActivity.this, Choose.class));
                } else {
                    startActivity(new Intent(ListOfItemCustomerActivity.this, Choose.class));
                }
                return true;

            case R.id.action_profile:
                /*if (username_retailer != null){

                } else {

                }*/


                new GetAllDetailsReturn().execute(new FechingDataFromCustomerOrRetailer());

/*              try {

/*                  JSONArray jsonObject = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                        jsonObject = new JSONArray(jsonArrayFromDatabase);
                    }
                    String result = jsonObject.getJSONObject(0).getString("r_id");
*/

/*                  String result = EntityUtils.toString((HttpEntity) jsonArrayFromDatabase);
                    Log.e("####",result);
                    jsonObject = new JSONObject(result);
*/

                /*try {
                    if (this.jsonArrayFromDatabase == null){
                        Toast.makeText(ListOfItemCustomerActivity.this, "JsonArray returns null", Toast.LENGTH_SHORT).show();
                    } else {
                        this.jsonArrayFromDatabase.getJSONObject(0).getString("r_first_name");
                        Log.e("Bhari",r_first_name);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                    Intent intent = new Intent(ListOfItemCustomerActivity.this, ProfileInformation.class);
                    intent.putExtra("r_id", r_id);
                    intent.putExtra("r_first_name", r_first_name);
                    intent.putExtra("r_last_name", r_last_name);
                    intent.putExtra("r_username", r_username);
                    intent.putExtra("r_password", r_password);
                    intent.putExtra("r_mobile_no", r_mobile_no);
                    intent.putExtra("r_date_of_birth", r_date_of_birth);
                    intent.putExtra("r_area", r_area);
                    startActivity(intent);*/

/*
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
*/

                return  true;



            case R.id.action_exit:
                Log.e("JatoyRe", "JatoyRe");
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
