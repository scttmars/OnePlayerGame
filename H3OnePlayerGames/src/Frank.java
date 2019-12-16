import java.util.ArrayList;
import java.util.List;

import edu.elon.cs.Util.Words;

public class Frank implements OnePlayerGame{

	
	private String correctWord;
	private ArrayList<FrankGuess> guessList = new ArrayList<FrankGuess>();
	private int numberOfGuesses = 0;
	
	
	
	public Frank() {
		correctWord = Words.getRandom5LetterWord();
	}
	
	
	
	public void addGuess(FrankGuess guess) {
		guessList.add(guess);
	}
	
	@Override
	public void makePlay(String guess) {
		if(guess.length() == 5) {
		String playerGuess = guess.toLowerCase();
		int matches = numberOfMatches(playerGuess);
		FrankGuess newGuess = new FrankGuess(playerGuess,matches);
		if(!guessList.contains(newGuess)) {
			numberOfGuesses++;
			addGuess(newGuess);
		}
		
		
		}
		
	}

	@Override
	public String getStatus() {
		if(isOver()) {
			return "It took " + numberOfGuesses + " guesses to win";
		}
		else if(numberOfGuesses > 0) {
			return toString();
		}
		else {
		return "no guesses have been made";
		}
		
	}

	@Override
	public boolean isOver() {
		if(mostRecentGuess().getNumberOfMatches() == 5) {
			return true;
		}
		return false;
		
	}
	
	private int numberOfMatches(String guess) {
		int numberOfMatches = 0;
		
		for(int i = 0; i < 5; i++) {
			if(guess.charAt(i) == correctWord.charAt(i)) {
				numberOfMatches++;
			}
		}
		return numberOfMatches;
	}
	
	private FrankGuess mostRecentGuess() {
		if(numberOfGuesses > 0) {
		return guessList.get(numberOfGuesses -1);
		}
		FrankGuess priorToUserGuess = new FrankGuess("nnnnn", 0);
		return priorToUserGuess;
	}
	
	public String toString() {
		String listOfGuesses = "";
		for(int i = 0; i < guessList.size(); i++) {
			listOfGuesses = "" + guessList.get(i) + "\n";
		}
		return getClass().getName() + "Guess M\n----- -\n" + listOfGuesses + "\n" + correctWord;
	}

}
