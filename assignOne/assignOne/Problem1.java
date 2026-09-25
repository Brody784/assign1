package assignOne;

public class Problem1{

	public static void main(String[] args) {
		int value;
		value = stringToInt("-12345");
		System.out.println(value);

		}
		public static int stringToInt(String str) {
		int number = 0;
		char zero = '0';
		int index = 0;
		int initial;
		char sign = ' ';
		if(str.charAt(0) == '-' || str.charAt(0) == '+') {
		sign = str.charAt(0);
		index++;
		}else {
		number = str.charAt(index) - zero ;
		index++;
		}
		for( initial = 0; initial < str.length() - 1 ; initial++) {
		number = 10 * number;
		number += str.charAt(index ) - zero;
		index++;
		}
		if(sign == '-') {
		number = number * -1;
		}
		return number;
		}
		int[] numbers = {1,2,3,4,5};
		int[] values = new int[5];
		int correct = 0;
		int turns = 0;
		int scoreCount = 0;
		boolean won = false;
		boolean quit = false;
		String[] names = new String[5];
		int[] scores = new int[5];
		public void random() {
		int index;
		int temp;
		Random rand = new Random();
		for(index = numbers.length - 1; index > 0; index--) {
		int randomIndex = rand.nextInt(index + 1);
		temp = numbers[index];
		numbers[index] = numbers[randomIndex];
		numbers[randomIndex] = temp;
		}
		}
		public void userInput() {
		int index;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter 5 numbers");
		for(index = 0; index < 5; index++) {
		
		boolean valid = false;
		
		while(!valid) {
		
		while(!scanner.hasNextInt()) {
		System.out.println("Please enter a valid input");
		scanner.next();
		}
		
		values[index] = scanner.nextInt();
		
		if(values[index] < 0 || values[index] > 5) {
		System.out.println("Please enter a number from 0 to 5");
		}
		else {
		valid = true;
		}
		}
		
		if(values[index] == 0) {
		quit = true;
		}
		}
		}
		public void compare() {
		int index;
		correct = 0;
		for(index = 0; index < values.length; index++) {
		if(values[index] == numbers[index]) {
		correct++;
		}
		}
		if(correct == 5) {
		won = true;
		}
		System.out.println("You have " + correct + " numbers correct");
		}
		public void displaySolution() {
		int index;
		System.out.print("The sequence of numbers was:");
		for(index = 0; index < numbers.length; index++) {
		System.out.print(numbers[index] + " ");
		}
		System.out.println();
		}
		public void highScore() {
		
		Scanner scanner = new Scanner(System.in);
		
		int insertIndex = scoreCount;
		
		for(int index = 0; index < scoreCount; index++) {
		
		if(turns < scores[index]) {
		insertIndex = index;
		break;
		}
		}
		
		if(scoreCount < 5 || insertIndex < 5) {
		
		System.out.println("You made the high score list!");
		System.out.println("Enter your name:");
		
		String playerName = scanner.next();
		
		int lastIndex;
		
		if(scoreCount < 5) {
		lastIndex = scoreCount;
		}
		else {
		lastIndex = 4;
		}
		
		for(int index = lastIndex; index > insertIndex; index--) {
		scores[index] = scores[index - 1];
		names[index] = names[index - 1];
		}
		
		if(insertIndex < 5) {
		scores[insertIndex] = turns;
		names[insertIndex] = playerName;
		
		if(scoreCount < 5) {
		scoreCount++;
		}
		}
		}
		}
		public void displayHighScores() {
		
		System.out.println("High Scores");
		System.out.println("---------------");
		
		for(int index = 0; index < scoreCount; index++) {
		System.out.println(scores[index] + " - " + names[index]);
		}
		}
		public void loadScores() {
		
		try {
		File file = new File("scores.txt");
		Scanner input = new Scanner(file);
		
		scoreCount = 0;
		
		while(input.hasNext() && scoreCount < 5) {
		names[scoreCount] = input.next();
		scores[scoreCount] = input.nextInt();
		scoreCount++;
		}
		
		input.close();
		}
		catch(FileNotFoundException e) {
		// No score file yet, so start with an empty list
		scoreCount = 0;
		}
		}
		public void saveScores() {
		
		try {
		PrintWriter output = new PrintWriter("scores.txt");
		
		for(int index = 0; index < scoreCount; index++) {
		output.println(names[index] + " " + scores[index]);
		}
		
		output.close();
		}
		catch(FileNotFoundException e) {
		System.out.println("Could not save high scores.");
		}
		}
		public void displayIntro() {
		System.out.println("Game: Who's Next");
		System.out.println();
		System.out.println("Objective: Identify the Sequence of 5 numbers between 1 and 5 using the fewest turns.");
		System.out.println("If you wish to quit guessing and give up, enter a ZERO for one of your guesses");
		System.out.println("and the game will display the solution and quit.");
		System.out.println();
		System.out.println("GOOD LUCK!!!");
		System.out.println();
		}
		public int turn() {
		turns++;
		return turns;
		}
		public boolean gameOver() {
		return this.quit;
		}
		public boolean winner() {
		return this.won;
		}
		

}
