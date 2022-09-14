package br.ufpb.dcx.dsc.figurinhas.models;

public class Figurinha {

    private String nome;

    private String selecao;
    private Long userId;

    private Long id;
    private static Long IdSequenceCounter = 0L;

    public Figurinha(Long userId, String nome, String selecao){
        this.userId = userId;
        this.nome = nome;
        this.selecao = selecao;
        this.id = Figurinha.IdSequenceCounter++;

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getSelecao() {
        return selecao;
    }

    public void setSelecao(String selecao) {
        this.selecao = selecao;
    }
}
