package br.com.cursojava.testes;

import java.util.Scanner;

public class SolicitaValor {
    public static String solicitaString() { return solicitaString(null); }
    public static String solicitaString(String msg) {
        System.out.println(msg != null ? msg : "Digite um texto: ");
        return new Scanner(System.in).next();
    }
    public static Integer solicitaInteiro() { return solicitaInteiro(null); }
    public static Integer solicitaInteiro(String msg) {
        System.out.println(msg != null ? msg : "Digite um valor inteiro: ");
        return new Scanner(System.in).nextInt();
    }
    public static Double solicitaFracionario() { return solicitaFracionario(null); }
    public static Double solicitaFracionario(String msg) {
        System.out.println(msg != null ? msg : "Digite um valor decimal: ");
        return new Scanner(System.in).nextDouble();
    }
    public static Boolean solicitaBoolean() { return solicitaBoolean(null); }
    public static Boolean solicitaBoolean(String msg) {
        System.out.println(msg != null ? msg : "Digite um valor booleano: ");
        return new Scanner(System.in).nextBoolean();
    }
}