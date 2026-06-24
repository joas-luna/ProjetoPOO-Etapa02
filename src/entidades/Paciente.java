package src.entidades;

import src.entidades.abstratos.Pessoa;


public class Paciente extends Pessoa {
    private Convenio convenio;
    public boolean ativo = true;

    public Paciente(String nome, String cpf) {
        super(nome, cpf);
    }

    public Paciente(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }

    // construtor com todos os dados
    public Paciente(String nome, String cpf, String telefone, String dataDeNascimento, Convenio convenio) {
        super(nome, cpf, telefone, dataDeNascimento);
        this.convenio = convenio;
    }

    public Paciente(String nome, String cpf, String telefone, String dataDeNascimento, Convenio convenio, boolean ativo) {
        this(nome, cpf, telefone, dataDeNascimento, convenio);
        this.ativo = ativo;
    }

    // atualiza so idade e telefone
    public void complementar(String dataDeNascimento, String telefone) {
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
    }

    // atualiza tudo incluindo convenio
    public void complementar(String dataDeNascimento, String telefone, Convenio convenio) {
        complementar(dataDeNascimento, telefone);
        this.convenio = convenio;
    }

    public void desativar() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public String exibirResumo() {
        String status = "Sim";
        if (!ativo) {
            status = "Nao";
        }
        return "Nome: " + getNome() +" CPF: " + getCpf() + " | Data de nascimento: " + dataDeNascimento
                + " | Tel: " + telefone + " | Convenio: " + convenio
                + " | Ativo: " + status;
    }
}
