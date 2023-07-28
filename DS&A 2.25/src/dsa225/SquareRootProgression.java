package dsa225;
import java.math.*;

public class SquareRootProgression extends Progression<Double>{
	public SquareRootProgression() {
		super(65536.0);
		
		
	}
	
	public SquareRootProgression(double current) {
		super(current);
	}
	
	@Override
	public void advance() {
		current = (double)Math.round(Math.sqrt(current));
	}

}
