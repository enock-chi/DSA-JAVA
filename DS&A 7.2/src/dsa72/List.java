package dsa72;

public interface List<e> {
	int size();
	
	boolean isEmpty();
	
	e get(int i);
	
	e set(int i, e data);
	
	e remove(int i);
	
	void add(int i, e data);

}
