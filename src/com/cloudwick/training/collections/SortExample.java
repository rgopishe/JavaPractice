package com.cloudwick.training.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List alist = new ArrayList();
		List userList = new ArrayList();

		UserSort obj = new UserSort();
		obj.ssn = 123;
		obj.name = "Raki";
		userList.add(obj);

		UserSort obj1 = new UserSort();
		obj1.ssn = 456;
		obj1.name = "Ritu";
		userList.add(obj1);

		alist.add(5);
		alist.add(12);
		alist.add(6);
		alist.add(3);
		alist.add(14);

		for (Object a : alist) {
			// System.out.println(Integer.parseInt(a.toString()));
			System.out.println(a);

		}

		Collections.sort(alist);

		for (Object a : alist) {
			// System.out.println(Integer.parseInt(a.toString()));
			System.out.println("Sorted results:" + a);

		}

		Collections.sort(userList);
		for (Object b : userList) {
			// System.out.println(Integer.parseInt(a.toString()));
			System.out.println("Sorted ssn are:" + ((UserSort)b).ssn);

		}
	}

}
