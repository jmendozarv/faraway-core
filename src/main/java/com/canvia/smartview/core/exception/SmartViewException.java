package com.canvia.smartview.core.exception;

public class SmartViewException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase DigiletException que recibe como parametro: exception
	 * @param exception
	 */
	public SmartViewException(Exception exception) {
		super(exception);
	}
	
	/**
	 * Constructor de la clase DigiletException que recibe como parametros: message y exception 
	 * @param message
	 * @param exception
	 */
	public SmartViewException(String message, Exception exception) {
		super(message, exception);
	}
	
	
	/**
	 * Constructor de la clase DigiletException que recibe como parametro: message
	 * @param message
	 */
	public SmartViewException(String message) {
		super(message);
	}
}
