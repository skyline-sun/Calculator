package com.example.calculator.Utils;

public class Weight {

	//0-千克  1-两  2-磅  3-盎司
	static double weightUnit[][]= {
			{ 1 , 20 , 2.20462262 , 35.27396195},
			{ 0.05 , 1 , 0.11023113 , 1.7636981 },
			{ 0.45359237 , 9.0718474 , 1 , 16 },
			{ 0.02834952 , 0.56699046 , 0.0625 , 1 },
	};
	
	public double transform(double value , int unitOne ,int unitTwo) {
		return value * weightUnit[unitOne][unitTwo];
	}
}
