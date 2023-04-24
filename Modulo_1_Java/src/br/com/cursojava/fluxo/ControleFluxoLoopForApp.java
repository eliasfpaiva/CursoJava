package br.com.cursojava.fluxo;

public class ControleFluxoLoopForApp {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i < 11; i++){
			sum += i;
			ControleFluxoOperadoresApp.executar(sum);
		}
	}
}