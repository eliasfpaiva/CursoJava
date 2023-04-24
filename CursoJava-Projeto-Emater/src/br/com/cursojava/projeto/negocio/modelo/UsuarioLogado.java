package br.com.cursojava.projeto.negocio.modelo;

import br.com.cursojava.projeto.negocio.modelo.interfaces.ITemListaFuncoes;
import br.com.cursojava.projeto.negocio.modelo.interfaces.IUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioLogado implements IUsuario, ITemListaFuncoes {
    public static final long serialVersionUID = 1;
    private Long id;
    private String nome;
    private String nomePerfil;
    private List<Funcao> funcoes = new ArrayList<>();
    private boolean admin;
    private boolean coord;

    public UsuarioLogado(Usuario usuario) {
        this(usuario.getNome(), usuario.getNomePerfil(), usuario.getFuncoes(), usuario.isAdmin(), usuario.isCoord());
    }

    public UsuarioLogado(String nome, String nomePerfil, List<Funcao> funcoes, boolean admin, boolean coord) {
        this.nome = nome;
        this.nomePerfil = nomePerfil;
        this.funcoes = funcoes;
        this.admin = admin;
        this.coord = coord;
    }

    @Override
    public String getNome() { return this.nome; }

    @Override
    public String getNomePerfil() { return this.nomePerfil; }

    @Override
    public List<Funcao> getFuncoes() {
        if (this.funcoesNull()) this.initFuncoes();
        return this.funcoes;
    }

    @Override
    public boolean isAdmin() { return this.admin; }

    @Override
    public boolean isCoord() { return this.coord; }

    public void setNome(String nome) { this.nome = nome; }
    public void setNomePerfil(String nomePerfil) { this.nomePerfil = nomePerfil; }

    @Override
    public void setFuncoes(List<Funcao> funcoes) { this.funcoes = funcoes; }

    @Override
    public String toString() {
        return "UsuarioLogado{" +
                "nome='" + nome + '\'' +
                ", nomePerfil='" + nomePerfil + '\'' +
                ", funcoes=" + funcoes.stream().map(Funcao::getDescricao).collect(Collectors.joining(", ")) +
                ", admin=" + admin +
                ", coord=" + coord +
                '}';
    }
}