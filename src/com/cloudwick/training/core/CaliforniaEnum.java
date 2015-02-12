package com.cloudwick.training.core;

public enum CaliforniaEnum {

	WINTER(11, "2000"), SUMMER(22, "3000"), FALL(13, "6000");

	private int id;
	private String pay;

	private CaliforniaEnum(int id, String pay) {
		this.id = id;
		this.pay = pay;

	}

	public int getId() {
		return id;
	}

	public String getPay() {
		return pay;
	}

}
