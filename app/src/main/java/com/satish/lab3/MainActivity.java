package com.satish.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1, etNumber2;
    private Button btnAdd, btnSubtract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI Elements
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);

        // Button Click Listeners
        btnAdd.setOnClickListener(v -> calculateResult("+"));
        btnSubtract.setOnClickListener(v -> calculateResult("-"));
    }

    private void calculateResult(String operation) {
        String num1Str = etNumber1.getText().toString().trim();
        String num2Str = etNumber2.getText().toString().trim();

        // Check if inputs are empty
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        // Convert to numbers
        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = operation.equals("+") ? num1 + num2 : num1 - num2;

        // Pass result to ResultActivity
        Intent intent = new Intent(MainActivity.this,
                ResultActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}
