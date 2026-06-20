public class Nutricionista extends Profissional {

    public Nutricionista(
            String nome,
            String cpf,
            String registro,
            double valorConsulta) {

        super(nome, cpf, registro, valorConsulta);
    }

    @Override
    public String exibirResumo() {
        return "Nutricionista: " + getNome();
    }
}