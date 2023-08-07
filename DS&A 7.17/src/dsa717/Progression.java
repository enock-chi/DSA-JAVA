/**
 * @Author Enock Shaun Chikobvu
 * 
 * Note that has next is always true if sticking to the original design 
 * of this class implementation from chapter 2. 
 * */

package dsa717;
import java.util.*;

public abstract class Progression implements Iterator<Long> {
	protected long current;
	
	public Progression() { this(0);}
	
	public Progression(long start) { current = start;}
	
	public long nextValue() {
		long answer = current;
		advance();
		return answer;
	}
	
	protected void advance() { current++;}
	
	public void printProgression(int i) {
		System.out.println(nextValue());
		for ( int k = 0; k < i; k++) System.out.println(" "+nextValue());
		System.out.println();
	}
}
