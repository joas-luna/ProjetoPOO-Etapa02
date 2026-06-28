package br.com.example.entidades.abstratos;

import java.util.ArrayList;
import java.util.List;

import br.com.example.dtos.HorarioDisponivel;

public abstract class Profissional extends Pessoa {

    private String especialidade;
    private String registroProfissional;
    private double valorConsulta;
    private List<String> diasDisponiveis = new ArrayList<>();
    private int totalDias;
    private HorarioDisponivel horarioDisponivel;

    public Profissional(String nome, String cpf, String especialidade) {
        super(nome, cpf);
        this.especialidade = especialidade;
    }

    public Profissional(String nome, String cpf, String especialidade, double valorConsulta) {
        this(nome, cpf, especialidade);
        this.valorConsulta = valorConsulta;
    }

    public Profissional(
            String nome,
            String cpf,
            String especialidade,
            double valorConsulta,
            String registroProfissional) {

        this(nome, cpf, especialidade, valorConsulta);
        this.registroProfissional = registroProfissional;
    }

    public Profissional(
            String nome,
            String cpf,
            String especialidade,
            double valorConsulta,
            String registroProfissional,
            List<String> dias,
            int totalDias) {

        this(
                nome,
                cpf,
                especialidade,
                valorConsulta,
                registroProfissional);

        this.totalDias = totalDias;

        for (int i = 0; i < totalDias; i++) {
            this.diasDisponiveis.add(dias.get(i));
        }
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public List<String> getDiasDisponiveis() {
        return diasDisponiveis;
    }

    public int getTotalDias() {
        return totalDias;
    }

    public HorarioDisponivel getHorarioDisponivel() {
        return horarioDisponivel;
    }

    public void setHorarioDisponivel(HorarioDisponivel horarioDisponivel) {
        this.horarioDisponivel = horarioDisponivel;
    }

    public void atualizar(String registro, double valor) {
        this.registroProfissional = registro;
        this.valorConsulta = valor;
    }

    public void atualizar(String registro, double valor,
                          List<String> dias, int totalDias) {

        this.registroProfissional = registro;
        this.valorConsulta = valor;
        this.totalDias = totalDias;

        this.diasDisponiveis.clear();

        for (int i = 0; i < totalDias; i++) {
            this.diasDisponiveis.add(dias.get(i));
        }
    }

    public boolean atendeNoDia(String dia) {

        for (int i = 0; i < totalDias; i++) {

            if (diasDisponiveis.get(i).equalsIgnoreCase(dia)) {
                return true;
            }

        }

        return false;
    }

    public static boolean especialidadeValida(String esp) {

        return esp.equalsIgnoreCase("clinica geral")
                || esp.equalsIgnoreCase("fisioterapia")
                || esp.equalsIgnoreCase("psicologia")
                || esp.equalsIgnoreCase("nutricao");
    }

    @Override
    public String exibirResumo() {

        String dias = "";

        for (int i = 0; i < totalDias; i++) {

            if (i > 0) {
                dias += ", ";
            }

            dias += diasDisponiveis.get(i);
        }

        return "Nome: " + getNome()
                + " | CPF: " + getCpf()
                + " | Espec: " + especialidade
                + " | Reg: " + registroProfissional
                + " | Valor: R$" + valorConsulta
                + " | Dias: " + dias;
    }

    public abstract void registrarEspecifico();
}