import org.apache.commons.lang.StringUtils;


public class MyCompactor implements Comparable<Object> {

	

	public int compareTo(Object o) {
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(StringUtils.trimToEmpty(null));
	}

}
