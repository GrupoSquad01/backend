package br.com.acerta.service;

public class ServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 2289651712276443832L;

	public ServiceException(String msg) {
		super(msg);
	}

}
