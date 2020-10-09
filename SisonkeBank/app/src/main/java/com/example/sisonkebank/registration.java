package com.example.sisonkebank;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class registration extends AppCompatActivity {

    BankUser myDb;
    Button btnReg;
    TextView txt;
    EditText userPassR,userNameR,userLastR,userEmailR,userMobileR;
    RadioGroup rgR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        //Pointing attributes
        userPassR = (EditText)findViewById(R.id.fldPasw);
        userNameR = (EditText)findViewById(R.id.fldName);
        userLastR = (EditText)findViewById(R.id.fldSurname);
        userEmailR = (EditText)findViewById(R.id.fldEmail);
        userMobileR = (EditText)findViewById(R.id.fldNumber);
        rgR = (RadioGroup)findViewById(R.id.radioGroup1);

        //Going back to the logging screen
        txt = (TextView)findViewById(R.id.btnLog);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //btnEnter
        btnReg = (Button)findViewById(R.id.btnEnter);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass = userPassR.getText().toString();
                String name = userNameR.getText().toString();
                String surname = userLastR.getText().toString();
                String email = userEmailR.getText().toString();
                String mobile = userMobileR.getText().toString();
                double curSav = 5000.00;
                double savAcc = 2000.00;


                //Radio Button
                int selected = rgR.getCheckedRadioButtonId();
                RadioButton btnRad = (RadioButton)findViewById(selected);
                String btnRadR = btnRad.getText().toString();

                //Checking if fields are empty
                if(pass.isEmpty() || name.isEmpty() || surname.isEmpty() || email.isEmpty() || mobile.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "One or more fields doesnt have details", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //Validating password length
                else if(pass.length() < 5) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Password length should be 5 or more", Toast.LENGTH_SHORT);
                    toast.show();
                    userPassR.setText(null);
                }
                //checking email
                else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Email is not valid", Toast.LENGTH_SHORT);
                    toast.show();
                    userEmailR.setText(null);
                }
                //Adding to database
                else {
                    boolean isInserted = myDb.addUser(email,name,surname,mobile,btnRadR,curSav,savAcc,pass);
                    if(isInserted == true){
                        Toast toast = Toast.makeText(getApplicationContext(), "Added to database ", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(), "No connection ", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });
    }
}
