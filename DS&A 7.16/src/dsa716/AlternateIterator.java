package dsa716;
import java.util.*;

public class AlternateIterator<e> implements Iterator<e> {
	private LinkedPositionalList<e> list = new LinkedPositionalList<>();
	private int i = 0;
	private boolean removable = false;
	
	public AlternateIterator(LinkedPositionalList<e> list) {
		this.list = list;
	}
	
	public boolean hasNext() { return ( i < list.size());}
	
	public e next() throws NoSuchElementException {
		if ( i == list.size()) throw new NoSuchElementException("");
		removable = true;
		i++;
		return list.get(i++);
	}
	
	public void remove() throws IllegalStateException{
		if (!removable) throw new IllegalStateException("Already empty");
		list.remove(i-1);
		removable = false;
	}

}
