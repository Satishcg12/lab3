package com.satish.lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView tvResult;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Initialize UI Elements
        tvResult = findViewById(R.id.tvResult);
        btnBack = findViewById(R.id.btnBack);

        // Get result from Intent
        double result = getIntent().getDoubleExtra("result", 0);
        tvResult.setText(String.valueOf(result));

        // Button Click Listener (Go Back)
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close activity and go back
            }
        });
    }
}
