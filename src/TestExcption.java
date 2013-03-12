import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class TestExcption {

		public static void main(String[] args) throws Exception {
			
			
			File file = new File("d:\\1.xls");
			
			try {
				FileInputStream fis = new FileInputStream(file);
			} catch (Exception e) {
				System.out.println("Fuck");
				e.printStackTrace();
			}
			
			System.out.println("HelloWord");
			
		}
}
