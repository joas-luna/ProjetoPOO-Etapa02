package src.entidades;

import java.util.ArrayList;
import java.util.List;

import src.dtos.Cobertura;


public class Convenio {
    protected String nome;
    protected Float percentualDeCobertura;
    protected List<Cobertura> especialidadesCobertas = new ArrayList<>();

    public String getNome() {
        return nome;
    }
}
