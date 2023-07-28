package dsa313;

public class ScoreBoard {
	private int numEntries = 0;
	private GameEntry[] board;
	
	public ScoreBoard(int size) {
		board = new GameEntry[size];
	}
	
	public void add(GameEntry e) {
	    int newScore = e.getScore();
	    // Check if the new entry is a high score
	    if (numEntries < board.length || newScore > board[numEntries-1].getScore()) {
	        if (numEntries < board.length) {
	            // No score drops from the board, so overall number increases
	            numEntries++;
	        }
	        // Shift any lower scores rightward to make room for the new entry
	        int j = numEntries - 1;
	        while (j > 0 && board[j-1].getScore() < newScore) {
	            board[j] = board[j-1];
	            j--;
	        }
	        board[j] = e;
	    }
	}


}
