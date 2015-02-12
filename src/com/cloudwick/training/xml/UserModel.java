package com.cloudwick.training.xml;

public class UserModel {
	private int userid;
	private String username;
	private String password;
	private int validity;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "UserModel [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", validity=" + validity + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}

}
