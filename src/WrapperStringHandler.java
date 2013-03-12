
public class WrapperStringHandler extends StringHandler {
	
	protected StringHandler sh;
	
	public WrapperStringHandler(StringHandler sh){
		this.sh = sh;
	}

	@Override
	public String handle(String s) {
		return super.handle(s);
	}
}
