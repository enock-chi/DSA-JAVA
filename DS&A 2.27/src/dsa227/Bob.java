package dsa227;
import java.util.*;

public class Bob {
	private ArrayList<Packet> packets = new ArrayList<>();
	
	public Bob() {	}
	
	public void receivePacket(Packet packet) {
		this.packets.add(packet);
	}
	
	public boolean checkPackets() {
		return (packets.isEmpty()) ? true : false;
	}
	
	public void readPacket() {
		Packet packet;
		Scanner input = new Scanner(System.in);
		while (!packets.isEmpty()) {
			packet = packets.get(0);
			packet.printPacket();
			System.out.println("Press any key to delete");
			String key = input.next();
			packets.remove(0);
			//input.close();
		}
	}
	
	public int packets() {
		return packets.size();
	}
	
	
	

}
