package br.ufpb.dcx.dsc.figurinhas.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_photo")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "nome")
    private String nome;
}
