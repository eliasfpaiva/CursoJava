package br.com.cursojava.oo.classes;

public class CalculatorApp {

	public static void main(String[] args) {
		Calculator cal = new Calculator(10.5, 2.0);

		System.out.println(cal.add());
		System.out.println(cal.subtract());
		System.out.println(cal.multiply());
		System.out.println(cal.divide());
	}
}