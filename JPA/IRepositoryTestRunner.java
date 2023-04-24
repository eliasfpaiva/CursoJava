package br.com.cursojava.projeto.integracao.jpa;

import br.com.cursojava.projeto.negocio.modelo.IEntidade;
import br.com.cursojava.projeto.sistema.exceptions.AppException;

public interface IRepositoryTestRunner {

	<E extends IEntidade> void runTest(Repository<E> repository) throws AppException ;

}
