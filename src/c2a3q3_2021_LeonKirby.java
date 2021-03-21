import java.util.Arrays;
import java.util.InputMismatchException;//Import utils required.
import java.util.Scanner;

public class c2a3q3_2021_LeonKirby {
    // Initialize arrays required.
    static int[] original = new int[4];
    static int[] modified = new int[4];

    static int y = 0;

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	for (int x = 0; x < original.length; x++) {// For loop to fill array with user inputs.
	    System.out.println("Enter an integer in the range of 1 to 9 (inclusive): ");
	    original[x] = numCheck(scan);
	}

	System.out.print("Original array: " + Arrays.toString(original) + "\n");
	modifiyArray(original);// Call modify array method.
	System.out.print("Modified array: " + Arrays.toString(modified) + "\n");

    }

    // Method to replace each element of the integer array with the sum of every
    // other element
    static void modifiyArray(int arr[]) {
	int sum = 0;
	for (int x = 0; x < original.length; x++)
	    sum += arr[x];
	if (y < modified.length) {
	    modified[y] = sum - arr[y];
	    y++;
	    modifiyArray(original);


	}
    }

    public static int numCheck(Scanner scan) {// Method to check for valid integer.

	int num = 0;

	try {

	    num = scan.nextInt();


	    if (num >= 1 && num <= 9) {

		System.out.println("Valid input");

	    } else {

		System.out.print("Invalid entry, number must be in range.\r\n" + "");
		return numCheck(scan);// Recall method if conditions are not met.
	    }

	}

	catch (InputMismatchException e) {// catch exception error

	    System.out.print("Invalid input, entry must be an integer between 1 and 9 inclusive. \n");

	    scan.next();

	    return numCheck(scan);
	}
	return num;// Return valid input.

    }

}
