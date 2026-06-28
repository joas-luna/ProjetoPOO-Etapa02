package br.com.example.servicos;

import java.util.ArrayList;
import java.util.List;

import br.com.example.contratos.Agendavel;
import br.com.example.dtos.Consulta;

public class AgendaServico implements Agendavel {

    private List<Consulta> consultas;

    public AgendaServico() {
        consultas = new ArrayList<>();
    }

    public AgendaServico(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public void agendar() {
        System.out.println("Metodo de agendamento chamado.");
    }

    @Override
    public void cancelar() {
        System.out.println("Metodo de cancelamento chamado.");
    }

    @Override
    public void remarcar() {
        System.out.println("Metodo de remarcacao chamado.");
    }

    public void adicionarConsulta(Consulta consulta) {

        if (!temConflito(
                consulta.getNomeDoProfissional(),
                consulta.getData(),
                consulta.getHorario())) {

            consultas.add(consulta);
            System.out.println("Consulta agendada com sucesso.");

        } else {

            System.out.println("Horario ocupado.");

        }

    }

    public boolean cancelarConsulta(String cpf, String data, String horario) {

        for (Consulta consulta : consultas) {

            if (consulta.getCPF().equals(cpf)
                    && consulta.getData().equals(data)
                    && consulta.getHorario().equals(horario)) {

                consulta.cancelar();
                return true;

            }

        }

        return false;

    }

    public boolean remarcarConsulta(
            String cpf,
            String data,
            String horario,
            String novaData,
            String novoHorario) {

        for (Consulta consulta : consultas) {

            if (consulta.getCPF().equals(cpf)
                    && consulta.getData().equals(data)
                    && consulta.getHorario().equals(horario)) {

                if (!temConflito(
                        consulta.getNomeDoProfissional(),
                        novaData,
                        novoHorario)) {

                    consultas.remove(consulta);

                    Consulta novaConsulta = new Consulta(
                            cpf,
                            consulta.getNomeDoProfissional(),
                            novaData,
                            novoHorario,
                            consulta.getTipo());

                    consultas.add(novaConsulta);

                    return true;

                }

                return false;

            }

        }

        return false;

    }

    public List<Consulta> listarConsultas() {
        return consultas;
    }

    public List<Consulta> buscarPorCPF(String cpf) {

        List<Consulta> resultado = new ArrayList<>();

        for (Consulta consulta : consultas) {

            if (consulta.getCPF().equals(cpf)) {

                resultado.add(consulta);

            }

        }

        return resultado;

    }

    public boolean temConflito(
            String profissional,
            String data,
            String horario) {

        for (Consulta consulta : consultas) {

            if (consulta.getNomeDoProfissional().equals(profissional)
                    && consulta.getData().equals(data)
                    && consulta.getHorario().equals(horario)
                    && consulta.getStatus().equals("agendada")) {

                return true;

            }

        }

        return false;

    }

    public String sugerirHorario(
            String profissional,
            String data) {

        for (int h = 8; h <= 18; h++) {

            String horario;

            if (h < 10) {

                horario = "0" + h + ":00";

            } else {

                horario = h + ":00";

            }

            if (!temConflito(profissional, data, horario)) {

                return horario;

            }

        }

        return "Nenhum horario disponivel.";

    }

}