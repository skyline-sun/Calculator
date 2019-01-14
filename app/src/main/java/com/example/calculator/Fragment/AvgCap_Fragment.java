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
import com.example.calculator.Utils.Mortgage;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.List;

public class AvgCap_Fragment extends Fragment {
    private EditText Mortgage, Time, Sum, Interest, MonSum;
    private NiceSpinner Pattern, Rate;
    private Button cal;

    private final double RateOrdinary[] = {3.43, 3.92, 4.41, 4.9, 5.39, 5.88, 6.37, 6.86};
    private final double RateFund[] = {3.25, 3.575, 3.9};
    

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loan_avg_cap, container, false);

        initView(view);
        Pattern.attachDataSource(getPattern());
        Pattern.setSelectedIndex(0);
        Rate.attachDataSource(getRateOrdinary());
        Rate.setSelectedIndex(3);

        Pattern.addOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Rate.attachDataSource(getRateOrdinary());
                        Rate.setSelectedIndex(3);
                        break;
                    case 1:
                        Rate.attachDataSource(getRateFund());
                        Rate.setSelectedIndex(0);
                        break;
                }
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m = Mortgage.getText().toString();
                String t = Time.getText().toString();

                if(0 == m.length()||0 == t.length()){
                    Toast.makeText(getActivity(),"请输入数据",Toast.LENGTH_SHORT).show();
                } else {
                    double rate;
                    switch (Pattern.getSelectedIndex()){
                        case 0:
                            rate = RateOrdinary[Rate.getSelectedIndex()];
                            break;
                        case 1:
                            rate = RateFund[Rate.getSelectedIndex()];
                            break;
                        default:
                            rate = 4.9;
                            break;
                    }

                    int mortgage = Integer.valueOf(m);
                    int time = Integer.valueOf(t);

                    Mortgage calculation = new Mortgage(mortgage, rate, time);
                    calculation.transData();

                    calculation.calculateTypeTwo();

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
        Time = view.findViewById(R.id.edit_Time);

        Pattern = view.findViewById(R.id.spinner_pattern);
        Rate = view.findViewById(R.id.spinner_rate);

        Sum = view.findViewById(R.id.edit_Sum);
        Interest = view.findViewById(R.id.edit_Interest);
        MonSum = view.findViewById(R.id.edit_MonSumAvgCap);

        cal = view.findViewById(R.id.btn_Cal);
    }


    private List<String> getPattern(){
        List<String> pattern = new ArrayList<>();
        pattern.add("商业贷款");
        pattern.add("公积金贷款");
        return pattern;
    }

    private List<String> getRateOrdinary(){
        List<String> rate = new ArrayList<>();
        rate.add("3.43%(7折)");
        rate.add("3.92%(8折)");
        rate.add("4.41%(9折)");
        rate.add("4.9%(基准利率)");
        rate.add("5.39%(1.1倍)");
        rate.add("5.88%(1.2倍)");
        rate.add("6.37%(1.3倍)");
        rate.add("6.86%(1.4倍)");
        return rate;
    }

    private List<String> getRateFund(){
        List<String> rate = new ArrayList<>();
        rate.add("3.25%(基准利率)");
        rate.add("3.575%(1.1倍)");
        rate.add("3.9%(1.2倍)");
        return rate;
    }
}
