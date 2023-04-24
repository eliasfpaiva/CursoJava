package br.com.cursojava.projeto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;
@Entity
public class Conta extends Entidade {
    public static final long serialVersionUID = 1;
    private String login;
    private String senha;
    private LocalDate dataCriacao;
    private LocalDate dataUltimoAcesso;
    @OneToOne(mappedBy = "conta")
    private Usuario usuario;
    private int tentativasLogin;
    private SituacaoConta situacao;

    public Conta() {}

    public Conta(String login, String senha) { this(login, senha, null, null, null, 0, null); }
    public Conta(String login, String senha, LocalDate dataCriacao, LocalDate dataUltimoAcesso, Usuario usuario, int tentativasLogin, SituacaoConta situacao) {
        this.login = login;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.dataUltimoAcesso = dataUltimoAcesso;
        this.setUsuario(usuario);
        this.tentativasLogin = tentativasLogin;
        this.situacao = situacao;
    }

    public String getLogin() { return login; }
    public String getSenha() { return senha; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public LocalDate getDataUltimoAcesso() { return dataUltimoAcesso; }
    public Usuario getUsuario() { return usuario; }
    public int getTentativasLogin() { return tentativasLogin; }
    public SituacaoConta getSituacao() { return situacao; }

    public void setLogin(String login) { this.login = login; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }
    public void setDataUltimoAcesso(LocalDate dataUltimoAcesso) { this.dataUltimoAcesso = dataUltimoAcesso; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setTentativasLogin(int tentativasLogin) { this.tentativasLogin = tentativasLogin; }
    public void setSituacao(SituacaoConta situacao) { this.situacao = situacao; }
}