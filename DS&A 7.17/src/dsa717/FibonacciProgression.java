package dsa717;

public class FibonacciProgression extends Progression{
	protected long prev;
	
	public FibonacciProgression() { this(0,1);}
	
	public FibonacciProgression(long current, long prev) {
		super(current);
		this.prev = prev;
	}
	
	protected void advance() {
		long temp = prev;
		prev = current;
		current += temp;
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Long next() {
		advance();
		return current;
	}
}
