package br.com.cursojava.projeto.integracao.jpa.repository;

import br.com.cursojava.projeto.negocio.modelo.Perfil;
import br.com.cursojava.projeto.sistema.excecoes.AppException;

public class PerfilRepository extends Repository<Perfil>{
    public static PerfilRepository getInstance() {
        return new PerfilRepository();
    }

    @Override
    public Class<Perfil> getEntityClass() throws AppException { return Perfil.class; }

    @Override
    public Perfil getEntityInstance() throws AppException { return new Perfil(); }

    @Override
    public Perfil setTestSampleToInsert(Perfil perfil) {
        long millis = System.currentTimeMillis();
        perfil.setNome("nome" + millis);
        return perfil;
    }

    @Override
    public Perfil setTestSampleToUpdate(Perfil perfil) {
        perfil.setNome(perfil.getNome() + "up");
        return perfil;
    }
}