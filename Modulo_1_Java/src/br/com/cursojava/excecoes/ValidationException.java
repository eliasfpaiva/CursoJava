package br.com.cursojava.excecoes;

public class ValidationException extends AppException{
    public ValidationException() {
        super("Erro de validação");
    }
}