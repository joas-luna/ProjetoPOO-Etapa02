package src.dtos;

import java.util.ArrayList;
import java.util.List;

public class Prontuario {
    private String observacoes;
    private Diagnostico diagnostico;
    private List<String> procedimentosRealizados = new ArrayList<>();    
    private String dataDoRegistro;
}
