package br.com.example.servicos;

import br.com.example.servicos.abstratos.Pagamento;

public class PagamentoCartao extends Pagamento {
    public PagamentoCartao(Integer indiceConsulta, double valorFinal, String tipoPagamento) {
        super(indiceConsulta, valorFinal, tipoPagamento);
    }
    public PagamentoCartao(Integer indiceConsulta, double valorFinal, String tipoPagamento, Integer parcelas) {
        super(indiceConsulta, valorFinal, tipoPagamento, parcelas);
    }

    @Override
    public Double calcularValorFinal() {
        return 0d;
    }
}
