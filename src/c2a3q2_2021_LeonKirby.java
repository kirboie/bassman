import java.util.Scanner;

public class c2a3q2_2021_LeonKirby extends Quiz {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

	System.out.println("Starting the test, there are 3 levels\r\n"
		+ "To advance to each level, you must get 3 questions right in the previous level");

	questionMaster(scan);

	System.out.println("Well done you Completed the quiz!!!!");

	scan.close();
    }

}






