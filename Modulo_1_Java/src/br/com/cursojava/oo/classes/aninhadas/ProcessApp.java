package br.com.cursojava.oo.classes.aninhadas;

public class ProcessApp {

	public static void main(String[] args) {
		Process process = new Process.Builder().config(new Process.Config()).build();

		System.out.println(process.getState());
		process.next();
		System.out.println(process.getState());
		process.next();
		System.out.println(process.getState());
		process.next();
		System.out.println(process.getState());
		process.next();
		System.out.println(process.getState());
		process.next();
		System.out.println(process.getState());
	}
}