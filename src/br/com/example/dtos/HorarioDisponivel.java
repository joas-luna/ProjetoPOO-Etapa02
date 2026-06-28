package br.com.example.dtos;

public class HorarioDisponivel {

    private String data;
    private String horario;
    private boolean disponivel;

    public HorarioDisponivel(String data, String horario) {
        this.data = data;
        this.horario = horario;
        this.disponivel = true;
    }

    public HorarioDisponivel(String data, String horario, boolean disponivel) {
        this.data = data;
        this.horario = horario;
        this.disponivel = disponivel;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void ocuparHorario() {
        this.disponivel = false;
    }

    public void liberarHorario() {
        this.disponivel = true;
    }

    public void alterarHorario(String data, String horario) {
        this.data = data;
        this.horario = horario;
    }

    public String exibirResumo() {
        return "Data: " + data +
               " | Horário: " + horario +
               " | Status: " + (disponivel ? "Disponível" : "Ocupado");
    }
}