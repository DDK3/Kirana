package com.example.pratik.kirana;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;

public class ItemDetailsRetailerActivity extends AppCompatActivity {

    private String NameOfItem, BrandOfItem, AreaOfRetailer, DescriptionOfRetailer, MobileOfRetailer, PriceOfItem, UserNameRetailer;
    private int id;

    ImageView imageViewInItemDetailsRetailer;

    Button buttonUpdateItem, buttonDeleteItem;

    TextView textViewNameInItemDetailsRetailer, textViewBrandInItemDetailsRetailer, textViewDescriptionInItemDetailsRetailer,
            textViewPriceInItemDetailsRetailer, textViewAreaInItemDetailsRetailer, textViewNumberOfRetailerInItemDetailsRetailer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details_retailer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        id = getIntent().getIntExtra("id", 1);
        NameOfItem = getIntent().getStringExtra("Name Of Item");
        BrandOfItem = getIntent().getStringExtra("Brand Of Item");
        AreaOfRetailer = getIntent().getStringExtra("Area Of Retailer");
        DescriptionOfRetailer = getIntent().getStringExtra("Description Of Item");
        MobileOfRetailer = getIntent().getStringExtra("Mobile No Of Retailer");
        PriceOfItem = getIntent().getStringExtra("Price Of Item");
        UserNameRetailer = getIntent().getStringExtra("Username Of Retailer");

        int idOfUser = id;

        final String urlForImageFetching = "http://192.168.43.35:80/kirana/getting_image_from_database.php?id="+ idOfUser;

        textViewNameInItemDetailsRetailer = (TextView) findViewById(R.id.textViewNameInItemDetailsRetailer);
        textViewBrandInItemDetailsRetailer = (TextView) findViewById(R.id.textViewBrandInItemDetailsRetailer);
        textViewDescriptionInItemDetailsRetailer = (TextView) findViewById(R.id.textViewDescriptionInItemDetailsRetailer);
        textViewPriceInItemDetailsRetailer = (TextView) findViewById(R.id.textViewPriceInItemDetailsRetailer);
        textViewAreaInItemDetailsRetailer = (TextView) findViewById(R.id.textViewAreaInItemDetailsRetailer);
        textViewNumberOfRetailerInItemDetailsRetailer = (TextView) findViewById(R.id.textViewNumberOfRetailerInItemDetailsRetailer);

        imageViewInItemDetailsRetailer = (ImageView) findViewById(R.id.imageViewInItemDetailsRetailer);

        buttonUpdateItem = (Button) findViewById(R.id.buttonUpdateItem);
        buttonDeleteItem = (Button) findViewById(R.id.buttonDeleteItem);

        textViewNameInItemDetailsRetailer.setText(NameOfItem);
        textViewBrandInItemDetailsRetailer.setText(BrandOfItem);
        textViewDescriptionInItemDetailsRetailer.setText(DescriptionOfRetailer);
        textViewPriceInItemDetailsRetailer.setText(PriceOfItem);
        textViewNumberOfRetailerInItemDetailsRetailer.setText(MobileOfRetailer);
        textViewAreaInItemDetailsRetailer.setText(AreaOfRetailer);

        new setImageToImageView(imageViewInItemDetailsRetailer).execute(urlForImageFetching);

        buttonUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetailsRetailerActivity.this, AddItemActivity.class);
                intent.putExtra("Update Item", "Update Item");
                intent.putExtra("idOfItemZZZ", id);
                intent.putExtra("NameOfITem", NameOfItem);
                intent.putExtra("BrandOfITem", BrandOfItem);
                intent.putExtra("AreaOfRetailer", AreaOfRetailer);
                intent.putExtra("Desc", DescriptionOfRetailer);
                Log.e("descPratik",DescriptionOfRetailer);
                intent.putExtra("Mob", MobileOfRetailer);
                intent.putExtra("Price", PriceOfItem);
                intent.putExtra("UsernameRetailer", UserNameRetailer);
                startActivity(intent);
            }
        });

        buttonDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DeleteItem().execute();
                Intent intent = new Intent(ItemDetailsRetailerActivity.this, ListOfItemCustomerActivity.class);
                intent.putExtra("username_retailer",UserNameRetailer);
                startActivity(intent);
                //startActivity(new Intent(ItemDetailsRetailerActivity.this, ListOfItemCustomerActivity.class));
            }
        });
    }

    class setImageToImageView extends AsyncTask<String, Void, Bitmap>{

        ImageView imv;

        public setImageToImageView(ImageView imv) {this.imv = imv;}

        @Override
        protected Bitmap doInBackground(String... params) {
            String url = params[0];
            Bitmap image = null;

            try {
                InputStream inputStream = new java.net.URL(url).openStream();
                Log.e("urlPratik",url);
                image = BitmapFactory.decodeStream(inputStream);
                Log.e("imagePratik1", String.valueOf(image));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("imagePratik", String.valueOf(image));
            return image;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            Log.e("imagePratik2", String.valueOf(bitmap));
            imageViewInItemDetailsRetailer.setImageBitmap(bitmap);
        }

    }

    class DeleteItem extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {

            String DeleteUrl = "http://192.168.43.35:80/kirana/delete_item.php?id="+id;

            Log.e("idPratik", String.valueOf(id));

            try {/*
                URL url = new URL(DeleteUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                //httpURLConnection.setConnectTimeout(1000 * 10);

                //httpURLConnection.disconnect();*/

                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(DeleteUrl);
                Log.e("urlPratik", DeleteUrl);
                httpClient.execute(httpGet);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(ItemDetailsRetailerActivity.this, "Item Deleted Successfully", Toast.LENGTH_SHORT).show();
        }
    }

}
