package src;
public class Paciente extends Pessoa {
    private int idade = 0;
    private String telefone = "";
    private String convenioNome = "";
    public boolean ativo = false;

    public Paciente(String nome, String cpf) {
        super(nome, cpf);
    }

    public Paciente(String nome, String cpf, int idade, String telefone) {
        super(nome, cpf);
        this.idade = idade;
        this.telefone = telefone;
    }

    // construtor com todos os dados
    public Paciente(String nome, String cpf, int idade, String telefone, String convenioNome) {
        this(nome, cpf, idade, telefone);
        this.convenioNome = convenioNome;
    }

    // atualiza so idade e telefone
    public void complementar(int idade, String telefone) {
        this.idade = idade;
        this.telefone = telefone;
    }

    // atualiza tudo incluindo convenio
    public void complementar(int idade, String telefone, String convenioNome) {
        complementar(idade, telefone);
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
        return "Nome: " + getNome() +" CPF: " + getCpf() + " | Idade: " + idade
                + " | Tel: " + telefone + " | Convenio: " + convenioNome
                + " | Ativo: " + status;
    }
}
