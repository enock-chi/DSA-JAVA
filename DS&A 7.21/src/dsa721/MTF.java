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
		if ( p != list.first()) list.addFirst(list.remove(p));
	}
	
	protected Position<Item<e>> findPosition( e data ){
		Position<Item<e>> walk = list.first();
		while ( walk != null && !data.equals(value(walk))) {
			walk = list.after(walk);
		}
		return walk;
	}
	
	public MTF() {}
	
    public int size() { return list.size();}
	
	public boolean isEmpty() { return list.isEmpty();}
	
	public void remove(e data) {
		Position<Item<e>> p = findPosition(data);
		if ( p != null) list.remove(p);
	}
	
	public void print() {
		e[] arr = (e[])new Object[list.size()];
		Position<Item<e>> walk = list.first();
		for ( int k = 0; k < list.size(); k++) {
			arr[k] = (e)walk.getData().getValue();
			walk = list.after(walk);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void add(e data) {
		list.addLast(new Item<>(data));
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
		for (Item<e> item : list) {
			temp.addLast(item);
		}
		
		PositionalList<e> result = new LinkedPositionalList<>();
		for ( int k = 0; k < i; k++ ) {
			Position<Item<e>> highPos = temp.first();
			Position<Item<e>> walk = temp.after(highPos);
			while ( walk != null) {
				if (count(walk) > count(highPos)) highPos = walk;
				walk = temp.after(walk);
			}
			result.addLast(value(highPos));
			temp.remove(highPos);
		}
		return (Iterable<e>) result;
	}
	
	
}
