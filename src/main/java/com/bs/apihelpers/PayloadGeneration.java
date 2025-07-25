package com.bs.apihelpers;

public class PayloadGeneration {

	private String from;
	private String to;
	private String q;

	public PayloadGeneration(String from, String to, String q) {
		this.from = from;
		this.to = to;
		this.q = q;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getQ() {
		return q;
	}


}
