package br.com.cursojava.projeto.negocio.modelo.interfaces;

import br.com.cursojava.projeto.negocio.modelo.Funcao;

import java.io.Serializable;
import java.util.List;

public interface IUsuario extends Serializable {
    String getNome();
    String getNomePerfil();
    List<Funcao> getFuncoes();

    boolean isAdmin();
    boolean isCoord();

    default boolean isUserInRole(String role) {
        return this.getFuncoes().stream().anyMatch(f -> f.getRole().equalsIgnoreCase(role));
    }
}