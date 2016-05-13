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

public class CustomerSignUpForm extends AppCompatActivity {

    private int dYear;
    private int dMonth;
    private int dDay;
    static final int DATE_DIALOG_ID = 1;
    Calendar c;

    EditText editTextFirstNameCustomerSignUp, editTextLastNameCustomerSignUp,
            editTextUsernameCustomerSignUp, editTextPasswordCustomerSignUp,
            editTextReTypePasswordCustomerSignUp,
            editTextDateOfBirthCustomerSignUp,editTextMobileNoCustomerSignUp;
    TextView textViewPassword;
    Spinner spinnerViewAreaCustomerSignUp;

    String CustomerFirstName, CustomerLastName, CustomerUsername, CustomerPassword, CustomerReTypePassword, CustomerDateOfBirth,
            CustomerArea,CustomerMobileNo;

    String firstNameCUC, lastNameCUC, usernameCUC, passwordCUC, mobileCUC, dateOfBirthCUC, areaCUC, customerUpdateCUC, FromUpdate;
    int idCUC;

    final static private String fromUpdate = "fromUpdate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_up_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextFirstNameCustomerSignUp = (EditText) findViewById(R.id.editTextFirstNameCustomerSignUp);
        editTextLastNameCustomerSignUp = (EditText) findViewById(R.id.editTextLastNameCustomerSignUp);
        editTextUsernameCustomerSignUp = (EditText) findViewById(R.id.editTextUsernameCustomerSignUp);
        editTextPasswordCustomerSignUp = (EditText) findViewById(R.id.editTextPasswordCustomerSignUp);
        editTextReTypePasswordCustomerSignUp = (EditText) findViewById(R.id.editTextReTypePasswordCustomerSignUp);
        editTextMobileNoCustomerSignUp = (EditText) findViewById(R.id.editTextMobileNoCustomerSignUp);
        editTextDateOfBirthCustomerSignUp = (EditText) findViewById(R.id.editTextDateOfBirthCustomerSignUp);
        Button buttonSubmitCustomer = (Button) findViewById(R.id.buttonSubmitCustomerSignUp);
        spinnerViewAreaCustomerSignUp = (Spinner) findViewById(R.id.spinnerViewAreaCustomerSignUp);
        textViewPassword = (TextView) findViewById(R.id.textViewPasswordCustomer);

        idCUC = getIntent().getIntExtra("idCU", -1);
        customerUpdateCUC = getIntent().getStringExtra("customerUpdate");
        firstNameCUC = getIntent().getStringExtra("firstCU");
        lastNameCUC = getIntent().getStringExtra("lastCU");
        usernameCUC = getIntent().getStringExtra("usernameCU");
        passwordCUC = getIntent().getStringExtra("passwordCU");
        mobileCUC = getIntent().getStringExtra("mobileCU");
        dateOfBirthCUC = getIntent().getStringExtra("dateCU");
        areaCUC = getIntent().getStringExtra("areaCU");

        if (customerUpdateCUC != null){
            editTextFirstNameCustomerSignUp.setText(firstNameCUC);
            editTextLastNameCustomerSignUp.setText(lastNameCUC);
            editTextUsernameCustomerSignUp.setText(usernameCUC);
            editTextPasswordCustomerSignUp.setText(passwordCUC);
            editTextReTypePasswordCustomerSignUp.setText(passwordCUC);
            editTextMobileNoCustomerSignUp.setText(mobileCUC);
            editTextDateOfBirthCustomerSignUp.setText(dateOfBirthCUC);
        }

        setIconInDate();

        buttonSubmitCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomerFirstName = editTextFirstNameCustomerSignUp.getText().toString();
                CustomerLastName = editTextLastNameCustomerSignUp.getText().toString();
                CustomerUsername = editTextUsernameCustomerSignUp.getText().toString();
                CustomerPassword = editTextPasswordCustomerSignUp.getText().toString();
                CustomerReTypePassword = editTextReTypePasswordCustomerSignUp.getText().toString();
                CustomerMobileNo = editTextMobileNoCustomerSignUp.getText().toString();
                CustomerDateOfBirth = editTextDateOfBirthCustomerSignUp.getText().toString();
                CustomerArea = spinnerViewAreaCustomerSignUp.getSelectedItem().toString();

                if (!(CustomerFirstName.equals("")) && !(CustomerLastName.equals("")) && !(CustomerUsername.equals(""))
                        && !(CustomerMobileNo.equals("")) && !(CustomerDateOfBirth.equals(""))){
                    if (!(CustomerArea.equals("Select your Area"))){
                        if (CustomerPassword.length()>5){
                            if (CustomerPassword.equals(CustomerReTypePassword)){
                                if (customerUpdateCUC != null){
                                    FromUpdate = fromUpdate;
                                } else {
                                    FromUpdate = null;
                                }

                                String idCustom = String.valueOf(idCUC);
                                String method = "CustomerRegistration";
                                BackgroundTask backgroundTask = new BackgroundTask(CustomerSignUpForm.this);
                                backgroundTask.execute(method, CustomerFirstName, CustomerLastName, CustomerUsername, CustomerPassword, CustomerMobileNo, CustomerDateOfBirth, CustomerArea, FromUpdate, idCustom);
                                finish();
                                startActivity(new Intent(CustomerSignUpForm.this, CustomerLoginForm.class));

                            } else {
                                textViewPassword.setText("Password does not matches");
                            }
                        } else {
                            textViewPassword.setText("Password should be atleast of 6 characters");
                        }
                    } else {
                        Snackbar.make(v,"Select an Area",Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }
                } else {
                    Snackbar.make(v,"Please up all the fields",Snackbar.LENGTH_LONG).setAction("Action",null).show();
                }

            }

        });

        editTextDateOfBirthCustomerSignUp.setOnClickListener(new View.OnClickListener() {

            @SuppressWarnings("deprecation")
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                showDialog(DATE_DIALOG_ID);
            }
        });

    }

    private void setIconInDate() {
        // TODO Auto-generated method stub
        try {
            Drawable datePickerIcon = getResources().getDrawable(
                    R.drawable.calender);

            editTextDateOfBirthCustomerSignUp
                    .setCompoundDrawablesWithIntrinsicBounds(null, null,
                            datePickerIcon, null);

            c = Calendar.getInstance();

            int dY = c.get(Calendar.YEAR);
            dYear = dY - 26;

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

    private DatePickerDialog.OnDateSetListener dDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub

            dYear = year;
            dMonth = monthOfYear;
            dDay = dayOfMonth;

            editTextDateOfBirthCustomerSignUp.setText(new StringBuilder()
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
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
