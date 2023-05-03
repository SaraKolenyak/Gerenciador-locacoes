package br.com.gerenciadorlocacoes.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "contrato")
public class ContratoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double valorAluguel;
    private int diaVencimento;
    private Date dtContrato;
    private int prazo;
    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private ImovelEntity imovel;
    @ManyToOne
    @JoinColumn(name = "locatario_id")
    private LocatarioEntity locatario;


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

    public void setImovel(ImovelEntity imovel) {
        this.imovel = imovel;
    }

    public void setLocatario(LocatarioEntity locatario) {
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

    public ImovelEntity getImovel() {
        return imovel;
    }

    public LocatarioEntity getLocatario() {
        return locatario;
    }


}
