package br.com.gerenciadorlocacoes.domains;

public class Locador {

    private long id;
    private String nome;
    private String celular;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public String getCelular() {
        return celular;
    }
}
