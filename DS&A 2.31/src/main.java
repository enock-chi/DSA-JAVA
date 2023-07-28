import dsa231.*;
import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
        Ecosystem eco = new Ecosystem();
        
        System.out.println("Press 'C' to cancel.");
        String cancel = input.nextLine();
        while (!cancel.equalsIgnoreCase("C")) {
            eco.move();
            System.out.println("Moved");
            cancel = input.nextLine();
        }
        input.close();
	}

}
