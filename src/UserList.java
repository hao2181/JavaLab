import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="userList")
public class UserList {
	
	@XmlElement(name="user")
	private List<User> userList ;
	

	public UserList(){
		userList = new ArrayList<User>();
	}
	
    public void add(User user){
    	userList.add(user);
    }

	public List<User> getUserlist() {
		return userList;
	}

	public void setUserlist(List<User> userList) {
		this.userList = userList;
	}


}
