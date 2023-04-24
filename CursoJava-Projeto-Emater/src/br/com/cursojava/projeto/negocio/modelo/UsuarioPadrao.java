package br.com.cursojava.projeto.negocio.modelo;

import javax.persistence.Entity;
@Entity
public class UsuarioPadrao extends Usuario {
    public static final long serialVersionUID = 1;
    public UsuarioPadrao() {}

    public UsuarioPadrao(String nome, String email, String cpf, String cidade, Conta conta, Perfil perfil) {
        super(nome, email, cpf, cidade, conta, perfil);
    }

    @Override
    public boolean isAdmin() { return false; }

    @Override
    public boolean isCoord() { return false; }
}