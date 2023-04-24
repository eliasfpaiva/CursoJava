package br.com.cursojava.projeto.negocio.modelo.interfaces;

import br.com.cursojava.projeto.negocio.modelo.Funcao;

import java.util.ArrayList;
import java.util.List;

public interface ITemListaFuncoes {
    List<Funcao> getFuncoes();
    void setFuncoes(List<Funcao> funcoes);
    default boolean funcoesNull(){ return this.getFuncoes() == null; }
    default void initFuncoes(){ if(this.funcoesNull()) this.setFuncoes(new ArrayList<>()); }
    default void addFuncao(Funcao funcao){ this.getFuncoes().add(funcao); }
    default void addAllFuncao(List<Funcao> funcoes){ this.getFuncoes().addAll(funcoes); }
    default void removeFuncao(Funcao funcao){
        if(this.funcoesNull()) return;
        this.getFuncoes().remove(funcao);
    }
    default void clearFuncoes(){
        if(this.funcoesNull()) return;
        this.getFuncoes().clear();
    }
}