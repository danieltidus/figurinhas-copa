package br.ufpb.dcx.dsc.figurinhas.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tb_album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToMany
    @JoinTable(name = "colecao",
    joinColumns = @JoinColumn(name = "album_id"),
    inverseJoinColumns = @JoinColumn(name = "fig_id") )
    Collection<Figurinha> figurinhas;

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Figurinha> getFigurinhas() {
        return figurinhas;
    }

    public void setFigurinhas(Collection<Figurinha> figurinhas) {
        this.figurinhas = figurinhas;
    }
}
