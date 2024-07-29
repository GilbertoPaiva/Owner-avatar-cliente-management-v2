package br.com.gpaiva.exception;

public class TipoChaveNaoEncontradaException extends Exception {

    private static final long serialVersionUID = -7078720255689650231L;

    public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
