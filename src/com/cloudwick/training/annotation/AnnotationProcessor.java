package com.cloudwick.training.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationProcessor {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub

		AnnotationUser obj = new AnnotationUser();
		Method[] methods = obj.getClass().getMethods();
		for(Method method: methods){
			MyAnnotation m = method.getAnnotation(MyAnnotation.class);
			if (m!=null){
				method.invoke(obj);
			}
		}
	}

}
