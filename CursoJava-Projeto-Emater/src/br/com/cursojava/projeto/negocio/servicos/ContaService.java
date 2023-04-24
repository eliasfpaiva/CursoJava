package br.com.cursojava.projeto.negocio.servicos;

import br.com.cursojava.projeto.negocio.modelo.Conta;

import java.util.List;

public class ContaService {
    protected static final List<Conta> CONTAS = List.of(
        new Conta("denis@web.com", "teste@123"),
        new Conta("ze@web.com", "teste@123"),
        new Conta("clarissa@web.com", "teste@123")
    );

    public Conta recuperarPorLogin(String login) {
        return CONTAS.stream()
                .filter(c -> c.getLogin().equalsIgnoreCase(login))
                .findFirst().orElse(null);
    }
}