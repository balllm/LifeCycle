package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    }

    public void returnToMainActivity(View view) {
        newNumber = 210;

        Intent intent = new Intent(ConfirmNumber.this, MainActivity.class);
        intent.putExtra("Number", newNumber);
        startActivity(intent);
    }
}