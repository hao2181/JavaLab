import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class Test {

	public static void main(String[] args) throws JAXBException {
		User u = new User();
		u.setId(1);
		u.setName("zhanghao");
		
		Address address = new Address();
		address.setProvince("shannxi");
		address.setCity("baoji");
		address.setStreet("zhongshanRoad");
		u.setAddress(address);
		
		UserList user = new UserList();
		user.add(u);
		user.add(u);
		user.add(u);
		
		JAXBContext ctx = JAXBContext.newInstance(UserList.class);
		Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        
        File file= new File("c:\\fff.xml");
		marshaller.marshal(user, System.out);
		marshaller.marshal(user, file);
	}


}
