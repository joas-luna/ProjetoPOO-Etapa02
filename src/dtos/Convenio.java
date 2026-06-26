package src.dtos;

import java.util.ArrayList;
import java.util.List;


public class Convenio {
    private String nome;
    private Float percentualDeCobertura;
    private List<Cobertura> especialidadesCobertas = new ArrayList<>();

    public String getNome() {
        return nome;
    }
}
