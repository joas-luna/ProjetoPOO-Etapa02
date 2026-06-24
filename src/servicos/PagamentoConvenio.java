package src.servicos;

import src.servicos.abstratos.Pagamento;

public class PagamentoConvenio extends Pagamento {
    public PagamentoConvenio(int indiceConsulta, double valorFinal, String tipoPagamento) {
        super(indiceConsulta, valorFinal, tipoPagamento);
    }
    public PagamentoConvenio(int indiceConsulta, double valorFinal, String tipoPagamento, int parcelas) {
        super(indiceConsulta, valorFinal, tipoPagamento, parcelas);
    }

    @Override
    public Double calcularValorFinal() {
        return 0d;
    }
}
