package br.com.cursojava.projeto.integracao.jpa;

import java.util.List;

import br.com.cursojava.projeto.negocio.modelo.IEntidade;
import br.com.cursojava.projeto.sistema.exceptions.AppException;

public class RepositoryTestRunner implements IRepositoryTestRunner {
	
	private RepositoryTestRunner() {}
	
	public static RepositoryTestRunner getInstance() {
		return new RepositoryTestRunner();
	}
	
	@Override
	public <E extends IEntidade> void runTest(Repository<E> repository) throws AppException {
		
		System.out.printf("\n\n#####  Entidade: %s  ######\n\n", repository.getEntityClass().getSimpleName());

		E filter = repository.getEntityInstance();
		Long count = repository.count(filter);
		List<E> result = repository.find(filter);
		System.out.printf("\nAntes:\n count(filter): %s - find(filter): %s\n\n", count, result);
		
		E entity = repository.getEntityInstance();
		repository.setTestSampleToInsert(entity);
		entity = repository.insert(entity); count = repository.count(filter); result = repository.find(filter);
		System.out.printf("\nDepois de Inserir:\n count(filter): %s - find(filter): %s\n\n", count, result);
		
		E entity2 = repository.getEntityInstance();
		repository.setTestSampleToInsert(entity2);
		entity2 = repository.insert(entity2); count = repository.count(filter); result = repository.find(filter);
		System.out.printf("\nDepois de Inserir:\n count(filter): %s - find(filter): %s\n\n", count, result);
		
		entity = repository.findById(entity.getId());
		System.out.printf("\nRecuperando pelo ID:\n findById(id): %s\n\n", entity);
		
		repository.setTestSampleToUpdate(entity);
		entity = repository.update(entity); count = repository.count(filter); result = repository.findAll();
		System.out.printf("\nDepois de Atualizar:\n count(filter): %s - findAll(): %s\n\n", count, result);
		
		count = repository.count(entity); result = repository.find(entity);
		System.out.printf("\nRecuperando com Filtro:\n count(entity): %s - find(entity): %s\n\n", count, result);
		
		repository.delete(entity); count = repository.count(filter); result = repository.findAll();
		System.out.printf("\nDepois de Remover:\n count(filter): %s - findAll(): %s\n\n", count, result);
		
		repository.delete(entity2); count = repository.count(filter); result = repository.findAll();
		System.out.printf("\nDepois de Remover:\n count(filter): %s - findAll(): %s\n\n", count, result);
		
	}

}
