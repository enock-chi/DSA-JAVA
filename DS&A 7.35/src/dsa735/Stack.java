package dsa735;

public interface Stack<e> {
     int size();
     boolean isEmpty();
     void push(e data);
     e first();
     e pop();
}
