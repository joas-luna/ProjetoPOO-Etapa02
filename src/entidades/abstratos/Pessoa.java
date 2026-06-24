package src.entidades.abstratos;


public abstract class Pessoa {

    protected String nome;
    protected String cpf;
    protected String telefone;
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

    public abstract String exibirResumo();
}