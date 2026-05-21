package br.com.kadson.databaseExercise.ExemploVendas.exceptions;

public class TableException extends Exception {

    private static final long serialVersionUID = -7509649433607067138L;

    public TableException(String msg, Exception e) {
        super(msg);
    }

}
