package com.example.calculator.Activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.calculator.R;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
    private final String tags[] = {"calculator","loan","Tax","conversion"};
    private final String titles[] = {"简单计算","贷款计算","个税计算","单位转换"};

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        tabHost = getTabHost();

        tabHost.addTab(tabHost.newTabSpec(tags[0]).setIndicator(titles[0]).
                setContent(new Intent(this, Cal_Activity.class)));
        tabHost.addTab(tabHost.newTabSpec(tags[1]).setIndicator(titles[1]).
                setContent(new Intent(this, Loan_Activity.class)));
        tabHost.addTab(tabHost.newTabSpec(tags[2]).setIndicator(titles[2]).
                setContent(new Intent(this, Tax_Activity.class)));
        tabHost.addTab(tabHost.newTabSpec(tags[3]).setIndicator(titles[3]).
                setContent(new Intent(this, Con_Activity.class)));

    }


}
