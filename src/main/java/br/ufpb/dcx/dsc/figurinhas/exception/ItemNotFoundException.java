package br.ufpb.dcx.dsc.figurinhas.exception;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String message){
        super(message);
    }
}
