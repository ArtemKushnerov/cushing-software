package com.websearch.exception;

import java.io.IOException;

public class GoogleSearchException extends RuntimeException {
    public GoogleSearchException(String message, IOException e) {
        super(message, e);
    }
}
