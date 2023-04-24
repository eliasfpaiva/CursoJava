package br.com.cursojava.projeto.integracao.jpa.repository;

import br.com.cursojava.projeto.negocio.modelo.UsuarioPadrao;
import br.com.cursojava.projeto.sistema.excecoes.AppException;

public class UsuarioPadraoRepository extends Repository<UsuarioPadrao>{
    public static UsuarioPadraoRepository getInstance() {
        return new UsuarioPadraoRepository();
    }

    @Override
    public Class<UsuarioPadrao> getEntityClass() throws AppException { return UsuarioPadrao.class; }

    @Override
    public UsuarioPadrao getEntityInstance() throws AppException { return new UsuarioPadrao(); }

    @Override
    public UsuarioPadrao setTestSampleToInsert(UsuarioPadrao usuario) {
        long millis = System.currentTimeMillis();
        usuario.setNome("nome" + millis);
        return usuario;
    }

    @Override
    public UsuarioPadrao setTestSampleToUpdate(UsuarioPadrao usuario) {
        usuario.setNome(usuario.getNome() + "up");
        return usuario;
    }
}