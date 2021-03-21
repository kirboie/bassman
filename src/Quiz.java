import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Quiz {
    // Initialize variables required
    private static String question;
    private static int ans; // Keep question and answer variables private.
    private static int x;
    private static int y;

    private static int level = 1;
    private static int input;
    private static int trie = 1;
    private static int correct = 0;
    private static boolean result;

    protected static void questionMaster(Scanner scan) {// Method to pose questions and check for completion.

	question = getQuestion(level);// Get question based on current level setting.

	System.out.print(question);

	askQuestion(scan);// call askQuestion method.

	if (correct == 3 && level == 3) {// Check if quiz has been completed.
	    return;
	} else if (result) { // If true is returned from askQuestion method get a new question.

	    questionMaster(scan);
	} else { // If false is returned from askQuestion method show correct answer and get a
	    // new question.
	    System.out.println("Hard Luck!.The correct answer was: " + getAnswer() + ". Try this one.");
	    trie = 1;
	    questionMaster(scan);
	}

    }

    private static boolean askQuestion(Scanner scan) {

	try {// try block to catch error when non integer is input

	    input = scan.nextInt();

	    result = checkAnswer(input);
	    if (result == true) {
		trie = 1; // Check answer and if correct reset trie's to 1 and increase correct variables.
		correct++;
		System.out.println("That is the correct answer.\n");
	    } else if (trie < 2) { // if answer is wrong and trie's are less than 2 then ask the question again.
		System.out.println("Incorrect try again ");
		trie++;
		askQuestion(scan);// Give another try at answering.
	    } else { // if tries are at 2 then return false.
		return false;
	    }
	    if (correct == 3 && level < 3) { // Check if 3 correct answers were given and increase the level if
		// required.
		level++;
		System.out.println("Well done going to level " + level + "\n");
		correct = 0;
	    }

	} catch (InputMismatchException e) {// catch exception error
	    System.out.print("Invalid input, entry must be an integer.\n");
	    scan.next();// Clear scanner
	    askQuestion(scan);// Use recursion to recall method if conditions are not met.
	}
	// Return valid input.
	return true;
    }

    private static String getQuestion(int level) {
	// Switch statement to generate question depending on level
	Random rand = new Random();
	switch (level) {
	case 1:
	    x = rand.nextInt(4) + 1;
	    y = rand.nextInt(3) + 1;
	    if (y > x) { // Put higher number always first
		int temp = x;
		x = y;
		y = temp;
	    }
	    ans = x + y;// Set answer variable.
	    question = "What is " + x + " + " + y + " ? ";// Set question variable.
	    break;
	case 2:
	    x = rand.nextInt(8) + 1;
	    y = rand.nextInt(8) + 1;
	    if (y > x) {
		int temp = x;
		x = y;
		y = temp;
	    }
	    ans = x + y;
	    question = ("What is " + x + " + " + y + " ? ");
	    break;
	case 3:
	    x = rand.nextInt(8) + 1;
	    y = rand.nextInt(8) + 1;
	    if (y > x) { // swap a and b so answer won't be negative
		int temp = x;
		x = y;
		y = temp;
	    }
	    ans = x - y;
	    question = ("What is " + x + " - " + y + " ? ");
	    break;
	default:
	    System.out.println("You've completed the quiz Well done");
	}
	return question;
    }

    private static boolean checkAnswer(int x) {// Check answer and return if incorrect.
	if (x == ans) {
	    return true;
	} else
	    return false;
    }

    private static int getAnswer() {// Return answer.
	return ans;
    }

}
