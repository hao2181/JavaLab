import java.util.HashMap;
import java.util.Map;


public class TestConstruct {
	
	Map<String,String> map = new HashMap<String,String>();
	
	public TestConstruct() {
	}
	
	public TestConstruct(Map<String,String> map){
		this.map = map;
	}
	
	void p(){
		map.put("zhang", "hao");
		map.put("hao", "zhang");
		map.put("world", "hello");
		map.put("hello", "hello");
	}
	
	public static void main(String[] args) {
		Map<String,String> m = new HashMap<String,String>();
		TestConstruct t = new TestConstruct(m);
		t.p();
		
		for(Map.Entry<String, String> e : m.entrySet()){
			System.out.println(e.getValue());
			System.out.println(m.size());
		}
	}
}
