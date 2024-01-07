package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button buttontoast;

   long backpress;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      buttontoast=findViewById(R.id.buttontoast);



      buttontoast.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              LayoutInflater inflater=getLayoutInflater();
              View myview=inflater.inflate(R.layout.custom_toast,findViewById(R.id.custom_toast_id));
              Toast toast=new Toast(MainActivity.this);
              toast.setDuration(Toast.LENGTH_SHORT);
              toast.setView(myview);
              toast.show();
          }
      });


    }

    @Override
    public void onBackPressed() {

       if (backpress+200>System.currentTimeMillis()){
           super.onBackPressed();
           return;
       }else {
           Toast.makeText(this, "press again to exit", Toast.LENGTH_SHORT).show();
       }

        backpress=System.currentTimeMillis();

    }
}
