import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestIO2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("d:"+File.separator+"1.txt");
		File file2 = new File("d:"+File.separator+"2.txt");
		
		
/*		try {
			FileReader fis = new FileReader(file);
			FileWriter fw = new FileWriter(file2);
			char[] b = new char[1024];
			int len = 0;
			while((len=fis.read(b))!=-1){
				System.out.println(String.valueOf(b));
				fw.write(b);
			}
			fw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		   FileInputStream fis=new FileInputStream(file);      //文件字节流
		   InputStreamReader isr=new InputStreamReader(fis,"GBK"); //字节流和字符流的桥梁，可以指定指定字符格式
		   String str=null;
		  
		   //直接读取字符，只要编码问题没问题
		   int c=0;
		   while((c=isr.read())!=-1)
		   System.out.print((char)c);
		   System.out.println("______________________________________________________");
	}

}
