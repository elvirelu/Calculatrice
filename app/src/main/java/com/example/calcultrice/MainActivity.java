package com.example.calcultrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String oldNumber = "";
    String op = "+";
    boolean isNewOp = true;
    String numberOp = "";

    EditText ed1;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editText);
        tv = findViewById(R.id.textV);
    }

    public void numberEvent(View view) {
        if(isNewOp){
            ed1.setText("");
            if(tv.getText().toString().contains("=")) {
                tv.setText("");
            }
        }
        isNewOp = false;
        String number = ed1.getText().toString();
        switch (view.getId()){
            case R.id.bu1:
                number += 1;
                break;
            case R.id.bu2:
                number += 2;
                break;
            case R.id.bu3:
                number += 3;
                break;
            case R.id.bu4:
                number += 4;
                break;
            case R.id.bu5:
                number += 5;
                break;
            case R.id.bu6:
                number += 6;
                break;
            case R.id.bu7:
                number += 7;
                break;
            case R.id.bu8:
                number += 8;
                break;
            case R.id.bu9:
                number += 9;
                break;
            case R.id.bu0:
                number += 0;
                break;
            case R.id.buDot:
                number += ".";
                break;
            case R.id.buPlusMinus:
                number = "-" + number;
                break;
        }
        ed1.setText(number);
    }

    public String calculate(String oldTv,String oldNum) {

        String[] number = oldTv.split(" ");
        double res = 0.0;
        if (oldTv.contains("+")) {
            res = Double.parseDouble(number[0]) + Double.parseDouble(oldNum);
        } else if (oldTv.contains("-")) {
            res = Double.parseDouble(number[0]) - Double.parseDouble(oldNum);
        } else if (oldTv.contains("/")) {
            res = Double.parseDouble(number[0]) / Double.parseDouble(oldNum);
        } else if (oldTv.contains("*")) {
            res = Double.parseDouble(number[0]) * Double.parseDouble(oldNum);
        }
        return res+"";
    }
    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = ed1.getText().toString();
            switch (view.getId()) {
                case R.id.buDivide:
                    op = "/";
                    break;
                case R.id.buMultiply:
                    op = "*";
                    break;
                case R.id.buPlus:
                    op = "+";
                    break;
                case R.id.buMinus:
                    op = "-";
                    break;
            }
        String oldTv = tv.getText().toString();
        if(!oldTv.equals("")){
            oldNumber = calculate(oldTv,oldNumber);
        }
        numberOp = oldNumber + " " + op;
        tv.setText(numberOp);
    }

    public void equalEvent(View view) {
        String newNumber = ed1.getText().toString();
        double result = 0.0;
        switch(op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        ed1.setText(result+"");
        tv.setText(numberOp + " " + newNumber + " =");
        isNewOp = true;
    }

    public void cEvent(View view) {
        ed1.setText("0");
        tv.setText("");
        isNewOp = true;
    }

    public void percentEvent(View view) {
        double no = Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(no+"");
        isNewOp = true;
    }

    public void srEvent(View view) {
        double sr = Math.sqrt(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(sr+"");
        isNewOp = true;
    }

    public void inverseEvent(View view) {
        double inverse = 1 / Double.parseDouble(ed1.getText().toString());
        ed1.setText(inverse+"");
        isNewOp = true;
    }
}