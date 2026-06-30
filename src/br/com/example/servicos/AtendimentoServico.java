package br.com.example.servicos;

import java.util.ArrayList;
import java.util.List;

public class AtendimentoServico {

    private List<Atendimento> atendimentos;

    public AtendimentoServico() {
        atendimentos = new ArrayList<>();
    }

    public AtendimentoServico(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public void registrarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
    }

    public Atendimento buscarAtendimento(Integer indiceConsulta) {

        for (Atendimento atendimento : atendimentos) {

            if (atendimento.getIndiceConsulta() == indiceConsulta) {
                return atendimento;
            }

        }

        return null;

    }

    public boolean adicionarDiagnostico(Integer indiceConsulta, String diagnostico) {

        Atendimento atendimento = buscarAtendimento(indiceConsulta);

        if (atendimento == null) {
            return false;
        }

        atendimento.setDiagnostico(diagnostico);

        return true;

    }

    public boolean adicionarProcedimento(Integer indiceConsulta, String procedimento) {

        Atendimento atendimento = buscarAtendimento(indiceConsulta);

        if (atendimento == null) {
            return false;
        }

        atendimento.adicionarProcedimento(procedimento);

        return true;

    }

    public boolean finalizarAtendimento(Integer indiceConsulta) {

        Atendimento atendimento = buscarAtendimento(indiceConsulta);

        if (atendimento == null) {
            return false;
        }

        atendimento.finalizar();

        return true;

    }

    public List<Atendimento> listarAtendimentos() {
        return atendimentos;
    }

    public void exibirTodos() {

        for (Atendimento atendimento : atendimentos) {

            System.out.println("----------------------------");
            System.out.println(atendimento.exibirResumo());

        }

    }

}