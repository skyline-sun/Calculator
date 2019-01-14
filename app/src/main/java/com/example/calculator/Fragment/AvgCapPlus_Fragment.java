package com.example.calculator.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calculator.R;
import com.example.calculator.Utils.LoanData;
import com.example.calculator.Utils.Mortgage;

import org.angmarch.views.NiceSpinner;

public class AvgCapPlus_Fragment extends Fragment {
    private EditText Mortgage, Sum, Interest, MonSum;
    private NiceSpinner Time, Pattern, Rate;
    private Button cal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loan_avg_cap_plus, container, false);

        initView(view);

        final LoanData loanData = new LoanData();
        Time.attachDataSource(loanData.getTime());
        Time.setSelectedIndex(29);

        Pattern.attachDataSource(loanData.getPattern());
        Pattern.setSelectedIndex(0);

        Rate.attachDataSource(loanData.getRateOrdinary(30));
        Rate.setSelectedIndex(3);


        Time.addOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (Pattern.getSelectedIndex() == 0) {
                    Rate.attachDataSource(loanData.getRateOrdinary(position + 1));
                    Rate.setSelectedIndex(3);
                } else {
                    Rate.attachDataSource(loanData.getRateFund(position + 1));
                    Rate.setSelectedIndex(0);
                }
            }
        });

        Pattern.addOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int year = Time.getSelectedIndex() + 1;
                if (position == 0) {
                    Rate.attachDataSource(loanData.getRateOrdinary(year));
                    Rate.setSelectedIndex(3);
                } else {
                    Rate.attachDataSource(loanData.getRateFund(year));
                    Rate.setSelectedIndex(0);
                }
            }
        });


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m = Mortgage.getText().toString();
                String t = String.valueOf(Time.getSelectedIndex() + 1);


                if (0 == m.length() || 0 == t.length()) {
                    Toast.makeText(getActivity(), "请输入数据", Toast.LENGTH_SHORT).show();
                }
                else if(Double.valueOf(m)>10000)
                    Toast.makeText(getActivity(), "请输入合理的贷款总额", Toast.LENGTH_SHORT).show();
                else {
                    double rate = loanData.getRate(Pattern.getSelectedIndex(), Time.getSelectedIndex() + 1, Rate.getSelectedIndex());
                    Toast.makeText(getActivity(), Double.toString(rate), Toast.LENGTH_SHORT).show();

                    int mortgage = Integer.valueOf(m);
                    int time = Integer.valueOf(t);

                    Mortgage calculation = new Mortgage(mortgage, rate, time);
                    calculation.transData();

                    calculation.calculateTypeOne();

                    Sum.setText(calculation.getSum_str());
                    Interest.setText(calculation.getInterest_str());
                    MonSum.setText(calculation.getMonthsum_str());
                }
            }

        });

        return view;
    }

    private void initView(View view) {
        Mortgage = view.findViewById(R.id.edit_Mortgage);

        Time = view.findViewById(R.id.spinner_time);
        Pattern = view.findViewById(R.id.spinner_pattern);
        Rate = view.findViewById(R.id.spinner_rate);

        Sum = view.findViewById(R.id.edit_Sum);
        Interest = view.findViewById(R.id.edit_Interest);
        MonSum = view.findViewById(R.id.edit_MonSumAvgCapPlus);

        cal = view.findViewById(R.id.btn_Cal);
    }

}
