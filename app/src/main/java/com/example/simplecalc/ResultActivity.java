package com.example.simplecalc;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView detailsText;
    LinearLayout resultLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        detailsText = findViewById(R.id.details_text);
        resultLayout = findViewById(R.id.result_layout);

        double num1 = getIntent().getDoubleExtra("num1", 0);
        double num2 = getIntent().getDoubleExtra("num2", 0);
        String operation = getIntent().getStringExtra("operation");
        double result = getIntent().getDoubleExtra("result", 0);

        String details =
                "First Number: " + num1 + "\n\n" +
                        "Second Number: " + num2 + "\n\n" +
                        "Operation: " + operation + "\n\n" +
                        "Result: " + result;

        detailsText.setText(details);

        if (operation != null) {
            if (operation.equals("ADD")) {
                resultLayout.setBackgroundColor(Color.parseColor("#E8F5E9"));
                detailsText.setTextColor(Color.parseColor("#2E7D32"));
            } else if (operation.equals("SUB")) {
                resultLayout.setBackgroundColor(Color.parseColor("#E3F2FD"));
                detailsText.setTextColor(Color.parseColor("#1565C0"));
            } else if (operation.equals("DIV")) {
                resultLayout.setBackgroundColor(Color.parseColor("#FCE4EC"));
                detailsText.setTextColor(Color.parseColor("#AD1457"));
            } else if (operation.equals("MUL")) {
                resultLayout.setBackgroundColor(Color.parseColor("#FFF3E0"));
                detailsText.setTextColor(Color.parseColor("#EF6C00"));
            }
        }
    }

    public void goBack(View view) {
        finish();
    }
}