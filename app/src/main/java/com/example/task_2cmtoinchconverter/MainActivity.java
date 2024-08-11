package com.example.task_2cmtoinchconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private RadioGroup rgConversionType;
    private RadioButton rbCmToInch, rbInchToCm;
    private Button btnConvert;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        etInput = findViewById(R.id.et_input);
        rgConversionType = findViewById(R.id.rg_conversion_type);
        rbCmToInch = findViewById(R.id.rb_cm_to_inch);
        rbInchToCm = findViewById(R.id.rb_inch_to_cm);
        btnConvert = findViewById(R.id.btn_convert);
        tvResult = findViewById(R.id.tv_result);

        // Set click listener for the convert button
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }

    // Method to handle conversion based on selected option
    private void convert() {
        String input = etInput.getText().toString();

        // Check if the input is not empty
        if (!input.isEmpty()) {
            double inputValue = Double.parseDouble(input);
            double resultValue;

            // Check which conversion is selected
            if (rbCmToInch.isChecked()) {
                // Convert cm to inch
                resultValue = inputValue / 2.54;
                tvResult.setText("Result: " + String.format("%.2f", resultValue) + " inches");
            } else if (rbInchToCm.isChecked()) {
                // Convert inch to cm
                resultValue = inputValue * 2.54;
                tvResult.setText("Result: " + String.format("%.2f", resultValue) + " cm");
            }
        } else {
            // If the input is empty, show a message
            tvResult.setText("Please enter a value");
        }
    }
}
