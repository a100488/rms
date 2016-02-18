package com.anwei.rms.exception;

public class WebException extends RuntimeException {

    private static final long serialVersionUID = -7819201559865829098L;

    public WebException() {
        super();
    }

    public WebException(String message) {
        super(message);
    }

    public WebException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public WebException(Throwable throwable) {
        super(throwable);
    }
}
