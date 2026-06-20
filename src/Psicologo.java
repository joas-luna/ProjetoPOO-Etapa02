public class Psicologo extends Profissional {

    public Psicologo(
            String nome,
            String cpf,
            String registro,
            double valorConsulta) {

        super(nome, cpf, registro, valorConsulta);
    }

    @Override
    public String exibirResumo() {
        return "Psicologo: " + getNome();
    }
}