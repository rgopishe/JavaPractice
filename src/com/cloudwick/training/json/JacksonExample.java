package com.cloudwick.training.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonExample {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		
		Employee obj = new Employee();
		List<String> list = new ArrayList<String>();
		obj.setAge("26");
		obj.setName("Raki");
		list.add("Abd");
		list.add("Xyz");
		obj.setAliases(list);
		
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("Anotherinput.json");
		mapper.writeValue(file, obj);
		
		
		Employee empobj2 = mapper.readValue(file, Employee.class);
		System.out.println(empobj2.getName());
		System.out.println(empobj2.getAge());
		System.out.println(empobj2.getAliases());
		

	}

}
