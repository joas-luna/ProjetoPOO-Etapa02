package src.servicos;

import java.util.ArrayList;
import java.util.List;

import src.dtos.Prontuario;

public class Atendimento {
    private int indiceConsulta;
    private String observacoes;
    private String diagnostico = "";
    private List<String> procedimentos = new ArrayList<>();
    private int totalProcedimentos = 0;
    private Prontuario prontuario;

    // registro basico - so observacoes
    public Atendimento(int indiceConsulta, String observacoes) {
        this.indiceConsulta = indiceConsulta;
        this.observacoes = observacoes;
    }

    public Atendimento(int indiceConsulta, String observacoes, String diagnostico) {
        this(indiceConsulta, observacoes);

        this.diagnostico = diagnostico;
    }

    // registro completo com procedimentos ja definidos
    public Atendimento(
        int indiceConsulta, 
        String observacoes, 
        String diagnostico,
        List<String> procedimentos, 
        int totalProcedimentos
    ) 
    {
        this(indiceConsulta, observacoes, diagnostico);

        this.totalProcedimentos = totalProcedimentos;
        
        for (int i = 0; i < totalProcedimentos; i++) {
            this.procedimentos.add(procedimentos.get(i));
        }
    }

    // adiciona um por vez
    public void adicionarProcedimento(String procedimento) {
        if (totalProcedimentos < 10) {
            this.procedimentos.add(procedimento);
            totalProcedimentos++;
        }
    }

    // adiciona varios de uma vez
    public void adicionarProcedimento(List<String> procs, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            if (totalProcedimentos < 10) {
                this.procedimentos.add(procs.get(i));
                totalProcedimentos++;
            }
        }
    }

    public String exibirResumo() {
        String resumo = "Observacoes: " + observacoes;

        if (!diagnostico.equals("")) {
            resumo = resumo + "\nDiagnostico: " + diagnostico;
        }

        if (totalProcedimentos > 0) {
            resumo = resumo + "\nProcedimentos: ";
            for (int i = 0; i < totalProcedimentos; i++) {
                resumo = resumo + procedimentos.get(i);
                if (i < totalProcedimentos - 1) {
                    resumo = resumo + ", ";
                }
            }
        }
        return resumo;
    }
}
