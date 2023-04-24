package br.com.cursojava.projeto.integracao.jpa.repository;

import br.com.cursojava.projeto.negocio.modelo.Coordenador;
import br.com.cursojava.projeto.sistema.excecoes.AppException;

public class CoordenadorRepository extends Repository<Coordenador>{
    public static CoordenadorRepository getInstance() {
        return new CoordenadorRepository();
    }

    @Override
    public Class<Coordenador> getEntityClass() throws AppException { return Coordenador.class; }

    @Override
    public Coordenador getEntityInstance() throws AppException { return new Coordenador(); }

    @Override
    public Coordenador setTestSampleToInsert(Coordenador coordenador) {
        long millis = System.currentTimeMillis();
        coordenador.setNome("nome" + millis);
        return coordenador;
    }

    @Override
    public Coordenador setTestSampleToUpdate(Coordenador coordenador) {
        coordenador.setNome(coordenador.getNome() + "up");
        return coordenador;
    }
}