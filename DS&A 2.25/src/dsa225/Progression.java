package dsa225;

public abstract class Progression <T> {
	protected T current;
	
	public Progression(T start) {
		this.current = start;
	}
	
	public T nextValue() {
		T temp = current;
		advance();
		return temp;
	}
	
	public abstract void advance();
	
	public void printProgression(int n) {
		for( int i = 0; i < n; i++) {
			System.out.print(nextValue() + " ");
		}
	}
	
	public void setCurrent(T current) {
		this.current = current;
	}

}
