package br.com.cursojava.projeto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Funcao extends Entidade {
    public static final long serialVersionUID = 1;
    private String role;
    private String nome;
    private String descricao;
    @ManyToOne
    private GrupoFuncao grupoFuncao;

    public Funcao() {}

    public Funcao(String role, String nome){ this(role, nome, null, null); }
    public Funcao(String role, String nome, String descricao, GrupoFuncao grupoFuncao) {
        this.role = role;
        this.nome = nome;
        this.descricao = descricao;
        this.grupoFuncao = grupoFuncao;
    }

    public String getRole() { return role; }

    public String getNome() { return nome; }

    public String getDescricao() { return descricao; }

    public GrupoFuncao getGrupoFuncao() { return grupoFuncao; }

    public void setGrupoFuncao(GrupoFuncao grupo) { this.grupoFuncao = grupo; }

    public void setRole(String role) { this.role = role; }

    public void setNome(String nome) { this.nome = nome; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Funcao{");
        sb.append("id='").append(this.getId()).append('\'');
        sb.append("role='").append(role).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", descricao='").append(descricao).append('\'');
        sb.append('}');
        return sb.toString();
    }
}