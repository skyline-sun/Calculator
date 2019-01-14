package com.example.calculator.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculator.R;

import java.util.HashMap;
import java.util.Map;

public class Cal_Activity extends AppCompatActivity {
    private Button Num00, Num0, Num1, Num2, Num3, Num4, Num5, Num6, Num7, Num8, Num9,
            Point, Plus, Minus, Multiply, Divide, Equal, AC, Percent, Del;

    private Map<View,String> map;
    private EditText input, output;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initView();
        initMap();
        setOnClickListener();

    }

    private void setOnClickListener() {
        Num00.setOnClickListener(new numberListener());
        Num0.setOnClickListener(new numberListener());
        Num1.setOnClickListener(new numberListener());
        Num2.setOnClickListener(new numberListener());
        Num3.setOnClickListener(new numberListener());
        Num4.setOnClickListener(new numberListener());
        Num5.setOnClickListener(new numberListener());
        Num6.setOnClickListener(new numberListener());
        Num7.setOnClickListener(new numberListener());
        Num8.setOnClickListener(new numberListener());
        Num9.setOnClickListener(new numberListener());

        Point = findViewById(R.id.btn_point);
        Plus = findViewById(R.id.btn_plus);
        Minus = findViewById(R.id.btn_minus);
        Multiply = findViewById(R.id.btn_multiply);
        Divide = findViewById(R.id.btn_divide);
        Equal = findViewById(R.id.btn_equal);
        AC = findViewById(R.id.btn_ac);
        Percent = findViewById(R.id.btn_percent);
        Del = findViewById(R.id.btn_delete);

    }

    private void initMap() {
        map = new HashMap<>();
        map.put(Num00,"00");
        map.put(Num0,"0");
        map.put(Num1,"1");
        map.put(Num2,"2");
        map.put(Num3,"3");
        map.put(Num4,"4");
        map.put(Num5,"5");
        map.put(Num6,"6");
        map.put(Num7,"7");
        map.put(Num8,"8");
        map.put(Num9,"9");

        map.put(Point,".");
        map.put(Plus,"+");
        map.put(Minus,"-");
        map.put(Multiply,"*");
        map.put(Divide,"/");
        map.put(Equal,"=");
        map.put(AC,"ac");
        map.put(Percent,"%");
        map.put(Del,"del");
    }

    private void initView(){
        Num00 = findViewById(R.id.btn_num00);
        Num0 = findViewById(R.id.btn_num0);
        Num1 = findViewById(R.id.btn_num1);
        Num2 = findViewById(R.id.btn_num2);
        Num3 = findViewById(R.id.btn_num3);
        Num4 = findViewById(R.id.btn_num4);
        Num5 = findViewById(R.id.btn_num5);
        Num6 = findViewById(R.id.btn_num6);
        Num7 = findViewById(R.id.btn_num7);
        Num8 = findViewById(R.id.btn_num8);
        Num9 = findViewById(R.id.btn_num9);

        Point = findViewById(R.id.btn_point);
        Plus = findViewById(R.id.btn_plus);
        Minus = findViewById(R.id.btn_minus);
        Multiply = findViewById(R.id.btn_multiply);
        Divide = findViewById(R.id.btn_divide);
        Equal = findViewById(R.id.btn_equal);
        AC = findViewById(R.id.btn_ac);
        Percent = findViewById(R.id.btn_percent);
        Del = findViewById(R.id.btn_delete);

        input = findViewById(R.id.cal_input);
        output = findViewById(R.id.cal_output);
    }

    //数字键监听
    private class numberListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            InputNum(view);
        }
    }

    private void InputNum(View view) {
        input.append(map.get(view));
    }

    //运算符键监听
    private class operListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            InputOper(view);
        }
    }

    private void InputOper(View view) {

    }


}

