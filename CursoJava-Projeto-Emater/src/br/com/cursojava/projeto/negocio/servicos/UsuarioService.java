package br.com.cursojava.projeto.negocio.servicos;

import br.com.cursojava.projeto.negocio.modelo.Administrador;
import br.com.cursojava.projeto.negocio.modelo.Perfil;
import br.com.cursojava.projeto.negocio.modelo.Usuario;

import java.util.List;

public class UsuarioService {
    private static final List<Usuario> USUARIOS = List.of(
            new Administrador("Denis", "denis@web.com", "123.123.123-34", "Carangola", ContaService.CONTAS.get(0), new Perfil()),
            new Administrador("José Henrique", "ze@web.com", "987.987.987-98", "Alfenas", ContaService.CONTAS.get(1), new Perfil()),
            new Administrador("Clarissa", "clarissa@web.com", "654.654.654-54", "Montas Claros", ContaService.CONTAS.get(2), new Perfil())
    );

    public Usuario recuperarUsuarioPorEmail(String email){
        return USUARIOS.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst().orElse(null);
    }
}