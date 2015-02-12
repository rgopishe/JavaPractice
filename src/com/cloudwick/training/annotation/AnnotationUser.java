package com.cloudwick.training.annotation;

public class AnnotationUser {
	
	public void getInfo(){
		System.out.println("getInfo Invoked");
	}
	@MyAnnotation
	public void getDetails(){
		System.out.println("getDetails Invoked");
	}

}
