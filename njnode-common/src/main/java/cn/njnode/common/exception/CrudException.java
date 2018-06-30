package cn.njnode.common.exception;

import static java.text.MessageFormat.format;

import java.text.MessageFormat;

public class CrudException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -94833616314273292L;

	/**
	 * 错误码
	 */
	private final String errorCode;

	/**
	 * Crud层抛出的异常
	 * 
	 * @param errorCode
	 *            错误码
	 * @param errFormat
	 *            错误描述模板，模板规则与{@link MessageFormat#format(String, Object...)}一致
	 * @param args
	 *            错误描述参数
	 */
	public CrudException(String errorCode, String errFormat, Object... args) {
		super(errorCode + "|" + format(errFormat, args));
		this.errorCode = errorCode;

	}

	/**
	 * Crud层抛出的异常
	 * 
	 * @param cause
	 *            错误原因
	 * @param errorCode
	 *            错误码
	 * @param errFormat
	 *            错误描述模板，模板规则与{@link MessageFormat#format(String, Object...)}一致
	 * @param args
	 *            错误描述参数
	 */
	public CrudException(Throwable cause, String errorCode, String errFormat, Object... args) {
		super(errorCode + "|" + format(errFormat, args), cause);
		this.errorCode = errorCode;
	}

	/**
	 * Crud层抛出的异常
	 * 
	 * @param cause
	 *            错误原因
	 * @param errorCode
	 *            错误码
	 */
	public CrudException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}

	/**
	 * Crud层抛出的异常
	 * 
	 * @param cause
	 *            源异常
	 */
	public CrudException(Throwable cause) {
		super(ErrorCodeConstants.Unknown, cause);
		this.errorCode = ErrorCodeConstants.Unknown;
	}

	/**
	 * Crud层抛出的异常
	 * 
	 * @param cause
	 *            源异常
	 */
	public CrudException(CrudException cause) {
		super(cause.getMessage(), cause.getCause());
		CrudException ce = (CrudException) cause;
		this.errorCode = ce.errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
