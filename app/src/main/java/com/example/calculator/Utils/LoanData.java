package com.example.calculator.Utils;

import java.util.ArrayList;
import java.util.List;

public class LoanData {
    private final double RateOrdinaryBelow1[] ={3.045, 3.48, 3.915, 4.35, 4.785, 5.22, 5.655};
    private final double RateOrdinary1To5[] = {3.325, 3.80, 4.275, 4.75, 5.225, 5.70, 6.175};
    private final double RateOrdinaryOver5[] = {3.43, 3.92, 4.41, 4.9, 5.39, 5.88, 6.37};
    private final String RateOrdinaryPercent[] = {"7折", "8折", "9折", "基准利率", "1.1倍", "1.2倍", "1.3倍"};

    private final double RateFundBelow5[] = {2.75, 3.025, 3.3};
    private final double RateFundOver5[] = {3.25, 3.575, 3.9};
    private final String RateFundPercent[] = {"基准利率", "1.1倍", "1.2倍"};

    //获取当前利息
    public double getRate(int pattern,int year,int position){
        double rate = 4.9;

        if(pattern == 0){
            if(year == 1){
                rate = RateOrdinaryBelow1[position];
            } else if (year >= 2 && year <= 5){
                rate = RateOrdinary1To5[position];
            } else {
                rate = RateOrdinaryOver5[position];
            }
        } else {
            if(year <= 5){
                rate = RateFundBelow5[position];
            } else {
                rate = RateFundOver5[position];
            }
        }

        return rate;
    }

    //获取时间List对象
    public List<String> getTime() {
        List<String> time = new ArrayList<>();

        for(int i = 0;i < 30;i++){
            time.add(Integer.toString(i+1));
        }

        return time;
    }

    //获取还款方式List对象
    public List<String> getPattern(){
        List<String> pattern = new ArrayList<>();
        pattern.add("商业贷款");
        pattern.add("公积金贷款");
        return pattern;
    }

    //根据贷款时间，获取商业贷款List对象
    public List<String> getRateOrdinary(int year){
        List<String> rate = new ArrayList<>();
        double RATE[];

        if (year == 1){
            RATE = RateOrdinaryBelow1;
        } else if (year >= 2 && year <= 5){
            RATE = RateOrdinary1To5;
        } else {
            RATE = RateOrdinaryOver5;
        }

        for (int i = 0;i < RateOrdinaryPercent.length;i++) {
            rate.add(Double.toString(RATE[i]) + "%(" + RateOrdinaryPercent[i] + ")");
        }

        return rate;
    }

    //根据贷款时间，获取公积金贷款List对象
    public List<String> getRateFund(int year){
        List<String> rate = new ArrayList<>();
        double RATE[];

        if(year <= 5){
            RATE = RateFundBelow5;
        } else {
            RATE = RateFundOver5;
        }

        for (int i = 0;i < RateFundPercent.length;i++){
            rate.add(Double.toString(RATE[i]) + "%(" + RateFundPercent[i] + ")");
        }
        return rate;
    }
}
