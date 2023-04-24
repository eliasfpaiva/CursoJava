package br.com.cursojava.oo.classes;

public class ShapeApp {

	public static void main(String[] args) {
		Shape r = new Rectangle(4,2);
		Shape s = new Square(4);
		Shape c = new Circle(4);
		
		r.imprimeArea();
		s.imprimeArea();
		c.imprimeArea();
	}
}