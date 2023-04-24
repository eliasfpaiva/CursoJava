package br.com.cursojava.projeto.negocio.modelo.interfaces;

import java.io.Serializable;

public interface IEntidade extends Serializable {
    Long getId();

    Long getVersion();
}