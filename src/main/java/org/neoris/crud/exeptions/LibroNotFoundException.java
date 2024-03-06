package org.neoris.crud.exeptions;

public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException(String message) {
        super(message);
    }
}
