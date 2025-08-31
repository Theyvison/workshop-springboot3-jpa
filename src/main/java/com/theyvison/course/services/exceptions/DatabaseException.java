package com.theyvison.course.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException {
    @Serial
    public static final long serialVersionUID = 1L;

    public DatabaseException(String message) {
        super(message);
    }
}
