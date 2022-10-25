package br.ufpb.dcx.dsc.figurinhas.dto;

import br.ufpb.dcx.dsc.figurinhas.validation.Selecao;

import javax.validation.constraints.NotBlank;

public class FigurinhaDTO {

    @NotBlank
    private String nome;
    @Selecao
    private String selecao;

    private Long id;

    public FigurinhaDTO(){

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

    public void setId(Long id){
        this.id = id;
    }
    public String getSelecao() {
        return selecao;
    }

    public void setSelecao(String selecao) {
        this.selecao = selecao;
    }

}
