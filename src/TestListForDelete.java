import java.util.ArrayList;
import java.util.List;


public class TestListForDelete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("strr1");
		list.add("strr2");
		list.add("strr3");
		list.add("strr4");
		list.add("strr5");
		list.add("strr6");
		for(int i= 0 ;i<list.size();i++){
				System.out.println(list.size());
				list.remove(i);
		}
		for(int i= 0 ;i<list.size();i++){
			String str = list.get(i);
			System.out.println(str);
		}
		
	}

}
