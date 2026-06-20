public class ClinicoGeral extends Profissional {

    public ClinicoGeral(
            String nome,
            String cpf,
            String registro,
            double valorConsulta) {

        super(nome, cpf, registro, valorConsulta);
    }

    @Override
    public String exibirResumo() {
        return "Clinico Geral: " + getNome();
    }
}