package com.klagan.retows.exception;

public class BusinessException extends Exception {

    /**
     * @author Andy Gómez
     * @implSpec Exception de lógica de negocio
     *
     */
    private static final long serialVersionUID = 1L;

    public BusinessException(String message, Long productId) {
        super(message.concat(productId.toString()));
    }
}