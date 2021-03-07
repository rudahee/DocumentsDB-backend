package com.docdb.model.enumerated;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode implements Serializable {
	
	NO_ERROR("OK"),
	INDETERMINATE_ERROR("Unknown error. Contact an administrator"),
	
	FIELD_IS_MISSING("Some required field is missing"),
	USER_ALREADY_EXIST("This user or email already exists"),
	INCORRECT_LOGIN("Incorrect username or password"),
	
	JWT_ERROR("Session failed, re-login"), 
	
	FILE_TOO_BIG("Maximun file size is 510Mb");
	
	private final String message;

	private ErrorCode( String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
