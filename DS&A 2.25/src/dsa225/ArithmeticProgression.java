package dsa225;

public class ArithmeticProgression extends Progression<Long> {
	protected long increment;
	
	public ArithmeticProgression() { super(0l);}
	
	public ArithmeticProgression(long start, long inc) {
		super(start);
		this.increment = inc;
		
	}
	
	@Override
	public void advance() {
		current += increment;
	}
	
	

}
