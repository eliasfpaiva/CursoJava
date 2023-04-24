package br.com.cursojava.projeto.integracao.jpa.repository;

import br.com.cursojava.projeto.negocio.modelo.Funcao;
import br.com.cursojava.projeto.sistema.excecoes.AppException;

public class FuncaoRepository extends Repository<Funcao>{
    public static FuncaoRepository getInstance() {
        return new FuncaoRepository();
    }

    @Override
    public Class<Funcao> getEntityClass() throws AppException { return Funcao.class; }

    @Override
    public Funcao getEntityInstance() throws AppException { return new Funcao(); }

    @Override
    public Funcao setTestSampleToInsert(Funcao fucao) {
        long millis = System.currentTimeMillis();
        fucao.setRole("role" + millis);
        fucao.setNome("nome" + millis);
        fucao.setDescricao("descrição" + millis);
        return fucao;
    }

    @Override
    public Funcao setTestSampleToUpdate(Funcao funcao) {
        funcao.setRole(funcao.getRole() + "up");
        funcao.setNome(funcao.getNome() + "up");
        funcao.setDescricao(funcao.getDescricao() + "up");
        return funcao;
    }
}