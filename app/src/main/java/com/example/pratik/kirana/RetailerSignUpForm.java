package com.example.pratik.kirana;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Calendar;


public class RetailerSignUpForm extends AppCompatActivity {

    int dY, dYear, dMonth, dDay;
    static final int DATE_DIALOG_ID = 1;
    Calendar c;
    EditText editTextFirstNameRetailerSignUp, editTextLastNameRetailerSignUp, editTextUsernameRetailerSignUp,
            editTextPasswordRetailerSignUp, editTextReTypePasswordRetailerSignUp, editTextDateOfBirthRetailerSignUp, editTextMobileNoRetailerSignUp;
    Spinner spinnerViewAreaRetailerSignUp;
    Button buttonSubmitRetailer;
    String RetailerFirstName, RetailerLastName, RetailerUsername, RetailerPassword, RetailerReTypePassword, RetailerDateOfBirth,
            RetailerArea, RetailerMobileNo;
    TextView textViewPassword;

    final static private String fromUpdate = "fromUpdate";

    String firstNameRUR, lastNameRUR, usernameRUR, passwordRUR, mobileRUR, dateOfBirthRUR, areaRUR, retailerUpdateRUR, FromUpdate;
    int idRUR;

    String idOfRetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_sign_up_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonSubmitRetailer = (Button) findViewById(R.id.buttonSubmitRetailerSignUp);

        editTextFirstNameRetailerSignUp = (EditText) findViewById(R.id.editTextFirstNameRetailerSignUp);
        editTextLastNameRetailerSignUp = (EditText) findViewById(R.id.editTextLastNameRetailerSignUp);
        editTextUsernameRetailerSignUp = (EditText) findViewById(R.id.editTextUsernameRetailerSignUp);
        editTextPasswordRetailerSignUp = (EditText) findViewById(R.id.editTextPasswordRetailerSignUp);
        editTextReTypePasswordRetailerSignUp = (EditText) findViewById(R.id.editTextReTypePasswordRetailerSignUp);
        editTextMobileNoRetailerSignUp = (EditText) findViewById(R.id.editTextMobileNoRetailerSignUp);
        editTextDateOfBirthRetailerSignUp = (EditText) findViewById(R.id.editTextDateOfBirthRetailerSignUp);
        spinnerViewAreaRetailerSignUp = (Spinner) findViewById(R.id.spinnerViewAreaRetailerSignUp);
        textViewPassword = (TextView) findViewById(R.id.textViewPasswordRetailer);

        idRUR = getIntent().getIntExtra("idRU", -1);
        retailerUpdateRUR = getIntent().getStringExtra("retailerUpdate");
        firstNameRUR = getIntent().getStringExtra("firstRU");
        lastNameRUR = getIntent().getStringExtra("lastRU");
        usernameRUR = getIntent().getStringExtra("usernameRU");
        passwordRUR = getIntent().getStringExtra("passwordRU");
        mobileRUR = getIntent().getStringExtra("mobileRU");
        dateOfBirthRUR = getIntent().getStringExtra("dateRU");
        areaRUR = getIntent().getStringExtra("areaRU");


        if (retailerUpdateRUR != null){
            editTextFirstNameRetailerSignUp.setText(firstNameRUR);
            editTextLastNameRetailerSignUp.setText(lastNameRUR);
            editTextUsernameRetailerSignUp.setText(usernameRUR);
            editTextPasswordRetailerSignUp.setText(passwordRUR);
            editTextReTypePasswordRetailerSignUp.setText(passwordRUR);
            editTextMobileNoRetailerSignUp.setText(mobileRUR);
            editTextDateOfBirthRetailerSignUp.setText(dateOfBirthRUR);
        }


        setIconInEditText();

        editTextDateOfBirthRetailerSignUp.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            public void onClick(View v) {
                // TODO Auto-generated method stub
                showDialog(DATE_DIALOG_ID);
            }
        });

        {

            buttonSubmitRetailer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    RetailerFirstName = editTextFirstNameRetailerSignUp.getText().toString();
                    RetailerLastName = editTextLastNameRetailerSignUp.getText().toString();
                    RetailerUsername = editTextUsernameRetailerSignUp.getText().toString();
                    RetailerPassword = editTextPasswordRetailerSignUp.getText().toString();
                    RetailerReTypePassword = editTextReTypePasswordRetailerSignUp.getText().toString();
                    RetailerMobileNo = editTextMobileNoRetailerSignUp.getText().toString();
                    RetailerDateOfBirth = editTextDateOfBirthRetailerSignUp.getText().toString();
                    RetailerArea = spinnerViewAreaRetailerSignUp.getSelectedItem().toString();

                    if (!(RetailerFirstName.equals("")) && !(RetailerLastName.equals("")) && !(RetailerUsername.equals("")) &&
                            !(RetailerMobileNo.equals("")) && !(RetailerDateOfBirth.equals(""))) {
                        if (!(RetailerArea.equals("Select your Area"))) {
                            if (RetailerPassword.length() > 7) {
                                if (RetailerPassword.equals(RetailerReTypePassword)) {
                                    if (retailerUpdateRUR != null){
                                        FromUpdate = fromUpdate;
                                    } else {
                                        FromUpdate = null;
                                    }

                                    idOfRetail = String.valueOf(idRUR);

                                    String method = "RetailerRegistration";
                                    BackgroundTask backgroundTask = new BackgroundTask(RetailerSignUpForm.this);
                                    backgroundTask.execute(method, RetailerFirstName, RetailerLastName, RetailerUsername, RetailerPassword, RetailerMobileNo, RetailerDateOfBirth, RetailerArea, FromUpdate, idOfRetail);
                                    finish();
                                    startActivity(new Intent(RetailerSignUpForm.this, RetailerLoginForm.class));
                                } else {
                                    textViewPassword.setText("Password does not match");
                                }
                            } else {
                                textViewPassword.setText("Password should be atleast of 8 characters");
                            }
                        } else {
                            Snackbar.make(v, "Select your Area", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        }
                    } else {
                        Snackbar.make(v, "Please up all the fields", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }
                }
            });

        }
    }

    private void setIconInEditText() {
        // TODO Auto-generated method stub

        try {

            Drawable datePickerIcon = getResources().getDrawable(
                    R.drawable.calender);

            editTextDateOfBirthRetailerSignUp
                    .setCompoundDrawablesWithIntrinsicBounds(null, null,
                            datePickerIcon, null);

            c = Calendar.getInstance();

            dY = c.get(Calendar.YEAR);
            dYear = dY - 25;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, dDateSetListener, dYear, dMonth,
                        dDay);

        }
        return null;
    }

    DatePickerDialog.OnDateSetListener dDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub

            dYear = year;
            dMonth = monthOfYear;
            dDay = dayOfMonth;

            editTextDateOfBirthRetailerSignUp.setText(new StringBuilder()
                    .append(dYear).append("-").append(pad(dMonth + 1)).append("-").append(dDay));

        }
    };

    private static String pad(int cc) {

        if (cc >= 10)
            return String.valueOf(cc);
        else
            return "0" + String.valueOf(cc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId())
        {
            case R.id.action_refresh:
                return true;

            case R.id.action_help:
                return true;

            case R.id.action_logout:
                return true;

            case R.id.action_exit:
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
