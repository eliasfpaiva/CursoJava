package br.com.cursojava.projeto.integracao.jpa.repository;

import br.com.cursojava.projeto.negocio.modelo.Funcao;
import br.com.cursojava.projeto.negocio.modelo.GrupoFuncao;
import br.com.cursojava.projeto.sistema.excecoes.AppException;

public class GrupoFuncaoRepository extends Repository<GrupoFuncao>{
    public static GrupoFuncaoRepository getInstance() {
        return new GrupoFuncaoRepository();
    }

    @Override
    public Class<GrupoFuncao> getEntityClass() throws AppException { return GrupoFuncao.class; }

    @Override
    public GrupoFuncao getEntityInstance() throws AppException { return new GrupoFuncao(); }

    @Override
    public GrupoFuncao setTestSampleToInsert(GrupoFuncao grupoFuncao) {
        long millis = System.currentTimeMillis();
        grupoFuncao.setNome("nome" + millis);
        return grupoFuncao;
    }

    @Override
    public GrupoFuncao setTestSampleToUpdate(GrupoFuncao grupoFuncao) {
        grupoFuncao.setNome(grupoFuncao.getNome() + "up");
        return grupoFuncao;
    }
}