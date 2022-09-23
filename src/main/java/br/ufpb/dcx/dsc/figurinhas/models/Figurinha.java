package br.ufpb.dcx.dsc.figurinhas.models;

import javax.persistence.*;

@Entity
@Table(name="tb_figurinha")
public class Figurinha {

    @Column(name = "nome")
    private String nome;

    @Column(name = "selecao")
    private String selecao;
    @Column(name = "user_id")
    private Long userId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private static Long IdSequenceCounter = 0L;

    public Figurinha(){
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
