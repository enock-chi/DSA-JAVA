package dsa717;
import java.util.*;

public class ArithmeticProgression extends Progression{
	protected long inc;
	
	public ArithmeticProgression() {this(1,0);}
	
	public ArithmeticProgression(long step) {this(step,0);}
	
	public ArithmeticProgression(long step, long start) {
		super (start);
		inc = start;
	}
	
	protected void advance() {
		current += inc;
	}
	
	@Override
	public Long next(){
		advance();
		return current;
	}

	@Override
	public boolean hasNext() {
		return true;
	};
	
}
