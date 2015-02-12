package com.cloudwick.training.designpattern;

public class CloneableExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub

		UserClone obj = new UserClone();
		obj.name = "Fremont";
		System.out.println("Fremont:"+ obj.name);
		
		UserClone obj2 = new UserClone();
		System.out.println("Fremont:"+ obj2.name);
		
		UserClone obj3 = (UserClone) obj.clone();
		System.out.println("Fremont:"+ obj3.name);
	}

}
  