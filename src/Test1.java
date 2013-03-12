import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class Test1 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException{
		
		JAXBContext ctx = null;
		try {
			ctx = JAXBContext.newInstance(UserList.class);
			//Marshaller marshaller = ctx.createMarshaller();
			Unmarshaller unMarshaller = ctx.createUnmarshaller();
			
	        
	        File file= new File("c:\\fff.xml");
	        UserList ul = (UserList)unMarshaller.unmarshal(file);  
			for(User u :ul.getUserlist()){
				System.out.println(u.getName());
				System.out.println(u.getAddress().getProvince());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	
	}

}
