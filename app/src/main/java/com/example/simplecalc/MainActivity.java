package com.example.simplecalc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText firstNumber, secondNumber;
    TextView resultText;
    LinearLayout mainLayout;

    double num1 = 0;
    double num2 = 0;
    double result = 0;

    String operation = "";
    String resultValue = "Result";

    int backgroundColor = Color.WHITE;
    int textColor = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.first_number);
        secondNumber = findViewById(R.id.second_number);
        resultText = findViewById(R.id.result_text);
        mainLayout = findViewById(R.id.main_layout);

        if (savedInstanceState != null) {
            num1 = savedInstanceState.getDouble("num1", 0);
            num2 = savedInstanceState.getDouble("num2", 0);
            result = savedInstanceState.getDouble("result", 0);
            operation = savedInstanceState.getString("operation", "");
            resultValue = savedInstanceState.getString("resultValue", "Result");
            backgroundColor = savedInstanceState.getInt("backgroundColor", Color.WHITE);
            textColor = savedInstanceState.getInt("textColor", Color.BLACK);

            resultText.setText(resultValue);
            resultText.setTextColor(textColor);
            mainLayout.setBackgroundColor(backgroundColor);
        }
    }

    public void addNumbers(View view) {
        if (readNumbers()) {
            result = num1 + num2;
            operation = "ADD";
            resultValue = String.valueOf(result);

            backgroundColor = Color.parseColor("#E8F5E9");
            textColor = Color.parseColor("#2E7D32");

            showResult();
        }
    }

    public void subNumbers(View view) {
        if (readNumbers()) {
            result = num1 - num2;
            operation = "SUB";
            resultValue = String.valueOf(result);

            backgroundColor = Color.parseColor("#E3F2FD");
            textColor = Color.parseColor("#1565C0");

            showResult();
        }
    }

    public void divNumbers(View view) {
        if (readNumbers()) {
            if (num2 == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }

            result = num1 / num2;
            operation = "DIV";
            resultValue = String.valueOf(result);

            backgroundColor = Color.parseColor("#FCE4EC");
            textColor = Color.parseColor("#AD1457");

            showResult();
        }
    }

    public void mulNumbers(View view) {
        if (readNumbers()) {
            result = num1 * num2;
            operation = "MUL";
            resultValue = String.valueOf(result);

            backgroundColor = Color.parseColor("#FFF3E0");
            textColor = Color.parseColor("#EF6C00");

            showResult();
        }
    }

    private boolean readNumbers() {
        String first = firstNumber.getText().toString();
        String second = secondNumber.getText().toString();

        if (first.isEmpty() || second.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return false;
        }

        num1 = Double.parseDouble(first);
        num2 = Double.parseDouble(second);

        return true;
    }

    private void showResult() {
        resultText.setText(resultValue);
        resultText.setTextColor(textColor);
        mainLayout.setBackgroundColor(backgroundColor);
    }

    public void openResultActivity(View view) {
        if (operation.isEmpty()) {
            Toast.makeText(this, "Please calculate first", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, ResultActivity.class);

        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);
        intent.putExtra("operation", operation);
        intent.putExtra("result", result);

        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("num1", num1);
        outState.putDouble("num2", num2);
        outState.putDouble("result", result);
        outState.putString("operation", operation);
        outState.putString("resultValue", resultValue);
        outState.putInt("backgroundColor", backgroundColor);
        outState.putInt("textColor", textColor);
    }
}