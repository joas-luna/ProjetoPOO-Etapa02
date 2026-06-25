package src.dtos;

import java.util.ArrayList;
import java.util.List;


public class Convenio {
    protected String nome;
    protected Float percentualDeCobertura;
    protected List<Cobertura> especialidadesCobertas = new ArrayList<>();

    public String getNome() {
        return nome;
    }
}
