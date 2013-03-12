import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;


public class TestCharSet {

		public static void main(String[] args) {
			
			Charset charset = Charset.forName("UTF-8");
			CharsetEncoder encoder = charset.newEncoder();
			//encoder.encode(((ByteBuffer.wrap("张浩".getBytes())).asCharBuffer());
			System.out.println(encoder.canEncode("张"));
		}
}
