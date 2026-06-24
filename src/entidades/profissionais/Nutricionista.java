package src.entidades.profissionais;

import src.entidades.abstratos.Profissional;

public class Nutricionista extends Profissional {
    @Override
    public void registrarEspecifico() {
    }

    public Nutricionista(
            String nome,
            String cpf,
            String registro,
            double valorConsulta) {

        super(nome, cpf, "nutricao", valorConsulta, registro);
    }

    @Override
    public String exibirResumo() {
        return "Nutricionista: " + getNome();
    }
}