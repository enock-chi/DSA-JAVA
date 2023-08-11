package dsa721;
import java.util.*;

public class MTF<e> {
//====================================================
	protected static class Item<e>{
		private e value;
		private int count = 0;
		
		public Item(e val) {
			value = val;
		}
		
		public int getCount() { return count;}
		
		public e getValue() { return value;}
		
		public void inc() { count++;}
	}
//====================================================
	PositionalList<Item<e>> list = new LinkedPositionalList<>();
	
	protected e value(Position<Item<e>> p) { return p.getData().getValue();}
	
	protected int count(Position<Item<e>> p) { return p.getData().getCount();}
	
	protected void moveUp(Position<Item<e>> p) {
		if ( p != list.first()) list.addFirst(list.remove(list.index(p)));
	}
	
	protected Position<Item<e>> findPosition( e data ){
		Position<Item<e>> walk = list.first();
		while ( walk != null && !data.equals(value(walk))) {
			walk = list.after(list.index(walk));
		}
		return walk;
	}
	
	public MTF() {}
	
    public int size() { return list.size();}
	
	public boolean isEmpty() { return list.isEmpty();}
	
	public void remove(e data) {
		Position<Item<e>> p = findPosition(data);
		if ( p != null) list.remove(list.index(p));
	}
	
	public void access( e data ) {
		Position<Item<e>> p = findPosition(data);
		if ( p == null) p = list.addLast(new Item<e>(data));
		p.getData().inc();
		moveUp(p);
	}
	
	public Iterable<e> getFavorites(int i) throws IllegalArgumentException{
		if ( i < 0 || size() > i) throw new IllegalArgumentException("Invalid index");
		PositionalList<Item<e>> temp = new LinkedPositionalList<>();
		
	}
	
	
}
