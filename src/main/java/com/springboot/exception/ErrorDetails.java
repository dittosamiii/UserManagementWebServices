package com.springboot.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String path;
	private String error;

	public ErrorDetails() {
		super();
	}

	public ErrorDetails(LocalDateTime timestamp, String message, String path, String error) {
		super();
		this.timestamp = timestamp;
		this.path = path;
		this.message = message;
		this.error = error;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return error;
	}

	public void setErrorCode(String error) {
		this.error = error;
	}
}
