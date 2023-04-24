package br.com.cursojava.oo.classes;

public class Circle extends Shape {
	private double radius;
	
	public Circle(double r) {
		radius = r;
	}
	
	@Override
	public double getArea() { return Math.PI * radius * radius; }
}