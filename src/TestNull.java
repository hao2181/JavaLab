
public class TestNull {
	public static void main(String[] args) {
		String a = null;
		
		System.out.println("".equals(a));
	//	System.out.println(a.indexOf("a"));
		
		if(a != null && !a.equals("")){
			System.out.println("HelloWolrd");
		}
		
		
		System.out.println( 64<<4 );
		
		System.out.println((0x31 & 0x0f));
	}
}
