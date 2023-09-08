package dsa734;
import java.util.*;

public class LinkedQueue<e> implements Queue<e> {
	private LinkedStack<e> stack = new LinkedStack<>();
	private LinkedStack<e> tempStack = new LinkedStack<>();

	@Override
	public int size() { return stack.size();}

	@Override
	public boolean isEmpty() { return stack.isEmpty();}

	@Override
	public void enqueue(e data) { 
		if (tempStack.isEmpty()) {
			stack.push(data);
		} else {
			int stackSize = tempStack.size();
			for ( int k = 0; k < stackSize; k++) {
				stack.push(tempStack.pop());
			}
			stack.push(data);
		}
	}

	@Override
	public e dequeue() {
		int stackSize = (stack.isEmpty()) ? tempStack.size() : stack.size();
		boolean flag = (!stack.isEmpty()) ? true : false;
		e removed = null;
		for (int k = 0; k < (stackSize - 1); k++) {
			if (flag) {
			    tempStack.push(stack.pop());
			} else {
				stack.push(tempStack.pop());
			}
		}
		if (flag) {
		    removed = stack.pop();
		} else {
		    removed = tempStack.pop();
		}
		return removed;
	}

	@Override
	public e first() { return stack.top();}
	
	public void print() { 
		int stackSize = tempStack.size();
		for ( int k = 0; k < stackSize; k++) {
			stack.push(tempStack.pop());
		}
		stack.print();
	}
	
	
	

}
