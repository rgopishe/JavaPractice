package com.cloudwick.training.designpattern;

public class UserFactory {

	public static AuthenticateI getObject(int type) {
		AuthenticateI obj = null;
		if (type == 1) {
			obj = new AdminUser();

		}
		else if (type == 2) {
			obj = new GeneralUser();
		}
		return obj;
	}
}
