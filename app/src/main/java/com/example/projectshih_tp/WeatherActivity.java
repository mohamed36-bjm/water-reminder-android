package com.example.projectshih_tp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class WeatherActivity extends AppCompatActivity {

    Spinner spWeather;
    Button btnNext, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        spWeather = findViewById(R.id.spWeather);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);

        // إضافة خيارات الطقس
        String[] weatherOptions = {"Normal", "Chaud", "Froid", "Pluvieux"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, weatherOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spWeather.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());

        btnNext.setOnClickListener(v -> {
            String weather = spWeather.getSelectedItem().toString();
            String gender = getIntent().getStringExtra("gender");

            Intent intent = new Intent(WeatherActivity.this, WeightActivity.class);
            intent.putExtra("gender", gender);
            intent.putExtra("weather", weather);
            startActivity(intent);
        });
    }
}