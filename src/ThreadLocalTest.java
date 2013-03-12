import java.sql.Connection;


public class ThreadLocalTest {

	ThreadLocal<Connection> holder = new ThreadLocal<Connection>(){
		
		@Override
		protected Connection initialValue() {
			// TODO Auto-generated method stub
			return super.initialValue();
		}
		
	};
}
