public class Profissional extends Pessoa {

    private String especialidade;
    private String registroProfissional;
    private double valorConsulta;
    private String[] diasDisponiveis;
    private int totalDias;

    // só nome, cpf e especialidade
    public Profissional(String nome, String cpf, String especialidade) {
        super(nome, cpf);

        this.especialidade = especialidade;
        this.registroProfissional = "";
        this.valorConsulta = 0;
        this.diasDisponiveis = new String[7];
        this.totalDias = 0;
    }

    public Profissional(String nome, String cpf, String especialidade,
                         String registroProfissional, double valorConsulta) {

        super(nome, cpf);

        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
        this.valorConsulta = valorConsulta;
        this.diasDisponiveis = new String[7];
        this.totalDias = 0;
    }

    // construtor completo com dias
    public Profissional(String nome, String cpf, String especialidade,
                         String registroProfissional, double valorConsulta,
                         String[] dias, int totalDias) {

        super(nome, cpf);

        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
        this.valorConsulta = valorConsulta;
        this.diasDisponiveis = new String[7];
        this.totalDias = totalDias;

        for (int i = 0; i < totalDias; i++) {
            this.diasDisponiveis[i] = dias[i];
        }
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public String[] getDiasDisponiveis() {
        return diasDisponiveis;
    }

    public int getTotalDias() {
        return totalDias;
    }

    public void atualizar(String registro, double valor) {
        this.registroProfissional = registro;
        this.valorConsulta = valor;
    }

    public void atualizar(String registro, double valor,
                          String[] dias, int totalDias) {

        this.registroProfissional = registro;
        this.valorConsulta = valor;
        this.totalDias = totalDias;

        for (int i = 0; i < totalDias; i++) {
            this.diasDisponiveis[i] = dias[i];
        }
    }

    // verifica se atende naquele dia
    public boolean atendeNoDia(String dia) {

        for (int i = 0; i < totalDias; i++) {

            if (diasDisponiveis[i] != null &&
                diasDisponiveis[i].equalsIgnoreCase(dia)) {

                return true;
            }
        }

        return false;
    }

    // valida especialidades
    public static boolean especialidadeValida(String esp) {

        return esp.equalsIgnoreCase("clinica geral")
                || esp.equalsIgnoreCase("fisioterapia")
                || esp.equalsIgnoreCase("psicologia")
                || esp.equalsIgnoreCase("nutricao");
    }

    @Override
    public String exibirResumo() {

        String dias = "";

        for (int i = 0; i < totalDias; i++) {

            if (i > 0) {
                dias += ", ";
            }

            dias += diasDisponiveis[i];
        }

        return "Nome: " + getNome()
                + " | CPF: " + getCpf()
                + " | Espec: " + especialidade
                + " | Reg: " + registroProfissional
                + " | Valor: R$" + valorConsulta
                + " | Dias: " + dias;
    }
}