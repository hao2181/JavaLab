import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author ZhangHao 
 * @date  2013-4-20
 */
public class TestList {

		public static void main(String[] args) {
			User1 u1 = new User1();
			u1.setName("zhang");
			u1.setWord("hello");
			
			User1 u2 = new User1();
			u2.setName("liu");
			u2.setWord("world");
			List<User1> list = new ArrayList<User1>();
			list.add(u1);
			list.add(u2);
			
			for(User1 u : list){
				if(u.getName().equals("zhang")){
					System.out.println("====");
					u.setWord("helooooooo");
				}
			}
			
			for(User1 u: list){
				System.out.println(u.getName()+"===="+u.getWord());
			}
			
		}
}


class User1{
	
	private String name;
	private String word;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
	
	
}