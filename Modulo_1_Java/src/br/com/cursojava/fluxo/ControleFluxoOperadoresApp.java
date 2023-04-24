package br.com.cursojava.fluxo;

public class ControleFluxoOperadoresApp {
	public static void main(String[] args) {
		int x = 1, sum = 0;
		sum += x;
		executar(sum);
	}
	
	public static void executar(int numero) {
		System.out.println("A soma é " + numero + parOuImpar(numero));
	}
	
	static String parOuImpar(int numero){
		return numero % 2 == 0 ? " - par" : " - impar";
	}
}