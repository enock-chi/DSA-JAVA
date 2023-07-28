package dsa223;

public class FibonacciProgression extends Progression{
	private long prev;
	
	public FibonacciProgression() {this(0,1);}
	
	public FibonacciProgression(long first, long sec) {
		super(first);
		this.prev = sec - first;
	}
	
	@Override
	protected void advance() {
		current += prev;
		prev = current - prev;
	}

}
