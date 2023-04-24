package br.com.cursojava.excecoes;

import br.com.cursojava.testes.SolicitaValor;

public class CustomExceptionApp {
    public static void main(String[] args) {
        IntegerValuesHandler handler = new IntegerValuesHandler();
        boolean continuar;
        do {
            try {
                Integer valor = SolicitaValor.solicitaInteiro();
                System.out.println(handler.find(valor));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                continuar = SolicitaValor.solicitaBoolean("Deseja continuar? (true ou false)");
            }
        }while (continuar);
    }
}