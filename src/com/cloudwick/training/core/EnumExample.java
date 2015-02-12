package com.cloudwick.training.core;

public class EnumExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//System.out.println(CaliforniaEnum.WINTER.getId());
		//System.out.println(CaliforniaEnum.WINTER.getPay());
		
		
		for(CaliforniaEnum e: CaliforniaEnum.values()){
			System.out.println(e.getId());
			System.out.println(e.getPay());
	}
		
	}

}
