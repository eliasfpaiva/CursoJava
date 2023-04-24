package br.com.cursojava.projeto.negocio.modelo;

import br.com.cursojava.projeto.negocio.modelo.interfaces.IUsuario;

import javax.persistence.*;
import java.util.List;

@Entity
//@AttributeOverride(name = "id", column = @Column(name = "id"))
//@AttributeOverride(name = "version", column = @Column(name = "version"))
public abstract class Usuario extends Entidade implements IUsuario {
    public static final long serialVersionUID = 1;
    private String nome;
    private String email;
    private String cpf;
    private String cidade;
    @OneToOne
    private Conta conta;
    @OneToOne
    private Perfil perfil;

    public Usuario() { }

    public Usuario(String nome, String email, String cpf, String cidade, Conta conta, Perfil perfil) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cidade = cidade;
        this.setConta(conta);
        this.perfil = perfil;
    }

    @Override
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public String getCidade() { return cidade; }
    public Conta getConta() { return conta; }
    public Perfil getPerfil() { return perfil; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public void setConta(Conta conta) {
        if(conta != null && !conta.equals(this.getConta()))
            conta.setUsuario(this);
        this.conta = conta;
    }
    public void setPerfil(Perfil perfil) { this.perfil = perfil; }

    @Override
    public String getNomePerfil() { return this.getPerfil().getNome(); }

    @Override
    public List<Funcao> getFuncoes() { return this.getPerfil().getFuncoes(); }

    @Override
    public abstract boolean isAdmin();

    @Override
    public abstract boolean isCoord();

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cidade='" + cidade + '\'' +
                ", conta=" + conta +
                ", perfil=" + perfil +
                '}';
    }
}