package dsa717;

public class GeometricProgression extends Progression{
	protected long base;
	
	public GeometricProgression() { this (2,1,4);}
	
	public GeometricProgression(long base) { this(base,1,base*base);}
	
	public GeometricProgression(long base, long start, long end) { 
		super(start);
		this.base = base;
	}
	
	protected void advance() {
		current *= base;
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
