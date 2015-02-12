package com.cloudwick.training.designpattern;

public class FactoryExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AuthenticateI obj = UserFactory.getObject(1);
		obj.authenticate();
		
		AuthenticateI obj1 = UserFactory.getObject(2);
		obj1.authenticate();
		
		System.out.println( obj1 instanceof GeneralUser);
	}

}
