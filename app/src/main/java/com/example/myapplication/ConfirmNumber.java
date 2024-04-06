package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmNumber extends AppCompatActivity {
    int newNumber;
    TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm);

        Intent intent = getIntent();

        text = findViewById(R.id.text);
        text.setText("Введите текст");
        // тут можно менять number
        newNumber = 210;

        Intent intent2 = new Intent(ConfirmNumber.this, MainActivity.class);
        intent2.putExtra("Number", newNumber);
        startActivity(intent2);
    }
}