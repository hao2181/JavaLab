import java.math.BigDecimal;


public class TestDouble2Decemal {


	public static void main(String[] args) {
		double f = 0.07;
		BigDecimal b1 = new BigDecimal(f*100);
		System.out.println(b1.setScale(2,BigDecimal.ROUND_HALF_UP));
	}
}
