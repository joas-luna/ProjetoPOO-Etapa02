package src;

public class Psicologo extends Profissional {

    public Psicologo(
            String nome,
            String cpf,
            String registro,
            double valorConsulta) {

        super(nome, cpf, "Pscicólogo", valorConsulta, registro);
    }

    @Override
    public String exibirResumo() {
        return "Psicologo: " + getNome();
    }
}