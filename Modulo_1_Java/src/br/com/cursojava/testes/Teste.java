package br.com.cursojava.testes;

public class Teste {
	public static void main(String[] args) {
		int n = 28767;
		System.out.println(n);

		try {
			throw new ArithmeticException("asdf");
		}catch (ArithmeticException arithmeticException){
			System.out.println("qwer");
			throw new RuntimeException("iiiii");
		}finally {
			System.out.println("nárnia");
		}
	}
}