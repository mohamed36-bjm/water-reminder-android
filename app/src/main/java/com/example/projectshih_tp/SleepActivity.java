package com.example.projectshih_tp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TimePicker;

public class SleepActivity extends AppCompatActivity {

    TimePicker timePicker;
    Button btnNext, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        timePicker = findViewById(R.id.timePicker);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());

        btnNext.setOnClickListener(v -> {
            String sleepTime = timePicker.getHour() + ":" + timePicker.getMinute();

            Intent intent = new Intent(SleepActivity.this, ResultActivity.class);
            intent.putExtra("gender", getIntent().getStringExtra("gender"));
            intent.putExtra("weight", getIntent().getStringExtra("weight"));
            intent.putExtra("weather", getIntent().getStringExtra("weather"));
            intent.putExtra("wake", getIntent().getStringExtra("wake"));
            intent.putExtra("sleep", sleepTime);
            startActivity(intent);
        });
    }
}