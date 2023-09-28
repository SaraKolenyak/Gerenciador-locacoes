package br.com.gerenciadorlocacoes.domains;

import java.util.Date;

public class Contrato {

    private long id;
    private double valorAluguel;
    private int diaVencimento;
    private Date dtContrato;
    private int prazo;
    private Imovel imovel;
    private Locatario locatario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public void setDtContrato(Date dtContrato) {
        this.dtContrato = dtContrato;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public int getDiaVencimento() {
        return diaVencimento;
    }

    public Date getDtContrato() {
        return dtContrato;
    }

    public int getPrazo() {
        return prazo;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public Locatario getLocatario() {
        return locatario;
    }
}
