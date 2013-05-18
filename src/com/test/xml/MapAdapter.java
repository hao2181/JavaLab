/**
 * 
 */
package com.test.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.test.xml.MapAdapter.Para.ParaEntry;

/**
 * @author ZhangHao 
 * @date  2013-5-18
 */
public class MapAdapter extends XmlAdapter<MapAdapter.Para, Map<String, String>> {
	
	 
	
	
	@Override
	public Map<String, String> unmarshal(Para v) throws Exception {
		Map<String,String> map = new HashMap<String, String>();
		for(ParaEntry p:v.entries){
			map.put(p.key, p.value);
		}
		return map;
	}

	@Override
	public Para marshal(Map<String, String> v) throws Exception {
		Para p  = new Para();
		for (Map.Entry<String, String> e : v.entrySet()) {
			p.entries.add(new ParaEntry(e));
		}
		return p;
	}
	
	
	public static class Para{
		@XmlElement(name="addres")
		List<ParaEntry> entries = new ArrayList<ParaEntry>();
		 
		static class ParaEntry{
			 @XmlAttribute	
			 String key;
			 @XmlElement
			 String value;
			 /**
			 * @param e
			 */
			public  ParaEntry(){
			}
			
			public  ParaEntry(Map.Entry<String, String> e){
				 key = e.getKey();
				 value=e.getValue();
			}
		}
	}
}
