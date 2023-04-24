package br.com.cursojava.projeto.negocio.modelo;

import javax.persistence.Entity;
@Entity
public class Administrador extends Usuario {
    public Administrador() {}

    public Administrador(String nome, String email, String cpf, String cidade, Conta conta, Perfil perfil) {
        super(nome, email, cpf, cidade, conta, perfil);
    }

    @Override
    public boolean isAdmin() { return true; }

    @Override
    public boolean isCoord() { return false; }
}