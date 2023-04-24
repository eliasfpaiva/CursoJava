package br.com.cursojava.oo.classes;

public class Rectangle extends Shape{
	double length, width;
	
	Rectangle(){ this(0, 0); }
	
	Rectangle(double length, double width){
		this.length = length;
		this.width = width;
	}

	private double getLength() { return length; }
	private double getWidth() { return width; }
	
	@Override
	public double getArea() { return getLength() * getWidth(); }
}