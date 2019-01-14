package com.example.calculator.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.calculator.Fragment.OtherIncome_Fragment;
import com.example.calculator.Fragment.Salary_Fragment;
import com.example.calculator.R;

import java.util.ArrayList;
import java.util.List;

public class Tax_Activity extends AppCompatActivity {
    private final String titles[] = {"月薪","其他收入"};

    private TabLayout tabLayout;
    private ViewPager viewPager;
    List<Fragment> fragments;

    private TaxPagerAdapter taxPagerAdapter =
            new TaxPagerAdapter(getSupportFragmentManager());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);

        tabLayout = findViewById(R.id.tab_tax);
        viewPager = findViewById(R.id.viewpager_tax);

        viewPager.setAdapter(taxPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        fragments = new ArrayList<>();
        fragments.add(new Salary_Fragment());
        fragments.add(new OtherIncome_Fragment());

    }

    private class TaxPagerAdapter extends FragmentPagerAdapter{

        public TaxPagerAdapter(FragmentManager fm) {
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
