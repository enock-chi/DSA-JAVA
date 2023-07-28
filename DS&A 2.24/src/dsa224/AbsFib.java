package dsa224;

public class AbsFib extends Progression{
	private long prev;
	
	public AbsFib() {this(0,1);}
	
	public AbsFib(long first, long sec) {
		super(first);
		this.prev = sec - first;
	}
	
	@Override
	protected void advance() {
		prev -= current;
		current = prev - current;
	}

}
