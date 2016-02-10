package com.jsc.javageeks.model;

public class ErrorResponse {

	private String status;
	private String errorMessage;

	public ErrorResponse() {
	}

	public ErrorResponse(String status, String errorMessage) {
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
