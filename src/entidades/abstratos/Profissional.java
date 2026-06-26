package src.entidades.abstratos;

import src.dtos.HorarioDisponivel;

import java.util.ArrayList;
import java.util.List;

public abstract class Profissional extends Pessoa {

    private String especialidade;
    private String registroProfissional;
    private double valorConsulta;
    private List<String> diasDisponiveis = new ArrayList<>();
    private int totalDias;
    private HorarioDisponivel horarioDisponivel;
    
    // só nome, cpf e especialidade
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
        String registroProfissional
    ) 
    {
        this(nome, cpf, especialidade, valorConsulta);

        this.registroProfissional = registroProfissional;
    }

    // construtor completo com dias
    public Profissional(
        String nome, 
        String cpf, 
        String especialidade,
        double valorConsulta,
        String registroProfissional, 
        List<String> dias, 
        int totalDias
    ) 
    {
        this(
            nome, 
            cpf, 
            especialidade, 
            valorConsulta, 
            registroProfissional
        );

        this.totalDias = totalDias;

        for (int i = 0; i < totalDias; i++) {
            this.diasDisponiveis.set(i, dias.get(i));
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

    public void atualizar(String registro, double valor) {
        this.registroProfissional = registro;
        this.valorConsulta = valor;
    }

    public void atualizar(String registro, double valor,
                          List<String> dias, int totalDias) {

        this.registroProfissional = registro;
        this.valorConsulta = valor;
        this.totalDias = totalDias;

        for (int i = 0; i < totalDias; i++) {
            this.diasDisponiveis.set(i, dias.get(i));
        }
    }

    // verifica se atende naquele dia
    public boolean atendeNoDia(String dia) {

        for (int i = 0; i < totalDias; i++) {

            if (diasDisponiveis.get(i) != null &&
                diasDisponiveis.get(i).equalsIgnoreCase(dia)) {

                return true;
            }
        }

        return false;
    }

    // valida especialidades
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