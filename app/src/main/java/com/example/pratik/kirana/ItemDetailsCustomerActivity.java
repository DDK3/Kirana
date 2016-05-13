package com.example.pratik.kirana;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class ItemDetailsCustomerActivity extends AppCompatActivity {

    private String NameOfItem, BrandOfItem, AreaOfRetailer, DescriptionOfRetailer, MobileOfRetailer, PriceOfItem, UserNameRetailer;
    private int id;

    TextView textViewNameInItemDetailsCustomer, textViewBrandInItemDetailsCustomer, textViewDescriptionInItemDetailsCustomer,
            textViewPriceInItemDetailsCustomer, textViewAreaInItemDetailsCustomer, textViewNumberOfRetailerInItemDetailsCustomer;

    ImageView imageViewInItemDetailsCustomer;
    Button buttonCallCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details_customer);
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
        final String urlForImageFetching = "http://192.168.43.35:80/kirana/getting_image_from_database.php?id=" + idOfUser;

        textViewNameInItemDetailsCustomer = (TextView) findViewById(R.id.textViewNameInItemDetailsCustomer);
        textViewBrandInItemDetailsCustomer = (TextView) findViewById(R.id.textViewBrandInItemDetailsCustomer);
        textViewDescriptionInItemDetailsCustomer = (TextView) findViewById(R.id.textViewDescriptionInItemDetailsCustomer);
        textViewPriceInItemDetailsCustomer = (TextView) findViewById(R.id.textViewPriceInItemDetailsCustomer);
        textViewAreaInItemDetailsCustomer = (TextView) findViewById(R.id.textViewAreaInItemDetailsCustomer);
        textViewNumberOfRetailerInItemDetailsCustomer = (TextView) findViewById(R.id.textViewNumberOfRetailerInItemDetailsCustomer);

        buttonCallCustomer = (Button) findViewById(R.id.buttonCallCustomer);
        imageViewInItemDetailsCustomer = (ImageView) findViewById(R.id.imageViewInItemDetailsCustomer);

        textViewNameInItemDetailsCustomer.setText(NameOfItem);
        textViewBrandInItemDetailsCustomer.setText(BrandOfItem);
        textViewDescriptionInItemDetailsCustomer.setText(DescriptionOfRetailer);
        textViewPriceInItemDetailsCustomer.setText(PriceOfItem);
        textViewNumberOfRetailerInItemDetailsCustomer.setText(MobileOfRetailer);
        textViewAreaInItemDetailsCustomer.setText(AreaOfRetailer);

        new setImageToImageView(imageViewInItemDetailsCustomer).execute(urlForImageFetching);

        buttonCallCustomer.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+MobileOfRetailer));
                startActivity(callIntent);
            }
        });

    }

    class setImageToImageView extends AsyncTask<String, Void, Bitmap> {

        ImageView imv;

        public setImageToImageView(ImageView imv) {this.imv = imv;}

        @Override
        protected Bitmap doInBackground(String... params) {
            String url = params[0];
            Bitmap image = null;

            try {
                InputStream inputStream = new java.net.URL(url).openStream();
                Log.e("urlPratik", url);
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
            imageViewInItemDetailsCustomer.setImageBitmap(bitmap);
        }

    }

}
