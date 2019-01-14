package com.example.calculator.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calculator.R;
import com.example.calculator.Utils.Length;
import com.example.calculator.Utils.Weight;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.List;

public class Con_Activity extends AppCompatActivity {

    private NiceSpinner Unit,One,Two;

    private EditText input,output;

    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        Unit = findViewById(R.id.spinner_unit);
        One = findViewById(R.id.spinner_one);
        Two = findViewById(R.id.spinner_two);

        input = findViewById(R.id.edit_input);
        output = findViewById(R.id.edit_output);

        btn = findViewById(R.id.btn_Cal);

        Unit.attachDataSource(getUnit());

        //默认显示长度，加载长度单位
        Unit.setSelectedIndex(0);
        One.attachDataSource(getLength());
        Two.attachDataSource(getLength());
        /*One.addOnItemClickListener(new spinnerListener());
        Two.addOnItemClickListener(new spinnerListener());*/

        Unit.addOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        One.attachDataSource(getLength());
                        Two.attachDataSource(getLength());
                        /*One.addOnItemClickListener(new spinnerListener());
                        Two.addOnItemClickListener(new spinnerListener());*/
                        break;
                    case 1:
                        One.attachDataSource(getWeight());
                        Two.attachDataSource(getWeight());
                        /*One.addOnItemClickListener(new spinnerListener());
                        Two.addOnItemClickListener(new spinnerListener());*/
                        break;
                }
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int unitPosition = Unit.getSelectedIndex();
                int position1 = One.getSelectedIndex();
                int position2 = Two.getSelectedIndex();

                if (0 == input.getText().length()){
                    Toast.makeText(Con_Activity.this,"请输入数据",Toast.LENGTH_SHORT).show();

                } else {
                    switch (unitPosition){
                        case 0:
                            Length length = new Length();
                            double outLength = length.transform(Double.valueOf(input.getText().toString()),position1,position2);
                            output.setText(Double.toString(outLength));
                            break;
                        case 1:
                            Weight weight = new Weight();
                            double outWeight = weight.transform(Double.valueOf(input.getText().toString()),position1,position2);
                            output.setText(Double.toString(outWeight));
                            break;
                    }
                }

            }
        });

    }

    private List<String> getUnit(){
        List<String> unit = new ArrayList<>();
        unit.add("长度");
        unit.add("质量");
        return unit;
    }

    //0-千克  1-两  2-磅  3-盎司
    private List<String> getWeight(){
        List<String> weight= new ArrayList<>();
        weight.add("千克");
        weight.add("两");
        weight.add("磅");
        weight.add("盎司");
        return weight;
    }

    //0-米  1-尺  2-英里  3-英寸  4-英尺
    private List<String> getLength(){
        List<String> length = new ArrayList<>();
        length.add("米");
        length.add("尺");
        length.add("英里");
        length.add("英寸");
        length.add("英尺");
        return length;
    }


    /*private class spinnerListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }*/


}
