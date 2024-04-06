package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable runnable;
    TextView textView;
    SharedPreferences settings;
    int newNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences("Account", MODE_PRIVATE);

        textView = findViewById(R.id.text_view);

        newNumber = getIntent().getIntExtra("Number", 0);
    }
    private void convertToMinutes(int number){
        int min = newNumber / 60;
        int sec = newNumber - (min * 60);
        if(newNumber >= 0){
            textView.setText("Время: " + min+":"+sec);
        }
    }
    public void plus(View view) {
//        getNumber();
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
//                SharedPreferences.Editor prefEdit = settings.edit();
//                prefEdit.putInt("Number", newNumber);
//                prefEdit.apply();

                handler.postDelayed(runnable, 1000);
                convertToMinutes(newNumber);
                newNumber--;


                SharedPreferences.Editor prefEdit = settings.edit();
                prefEdit.putInt("Number", newNumber);
                prefEdit.apply();
            }
        }, 1000);
    }
    public void confirm(View view) {
        Intent intent = new Intent(MainActivity.this, ConfirmNumber.class);
        // вроде не надо тк надо чтобы number с другого класса в main отправить
//        intent.putExtra("Number", number);
        SharedPreferences.Editor prefEdit = settings.edit();
        prefEdit.remove("Number");
        prefEdit.apply();
        startActivity(intent);
    }
    public void getNumber(){
        newNumber = settings.getInt("Number", 0);
    }
}