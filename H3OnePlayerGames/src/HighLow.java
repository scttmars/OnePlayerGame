public class HighLow implements OnePlayerGame{

	private int max;
	private int min;
	private int target;
	private int numPlays;
	private int recentPlay;
	
	private static final int NO_PLAY = -1;
	
	public HighLow(int low, int high) {

		// if the low and high values do not
		// form a range, or if low is a negative
		// number, then set target and recentPlay
		// to both be 0 (so isOver() returns true and
		// the game ends immediately)
		if (low < 0 || high < low) {
			target = 0;
			recentPlay = 0;
			return;
		}

		// if the low and high values do form a range
		// then set everything up, including the selection
		// of a random target number in the range
		max = high;
		min = low;
		target = (int)(Math.random() * (high - low + 1) + low);
		numPlays = 0;
		recentPlay = NO_PLAY;
	}


	public void makePlay(int guess) {
		if (guess >= min && guess <= max) {
			recentPlay = guess;
			numPlays++;
		}		
	}
		
	public boolean isOver() {
		return recentPlay == target;
	}
	
	public String getStatus() {
		if (isOver()) {
			return "You win in " + numPlays + " guesses! \u266B Hooray! \u266A";
		}
		String status = "It is your first guess.\n"; 
		if (numPlays > 0) {
			status = "Number of guesses: " + numPlays + "\n";
			status += "Your recent guess of " + recentPlay + " was too low.\n";
			if (recentPlay > target) {
				status = status.replace("low", "high");
			}
		}
		return status + "Guessing range is between " + min + " and " + max + ".";
	}
	
	public String toString() {
		String fmt = "%s[min=%d,max=%d,target=%d,numPlays=%d,recentPlay=%d]";
		return String.format(fmt, getClass().getName(), min, max, target, numPlays, recentPlay);
	}


	
	public void makePlay(String guess) {
		int r = Integer.parseInt(guess);
		makePlay(r);
		
	}
}
