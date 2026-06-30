package br.com.example.entidades;

import br.com.example.dtos.Convenio;
import br.com.example.entidades.abstratos.Pessoa;
import br.com.example.utilitarios.Saida;


public class Paciente extends Pessoa {
    private Convenio convenio;
    public boolean ativo = true;

    public Paciente(String nome, String cpf) {
        super(nome, cpf);
    }

    public Paciente(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }

    public Paciente(String nome, String cpf, String telefone, String dataDeNascimento) {
        super(nome, cpf, telefone, dataDeNascimento);
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

    public void desativar() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    // atualiza tudo incluindo convenio
    public void complementar(String dataDeNascimento, String telefone, Convenio convenio) {
        complementar(dataDeNascimento, telefone);
        this.convenio = convenio;
    }

    @Override
    public String exibirResumo() {
        String status = "Sim";
        if (!ativo) {
            status = "Nao";
        }
        return Saida.verde(nome) + " | " 
        + Saida.vermelho("CPF: " + getCpf()) + " | " 
        + Saida.ciano("Data de nascimento: " + dataDeNascimento) + " | " 
        + Saida.roxo("Tel: " + telefone) + " | " 
        + Saida.amarelo("Convenio: " + convenio) + " | " 
        + status;
    }

    public String exibirResumo(Integer lenNome, Integer lenNomeConvenio) {
        String status = "Sim";
        String nomeConvenio = "Nenhum";
        Integer lenNumero = 4;
        Integer lenDataDeNascimento = 4;

        if (!ativo) {
            status = "Nao";
        }    

        if(convenio != null) {
            nomeConvenio = convenio.getNome();
        }

        if(telefone != null) {
            lenNumero = 15;
        }

        if(dataDeNascimento != null) {
            lenDataDeNascimento = 10;
        }

        return Saida.verde(nome) + Saida.espacos(lenNome - nome.length()) + " | " 
        + Saida.vermelho(cpf) + " | " 
        + Saida.ciano(dataDeNascimento) + Saida.espacos(18 - lenDataDeNascimento) + " | " 
        + Saida.roxo(telefone) +  Saida.espacos(15 - lenNumero) + " | " 
        + Saida.amarelo(nomeConvenio) + Saida.espacos(lenNomeConvenio - nomeConvenio.length()) + " | " 
        + status;
    }
}
