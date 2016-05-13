package com.example.pratik.kirana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class GridMainActivity extends AppCompatActivity {

    GridView gv;

    public static String [] textsForMainLayoutOfGridView={"Bluetooth Accessories", "Books", "Clothing", "Computer and Laptop",
            "Computer Accessories", "Electronics", "Kids Toys", "Mobiles and Tablets", "CDs and DVDs", "Shoes and Slippers",
            "School Accessories", "Watches"};

    public static int [] imagesForMainLayoutOfGridView={R.drawable.bluetooth, R.drawable.books, R.drawable.clothing,
            R.drawable.computer_and_laptop, R.drawable.computer_and_laptop, R.drawable.electronic_accessories, R.drawable.toys,
            R.drawable.mobile, R.drawable.dvd, R.drawable.shoes, R.drawable.school_accessories, R.drawable.watch};

    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gv=(GridView) findViewById(R.id.gridViewForMainLayout);

        final String username_customer = getIntent().getStringExtra("username_customer");

        gv.setAdapter(new CustomAdapterForMainGridView(this, textsForMainLayoutOfGridView, imagesForMainLayoutOfGridView));

        this.gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int positionForMainGridLayout, long id) {
                Intent intent = new Intent(GridMainActivity.this, GridSubLayout.class);
                intent.putExtra("Position", positionForMainGridLayout);
                intent.putExtra("customer_username", username_customer);
                startActivity(intent);

            }
        });

    }

}
