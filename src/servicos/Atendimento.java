package src.servicos;

import java.util.ArrayList;
import java.util.List;

import src.contratos.Atendivel;
import src.dtos.Prontuario;

public class Atendimento implements Atendivel {

    private int indiceConsulta;
    private String observacoes;
    private String diagnostico = "";
    private List<String> procedimentos = new ArrayList<>();
    private int totalProcedimentos = 0;
    private Prontuario prontuario;
    private boolean finalizado = false;

    public Atendimento(int indiceConsulta, String observacoes) {
        this.indiceConsulta = indiceConsulta;
        this.observacoes = observacoes;
    }

    public Atendimento(int indiceConsulta, String observacoes, String diagnostico) {
        this(indiceConsulta, observacoes);
        this.diagnostico = diagnostico;
    }

    public Atendimento(
            int indiceConsulta,
            String observacoes,
            String diagnostico,
            List<String> procedimentos,
            int totalProcedimentos) {

        this(indiceConsulta, observacoes, diagnostico);

        this.totalProcedimentos = totalProcedimentos;

        for (int i = 0; i < totalProcedimentos; i++) {
            this.procedimentos.add(procedimentos.get(i));
        }
    }

    public int getIndiceConsulta() {
        return indiceConsulta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public List<String> getProcedimentos() {
        return procedimentos;
    }

    public int getTotalProcedimentos() {
        return totalProcedimentos;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public void adicionarProcedimento(String procedimento) {

        if (totalProcedimentos < 10) {
            procedimentos.add(procedimento);
            totalProcedimentos++;
        }

    }

    public void adicionarProcedimento(List<String> procs, int quantidade) {

        for (int i = 0; i < quantidade; i++) {

            if (totalProcedimentos < 10) {
                procedimentos.add(procs.get(i));
                totalProcedimentos++;
            }

        }

    }

    @Override
    public void registrar() {
        System.out.println("Atendimento registrado.");
    }

    @Override
    public void finalizar() {
        finalizado = true;
    }

    public String exibirResumo() {

        String resumo = "";

        resumo += "Consulta: " + indiceConsulta;
        resumo += "\nObservações: " + observacoes;

        if (!diagnostico.equals("")) {
            resumo += "\nDiagnóstico: " + diagnostico;
        }

        if (totalProcedimentos > 0) {

            resumo += "\nProcedimentos: ";

            for (int i = 0; i < totalProcedimentos; i++) {

                resumo += procedimentos.get(i);

                if (i < totalProcedimentos - 1) {
                    resumo += ", ";
                }

            }

        }

        if (prontuario != null) {
            resumo += "\nProntuário registrado.";
        }

        resumo += "\nStatus: ";

        if (finalizado) {
            resumo += "Finalizado";
        } else {
            resumo += "Em andamento";
        }

        return resumo;

    }

}