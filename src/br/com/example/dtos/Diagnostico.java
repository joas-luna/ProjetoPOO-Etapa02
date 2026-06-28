package br.com.example.dtos;

public class Diagnostico {

    private String descricao;
    private String cid;
    private String recomendacoes;

    public Diagnostico(String descricao) {
        this.descricao = descricao;
    }

    public Diagnostico(String descricao, String cid) {
        this.descricao = descricao;
        this.cid = cid;
    }

    public Diagnostico(String descricao, String cid, String recomendacoes) {
        this.descricao = descricao;
        this.cid = cid;
        this.recomendacoes = recomendacoes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getRecomendacoes() {
        return recomendacoes;
    }

    public void setRecomendacoes(String recomendacoes) {
        this.recomendacoes = recomendacoes;
    }

    @Override
    public String toString() {

        String texto = descricao;

        if (cid != null && !cid.isEmpty()) {
            texto += " (CID: " + cid + ")";
        }

        if (recomendacoes != null && !recomendacoes.isEmpty()) {
            texto += " - " + recomendacoes;
        }

        return texto;
    }

}