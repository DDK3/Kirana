package com.example.pratik.kirana;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread th = new Thread()
        {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                super.run();

                try
                {
                    sleep(2000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally
                {
                    Intent i = new Intent(SplashActivity.this, GettingStarted.class);
                    startActivity(i);
                }
            }
        };
        th.start();

    }

}
