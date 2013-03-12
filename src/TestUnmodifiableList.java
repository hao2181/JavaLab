import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestUnmodifiableList {

		public static void main(String[] args) {
			List<String> list = new ArrayList<String>();
			list.add("zhang");
			List<String> list2 = Collections.unmodifiableList(list);//返回一个不可修改的List
			list2.add("hao");
		}
}
