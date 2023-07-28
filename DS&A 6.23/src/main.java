import java.util.*;
import dsa623.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStack<String> stack = new LinkedStack<>();
		LinkedQueue<String> queue = new LinkedQueue<>();
		Random random = new Random();
		
		queue.queue("E");
	    queue.queue("D");
	    queue.queue("C");
	    queue.queue("B");
	    queue.queue("A");
		
		queue.print();
		System.out.println("==============");
		
		LinkedStack<String>[] store = new LinkedStack[queue.size()];
		
		for(int k = 0; k < store.length; k++) {
			store[k] = new LinkedStack<>();
		}
		
		for (int k = 0; k < store.length - 1; k++) {
			for (int j = 0; j < store.length; j++) {
				store[j].push(queue.first());
				store[j].print();
				queue.rotate();
			}
			queue.rotate();
		}
		queue.rotate();
		queue.print();

	}
	
	
}


/*
import java.util.*;

public class SubsetGenerator {
    public static Queue<Set<Integer>> generateSubsets(int n) {
        // Create an empty stack and queue
        Stack<Set<Integer>> stack = new Stack<>();
        Queue<Set<Integer>> queue = new LinkedList<>();

        // Push an empty set into the stack
        stack.push(new HashSet<>());

        while (!stack.isEmpty()) {
            // Pop a subset from the stack
            Set<Integer> currentSubset = stack.pop();

            // Enqueue this subset into the queue
            queue.add(currentSubset);

            // Generate new subsets by adding each element from the original set T
            for (int i = 1; i <= n; i++) {
                if (!currentSubset.contains(i)) {
                    // Create a new subset by adding the element i to the current subset
                    Set<Integer> newSubset = new HashSet<>(currentSubset);
                    newSubset.add(i);

                    // Push the new subset into the stack for further processing
                    stack.push(newSubset);
                }
            }
        }

        return queue;
    }

    public static void main(String[] args) {
        int n = 3; // Test with a 3-element set T
        Queue<Set<Integer>> resultQueue = generateSubsets(n);

        // Print the generated subsets
        while (!resultQueue.isEmpty()) {
            System.out.println(resultQueue.poll());
        }
    }
}
*/
