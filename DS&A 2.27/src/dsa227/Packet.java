package dsa227;

public class Packet {
	protected String destination;
	protected String source;
	protected static int sequenceNumber;
	protected byte[] payload;
	
	public Packet() {
		this.destination = "Bill";
		this.source = "Alice";
		sequenceNumber++;
		this.payload ="Hello, World!".getBytes();
		
	}
	
	public Packet(String destination, String source, byte[] payload) {
		this.destination = destination;
		this.source = source;
		sequenceNumber++;
		this.payload = payload;
		
	}
	
	public void printPacket() {
		System.out.println("Source: "+ source +" Sequence No.:"+ sequenceNumber + "Payload: \n"+payload);
	}

}
