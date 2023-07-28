package dsa227;
import java.util.*;

public class Application {
	private ArrayList<Packet> packets = new ArrayList<>();
	private Alice alice = new Alice();
	private Bob bob = new Bob();
	private int option; 
	
	public Application() { }
	
	public void menu() {
	    Scanner input = new Scanner(System.in);
	    boolean validOptionChosen = false;

	    while (!validOptionChosen) {
	        System.out.println("1. Alice, do you wish to create a packet?");
	        System.out.println("2. Bob, do you want to check if you have packets?");
	        System.out.println("3. Bob, do you want to read packets?");

	        try {
	            option = input.nextInt();
	            input.nextLine(); // Consume the remaining newline character

	            if (option >= 1 && option <= 3) {
	                validOptionChosen = true;
	            } else {
	                System.out.println("Please make sure to choose an option between 1-3.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Please enter a valid option number.");
	            input.nextLine(); // Clear the invalid input from the scanner
	        }
	    

	    switch (option) {
	        case 1:
	            System.out.println("Please enter destination and payload:");
	            String destination = input.nextLine();
	            String payload = input.nextLine();
	            byte[] payloadBytes = payload.getBytes();
	            bob.receivePacket(alice.createPacket(destination, payloadBytes));
	            System.out.println("Packet created");
	            break;
	        case 2:
	            System.out.println("Good day, Bob.");
	            System.out.println("You have " + bob.packets() + " packets to read.");
	            break;
	        case 3:
	            System.out.println("Good day, Bob.");
	            System.out.println("Your packet read:\n");
	            bob.readPacket();
	            break;
	    }

	    //input.close();
	    }
	}

}
