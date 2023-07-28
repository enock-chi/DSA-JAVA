package dsa225;

public class GeometricProgression extends Progression<Long>{
	protected long factor;
	
	public GeometricProgression() {super(0l);}
	
	public GeometricProgression(long start, long factor) {
		super(start);
		this.factor = factor;
	}
	
	@Override
	public void advance() {
		current *= factor;
	}

}
