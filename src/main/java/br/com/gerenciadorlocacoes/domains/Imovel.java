package br.com.gerenciadorlocacoes.domains;

public class Imovel {

    private long id;
    private String apelido;
    private String endereco;

    private Locador locador;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setEndereco(String enderco) {
        this.endereco = enderco;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public String getApelido() {
        return apelido;
    }

    public String getEndereco() {
        return endereco;
    }

    public Locador getLocador() {
        return locador;
    }
}
