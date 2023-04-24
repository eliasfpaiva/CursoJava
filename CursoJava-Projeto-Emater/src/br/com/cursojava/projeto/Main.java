package br.com.cursojava.projeto;

import br.com.cursojava.projeto.integracao.jpa.repository.FuncaoRepository;
import br.com.cursojava.projeto.integracao.jpa.testes.RepositoryTestRunner;
import br.com.cursojava.projeto.negocio.modelo.Funcao;
import br.com.cursojava.projeto.negocio.modelo.Perfil;
import br.com.cursojava.projeto.negocio.modelo.UsuarioLogado;
import br.com.cursojava.projeto.negocio.servicos.LoginService;
import br.com.cursojava.projeto.sistema.excecoes.AppException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        RepositoryTestRunner.getInstance().runTest(FuncaoRepository.getInstance());
    }

    private static void testeFuncaoRepository() throws AppException {
        Funcao insert = FuncaoRepository.getInstance().insert(new Funcao("f1", "f1", "f1", null));
        System.out.println(FuncaoRepository.getInstance().findById(insert.getId()+1));
    }

    private static void testeJdbc() {
        LoginService loginService = new LoginService();
        UsuarioLogado usuario = loginService.login("ze@web.com", "teste@123");
        System.out.printf("Usuário: %s", usuario);
    }

    private static void testeInterferenciaReferencia() {
        List<Funcao> funcoes = new ArrayList<>(Arrays.asList(new Funcao("f1", "f1", "f1", null),
                new Funcao("f2", "f2", "f2", null),
                new Funcao("f3", "f3", "f3", null)));
        Perfil perfil = new Perfil("Teste", "Teste", null);

        perfil.setFuncoes(funcoes);

        System.out.println("Nárnia");

        funcoes.add(new Funcao("f4","f4","f4",null));

        System.out.println("Arquelândia");
    }
}