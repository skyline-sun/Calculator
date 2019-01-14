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

import com.example.calculator.R;
import com.example.calculator.Utils.Tax;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.List;

public class OtherIncome_Fragment extends Fragment {
    private NiceSpinner IncomeType;
    private EditText BeforeTax, AfterTax;
    private Button cal;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tax_other, container, false);

        IncomeType = view.findViewById(R.id.spinner_incomeType);

        IncomeType.attachDataSource(getIncomeType());
        IncomeType.setSelectedIndex(0);

        BeforeTax = view.findViewById(R.id.edit_beforeTax);
        AfterTax = view.findViewById(R.id.edit_AfterTax);

        cal = view.findViewById(R.id.btn_annualCal);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(0 == BeforeTax.getText().length()){
                    Toast.makeText(getActivity(), "请输入数据", Toast.LENGTH_SHORT).show();
                } else {
                    Tax tax = new Tax();
                    String beforeTax = BeforeTax.getText().toString();
                    switch (IncomeType.getSelectedIndex()){
                        case 0:
                            int annual = Integer.valueOf(beforeTax);
                            AfterTax.setText(Double.toString(tax.getAnnual(annual)));
                            break;
                        case 1:
                            int writing = Integer.valueOf(beforeTax);
                            AfterTax.setText(Double.toString(tax.getWritting(writing)));
                            break;
                        case 2:
                            int windfall = Integer.valueOf(beforeTax);
                            AfterTax.setText(Double.toString(tax.getWindfall(windfall)));
                            break;
                    }
                }
            }
        });

        return view;
    }

    private List<String> getIncomeType(){
        List<String> type = new ArrayList<>();
        type.add("年终奖");
        type.add("稿酬");
        type.add("意外所得");
        return type;
    }
}
