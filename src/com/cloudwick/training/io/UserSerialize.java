package com.cloudwick.training.io;

import java.io.Serializable;

public class UserSerialize implements Serializable {

	private transient int ssn;
	private String name;

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
