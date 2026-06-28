package br.com.example.entidades.profissionais;

import br.com.example.entidades.abstratos.Profissional;

public class Psicologo extends Profissional {
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
    
    @Override
    public void registrarEspecifico() {
    }
}