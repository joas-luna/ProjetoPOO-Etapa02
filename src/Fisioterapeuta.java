public class Fisioterapeuta extends Profissional {

    public Fisioterapeuta(
            String nome,
            String cpf,
            String registro,
            double valorConsulta) {

        super(nome, cpf, registro, valorConsulta);
    }

    @Override
    public String exibirResumo() {
        return "Fisioterapeuta: " + getNome();
    }
}