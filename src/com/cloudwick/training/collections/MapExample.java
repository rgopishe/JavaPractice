package com.cloudwick.training.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class MapExample {

	Map<Integer,String> dataMap;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapExample mp = new MapExample();
		mp.populateMap();
		mp.fetchDataByKeys();
		mp.fetchByEntry();

	}

	private void populateMap(){
		dataMap = new HashMap<>();
		dataMap.put(11, "F");
		dataMap.put(22, "G");
		dataMap.put(11, "C");
		dataMap.put(33, "M");
		//dataMap.put(null,null);
		
	}
	
	private void fetchDataByKeys(){
		Set<Integer> keyset = dataMap.keySet();
		Iterator<Integer> itr = keyset.iterator();
		while(itr.hasNext()){
			int i = itr.next();
			System.out.println("key is :"+i);
			String val = dataMap.get(i);
			System.out.println("Values are :"+val);
			//dataMap.remove(33);
		}
	}
	
	private void fetchByEntry(){
		Set<Entry<Integer , String>> entries = dataMap.entrySet();
		for (Entry<Integer , String> e : entries){
			System.out.println("Entry key:" +e.getKey());
			System.out.println("Entry value:" +e.getValue());
		}
	}
}

