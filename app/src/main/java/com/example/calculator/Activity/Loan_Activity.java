package com.example.calculator.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.calculator.Fragment.AvgCapPlus_Fragment;
import com.example.calculator.Fragment.AvgCap_Fragment;
import com.example.calculator.R;

import java.util.ArrayList;
import java.util.List;

public class Loan_Activity extends AppCompatActivity {
    private final String titles[] = {"等额本息","等额本金"};

    private TabLayout tabLayout;
    private ViewPager viewPager;
    List<Fragment> fragments;

    private LoanPagerAdapter loanPagerAdapter =
            new LoanPagerAdapter(getSupportFragmentManager());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        tabLayout = findViewById(R.id.tab_loan);
        viewPager = findViewById(R.id.viewpager_loan);

        viewPager.setAdapter(loanPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        fragments = new ArrayList<>();
        fragments.add(new AvgCapPlus_Fragment());
        fragments.add(new AvgCap_Fragment());

    }

    private class LoanPagerAdapter extends FragmentPagerAdapter{
        public LoanPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
