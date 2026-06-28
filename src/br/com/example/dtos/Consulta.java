package br.com.example.dtos;


public class Consulta {
    private String cpfPaciente;
    private String nomeProfissional;
    private String data;
    private String horario;
    private String tipo = "inicial";
    private String status = "agendada";

    // sem tipo - assume inicial
    public Consulta(String cpfPaciente, String nomeProfissional, String data, String horario) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.data = data;
        this.horario = horario;
    }

    public Consulta(
        String cpfPaciente, 
        String nomeProfissional, 
        String data, 
        String horario, 
        String tipo
    ) 
    {
        this(cpfPaciente, nomeProfissional, data, horario);
        this.tipo = tipo;
    }

    // esse aqui a gente usa na remarcacao pra poder setar o status direto
    public Consulta(
        String cpfPaciente, 
        String nomeProfissional, 
        String data,
        String horario, 
        String tipo, 
        String status
    ) 
    {
        this(cpfPaciente, nomeProfissional, data, horario, tipo);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void cancelar() {
        this.status = "cancelada";
    }

    // cancelar com motivo - retorna a msg formatada
    public String cancelar(String motivo) {
        this.status = "cancelada";
        return "Consulta cancelada. Motivo: " + motivo;
    }

    public void remarcar() {
        this.status = "remarcada";
    }

    public void realizar() {
        this.status = "realizada";
    }

    public String getCPF() {
        return cpfPaciente;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public String getNomeDoProfissional() {
        return nomeProfissional;
    }

    public String getTipo() {
        return tipo;
    }

    public String exibirResumo() {
        return "Paciente(CPF): " + cpfPaciente + " | Prof: " + nomeProfissional
                + " | Data: " + data + " | Hora: " + horario
                + " | Tipo: " + tipo + " | Status: " + status;
    }
}
