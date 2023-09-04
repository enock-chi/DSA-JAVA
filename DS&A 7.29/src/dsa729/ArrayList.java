package dsa729;
import java.util.*;

public class ArrayList<e> implements List<e> {
	public final static int CAP = 20;
	private e[] data;
	private int size = 0;
	
	public ArrayList() {this(CAP);}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int cap) {
		data = (e[]) new Object[cap];
	}

	@Override
	public int size() { return size; }

	@Override
	public boolean isEmpty() { return (size == 0);}

	@Override
	public e get(int i) throws IndexOutOfBoundsException {
		check(i,size);
		return data[i];
	}

	@Override
	public e set(int i, e data) throws IndexOutOfBoundsException {
		check(i,size);
		e removed = this.data[i];
		this.data[i] = data;
		return removed;
	}

	@Override
	public void add(int i, e data) throws IndexOutOfBoundsException {
		check(i,size+1);
		resize();
		for ( int k = size - 1; k > i; k-- ) {
			this.data[k + 1] = this.data[k];
		}
		this.data[i] = data;
		size++;
	}

	@Override
	public e remove(int i) throws IndexOutOfBoundsException, IllegalStateException {
		check(i,size);
		resize();
		if (isEmpty()) throw new IllegalStateException("Array is Empty");
		e removed = this.data[i];
		for (int k = i; k < size - 1  ; k++) {
			this.data[k] = this.data[k+1];
		}
		this.data[size - 1] = null;
		size--;
		return removed;
	}
	
	@SuppressWarnings("unchecked")
	public void resize() {
		e[] temp;
		if (size >= data.length) {
			temp = (e[]) new Object[data.length * 2];
			System.arraycopy(data,0,temp,0,size);
			data = temp;
		} else if (size <= (data.length * 0.25)) {
			temp = (e[]) new Object[data.length / 2];
			System.arraycopy(data,0,temp,0,size);
			data = temp;
		}
	}
	
	public void print() {
		System.out.println(Arrays.toString(data));
	}
	
	protected void check(int i, int n) throws IndexOutOfBoundsException{
		if ( i < 0 || i >= n) throw new IndexOutOfBoundsException("Index not in set");
	}

}
