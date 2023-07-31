package dsa715;

public interface PositionalQueue<e> {
     int size();
     
     boolean isEmpty();
     
     Position<e> enqueue(e data) throws IllegalArgumentException;
     
     Position<e> dequeue() throws IllegalArgumentException;
     
     Position<e> first() throws IllegalArgumentException;
}
