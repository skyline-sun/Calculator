package com.example.calculator.Utils;

import com.example.calculator.Bean.SalaryBean;

public class Tax {
	//月薪税
	public double getMonthTax(SalaryBean salarybean) {
		int salary = salarybean.getSalary();
		double GongJiJIn = salarybean.getGongJiJIn();
		double YiLiao = salarybean.getYiLiao();
		double YangLao = salarybean.getYangLao();
		double SheYe = salarybean.getShiYe();
		double Gongshang = salarybean.getGongShang();
		double ShengYu = salarybean.getShengYu();
		
		double afterSalary = salary - salary*(GongJiJIn + YiLiao + YangLao + SheYe + Gongshang + ShengYu)/100 - 5000;
		double tax = 0;
		
		if(afterSalary < 0) {
			tax = 0;
		}
		
		if(afterSalary > 0 && afterSalary <= 3000) {
			tax = afterSalary*0.03;
		}
		
		if(afterSalary > 3000 && afterSalary <= 12000) {
			tax = afterSalary * 0.10 - 210;
		}
		
		if(afterSalary > 12000 && afterSalary <= 25000) {
			tax = afterSalary * 0.20 - 1410;
		}
		
		if(afterSalary > 25000 && afterSalary <= 35000) {
			tax = afterSalary * 0.25 - 2660;
		}
		
		if(afterSalary > 35000 && afterSalary <= 55000) {
			tax = afterSalary * 0.30 - 4410;
		}
		
		if(afterSalary > 55000 && afterSalary <= 80000) {
			tax = afterSalary * 0.35 - 7160;
		}
		
		if(afterSalary > 80000 ) {
			tax = afterSalary * 0.45 - 15160;
		}
		
		return afterSalary + 5000 - tax;
		
	}


	//年终奖税
	public double getAnnual(int annual) {
		
		double average =(double) annual/12;

		double tax = 0;
		
		if(average < 0) {
			tax = 0;
		}
		
		if(average > 0 && average <= 3000) {
			tax = annual*0.03;
		}
		
		if(average > 3000 && average <= 12000) {
			tax = annual * 0.10 - 210;
		}
		
		if(average > 12000 && average <= 25000) {
			tax = annual * 0.20 - 1410;
		}
		
		if(average > 25000 && average <= 35000) {
			tax = annual * 0.25 - 2660;
		}
		
		if(average > 35000 && average <= 55000) {
			tax = annual * 0.30 - 4410;
		}
		
		if(average > 55000 && average <= 80000) {
			tax = annual * 0.35 - 7160;
		}
		
		if(average > 80000 ) {
			tax = annual * 0.45 - 15160;
		}
		
		return annual - tax;
	}

	//稿酬税
	public double getWritting(int writting) {
		
		double tax = 0;
		
		if(writting <= 4000) {
			tax = (writting - 800) * 0.14;
		}
		if(writting > 4000) {
			tax = writting * 0.112;
		}
		return writting - tax;
		
	}

	//意外收入税
	public double getWindfall(int windfall) {
		return windfall * 0.8;
	}
}
