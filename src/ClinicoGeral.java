package src;

public class ClinicoGeral extends Profissional {

    public ClinicoGeral(
            String nome,
            String cpf,
            String registro,
            double valorConsulta) {

        super(nome, cpf, "Clínico Geral", valorConsulta, registro);
    }

    @Override
    public String exibirResumo() {
        return "Clinico Geral: " + getNome();
    }
}