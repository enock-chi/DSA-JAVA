package dsa724;
import java.util.*;

public class MTF<e> {
//=================================================================
	public static class Item<e>{
		private e value;
		private int count = 0;
		
		public Item(e val) { value = val;}
		public int getCount() { return count;}
		public e getValue() { return value;}
		public void inc() { count++;}
	}
//=================================================================
	
	LinkedPositionalList<Item<e>> list = new LinkedPositionalList<>();
	public MTF() {}
	
	protected e value(Position<Item<e>> p) { return p.getData().getValue();}
	
	protected int count(Position<Item<e>> p) { return p.getData().getCount();}
	
	protected Position<Item<e>> findPosition(e data){
		Position<Item<e>> walk = list.first();
		while ( walk != null && !data.equals(value(walk))) {
			walk = list.after(walk);
		}
		return walk;
	}
	
	protected void moveUp(Position<Item<e>> p) {
		if ( p != list.first()) list.addFirst(list.remove(p));
	}
	
	public int size() { return list.size();}
	
	public boolean isEmpty() { return list.isEmpty();}
	
	public void access(e data) {
		Position<Item<e>> p = (list.size() == 0) ? findPosition(data) : null;
		if ( p == null ) {
			p = list.addLast(new Item<e>(data));
		}
		p.getData().inc();
		moveUp(p);
	}
	
	public Iterable<e> getFavourites(int k) throws IllegalArgumentException{
		if ( k < 0 || k > size()) throw new IllegalArgumentException("Invalid Position");
		
		PositionalList<Item<e>> temp = new LinkedPositionalList<>();
		for (Item<e> item : list) temp.addLast(item);
		
		PositionalList<e> result = new LinkedPositionalList<>();
		for ( int j = 0; j < k ; j++) {
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
	
	public void remove(e data) {
		Position<Item<e>> p = findPosition(data);
		if ( p != null ) list.remove(p);
	}
	
	public void print() {
		e[] arr = (e[]) new Object[list.size()];
		Position<Item<e>> walk = list.first();
		for ( int k = 0; k < list.size() ; k++) {
			arr[k] = walk.getData().getValue();
			walk = list.after(walk);
		}
		System.out.println(Arrays.toString(arr));
	}

}
