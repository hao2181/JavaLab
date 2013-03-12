import org.apache.commons.lang.StringUtils;


public class TestSplit {
	
	public static void main(String[] args) {
		
		String s = "12312312@h8uhiu2huih@131jk23n1jn23jn1k@bnj2bn@3nj1k2n3j2n1k@bn1j23b1j23@";
		
		String str[] = s.split("@");
		System.out.println(str.length);
		for(int i=0 ; i<str.length ;i++){
			System.out.println(str[i].toString());
		}
		
		String s1[] = StringUtils.splitByWholeSeparator(s, "@");
		for(int i=0 ; i<s1.length ;i++){
			System.out.println(s1[i].toString());
		}
		System.out.println(s1.length);
	}
}
