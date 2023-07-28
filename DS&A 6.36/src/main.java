import java.util.*;
import dsa636.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LinkedQueue<Double> queue = new LinkedQueue<>();
        Scanner input = new Scanner(System.in);
        String cont = "c";
        double sell = 0;
        int sold = 0;
        while (cont.equals("c")) {
        	System.out.println("b for buy and s for sell");
        	String decision = input.next();
        	int numStocks = 0;
        	if (decision.equals("b")) {
        		System.out.println("How many stocks?");
        		numStocks = input.nextInt();
        		System.out.println("Price per stock");
        		double price = input.nextDouble();
        		for (int k = 0; k < numStocks; k++) {
        			queue.enqueue(price);
        		} 
        	} else {
        		System.out.println("What is the sell price");
        		sell = input.nextDouble();
        		System.out.println("How many are to be sold");
            	sold = input.nextInt();
        	}
        	System.out.println("c to contine");
        	cont = input.next();
        	
        	
        }
        System.out.println("Profits are: " + sum(queue,sell,sold));
        
	}
	
	public static <e extends Number> double sum(LinkedQueue<e> q, double p,int num) {
		if (num == 0) return 0;
		double add = p - q.dequeue().doubleValue();
		return add+sum(q,p,num-1);
	}

}
