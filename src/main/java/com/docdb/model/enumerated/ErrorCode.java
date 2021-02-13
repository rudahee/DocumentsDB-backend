package com.docdb.model.enumerated;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode implements Serializable {
	
	NO_ERROR(0, "OK"),
	INDETERMINATE_ERROR(9000, "Unknown error. Contact an administrator"),
	
	BAD_REGISTER(1001, "Some required field is missing"),
	USER_ALREADY_EXIST(1002, "This user or email already exists"),
	BAD_LOGIN(1003, "Username or password missing"),
	INCORRECT_LOGIN(1004, "Incorrect username or password");
	
	
	
	private final Integer error_code;
	private final String message;

	private ErrorCode(Integer error_code, String message) {
		this.error_code = error_code;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public int getError_code() {
		return error_code;
	}
}
