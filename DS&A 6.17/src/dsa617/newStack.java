package dsa617;

public class newStack<E> implements Stack<E> {
     private LinkedList<E> list = new LinkedList<>();
     
     public newStack() {}
     
     public int Size() { return list.getSize();}
     
     public boolean isEmpty() { return list.isEmpty();}
     
     public void push(E e) { list.addLast(e);}
     
     public E top() { return list.first();}
     
     public E pop() { return list.removeLast();}
     
     public void print() { list.output();}
}
