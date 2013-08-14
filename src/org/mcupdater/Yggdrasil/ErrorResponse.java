package org.mcupdater.Yggdrasil;

public class ErrorResponse {
	private String error;
	private String errorMessage;
	private String cause;
	
	public String getError() {
		return this.error;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
	public String getCause() {
		return this.cause;
	}
}
