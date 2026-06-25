package src.entidades.profissionais;

import src.entidades.abstratos.Profissional;

public class Fisioterapeuta extends Profissional {
    public Fisioterapeuta(
        String nome,
        String cpf,
        String registro,
        double valorConsulta) {

        super(nome, cpf, "fisioterapia", valorConsulta, registro);
    }
    
    @Override
    public String exibirResumo() {
        return "Fisioterapeuta: " + getNome();
    }

    @Override
    public void registrarEspecifico() {
    }
}