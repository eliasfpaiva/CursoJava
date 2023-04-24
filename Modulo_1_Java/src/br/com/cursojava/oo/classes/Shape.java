package br.com.cursojava.oo.classes;

public abstract class Shape {
	public abstract double getArea();
	
	public void imprimeArea() {
		System.out.println(String.format("A área do %s é %.2f", this.getClass().getSimpleName(), this.getArea()));
	}
}