package br.com.cursojava.fluxo;

public class ControleFluxoLoopWhileApp {
	public static void main(String[] args) {
		int i = 1, sum = 0;
		while(i <= 10) {
			sum += i;
			ControleFluxoOperadoresApp.executar(sum);
			i++;
		}
	}
}