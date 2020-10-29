package com.epiousion.exception;

public class EpiousionException extends Exception{
	
	public EpiousionException(String mensagem, Exception e) {
        super(mensagem, e);
    }

    public EpiousionException(String mensagem) {
        super(mensagem);
    }
}
