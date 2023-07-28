package dsa622;

public interface Stack<e> {
     int size();
     
     boolean isEmpty();
     
     private void push(e data) {};
     
     e top();
     
     private e pop() throws IllegalStateException{return null;};
}
