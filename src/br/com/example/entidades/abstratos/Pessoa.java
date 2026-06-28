package br.com.example.entidades.abstratos;


public abstract class Pessoa {
    private String nome;
    private String cpf;
    /**
     * Número de telefone pode ser acessado pelas subclasses.
     */
    protected String telefone;
    /**
     * Data de nascimento pode ser acessado pelas subclasses.
     */
    protected String dataDeNascimento;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(String nome, String cpf, String telefone) {
        this(nome, cpf);
        this.telefone = telefone;
    }

    public Pessoa(String nome, String cpf, String telefone, String dataDeNascimento) {
        this(nome, cpf, telefone);
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // atualiza so idade e telefone
    public void complementar(String dataDeNascimento, String telefone) {
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
    }

    public abstract String exibirResumo();
}