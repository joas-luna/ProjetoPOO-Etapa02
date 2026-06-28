package src.servicos;

import java.util.ArrayList;
import java.util.List;

import src.entidades.Paciente;

public class PacienteServico {

    private List<Paciente> pacientes;

    public PacienteServico() {
        pacientes = new ArrayList<>();
    }

    public PacienteServico(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void cadastrarPaciente(Paciente paciente) {

        if (!cpfExiste(paciente.getCpf())) {
            pacientes.add(paciente);
            System.out.println("Paciente cadastrado com sucesso.");
        } else {
            System.out.println("CPF já cadastrado.");
        }

    }

    public Paciente buscarPorCPF(String cpf) {

        for (Paciente paciente : pacientes) {

            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }

        }

        return null;

    }

    public List<Paciente> buscarPorNome(String nome) {

        List<Paciente> resultado = new ArrayList<>();

        for (Paciente paciente : pacientes) {

            if (paciente.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(paciente);
            }

        }

        return resultado;

    }

    public List<Paciente> buscaInstantanea(String texto) {

        List<Paciente> resultado = new ArrayList<>();

        texto = texto.toLowerCase();

        for (Paciente paciente : pacientes) {

            if (paciente.getNome().toLowerCase().contains(texto)
                    || paciente.getCpf().contains(texto)) {

                resultado.add(paciente);

            }

        }

        return resultado;

    }

    public boolean cpfExiste(String cpf) {

        for (Paciente paciente : pacientes) {

            if (paciente.getCpf().equals(cpf)) {
                return true;
            }

        }

        return false;

    }

    public void desativarPaciente(String cpf) {

        Paciente paciente = buscarPorCPF(cpf);

        if (paciente != null) {
            paciente.desativar();
        }

    }

    public void ativarPaciente(String cpf) {

        Paciente paciente = buscarPorCPF(cpf);

        if (paciente != null) {
            paciente.ativar();
        }

    }

    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    public void exibirPacientes() {

        for (Paciente paciente : pacientes) {

            System.out.println("-------------------------");
            System.out.println(paciente.exibirResumo());

        }

    }

}