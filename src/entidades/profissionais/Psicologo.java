package src.entidades.profissionais;

import src.entidades.abstratos.Profissional;

public class Psicologo extends Profissional {
    @Override
    public void registrarEspecifico() {
    }
    
    public Psicologo(
            String nome,
            String cpf,
            String registro,
            double valorConsulta) {

        super(nome, cpf, "psicologia", valorConsulta, registro);
    }

    @Override
    public String exibirResumo() {
        return "Psicologo: " + getNome();
    }
}