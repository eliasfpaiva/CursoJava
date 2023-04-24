package br.com.cursojava.projeto.negocio.servicos;

import br.com.cursojava.projeto.negocio.modelo.Conta;
import br.com.cursojava.projeto.negocio.modelo.Usuario;
import br.com.cursojava.projeto.negocio.modelo.UsuarioLogado;
import br.com.cursojava.projeto.negocio.modelo.UsuarioPadrao;

public class LoginService {
    private ContaService contaService;
    private UsuarioService usuarioService;

    public LoginService() {
        this.contaService = new ContaService();
        this.usuarioService = new UsuarioService();
    }

    public UsuarioLogado login(String login, String senha){
        Conta conta = this.contaService.recuperarPorLogin(login);

        if (conta != null){
            if (conta.getSenha().equals(senha)) {
                Usuario usuario = this.usuarioService.recuperarUsuarioPorEmail(conta.getLogin());
                return new UsuarioLogado(usuario);
            }
        }
        return null;
    }
}