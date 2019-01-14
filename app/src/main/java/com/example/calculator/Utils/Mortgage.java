package com.example.calculator.Utils;

import android.util.Log;

import java.text.DecimalFormat;

public class Mortgage {
    private int mortgage;
    private double rate;
    private double montRate;

    private int time;

    private double sum = 0;
    private double interest = 0;
    private double monthsum = 0;

    private String sum_str;
    private String interest_str;
    private String monthsum_str;

    public Mortgage(int mortgage, double rate, int time) {
        this.mortgage = mortgage;
        this.rate = rate / 100;
        this.time = time;
    }

    public void transData() {
        //万元转换为元
        mortgage = mortgage * 10000;
        //年利率转换为月利率
        montRate = rate / 12;
        //贷款时间转换为月
        time = time * 12;
    }

    public void calculateTypeOne() {
        //月供
        monthsum = mortgage * montRate * Math.pow((1 + montRate), time) / (Math.pow(1 + montRate, time) - 1);
        //还款总额
        sum = monthsum * time;
        //还款利息总额
        interest = monthsum * time - mortgage;

        resultFormat();
        Log.d("mortgage", "每月还款" + monthsum_str + "共还款：" + sum_str + "\t" + "共还利息：" + interest_str);
    }

    public void calculateTypeTwo() {
        String[] strings = new String[time + 1];
        String monthCapital[] = new String[time + 1];
        String monthInterest[] = new String[time + 1];
        String monthSum[] = new String[time + 1];

        DecimalFormat df = new DecimalFormat("0.00");
        double paid = 0;
        double paidCapital = 0;
        double paidInterest = 0;
        double paidSum = 0;
        for (int i = 1; i <= time; i++) {
            //每月应还本金：贷款本金÷还款月数
            monthCapital[i] = df.format(mortgage / time);
            //每月应还利息：剩余本金×月利率=(贷款本金-已归还本金累计额)×月利率
            monthInterest[i] = df.format((mortgage - paid) * montRate);
            //月供：(贷款本金÷还款月数)+(贷款本金-已归还本金累计额)×月利率
            monthSum[i] = df.format((mortgage / time) + (mortgage - paid) * montRate);
            //已归还本金累计额
            paid = paid + mortgage / time;
            //已还本金
            paidCapital = paidCapital + mortgage / time;
            //已还利息
            paidInterest = paidInterest + (mortgage - paid) * montRate;
            //总共已还
            paidSum = paidSum + (mortgage / time) + (mortgage - paid) * montRate;
            strings[i] = "第" + i + "期" + "     " + monthCapital[i] + "     " + monthInterest[i] + "     " + monthSum[i];
        }
        sum = time * (mortgage * montRate - montRate * (mortgage / time) * (time - 1) / 2 + mortgage / time);
        interest = sum - mortgage;
        //首月还款
        monthsum = (mortgage / time) + mortgage * montRate;

        resultFormat();
    }

    private void resultFormat() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        sum_str = decimalFormat.format(sum);
        interest_str = decimalFormat.format(interest);
        monthsum_str = decimalFormat.format(monthsum);
    }

    public String getSum_str() {
        return sum_str;
    }

    public String getInterest_str() {
        return interest_str;
    }

    public String getMonthsum_str() {
        return monthsum_str;
    }

}


