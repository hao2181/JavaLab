package com.test.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class TestJackson {
	
	ObjectMapper mapper = null; // can reuse, share globally

	public TestJackson() {
		mapper = new ObjectMapper();
	}
	
	@Test //普通bean to json
	public void test01() throws IOException{
		User user = new User(1,"zhanghao","DongFeng Street");
		System.out.println(mapper.writeValueAsString(user));
	}
	
	@Test //普通list to json
	public void test02() throws IOException{
		List<User> list = new ArrayList<User>();
		list.add(new User(1,"zhang1","ONE1 STREET"));
		list.add(new User(2,"zhang2","ONE2 STREET"));
		list.add(new User(3,"zhang3","ONE3 STREET"));
		list.add(new User(4,"zhang4","ONE4 STREET"));
		System.out.println(mapper.writeValueAsString(list));
	}
	
	@Test //普通map to json
	public void test03() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", new User(1,"zhang1","ONE1 STREET"));
		map.put("2", new User(2,"zhang2","ONE2 STREET"));
		//map.put("3", value);
		//map.put("4", value);
		System.out.println(mapper.writeValueAsString(map));
	}
	
	@Test // 数组
	public void test04() throws IOException{
		Object[] obj = new Object[10];
		obj[0] = new User(1,"arry1","zhongshan road1");
		obj[1] = new User(2,"arry2","zhongshan road2");
		obj[2] = new User(3,"arry3","zhongshan road3");
		System.out.println(mapper.writeValueAsString(obj));
	}
	
	@Test //json 到对象
	public void test05() throws JsonParseException, JsonMappingException, IOException{
		//User1 user = mapper.readValue(new File("c:/1.txt"), User1.class);
		User1 user = mapper.readValue(new File("c:/1.txt"), User1.class);
		System.out.println(user.getName());
	}

	
}
