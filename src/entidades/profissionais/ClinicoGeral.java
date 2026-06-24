package src.entidades.profissionais;

import src.entidades.abstratos.Profissional;

public class ClinicoGeral extends Profissional {
    @Override
    public void registrarEspecifico() {
    }

    public ClinicoGeral(
            String nome,
            String cpf,
            String registro,
            double valorConsulta) {

        super(nome, cpf, "clinica geral", valorConsulta, registro);
    }

    @Override
    public String exibirResumo() {
        return "Clinico Geral: " + getNome();
    }
}