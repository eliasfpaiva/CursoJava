package br.com.cursojava.oo.classes;

public class Calculator {
	private double num1, num2;
	
	public Calculator(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public double getNum1() { return num1; }
	public void setNum1(double num1) { this.num1 = num1; }
	public double getNum2() { return num2; }
	public void setNum2(double num2) { this.num2 = num2; }

	public double add() { return getNum1() + getNum2(); }
	
	public double subtract() { return getNum1() - getNum2(); }
	
	public double multiply() { return getNum1() * getNum2(); }
	
	public double divide() { return getNum1() / getNum2(); }
}