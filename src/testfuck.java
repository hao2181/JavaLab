import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class testfuck {

		public static void main(String[] args) throws IOException {
/*			File file = new File("c:\\1.txt");
			BufferedOutputStream out = new BufferedOutputStream(new  FileOutputStream(file));
			OutputStreamWriter ow = new OutputStreamWriter(out);
			ow.write("fffffffffffffffffffffffffff");
			System.out.println(args[0]);
			out.write(args[0].getBytes());
			out.close();
			ow.close();*/
			
			String a = "T4NJx%2FVgocRsLyQnrMZLyuQQkFzMAxQjdqyzf6pM%2Fcg%3D";
			String b = new String(a.getBytes("ISO8859-1"),"GBK");
			System.out.println(b);
		}

}
