package com.example.pratik.kirana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileInformation extends AppCompatActivity {

    TextView textViewIDinProfileInfo, textViewFullName, textViewUsername, textViewPassword, textViewMobileNo, textViewDateOfBirth, textViewAreaProfileInfo;
    Button buttonUpdateCustomerOrRetailerInformation;

    int idCR, idC;
    String firstNameCR, lastNameCR, usernameCR, passwordCR, mobileNoCR, dateOfBirthCR, areaCR, retailerCR;
    String firstNameC, lastNameC, usernameC, passwordC, mobileNoC, dateOfBirthC, areaC, customerC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewIDinProfileInfo = (TextView) findViewById(R.id.textIDInProfileInfo);
        textViewFullName = (TextView) findViewById(R.id.textViewFullName);
        textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        textViewPassword = (TextView) findViewById(R.id.textViewPassword);
        textViewMobileNo = (TextView) findViewById(R.id.textViewMobileNo);
        textViewDateOfBirth = (TextView) findViewById(R.id.textViewDateOfBirth);
        textViewAreaProfileInfo = (TextView) findViewById(R.id.textViewAreaInProfileInfo);

        buttonUpdateCustomerOrRetailerInformation = (Button) findViewById(R.id.buttonUpdateCustomerOrRetailerInformation);

        idCR = getIntent().getIntExtra("r_id", -1);
        firstNameCR = getIntent().getStringExtra("r_first_name");
        lastNameCR = getIntent().getStringExtra("r_last_name");
        usernameCR = getIntent().getStringExtra("r_username");
        passwordCR = getIntent().getStringExtra("r_password");
        mobileNoCR = getIntent().getStringExtra("r_mobile_no");
        dateOfBirthCR = getIntent().getStringExtra("r_date_of_birth");
        areaCR = getIntent().getStringExtra("r_area");
        retailerCR = getIntent().getStringExtra("retailer");

        idC = getIntent().getIntExtra("c_id", -1);
        firstNameC = getIntent().getStringExtra("c_first_name");
        lastNameC = getIntent().getStringExtra("c_last_name");
        usernameC = getIntent().getStringExtra("c_username");
        passwordC = getIntent().getStringExtra("c_password");
        mobileNoC = getIntent().getStringExtra("c_mobile_no");
        dateOfBirthC = getIntent().getStringExtra("c_date_of_birth");
        areaC = getIntent().getStringExtra("c_area");
        customerC = getIntent().getStringExtra("customer");

        Log.e("@#@#@#", idCR + firstNameCR + lastNameCR + lastNameCR + usernameCR + passwordCR + mobileNoCR + dateOfBirthCR + areaCR);
        Log.e("@#@#@#", idC + firstNameC + lastNameC + lastNameC + usernameC + passwordC + mobileNoC + dateOfBirthC + areaC);
        if (customerC == null){
            textViewIDinProfileInfo.setText(String.valueOf(idCR));
            textViewFullName.setText(firstNameCR+" "+lastNameCR);
            textViewUsername.setText(usernameCR);
            textViewPassword.setText(passwordCR);
            textViewMobileNo.setText(mobileNoCR);
            textViewDateOfBirth.setText(dateOfBirthCR);
            textViewAreaProfileInfo.setText(areaCR);
        } else {
            textViewIDinProfileInfo.setText(String.valueOf(idC));
            textViewFullName.setText(firstNameC+" "+lastNameC);
            textViewUsername.setText(usernameC);
            textViewPassword.setText(passwordC);
            textViewMobileNo.setText(mobileNoC);
            textViewDateOfBirth.setText(dateOfBirthC);
            textViewAreaProfileInfo.setText(areaC);
        }


        buttonUpdateCustomerOrRetailerInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customerC != null){

                    Intent intent = new Intent(ProfileInformation.this, CustomerSignUpForm.class);
                    intent.putExtra("customerUpdate","customerUpdate");
                    intent.putExtra("idCU", idC);
                    intent.putExtra("firstCU", firstNameC);
                    intent.putExtra("lastCU", lastNameC);
                    intent.putExtra("usernameCU", usernameC);
                    intent.putExtra("passwordCU", passwordC);
                    intent.putExtra("mobileCU", mobileNoC);
                    intent.putExtra("dateCU", dateOfBirthC);
                    intent.putExtra("areaCU", areaC);
                    startActivity(intent);

                } else {

                    Intent intent = new Intent(ProfileInformation.this, RetailerSignUpForm.class);
                    intent.putExtra("retailerUpdate", "retailerUpdate");
                    intent.putExtra("idRU", idCR);
                    intent.putExtra("firstRU", firstNameCR);
                    intent.putExtra("lastRU", lastNameCR);
                    intent.putExtra("usernameRU", usernameCR);
                    intent.putExtra("passwordRU", passwordCR);
                    intent.putExtra("mobileRU", mobileNoCR);
                    intent.putExtra("dateRU", dateOfBirthCR);
                    intent.putExtra("areaRU", areaCR);
                    startActivity(intent);

                }
            }
        });

    }

}
