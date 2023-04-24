package br.com.cursojava.projeto.integracao.jpa.repository;

import br.com.cursojava.projeto.negocio.modelo.Conta;
import br.com.cursojava.projeto.sistema.excecoes.AppException;

public class ContaRepository extends Repository<Conta>{
    public static ContaRepository getInstance() {
        return new ContaRepository();
    }

    @Override
    public Class<Conta> getEntityClass() throws AppException { return Conta.class; }

    @Override
    public Conta getEntityInstance() throws AppException { return new Conta(); }

    @Override
    public Conta setTestSampleToInsert(Conta conta) {
        long millis = System.currentTimeMillis();
        conta.setLogin("nome" + millis);
        return conta;
    }

    @Override
    public Conta setTestSampleToUpdate(Conta conta) {
        conta.setLogin(conta.getLogin() + "up");
        return conta;
    }
}