package com.example.demo.dto;

public class ResponseModelDTO<T> {
	private String message;
	private T data;
	
	public String getMessage() {
		return this.message;
	}
	public T getData() {
		return this.data;
	}
	public void setMessage(String message) {
		this.message=message;
	}
	public void setData(T data) {
		this.data=data;
	}
	
	public ResponseModelDTO() {
		
	}
	public ResponseModelDTO(String message) {
		this.message=message;
	}
	public ResponseModelDTO(String message, T data) {
		this.message=message;
		this.data=data;
	}
	 

}
