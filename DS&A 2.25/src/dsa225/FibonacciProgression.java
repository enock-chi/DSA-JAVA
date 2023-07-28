package dsa225;

public class FibonacciProgression extends Progression<Long>{
	protected long prev;
	
	public FibonacciProgression() {super(0l);}
	
	public FibonacciProgression(long start, long prev) {
		super(start);
		this.prev = prev;
	}
	
	@Override
	public void advance() {
;		current += prev;
		prev = current - prev;
	}

}
