package com.anwei.rms.exception;

/**
 * 常用的业务类型异常抛出
 * 
 * @author Songanwei
 *
 */
public class BusinessServerErrorException extends HttpException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5334724530273548451L;

	public BusinessServerErrorException() {
		super();
	}

	public BusinessServerErrorException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public BusinessServerErrorException(String message) {
		super(message);
	}

	public BusinessServerErrorException(Throwable throwable) {
		super(throwable);
	}

	private String errorCode = null;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
