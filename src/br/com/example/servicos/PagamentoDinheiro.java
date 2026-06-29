package br.com.example.servicos;

import br.com.example.servicos.abstratos.Pagamento;;


public class PagamentoDinheiro extends Pagamento {
    public PagamentoDinheiro(Integer indiceConsulta, double valorFinal, String tipoPagamento) {
        super(indiceConsulta, valorFinal, tipoPagamento);
    }
    public PagamentoDinheiro(Integer indiceConsulta, double valorFinal, String tipoPagamento, Integer parcelas) {
        super(indiceConsulta, valorFinal, tipoPagamento, parcelas);
    }

    @Override
    public Double calcularValorFinal() {
        return 0d;
    }
}
