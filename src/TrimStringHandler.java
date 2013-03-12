
public class TrimStringHandler extends WrapperStringHandler {

	
	public TrimStringHandler(StringHandler sh) {
		super(sh);
		
	}

	@Override
	public String handle(String s) {
		s =sh.handle(s);
		s = s.trim();
		return s;
	}

}
