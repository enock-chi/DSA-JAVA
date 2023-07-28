package dsa231;

public class Fish extends Animal {
	protected static String icon = "*";
	
	public Fish() {
		this.pos[0][0] = (int)(Math.random()*10);
		this.pos[0][1] = (int)(Math.random()*10);
	}

}
