/**
 * 
 */
package com.test.xml;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * @author ZhangHao 
 * @date  2013-5-18
 */
public class TestJaxb {
	public static void main(String[] args) throws JAXBException {
		JAXBContext ctx = JAXBContext.newInstance(User.class);
		/*
			Unmarshaller um = ctx.createUnmarshaller();
			User u = (User)um.unmarshal(new File("text.xml"));
			System.out.println(u.getUsername());
			System.out.println(u.getAddress());
		*/
		Marshaller m = ctx.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		User u = new User();
		u.setUsername("张浩");
		u.setPassword("123456");
		
		u.setBirthday(new Date());
		List<String> list = new ArrayList<String>();
		list.add("游泳");
		list.add("跑步");
		list.add("篮球");
		u.setHobby(list);
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("1","台湾");
		map.put("2","日本");
		u.setAddresses(map);
		m.marshal(u, System.out);
	}
}
