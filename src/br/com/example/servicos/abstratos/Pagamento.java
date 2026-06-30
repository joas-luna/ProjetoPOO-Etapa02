package br.com.example.servicos.abstratos;


public abstract class Pagamento {
    private Integer indiceConsulta;
    private double valorFinal;
    private String tipoPagamento;
    private Integer parcelas = 1;

    public Pagamento(Integer indiceConsulta, double valorFinal, String tipoPagamento) {
        this.indiceConsulta = indiceConsulta;
        this.valorFinal = valorFinal;
        this.tipoPagamento = tipoPagamento;
    }

    // com parcelas (so pra cartao)
    public Pagamento(Integer indiceConsulta, double valorFinal, String tipoPagamento, Integer parcelas) {
        this(indiceConsulta, valorFinal, tipoPagamento);
        this.parcelas = parcelas;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    // sem desconto nenhum
    public static double calcularValor(double valorBase) {
        return valorBase;
    }

    // com desconto em percentual
    public static double calcularValor(double valorBase, double percentualDesconto) {
        double desconto = valorBase * percentualDesconto / 100;
        double valor = valorBase - desconto;
        if (valor < 0) {
            valor = 0;
        }
        return valor;
    }

    // com desconto e multa somada
    public static double calcularValor(double valorBase, double percentualDesconto, double multa) {
        return calcularValor(valorBase, percentualDesconto) + multa;
    }

    public String exibirResumo() {
        // arredonda pra 2 casas
        double valorArredondado = Math.round(valorFinal * 100.0) / 100.0;
        String resumo = "Consulta #" + indiceConsulta + " | Valor: R$" + valorArredondado
                + " | Tipo: " + tipoPagamento + " | Parcelas: " + parcelas;
        if (parcelas > 1) {
            double valorParcela = Math.round((valorFinal / parcelas) * 100.0) / 100.0;
            resumo = resumo + " (R$" + valorParcela + " cada)";
        }
        return resumo;
    }

    public abstract Double calcularValorFinal();
}
