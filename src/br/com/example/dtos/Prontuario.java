package br.com.example.dtos;

import java.util.ArrayList;
import java.util.List;

public class Prontuario {

    private String observacoes;
    private Diagnostico diagnostico;
    private List<String> procedimentosRealizados = new ArrayList<>();
    private String dataDoRegistro;

    public Prontuario(String observacoes, Diagnostico diagnostico, String dataDoRegistro) {
        this.observacoes = observacoes;
        this.diagnostico = diagnostico;
        this.dataDoRegistro = dataDoRegistro;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public List<String> getProcedimentosRealizados() {
        return procedimentosRealizados;
    }

    public void adicionarProcedimento(String procedimento) {
        procedimentosRealizados.add(procedimento);
    }

    public String getDataDoRegistro() {
        return dataDoRegistro;
    }

    public void setDataDoRegistro(String dataDoRegistro) {
        this.dataDoRegistro = dataDoRegistro;
    }

    public String exibirResumo() {

        String resumo = "";

        resumo += "Data: " + dataDoRegistro;
        resumo += "\nObservações: " + observacoes;

        if (diagnostico != null) {
            resumo += "\nDiagnóstico: " + diagnostico.toString();
        }

        if (!procedimentosRealizados.isEmpty()) {

            resumo += "\nProcedimentos: ";

            for (int i = 0; i < procedimentosRealizados.size(); i++) {

                resumo += procedimentosRealizados.get(i);

                if (i < procedimentosRealizados.size() - 1) {
                    resumo += ", ";
                }

            }

        }

        return resumo;

    }

}