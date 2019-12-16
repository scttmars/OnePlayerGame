
public class FrankGuess {
	
	private String guess;
	private int numberOfMatches;
	
	
	public FrankGuess (String g, int number) {
		guess = g;
		numberOfMatches = number;
	}
	
	public String getGuess() {
		return guess;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		FrankGuess guess2 = (FrankGuess) (obj);
		boolean sameGuess = guess.equals(guess2.getGuess());
		boolean sameNumberOfMatches;
		if(0 == numberOfMatches - guess2.numberOfMatches ) {
			sameNumberOfMatches = true;
		}
		else {
			sameNumberOfMatches = false;
		}
		return sameNumberOfMatches && sameGuess;
	}
	
	@Override
	public String toString() {
		return guess + " " + numberOfMatches;
	}
	
	public int getNumberOfMatches() {
		return numberOfMatches;
	}
	

}
