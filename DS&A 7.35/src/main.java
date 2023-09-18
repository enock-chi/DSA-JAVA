import dsa735.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack stack = new ArrayStack<>();
        for ( int k = 1; k <= 10; k++) {
            stack.push(k);
        }
        
        stack.print();
        
        stack.pop();
        
        stack.print();
	}

}
