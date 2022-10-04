package br.ufpb.dcx.dsc.figurinhas.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="tb_figurinha")
public class Figurinha {

    @Column(name = "nome")
    private String nome;

    @Column(name = "selecao")
    private String selecao;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fig_id")
    private Long figId;
    private static Long IdSequenceCounter = 0L;


    @ManyToMany(mappedBy = "figurinhas")
    private Collection<Album> albuns;

    public Figurinha(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSelecao() {
        return selecao;
    }

    public void setSelecao(String selecao) {
        this.selecao = selecao;
    }

    public Long getFigId() {
        return figId;
    }

    public void setFigId(Long figId) {
        this.figId = figId;
    }

    public static Long getIdSequenceCounter() {
        return IdSequenceCounter;
    }

    public static void setIdSequenceCounter(Long idSequenceCounter) {
        IdSequenceCounter = idSequenceCounter;
    }

    public Collection<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(Collection<Album> albuns) {
        this.albuns = albuns;
    }
}
