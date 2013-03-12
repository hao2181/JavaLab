import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestDoubleCompare {
	public static void main(String[] args) throws ParseException {
		String str="2012年9月12日";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
		Date date = formatter.parse(str);
		
		System.out.println(date);
	}
}
