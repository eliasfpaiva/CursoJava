package br.com.cursojava.projeto.negocio.modelo;

import br.com.cursojava.projeto.negocio.modelo.interfaces.ITemListaFuncoes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Perfil extends Entidade implements ITemListaFuncoes {
    public static final long serialVersionUID = 1;

    private String nome;
    private String descricao;
    @ManyToMany
    private List<Funcao> funcoes = new ArrayList<>();

    public Perfil() { this.initFuncoes(); }

    public Perfil(String nome, String descricao, List<Funcao> funcoes) {
        this.nome = nome;
        this.descricao = descricao;
        this.funcoes = funcoes;
    }

    public String getNome() { return nome; }

    public String getDescricao() { return descricao; }

    @Override
    public List<Funcao> getFuncoes() { return funcoes; }


    public void setNome(String nome) { this.nome = nome; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public void setFuncoes(List<Funcao> funcoes) {
        this.funcoes = new ArrayList<>();
        this.getFuncoes().addAll(funcoes);
    }

    public boolean hasFuncaoWithRole(String role) {
        return this.getFuncoes().stream().anyMatch(f -> f.getRole().equalsIgnoreCase(role));
    }
}