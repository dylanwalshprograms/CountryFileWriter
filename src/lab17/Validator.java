package lab17;

import java.util.Scanner;

public class Validator {
	
	public static int getInt(Scanner scnr, String prompt, int min, int max) {
		boolean isValid = false;
		int number;
		do {
			number = getInt(scnr, prompt);
			
			if (number < min) {
				isValid = false;
				System.out.println("The number must be at least " + min);
			} else if (number > max) {
				isValid = false;
				System.out.println("The number must not be larger than " + max);
			} else {
				isValid = true;
			}
			
		} while (!isValid);
		return number;
	}
	
	public static int getInt(Scanner scnr, String prompt) {
		System.out.print(prompt);
		boolean isValid = scnr.hasNextInt();
		while (!isValid) { // keep looping as long as they enter something invalid
			scnr.nextLine(); // advance the scanner past the bad input
			System.out.println("Oops. That's not a valid number. Please enter a number without decimals.");
			System.out.print(prompt);
			isValid = scnr.hasNextInt();
		}
		int answer = scnr.nextInt();
		scnr.nextLine();
		return answer;
	}

}
