package src;

public class Nutricionista extends Profissional {

    public Nutricionista(
            String nome,
            String cpf,
            String registro,
            double valorConsulta) {

        super(nome, cpf, "Nutricionista", valorConsulta, registro);
    }

    @Override
    public String exibirResumo() {
        return "Nutricionista: " + getNome();
    }
}