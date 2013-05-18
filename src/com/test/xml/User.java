/**
 * 
 */
package com.test.xml;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author ZhangHao 
 * @date  2013-5-18
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	private String username;
	private String password;
	@XmlElementWrapper(name="hobbys")
	private List<String> hobby;
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date birthday;
	
	@XmlJavaTypeAdapter(MapAdapter.class)
	private Map addresses;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
	public Map getAddresses() {
		return addresses;
	}
	public void setAddresses(Map addresses) {
		this.addresses = addresses;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	

}
