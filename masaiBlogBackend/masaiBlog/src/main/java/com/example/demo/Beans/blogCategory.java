package com.example.demo.Beans;

public enum blogCategory {
//	Technology, Art, Sports
	
	TECHNOLOGY("Technology"),
	ART("Art"),
	SPORTS("Sports");
	
	private final String value;

	private blogCategory(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
