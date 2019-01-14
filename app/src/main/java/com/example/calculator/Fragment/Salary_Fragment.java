package com.example.calculator.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calculator.Bean.SalaryBean;
import com.example.calculator.R;
import com.example.calculator.Utils.Tax;

public class Salary_Fragment extends Fragment {
    private EditText Salary, GongJiJin, YiLiao, YangLao, ShiYe, GongShang, ShengYu, AfterSalary;

    private Button cal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tax_salary, container, false);

        Salary = view.findViewById(R.id.edit_Salary);
        GongJiJin = view.findViewById(R.id.edit_GongJiJin);
        YiLiao = view.findViewById(R.id.edit_YiLiao);
        YangLao = view.findViewById(R.id.edit_YangLao);
        ShiYe = view.findViewById(R.id.edit_ShiYe);
        GongShang = view.findViewById(R.id.edit_GongShang);
        ShengYu = view.findViewById(R.id.edit_ShengYu);
        AfterSalary = view.findViewById(R.id.edit_AfterSalary);

        cal = view.findViewById(R.id.btn_salaryCal);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (0 == Salary.getText().length()) {
                    Toast.makeText(getActivity(), "请输入税前工资", Toast.LENGTH_SHORT).show();
                } else if (0 == GongJiJin.getText().length()) {
                    Toast.makeText(getActivity(), "请输入公积金比例", Toast.LENGTH_SHORT).show();
                } else if (0 == YiLiao.getText().length()) {
                    Toast.makeText(getActivity(), "请输入医疗险比例", Toast.LENGTH_SHORT).show();
                } else if (0 == YangLao.getText().length()) {
                    Toast.makeText(getActivity(), "请输入养老险比例", Toast.LENGTH_SHORT).show();
                } else if (0 == ShiYe.getText().length()) {
                    Toast.makeText(getActivity(), "请输入失业险比例", Toast.LENGTH_SHORT).show();
                } else if (0 == GongShang.getText().length()) {
                    Toast.makeText(getActivity(), "请输入工伤险比例", Toast.LENGTH_SHORT).show();
                } else if (0 == ShengYu.getText().length()) {
                    Toast.makeText(getActivity(), "请输入生育险比例", Toast.LENGTH_SHORT).show();
                } else {
                    SalaryBean salary = new SalaryBean();
                    salary.setSalary(Integer.valueOf(Salary.getText().toString()));
                    salary.setGongJiJIn(Double.valueOf(GongJiJin.getText().toString()));
                    salary.setYiLiao(Double.valueOf(YiLiao.getText().toString()));
                    salary.setYangLao(Double.valueOf(YangLao.getText().toString()));
                    salary.setShiYe(Double.valueOf(ShiYe.getText().toString()));
                    salary.setGongShang(Double.valueOf(GongShang.getText().toString()));
                    salary.setShengYu(Double.valueOf(ShengYu.getText().toString()));

                    Tax tax = new Tax();
                    AfterSalary.setText(Double.toString(tax.getMonthTax(salary)));
                }
            }
        });

        return view;
    }


}
