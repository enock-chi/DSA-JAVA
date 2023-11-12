package dsa761;

public class TextEditor<E> {
	private LinkedPositionalList<E> editor = new LinkedPositionalList<>();
	private Position<E> cursor;
	
	public TextEditor() {}
	
	public void left() throws IllegalArgumentException{
		cursor = editor.before(cursor);
	}
	
	public void right() throws IllegalArgumentException{
		cursor = editor.after(cursor);
	}
	
	public void insert(E data) throws IllegalArgumentException{
		if ( editor.size() == 0) cursor = editor.addFirst(data);
		else cursor = editor.addAfter(cursor,data);
	}
	
	public void remove() throws IllegalArgumentException{
		Position<E> newCursor = editor.before(cursor);
		editor.remove(cursor);
		cursor = newCursor;
	}
	
	public void print() { editor.print(); }

}
