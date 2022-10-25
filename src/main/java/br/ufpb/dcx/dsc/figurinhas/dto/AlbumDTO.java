package br.ufpb.dcx.dsc.figurinhas.dto;

import javax.validation.constraints.NotBlank;

public class AlbumDTO {

    private Long albumId;

    @NotBlank
    private String nome;

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
}
