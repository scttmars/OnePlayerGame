import java.util.Scanner;
import java.util.ArrayList;

public class Play {

	private static Scanner in;
	private static final String QUIT = "n";
	private static boolean cheat;	
	
	public static void main(String[] args) {
		
		
		in = new Scanner(System.in);
		System.out.println("type h for High Low and type f to play frank");
		String gameType = in.nextLine().toLowerCase();
		
		System.out.println("Type enter for cheat mode. Type anything else for regular mode.");
		cheat = in.nextLine().equals("");
		
		String game = "";
		
		
		
		while (!game.startsWith(QUIT)) {
			if(gameType.startsWith("h")) {
			HighLow hl = new HighLow(0, 255);
			play(hl);

			System.out.print("Play again? ");
			game = in.nextLine().toLowerCase();
			}
			if(gameType.startsWith("f")) {
				Frank frank = new Frank();
				play(frank);
				System.out.print("Play again? ");
				game = in.nextLine().toLowerCase();
			}
			else {
				break;
			}
		}
	}

	public static void play(OnePlayerGame game) {

		while (!game.isOver()) {
			System.out.println();
			if (cheat) {
				System.out.println(game);
			}
			System.out.println(game.getStatus());
			System.out.print("Make your play: ");
			String play = in.nextLine();
			game.makePlay(play);
		}

		System.out.println("\n" + game.getStatus());
	}

}
