package dsa724;

public class MTF<e> {
//=================================================================
	protected static class Item<e>{
		private e value;
		private int count = 0;
		
		public Item(e val) { this.value = val;}
		public int getCount() { return count;}
		public e getValue() { return value;}
		public void inc() { count++;}
	}
//=================================================================
	
	PositionalList<Item<e>> list = new LinkedPositionalList<>();
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
		Position<Item<e>> p = findPosition(data);
		if ( p == null ) p = list.addLast(); 
	}
	
	public Iterable<e> getFavourites(int k) throws IllegalArgumentException{
		if ( k < 0 || k > size()) throw new IllegalArgumentException("Invalid Position");
		
		PositionalList<Item<e>> temp = new LinkedPositionalList<>();
		for (Item<e> item : list) temp.addLast(item);
		
		PositionalList<Item<e>> result = new LinkedPositionalList<>();
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
		
		
	}

}
