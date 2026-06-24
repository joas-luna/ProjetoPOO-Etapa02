package src.entidades;

import src.entidades.abstratos.Pessoa;


public class Paciente extends Pessoa {
    private String convenioNome = "";
    public boolean ativo = true;

    public Paciente(String nome, String cpf) {
        super(nome, cpf);
    }

    public Paciente(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }

    // construtor com todos os dados
    public Paciente(String nome, String cpf, String telefone, String dataDeNascimento, String convenioNome) {
        super(nome, cpf, telefone, dataDeNascimento);
        this.convenioNome = convenioNome;
    }

    public Paciente(String nome, String cpf, String telefone, String dataDeNascimento, String convenioNome, boolean ativo) {
        this(nome, cpf, telefone, dataDeNascimento, convenioNome);
        this.ativo = ativo;
    }

    // atualiza so idade e telefone
    public void complementar(String dataDeNascimento, String telefone) {
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
    }

    // atualiza tudo incluindo convenio
    public void complementar(String dataDeNascimento, String telefone, String convenioNome) {
        complementar(dataDeNascimento, telefone);
        this.convenioNome = convenioNome;
    }

    public void desativar() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }

    public String getConvenioNome() {
        return convenioNome;
    }

    public String exibirResumo() {
        String status = "Sim";
        if (!ativo) {
            status = "Nao";
        }
        return "Nome: " + getNome() +" CPF: " + getCpf() + " | Data de nascimento: " + dataDeNascimento
                + " | Tel: " + telefone + " | Convenio: " + convenioNome
                + " | Ativo: " + status;
    }
}
