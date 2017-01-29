package com.axatrikx.controller;

import java.util.Arrays;
import java.util.HashMap;

import org.apache.http.params.HttpParams;



public class RestResponse {

	private int responseCode;
	private String responseBody;
	private HashMap<String, String> headers;
	private String responseMessage;
	private HashMap<String, String> params;
	
	public RestResponse() {
		headers = new HashMap<String, String>();
		
	}

	

	



	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public HashMap<String, String> getHeaders() {
		return headers;
	}

	public String getHeader(String name) {
		return headers.get(name);
	}

	public void setHeader(String name, String value) {
		this.headers.put(name, value);
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public HashMap<String, String> getParams() {
		return params;
	}

	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}

	

	

}
