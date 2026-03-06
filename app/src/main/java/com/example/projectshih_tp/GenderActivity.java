package com.example.projectshih_tp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class GenderActivity extends AppCompatActivity {

    RadioGroup rgGender;
    Button btnNext, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        rgGender = findViewById(R.id.rgGender);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());

        btnNext.setOnClickListener(v -> {
            int selectedId = rgGender.getCheckedRadioButtonId();
            RadioButton rb = findViewById(selectedId);
            String gender = rb.getText().toString();

            Intent intent = new Intent(GenderActivity.this, WeatherActivity.class);
            intent.putExtra("gender", gender);
            startActivity(intent);
        });
    }
}