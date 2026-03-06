package com.example.projectshih_tp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class WeightActivity extends AppCompatActivity {

    EditText etWeight;
    Button btnNext, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        etWeight = findViewById(R.id.etWeight);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());

        btnNext.setOnClickListener(v -> {
            String weight = etWeight.getText().toString();
            String gender = getIntent().getStringExtra("gender");
            String weather = getIntent().getStringExtra("weather");

            Intent intent = new Intent(WeightActivity.this, WakeUpActivity.class);
            intent.putExtra("gender", gender);
            intent.putExtra("weight", weight);
            intent.putExtra("weather", weather);
            startActivity(intent);
        });
    }
}