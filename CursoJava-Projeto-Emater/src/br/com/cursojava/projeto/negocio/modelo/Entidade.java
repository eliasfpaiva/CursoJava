package br.com.cursojava.projeto.negocio.modelo;

import br.com.cursojava.projeto.negocio.modelo.interfaces.IEntidade;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@MappedSuperclass
public abstract class Entidade implements IEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Override
    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    @Override
    public Long getVersion() { return version; }

    public void setVersion(Long version) { this.version = version; }
}