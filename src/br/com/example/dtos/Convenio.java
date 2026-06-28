package br.com.example.dtos;

import java.util.ArrayList;
import java.util.List;


public class Convenio {
    private String nome;
    private Float percentualDeCobertura;
    private List<Cobertura> especialidadesCobertas = new ArrayList<>();

    public Convenio(String nome) {
        setNome(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
