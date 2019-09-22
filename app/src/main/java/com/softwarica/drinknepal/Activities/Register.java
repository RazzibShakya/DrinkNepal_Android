package com.softwarica.drinknepal.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.softwarica.drinknepal.BusinessLogic.UserLogic;
import com.softwarica.drinknepal.Model.Connection;
import com.softwarica.drinknepal.R;

import java.util.Calendar;

public class Register extends AppCompatActivity implements View.OnClickListener {
EditText txtname,txtaddress,txtemail,txtpassword,txtphone;
TextView txtdob,btnlogin;
Button btnregister,btnCalendar;
    int day, month, year;
    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initiate();
        getSupportActionBar().hide();

    }

    //this function is for calendar and date to be set
    public void SelectDate(){
        Calendar calendar = Calendar.getInstance();
        day=calendar.get(Calendar.DAY_OF_MONTH);
        month=calendar.get(Calendar.MONTH);
        year=calendar.get(Calendar.YEAR);
        setDate(year,month+1,day);
        listener=new DatePickerDialog.OnDateSetListener() {
            @Override

            public void onDateSet(DatePicker view, int year, int month, int day) {
                setDate(year,month+1,day);
            }
        };
        datePickerDialog=new DatePickerDialog(this,listener,year,month+1,day);
    }

    //this is method for setting date from date picker
    public void setDate(int year,int month, int day){
        txtdob.setText(year+"-"+month+"-"+day);
    }

    public void initiate(){
        txtname=findViewById(R.id.regname);
        txtaddress=findViewById(R.id.regaddress);
        txtemail=findViewById(R.id.regemail);
        txtdob=findViewById(R.id.tvDate);
        txtpassword=findViewById(R.id.regpass);
        txtphone=findViewById(R.id.regphone);
        btnlogin=findViewById(R.id.btngotologin);
        btnCalendar=findViewById(R.id.btndate);
       btnregister=findViewById(R.id.btnRegister);
        btnregister.setOnClickListener(this);
        btnlogin.setOnClickListener(this);
        btnCalendar.setOnClickListener(this);
        SelectDate();
    }
    public boolean RegisterValidation() {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (txtname.getText().toString().isEmpty()) {
            txtname.setError("Fill Your Name");
            txtname.requestFocus();
            return false;
        }
        if (txtphone.getText().toString().isEmpty()) {
            txtphone.setError("Fill Your phone number");
            txtphone.requestFocus();
            return false;
        }
        if (txtaddress.getText().toString().isEmpty()) {
            txtaddress.setError("Fill where you are from");
            txtaddress.requestFocus();
            return false;
        }

        if (txtemail.getText().toString().isEmpty() || !txtemail.getText().toString().trim().matches(emailPattern)) {
            txtemail.setError("Your email is invalid");
            txtemail.requestFocus();
            return false;
        }

        if (txtpassword.getText().toString().isEmpty() || txtpassword.getText().toString().length() < 6) {
            txtpassword.setError("Invalid password or password must have atleast 6 characters");
            txtpassword.requestFocus();
            return false;
        }

        if (!txtdob.getText().toString().isEmpty()) {


        }else{
            txtdob.setError("Date is invalid");
            txtdob.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(txtname.getText().toString()) && TextUtils.isEmpty(txtpassword.getText().toString()) && TextUtils.isEmpty(txtphone.getText().toString()) &&
                TextUtils.isEmpty(txtemail.getText().toString())&& TextUtils.isEmpty(txtpassword.getText().toString())) {
            txtname.setError("Fill Your Name");
            txtphone.setError("Fill Your phone number");
            txtemail.setError("Fill Your email");
            txtpassword.setError("Fill Your password");
            txtaddress.setError("Fill Your address");
            txtname.requestFocus();
            return false;
        }


        return true;
    }

    public void gotoLogin(){
        Intent intent1 = new Intent(Register.this,Login.class);
        startActivity(intent1);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnRegister:
                if(RegisterValidation()==true){
                    UserLogic ul=new UserLogic();
                    Connection conn=new Connection();
                    conn.StrictMode();
                    if(ul.RegisterUser(txtname.getText().toString(),txtemail.getText().toString(),txtphone
                    .getText().toString(),txtaddress.getText().toString(),txtdob.getText().toString(),txtpassword.getText()
                    .toString())){
                        Toast.makeText(getApplicationContext(),"User added successfully",Toast.LENGTH_SHORT).show();
                        gotoLogin();
                    }else{
                        Toast.makeText(getApplicationContext(),"User cannot be registered",Toast.LENGTH_SHORT).show();
                    }
                }

                break;
            case R.id.btngotologin:
                gotoLogin();
                break;

            case R.id.btndate:
                datePickerDialog.show();
                break;
        }
    }
}
