import java.util.Random;

import org.h2.util.DateTimeUtils;


public class TestRandom {

	public static void main(String[] args) {
		String str = "";
	//	DateTimeUtils.getYMDHMSS("yyyyMMddHHmmss");
		Random r = new Random();
		int result=100+r.nextInt(900);
		System.out.println(result);
		//return null;
	}
}
