package br.com.cursojava.projeto.negocio.modelo;

import br.com.cursojava.projeto.negocio.modelo.interfaces.ITemListaFuncoes;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
public class GrupoFuncao extends Entidade implements ITemListaFuncoes {
    public static final long serialVersionUID = 1;
    public String nome;
    public String descricao;
    @OneToMany(mappedBy = "grupoFuncao")
    public List<Funcao> funcoes;

    public GrupoFuncao() {}

    public GrupoFuncao(String nome, String descricao, List<Funcao> funcoes) {
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
    public void setFuncoes(List<Funcao> funcoes) { this.funcoes = funcoes; }
}