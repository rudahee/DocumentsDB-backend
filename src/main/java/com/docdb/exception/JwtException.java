package com.docdb.exception;

import com.docdb.model.enumerated.ErrorCode;

@SuppressWarnings("serial")
public class JwtException extends Exception {

	private final ErrorCode code;

	public JwtException(ErrorCode code) {
		super();
		this.code = code;
	}
	
	public ErrorCode getCode() {
		return this.code;
	}
}
