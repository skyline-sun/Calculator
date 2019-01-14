package com.example.calculator.Utils;

public class Length {

	//0-米  1-尺  2-英里  3-英寸  4-英尺 
	static double lengthUnit[][]= {
			{ 1 , 3.0003 , 0.00062137 , 39.37007874 , 3.2808399 },
			{ 0.3333 , 1 , 0.0002071 , 13.12204724 , 1.09350394 },
			{ 1609.344 , 4828.51485149 , 1 , 63360 , 5280 },
			{ 0.0254 , 0.07620762 , 0.00001578 , 1 , 0.08333333 },
			{ 0.3048 , 0.91449145 , 0.00018939 , 12 , 1 }
	};
	
	public double transform(double value , int unitOne ,int unitTwo) {
		return value * lengthUnit[unitOne][unitTwo];
	}

}
