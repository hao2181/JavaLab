
public class TestStringlength {


	
	public static void main(String[] args) {
		String a="a1";
		String b="发发";
		
		byte[] b1 = a.getBytes();
		byte[] b2 = b.getBytes();
		
		System.out.println(b1.length+"--"+b2.length);
	}
}
