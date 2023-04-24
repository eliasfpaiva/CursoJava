package br.com.cursojava.projeto.integracao.jpa.testes;

import br.com.cursojava.projeto.integracao.jpa.repository.Repository;
import br.com.cursojava.projeto.negocio.modelo.interfaces.IEntidade;
import br.com.cursojava.projeto.sistema.excecoes.AppException;

public interface IRepositoryTestRunner {
	<E extends IEntidade> void runTest(Repository<E> repository) throws AppException;
}