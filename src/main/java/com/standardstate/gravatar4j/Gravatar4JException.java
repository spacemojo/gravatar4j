package com.standardstate.gravatar4j;

public class Gravatar4JException extends RuntimeException {

    public Gravatar4JException(final Throwable cause) {
        super(cause);
    }

    public Gravatar4JException(final String message) {
        super(message);
    }
    
}
