package com.example.pratik.kirana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class GridSubLayout extends AppCompatActivity {

    GridView gridView;

    String CheckingTexts[];
    int CheckingImages[];

    String []Bluetooth_Accessories_texts = {"Earphone", "Headsets", "Bluetooth", "Smart Watches"};
    String []Books_texts = {"Text Books", "Magzines", "Children's Books", "Text Books", "Other Books"};
    String []Clothing_texts = {"Women's Fashion", "Men's Fashion", "Children's Fashion"};
    String []Computer_and_Laptop_texts = {"Laptop", "Computer"};
    String []Computer_Accessories_texts = {"Hard Disks", "Pen Drive", "Motherboard", "Laptop Battery", "Charger", "Mouse", "Keyboard", "Webcam", "Speaker"};
    String []Electronics_texts = {"Refrigerator", "Oven", "Television", "Headphones", "Fan", "Home Theater", "Light Bulbs"};
    String []Kid_Toys_texts = {"Car Toys", "Barbie", "Video Games", "Teddy Bear"};
    String []Mobile_and_Tablets_texts = {"Mobiles", "Tablets", "Mobile Battery"};
    String []CDs_and_DVDs_texts = {"Movies CDs", "Movies DVDs", "Music CDs", "Music DVDs"};
    String []Shoes_and_Slippers_texts = {"Sports Shoes", "Shoes", "Sandal", "Slippers"};
    String []School_Accessories_texts = {"Water Bags", "School Bags", "Tiffin", "Note Books", "Pens"};
    String []Watches_texts = {"Ladies Watches", "Gents Watches"};


    int []Bluetooth_Accessories_images = {R.drawable.bluetooth, R.drawable.bluetooth, R.drawable.bluetooth, R.drawable.bluetooth};
    int []Books_images = {R.drawable.books, R.drawable.books, R.drawable.books, R.drawable.books, R.drawable.books};
    int []Clothing_images = {R.drawable.clothing,R.drawable.clothing,R.drawable.clothing};
    int []Computer_and_Laptop_images = {R.drawable.computer_and_laptop, R.drawable.computer_and_laptop};
    int []Computer_Accessories_images = {R.drawable.dvd, R.drawable.dvd, R.drawable.dvd, R.drawable.dvd, R.drawable.dvd, R.drawable.dvd, R.drawable.dvd, R.drawable.dvd, R.drawable.dvd};
    int []Electronic_images = {R.drawable.electronic_accessories, R.drawable.electronic_accessories, R.drawable.electronic_accessories, R.drawable.electronic_accessories,R.drawable.electronic_accessories, R.drawable.electronic_accessories, R.drawable.electronic_accessories};
    int []Kid_Toys_images = {R.drawable.toys, R.drawable.toys, R.drawable.toys, R.drawable.toys};
    int []Mobile_and_Tablets_images = {R.drawable.mobile, R.drawable.mobile, R.drawable.mobile};
    int []CDs_and_DVDs_images = {R.drawable.dvd, R.drawable.dvd, R.drawable.dvd, R.drawable.dvd};
    int []Shoes_and_Slippers_images = {R.drawable.shoes, R.drawable.shoes, R.drawable.shoes, R.drawable.shoes};
    int []School_Accessories_images = {R.drawable.school_accessories, R.drawable.school_accessories, R.drawable.school_accessories, R.drawable.school_accessories, R.drawable.school_accessories};
    int []Watches_images = {R.drawable.watch, R.drawable.watch};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_sub_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridView = (GridView) findViewById(R.id.gridViewForSubLayout);

        int q = getIntent().getIntExtra("Position",-1);
        final String customer_username = getIntent().getStringExtra("customer_username");

        if (q == 0){
            CheckingTexts = Bluetooth_Accessories_texts;
            CheckingImages = Bluetooth_Accessories_images;
        } else if (q == 1){
            CheckingTexts = Books_texts;
            CheckingImages = Books_images;
        } else if (q == 2){
            CheckingTexts = Clothing_texts;
            CheckingImages = Clothing_images;
        } else if (q == 3){
            CheckingTexts = Computer_and_Laptop_texts;
            CheckingImages = Computer_and_Laptop_images;
        } else if (q == 4){
            CheckingTexts = Computer_Accessories_texts;
            CheckingImages = Computer_Accessories_images;
        } else if (q == 5){
            CheckingTexts = Electronics_texts;
            CheckingImages = Electronic_images;
        } else if (q == 6){
            CheckingTexts = Kid_Toys_texts;
            CheckingImages = Kid_Toys_images;
        } else if (q == 7){
            CheckingTexts = Mobile_and_Tablets_texts;
            CheckingImages = Mobile_and_Tablets_images;
        } else if (q == 8){
            CheckingTexts = CDs_and_DVDs_texts;
            CheckingImages = CDs_and_DVDs_images;
        } else if (q == 9){
            CheckingTexts = Shoes_and_Slippers_texts;
            CheckingImages = Shoes_and_Slippers_images;
        } else if (q == 10){
            CheckingTexts = School_Accessories_texts;
            CheckingImages = School_Accessories_images;
        } else {
            CheckingTexts = Watches_texts;
            CheckingImages = Watches_images;
        }

        gridView.setAdapter(new CustomAdapterForMainGridView(this, CheckingTexts, CheckingImages));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(GridSubLayout.this, CheckingTexts[position], Toast.LENGTH_SHORT).show();

                String itemType = CheckingTexts[position];

                Intent intent = new Intent(GridSubLayout.this, ListOfItemCustomerActivity.class);
                intent.putExtra("Type Of Item", itemType);
                intent.putExtra("typ", itemType);
                intent.putExtra("username_of_customer",customer_username);
                startActivity(intent);
            }
        });

    }

}
