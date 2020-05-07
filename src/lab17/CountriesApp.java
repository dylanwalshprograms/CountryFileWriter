package lab17;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountriesApp {
	
	private static Scanner scnr = new Scanner(System.in);
	private static FileHelper<Country> helper = new FileHelper<>("countries.txt", new CountryLineConverter());
	
	public static void main(String[] args) {
		int userInt = 0;
		do {
			printMenu();
			userInt = Validator.getInt(scnr, "Pick an option (1-3):",1, 3);
			if (userInt == 1) {
				printCountries();
			}
			if (userInt == 2) {
				writeCountry();
			}
		}while (userInt != 3);
		System.out.println("Goodbye!");
		scnr.close();

	}
	public static void printCountries() {
		 Path filePath = Paths.get("countries.txt");
		 if(Files.notExists(filePath)) {
				try {
					Files.createFile(filePath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 List<Country> allCountries = helper.readAll();
			for(Country p : allCountries) {
				System.out.println(p);
			}

	}
	public static void writeCountry() {
		System.out.println("Enter Country:");
		String country = scnr.nextLine();
		int population = Validator.getInt(scnr, "Enter Population:");
		helper.append(new Country(country, population));
	}
	
	public static void printMenu() {
		System.out.println("MENU:");
		System.out.println("1: Display Countries");
		System.out.println("2: Add a Country");
		System.out.println("3: Quit");
		System.out.println();
	}
	public void removeLine(String lineContent) throws IOException
	{
	    File file = new File("myFile.txt");
	    List<String> out = Files.lines(file.toPath())
	                        .filter(line -> !line.contains(lineContent))
	                        .collect(Collectors.toList());
	    Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
	}

}
