public class Tagss {
	private static  Integer[] base ;

	public static void printAll(Integer len) {
		base = new Integer[len];
		for (int i = 0; i < len; i++) {
			base[i] = (i + 1);
		}
		check(base, 0, base.length-1);
	}

	public static void check(Integer[] base, int start, int end) {
		if (start == end) {
			for (int i = 0; i <= end; i++) {
				if(i==end){
					System.out.print(base[i]);
				}else{
					System.out.print(base[i]);
				}
			}
			System.out.println();
		} else {
			for (int i = start; i <= end; i++) {
				Integer temp = base[start];
				base[start] = base[i];
				base[i] = temp;
				check(base, start + 1, end);
				temp = base[start];
				base[start] = base[i];
				base[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		printAll(5);
	}
}
