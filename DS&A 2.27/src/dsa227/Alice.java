package dsa227;

public class Alice {
	
	public Alice() {}
	
	public Packet createPacket(String destination, byte[] payload) {
		return new Packet(destination,"Alice",payload);
	}

}
