package br.com.cursojava.projeto.integracao.jpa.repository;

import br.com.cursojava.projeto.negocio.modelo.Administrador;
import br.com.cursojava.projeto.sistema.excecoes.AppException;

public class AdminstradorRepository extends Repository<Administrador>{
    public static AdminstradorRepository getInstance() {
        return new AdminstradorRepository();
    }

    @Override
    public Class<Administrador> getEntityClass() throws AppException { return Administrador.class; }

    @Override
    public Administrador getEntityInstance() throws AppException { return new Administrador(); }

    @Override
    public Administrador setTestSampleToInsert(Administrador administrador) {
        long millis = System.currentTimeMillis();
        administrador.setNome("nome" + millis);
        return administrador;
    }

    @Override
    public Administrador setTestSampleToUpdate(Administrador administrador) {
        administrador.setNome(administrador.getNome() + "up");
        return administrador;
    }
}