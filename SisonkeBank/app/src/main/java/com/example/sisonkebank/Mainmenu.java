package com.example.sisonkebank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Mainmenu extends AppCompatActivity {

    Button btnView, btnTrans, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);

        //Viewing accounts button
        btnView = (Button)findViewById(R.id.btnViewAccount);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openView = new Intent(Mainmenu.this, ViewAccount.class);
                startActivity(openView);
            }
        });

        //Transfer balance button
        btnTrans = (Button)findViewById(R.id.btnTransfer);
        btnTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openTrans= new Intent(Mainmenu.this, Trans.class);
                startActivity(openTrans);
            }
        });

        //Presseing logout
        btnExit = (Button)findViewById(R.id.btnLogout);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit = new Intent(Mainmenu.this,Login.class);
                startActivity(exit);
                finish();

                //toast message
                Context context = getApplicationContext();
                String text = "You have been logged out";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}
