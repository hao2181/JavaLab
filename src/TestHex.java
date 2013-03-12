
public class TestHex {
	
	public static void main(String[] args) {
		byte byt = -16;
		System.out.println(Integer.toHexString((byt & 0x000000FF) | 0xFFFFFF00));
		
	}
}
