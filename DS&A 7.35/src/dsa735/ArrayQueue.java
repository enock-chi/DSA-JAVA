package dsa735;

public class ArrayQueue<e> implements Queue<e> {
	private ArrayStack<e> stack = new ArrayStack<>();
	private ArrayStack<e> tempStack = new ArrayStack<>();
	private int size = 0;
	
	public ArrayQueue() {}
	
	public int size() { return size;}
	
	public boolean isEmpty() { return (size == 0) ;}
	
	public void enqueue( e data) {
		if ( tempStack.isEmpty()) {
			stack.push(data);
		} else {
			tempStack.push(data);
		}
		size++;
	}
	
	public e dequeue() {
		e removed = null;
		int loopSize = 0;
		if ( tempStack.isEmpty()) {
			loopSize = stack.size();
			removed = stack.pop();
			for (int k = 0; k < loopSize - 1; k++) {
				tempStack.push(stack.pop());
			} 
		} else {
			loopSize = tempStack.size();
			for (int k = 0; k < loopSize - 1; k++) {
				stack.push(tempStack.pop());
			}
			removed = tempStack.pop();
		}
		size--;
		return removed;
	}
	
	public e top() { return stack.first();}
	
	public void print() {
		if (stack.isEmpty()) {
			tempStack.print();
		} else {
			stack.print();
		}
	}

}
