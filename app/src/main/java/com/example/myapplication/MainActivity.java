package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable runnable;
    TextView textView;
    SharedPreferences settings;
    int number = 90;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences("Account", MODE_PRIVATE);

        textView = findViewById(R.id.text_view);
    }

    private void convertToMinutes(int number){
        int min = number / 60;
        int sec = number - (min * 60);
        if(number > 0){
            textView.setText("Время: " + min+":"+sec);
        }
    }
    public void plus(View view) {
        getNumber();
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                SharedPreferences.Editor prefEdit = settings.edit();
                prefEdit.putInt("Number", number);
                prefEdit.apply();

                handler.postDelayed(runnable, 1000);
                convertToMinutes(number);
                number--;
            }
        }, 1000);
    }
    public void getNumber(){
        number = settings.getInt("Number", 0);
    }
}