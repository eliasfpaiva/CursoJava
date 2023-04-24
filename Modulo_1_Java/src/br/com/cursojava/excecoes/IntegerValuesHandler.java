package br.com.cursojava.excecoes;

public class IntegerValuesHandler {
    private Integer[] values = { 1, 10, 20, 100, 1000 };
    public Integer find(Integer value) throws AppException{
        if(value < 0) throw new ValidationException();

        for (int i = 0; i < values.length; i++){
            if(values[i].equals(value)) return i;
        }

        throw new NotFoundException();
    }
}