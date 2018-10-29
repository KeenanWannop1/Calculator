package com.example.admin.calculator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.lang.*;

import com.example.admin.calculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DecimalFormat decimalFormat;
    private ActivityMainBinding binding;
    private String OPERATION_CLICKED;
    private double firstNumber = Double.NaN;
    private double secondNumber = Double.NaN;
    private String holder = "";
    private List<String> operationHolder = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decimalFormat = new DecimalFormat("#.##########");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.entryField.setText(binding.entryField.getText() + "9");
            }
        });
        binding.buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.entryField.setText(binding.entryField.getText() + "8");
            }
        });
        binding.buttonSeven.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                binding.entryField.setText(binding.entryField.getText() + "7");
            }
        });
        binding.buttonSix.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                binding.entryField.setText(binding.entryField.getText() + "6");
            }
        });
        binding.buttonFive.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                binding.entryField.setText(binding.entryField.getText() + "5");
            }
        });
        binding.buttonFour.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                binding.entryField.setText(binding.entryField.getText() + "4");
            }
        });
        binding.buttonThree.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                binding.entryField.setText(binding.entryField.getText() + "3");
            }
        });
        binding.buttonTwo.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                binding.entryField.setText(binding.entryField.getText() + "2");
            }
        });
        binding.buttonOne.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                binding.entryField.setText(binding.entryField.getText() + "1");
            }
        });
        binding.buttonDecimal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                binding.entryField.setText(binding.entryField.getText() + ".");
            }
        });
        binding.buttonPlus.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                OPERATION_CLICKED = "+";
                binding.entryField.setText(binding.entryField.getText() + "+");

            }
        });
        binding.buttonMinus.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                OPERATION_CLICKED = "-";
                binding.entryField.setText(binding.entryField.getText() + "-");
            }
        });
        binding.buttonMultiply.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                OPERATION_CLICKED = "*";
                binding.entryField.setText(binding.entryField.getText() + "*");
            }
        });
        binding.buttonDivide.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                OPERATION_CLICKED = "/";
                binding.entryField.setText(binding.entryField.getText() + "/");
            }
        });

        binding.buttonCos.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                OPERATION_CLICKED = "cos";
                calculation();
                binding.entryField.setText(decimalFormat.format(firstNumber));
            }
        });
        binding.buttonSin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                OPERATION_CLICKED = "sin";
                calculation();
                binding.entryField.setText(decimalFormat.format(firstNumber));
            }
        });
        binding.buttonTan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                OPERATION_CLICKED = "tan";
                calculation();
                binding.entryField.setText(decimalFormat.format(firstNumber));
            }
        });

        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.entryField.setText("");
                firstNumber = Double.NaN;
                secondNumber = Double.NaN;
            }
        });
        binding.buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation();
                binding.entryField.setText(decimalFormat.format(firstNumber));
            }
        });

    }

    public void calculation() {
            holder = (String)binding.entryField.getText();
            String[] splitHolder;

            switch (OPERATION_CLICKED) {
                case "+":
                    splitHolder = holder.split("\\+");
                    firstNumber = Double.parseDouble(splitHolder[0]);
                    secondNumber = Double.parseDouble(splitHolder[1]);
                    firstNumber = this.firstNumber + secondNumber;
                    break;
                case "-":
                    splitHolder = holder.split("-");
                    firstNumber = Double.parseDouble(splitHolder[0]);
                    secondNumber = Double.parseDouble(splitHolder[1]);
                    firstNumber = this.firstNumber - secondNumber;
                    break;
                case "*":
                    splitHolder = holder.split("\\*");
                    firstNumber = Double.parseDouble(splitHolder[0]);
                    secondNumber = Double.parseDouble(splitHolder[1]);
                    firstNumber = this.firstNumber * secondNumber;
                    break;
                case "/":
                    splitHolder = holder.split("/");
                    firstNumber = Double.parseDouble(splitHolder[0]);
                    secondNumber = Double.parseDouble(splitHolder[1]);
                    firstNumber = this.firstNumber / secondNumber;
                    break;
                case "cos":
                    firstNumber = Double.parseDouble(holder);
                    firstNumber = Math.cos(this.firstNumber);
                case "sin":
                    firstNumber = Double.parseDouble(holder);
                    firstNumber = Math.sin(this.firstNumber);
                case "tan":
                    firstNumber = Double.parseDouble(holder);
                    firstNumber = Math.tan(this.firstNumber);

            }
        }
    }


