package assignOne;
//Sebastian was partner 
public class runGame {
	public static void main(String[] args) {

		NextGame game = new NextGame();

		game.displayIntro();
		game.loadScores();
		game.random();

		while (!game.winner() && !game.gameOver()) {
		System.out.println("=== turn " + game.turn() + "===");
		game.userInput();
		game.compare();
		}
		if(game.winner()) {
		game.highScore();
		game.saveScores();
		}

		game.displaySolution();
		game.displayHighScores();
		}


}
