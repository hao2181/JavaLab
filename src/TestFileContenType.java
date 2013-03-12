import java.io.File;

import javax.swing.JFileChooser;


public class TestFileContenType {
	
	public static void main(String[] args) {
		
		File file = new File("d:/1.txt");
		JFileChooser chooser = new JFileChooser();
		String fileTypeName = chooser.getTypeDescription(file);
		System.out.println(fileTypeName);
	}
}
