
public class Maryland extends State {
    public Maryland() {}
    public void printMe() { System.out.println("Read it!");}
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
        Region east = new State();
        State md = new Maryland();
        Object obj = new Place();
        Place usa = new Region();
        md.printMe();
        east.printMe();
        ((Place)obj).printMe();
        obj = md;
        ((Maryland)obj).printMe();
        obj = usa;
        ((Place)obj).printMe();
        usa = md;
        ((Place)usa).printMe();
	}

}

class State extends Region{
	public State() {}
	public void printMe() {System.out.println("Ship it!");}
}

class Region extends Place{
	public Region() {}
	public void printMe() {System.out.println("Box it!");}
}

class Place extends Object{
	public Place() {}
	public void printMe() {System.out.println("Buy it!");}
}