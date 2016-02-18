package com.anwei.rms.exception;



public class HttpException extends WebException {

    private static final long serialVersionUID = 422926358629179390L;

    public HttpException() {
        super();
    }

    public HttpException(String message) {
        super(message);
    }

    public HttpException(Throwable throwable) {
        super(throwable);
    }

    public HttpException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
