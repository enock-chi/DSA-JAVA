package dsa719;
import java.util.*;

public interface List<e> {
     int size();
     
     boolean isEmpty();
     
     void add(int i, e data) throws IndexOutOfBoundsException;
     
     e set(int i, e data) throws IndexOutOfBoundsException;
     
     e remove(int i) throws IndexOutOfBoundsException;
     
     e get(int i) throws IndexOutOfBoundsException;
}
