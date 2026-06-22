package src;

public class Fisioterapeuta extends Profissional {

    public Fisioterapeuta(
            String nome,
            String cpf,
            String registro,
            double valorConsulta) {

        super(nome, cpf, "Fisioterapeuta", valorConsulta, registro);
    }

    @Override
    public String exibirResumo() {
        return "Fisioterapeuta: " + getNome();
    }
}