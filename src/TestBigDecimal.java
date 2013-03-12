import java.math.BigDecimal;


public class TestBigDecimal {

	public static void main(String[] args) {
		
		BigDecimal b1 = new BigDecimal(1258.00).setScale(2);
		
		System.out.println(b1.equals(new BigDecimal("1258.00").setScale(2)));
	}
}
