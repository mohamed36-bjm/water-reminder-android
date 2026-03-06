package com.example.projectshih_tp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvWaterLeft;
    ProgressBar progressWater;
    LinearLayout layoutCups;

    int totalWater;
    int waterLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvWaterLeft = findViewById(R.id.tvWaterLeft);
        progressWater = findViewById(R.id.progressWater);
        layoutCups = findViewById(R.id.layoutCups);

        String weightStr = getIntent().getStringExtra("weight");
        String gender = getIntent().getStringExtra("gender");
        String weather = getIntent().getStringExtra("weather");

        int weight = Integer.parseInt(weightStr);

        // حساب كمية الماء
        totalWater = weight * 35;
        if(gender.equalsIgnoreCase("Homme")) totalWater += 200;
        switch (weather){
            case "Chaud": totalWater += 500; break;
            case "Froid": totalWater -= 100; break;
            case "Pluvieux": totalWater -= 50; break;
        }

        waterLeft = totalWater;

        progressWater.setMax(totalWater);
        progressWater.setProgress(waterLeft);
        tvWaterLeft.setText(waterLeft + " ml");

        // أكواب مختلفة الأحجام
        int[] cupSizes = {150, 200, 250, 300, 350};

        for (int size : cupSizes) {
            Button cup = new Button(this);
            cup.setText(size + " ml");
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(8,0,8,0);
            cup.setLayoutParams(params);

            cup.setOnClickListener(v -> {
                if (waterLeft > 0) {
                    waterLeft -= size;
                    if (waterLeft < 0) waterLeft = 0;
                    progressWater.setProgress(waterLeft);
                    tvWaterLeft.setText(waterLeft + " ml");
                }
            });

            layoutCups.addView(cup);
        }
    }
}