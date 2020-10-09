package com.example.sisonkebank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    TextView txt;
    Button btn;
    EditText userPassR,userEmailR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        userPassR = (EditText)findViewById(R.id.fldPasw);
        userEmailR = (EditText)findViewById(R.id.fldEmail);

        //textview for registering
        txt = (TextView)findViewById(R.id.btnLog);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(Login.this,registration.class);
                startActivity(open);

            }
        });

        //Loging in button
        btn = (Button)findViewById(R.id.btnEnter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = userEmailR.getText().toString();
                String pass = userPassR.getText().toString();

                //checking email
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Email is not valid", Toast.LENGTH_SHORT);
                    toast.show();
                    userEmailR.setText(null);
                    userPassR.setText(null);
                }

                //checking password
                else if(pass.length() < 5) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Password length should be 5 or more", Toast.LENGTH_SHORT);
                    toast.show();
                    userPassR.setText(null);
                    userEmailR.setText(null);
                }
                else{
                    Intent login = new Intent(Login.this,Mainmenu.class);
                    startActivity(login);
                    finish();
                }
            }
        });
    }
}
