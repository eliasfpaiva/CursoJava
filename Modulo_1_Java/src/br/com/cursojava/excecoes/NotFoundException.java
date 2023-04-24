package br.com.cursojava.excecoes;

public class NotFoundException  extends AppException{
    public NotFoundException() {
        super("Item não encontrado");
    }
}
