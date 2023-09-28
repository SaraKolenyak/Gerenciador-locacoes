package br.com.gerenciadorlocacoes.entities;

import javax.persistence.*;

@Entity
@Table(name = "imovel")
public class ImovelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "locador_id")
    private LocadorEntity locador;
    private String apelido;
    private String endereco;


    public void setId(long id) {
        this.id = id;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public String getApelido() {
        return apelido;
    }

    public String getEndereco() {
        return endereco;
    }

    public LocadorEntity getLocador() {
        return locador;
    }

    public void setLocador(LocadorEntity locador) {
        this.locador = locador;
    }
}
