package com.cloudwick.training.collections;

public class UserSort implements Comparable<UserSort>{
	
	public int ssn;
	public String name;
	@Override
	public int compareTo(UserSort o) {
		// TODO Auto-generated method stub
		return this.ssn - o.ssn;
	}

}
