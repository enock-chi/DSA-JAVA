package dsa223;

public class Progression {
	protected long current;
	
	public Progression() { this(0);}
	
	public Progression(long current) {
		this.current = current;
	}
	
	public long nextValue() {
		long output = current;
		advance();
		return output;
	}
	
	public void printProgression(int x) {
		for (int i = 0; i < x; i++) {
			System.out.print(nextValue() + " ");
		}
		System.out.println();
	}
	
	protected void advance() {
		current++;
	}
	
	

}
