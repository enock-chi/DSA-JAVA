package dsa231;

public abstract class Animal {
      protected int[][] pos = new int[1][2];
      
      public void movePos() {
    	  pos[0][0] += Math.round(Math.random());
    	  pos[0][1] += Math.round(Math.random());
    	  check();
      }
      
      public void check() {
    	  if (pos[0][0] == 10) {
    		  pos[0][0] = 0;
    	  }
    	  if (pos[0][1] == 10) {
    		  pos[0][1] = 0;
    	  }
      }
}
