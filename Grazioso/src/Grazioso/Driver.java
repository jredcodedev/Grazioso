package Grazioso;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Driver {
	private static ArrayList<Dog> dogList = new ArrayList<Dog>();
	private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
	private static final Set<String> monkeySpeciesSet = Set.of("Capuchin", "Guenon", "Macaque", "Marmoset",
			"Squirrel monkey", "Tamarin"); // Set of valid monkey species

	public static void main(String[] args) {
		String userInput = "";
		Scanner scnr = new Scanner(System.in);

		initializeDogList();
		initializeMonkeyList();

		// Menu loop until user input is "q"
		while (userInput.compareTo("q") != 0) {

			// Show menu and grab user input
			displayMenu();
			userInput = scnr.nextLine();

			// Switch statement to call appropriate methods for menu options
			switch (userInput) {
			case "1":
				intakeNewDog(scnr);
				break;
			case "2":
				intakeNewMonkey(scnr);
				break;
			case "3":
				reserveAnimal(scnr);
				break;
			case "4":
				printAnimals("dog");
				break;
			case "5":
				printAnimals("monkey");
				break;
			case "6":
				printAnimals("available");
				break;
			case "q":
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}

		}

	}

	// This method prints the menu options
	public static void displayMenu() {
		System.out.println("\n\n");
		System.out.println("\t\t\t\tRescue Animal System Menu");
		System.out.println("[1] Intake a new dog");
		System.out.println("[2] Intake a new monkey");
		System.out.println("[3] Reserve an animal");
		System.out.println("[4] Print a list of all dogs");
		System.out.println("[5] Print a list of all monkeys");
		System.out.println("[6] Print a list of all animals that are not reserved");
		System.out.println("[q] Quit application");
		System.out.println();
		System.out.println("Enter a menu selection");
	}

	// Adds dogs to a list for testing
	public static void initializeDogList() {
		Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake",
				false, "United States");
		Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false,
				"United States");
		Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false,
				"Canada");

		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
	}

	// Adds monkey to a list for testing
	public static void initializeMonkeyList() {
		Monkey monkey1 = new Monkey("Abu", "male", "2", "6.0", "02-04-2023", "Brazil", "intake", false, "United States",
				"18.0", "18.0", "18.0", "Chapucin");

		monkeyList.add(monkey1);
	}

	// Prompts user for new dog information and instantiates new dog then adds it to
	// the list
	public static void intakeNewDog(Scanner scanner) {

		// Get dog name from user
		System.out.println("What is the dog's name?");
		String name = scanner.nextLine();

		// Check for duplicate dogs
		for (Dog dog : dogList) {
			if (dog.getName().equalsIgnoreCase(name)) {
				System.out.println("\n\nThis dog is already in our system\n\n");
				return; // returns to menu
			}
		}

		// Get dog breed from user
		System.out.println("What is the dog's breed?");
		String breed = scanner.nextLine();

		// Get dog gender from user and validate
		String gender = "";
		boolean validGender = false;

		while (!validGender) {
			System.out.println("What is the dog's gender? (male, female, other)");
			gender = scanner.nextLine();

			if (isValidGender(gender)) {
				validGender = true;
			} else {
				System.out.println("\nGender must be male, female, or other.\n");
			}
		}

		// Get dog age from user and ensure it is a number
		String age = "";
		boolean validAge = false;

		while (!validAge) {
			System.out.println("What is the dog's age?");
			age = scanner.nextLine();
			if (isNumber(age)) {
				validAge = true;
			} else {
				System.out.println("\nInvalid age.\n");
			}
		}

		// Get dog weight from user and ensure it is a number
		String weight = "";
		boolean validWeight = false;

		while (!validWeight) {
			System.out.println("What is the dog's weight?");
			weight = scanner.nextLine();
			if (isNumber(weight)) {
				validWeight = true;
			} else {
				System.out.println("\nInvalid weight.\n");
			}
		}

		// Get dog acquisition date from user and ensure it is a date in the correct
		// format
		String acquisitionDate = "";
		boolean validDate = false;

		while (!validDate) {
			System.out.println("What is the dog's acquisition date? (MM-dd-yyyy)");
			acquisitionDate = scanner.nextLine();

			if (isValidDate(acquisitionDate)) {
				validDate = true;
			} else {
				System.out.println("\nInvalid date, use format MM-dd-yyyy.\n");
			}
		}

		// Get dog acquisition location from user
		System.out.println("What is the dog's acquisition location?");
		String acquisitionLocation = scanner.nextLine();

		// Get dog training status from user
		System.out.println("What is the dog's training status?");
		String trainingStatus = scanner.nextLine();

		// Get reserved status from user and convert to boolean while checking for valid
		// input
		String reservedInput = "";
		boolean reserved = false;
		boolean validReservedStatus = false;

		while (!validReservedStatus) {
			System.out.println("Is the dog reserved? (Y/N)");
			reservedInput = scanner.nextLine();

			try {
				if (yesOrNo(reservedInput)) {
					reserved = true;
					validReservedStatus = true;
				}
				if (!yesOrNo(reservedInput)) {
					reserved = false;
					validReservedStatus = true;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		// Get dog service country from user
		System.out.println("What is the dog's service country?");
		String inServiceCountry = scanner.nextLine();

		// Create new dog and add to list
		dogList.add(new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionLocation, trainingStatus,
				reserved, inServiceCountry));

		System.out.println("\n" + name + " added successfully.\n");

	}

	// Prompts user for new dog information and instantiates new dog then adds it to
	// the list
	public static void intakeNewMonkey(Scanner scanner) {

		// Get monkey name from user
		System.out.println("What is the monkey's name?");
		String name = scanner.nextLine();

		// Check for duplicate monkeys
		for (Monkey monkey : monkeyList) {
			if (monkey.getName().equalsIgnoreCase(name)) {
				System.out.println("\n\nThis monkey is already in our system\n\n");
				return; // returns to menu
			}
		}

		// Get monkey gender from user and validate
		String gender = "";
		boolean validGender = false;

		while (!validGender) {
			System.out.println("What is the monkey's gender? (male, female, other)");
			gender = scanner.nextLine();

			if (isValidGender(gender)) {
				validGender = true;
			} else {
				System.out.println("\nGender must be male, female, or other.\n");
			}
		}

		// Get monkey age from user and ensure it is a number
		String age = "";
		boolean validAge = false;

		while (!validAge) {
			System.out.println("What is the monkey's age?");
			age = scanner.nextLine();

			if (isNumber(age)) {
				validAge = true;
			} else {
				System.out.println("\nInvalid age.\n");
			}
		}

		// Get monkey weight from user and ensure it is a number
		String weight = "";
		boolean validWeight = false;

		while (!validWeight) {
			System.out.println("What is the monkey's weight?");
			weight = scanner.nextLine();

			if (isNumber(weight)) {
				validWeight = true;
			} else {
				System.out.println("\nInvalid weight.\n");
			}
		}

		// Get monkey acquisition date from user and ensure it is the correct format
		String acquisitionDate = "";
		boolean validDate = false;

		while (!validDate) {
			System.out.println("What is the monkey's acquisition date? (MM-dd-yyyy)");
			acquisitionDate = scanner.nextLine();

			if (isValidDate(acquisitionDate)) {
				validDate = true;
			} else {
				System.out.println("\nInvalid date, use format MM-dd-yyyy.\n");
			}
		}

		// Get monkey acquisition location from user
		System.out.println("What is the monkey's acquisition location?");
		String acquisitionLocation = scanner.nextLine();

		// Get monkey training status from user
		System.out.println("What is the monkey's training status?");
		String trainingStatus = scanner.nextLine();

		// Get reserved status from user and convert to boolean while checking for valid
		// input
		String reservedInput = "";
		boolean reserved = false;
		boolean validReservedStatus = false;

		while (!validReservedStatus) {
			System.out.println("Is the monkey reserved? (Y/N)");
			reservedInput = scanner.nextLine();

			try {
				if (yesOrNo(reservedInput)) {
					reserved = true;
					validReservedStatus = true;
				}
				if (!yesOrNo(reservedInput)) {
					reserved = false;
					validReservedStatus = true;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		// Get monkey service country from user
		System.out.println("What is the monkey's service country?");
		String inServiceCountry = scanner.nextLine();

		// Get monkey tail length from user and ensure it is a number
		String tailLength = "";
		boolean validTailLength = false;

		while (!validTailLength) {
			System.out.println("What is the monkey's tail length?");
			tailLength = scanner.nextLine();

			if (isNumber(tailLength)) {
				validTailLength = true;
			} else {
				System.out.println("\nInvalid tail length.\n");
			}
		}

		// Get monkey height from user and ensure it is a number
		String height = "";
		boolean validHeight = false;

		while (!validHeight) {
			System.out.println("What is the monkey's height?");
			height = scanner.nextLine();

			if (isNumber(height)) {
				validHeight = true;
			} else {
				System.out.println("\nInvalid height.\n");
			}
		}

		// Get monkey body length from user and ensure it is a number
		String bodyLength = "";
		boolean validBodyLength = false;

		while (!validBodyLength) {
			System.out.println("What is the monkey's body length?");
			bodyLength = scanner.nextLine();

			if (isNumber(bodyLength)) {
				validBodyLength = true;
			} else {
				System.out.println("\nInvalid body length.\n");
			}
		}

		// Get monkey species from user and validate
		System.out.println("What is the monkey's species?");
		String species = scanner.nextLine();
		while (!monkeySpeciesSet.contains(species)) {
			System.out.println("\nInvalid species.\n");
			System.out.println("What is the monkey's species?");
			species = scanner.nextLine();
		}

		// Instantiate new monkey and add to list
		monkeyList.add(new Monkey(name, gender, age, weight, acquisitionDate, acquisitionLocation, trainingStatus,
				reserved, inServiceCountry, tailLength, height, bodyLength, species));

		System.out.println("\n" + name + " added successfully.\n");

	}

	// Prompt user for animal type and service country then check for available
	// animals and reserve if available
	public static void reserveAnimal(Scanner scanner) {

		// Get animal type from user and validate
		String animalType = "";
		boolean validType = false;

		while (!validType) {
			System.out.println("What type of animal would you like to reserve? (monkey or dog)");
			animalType = scanner.nextLine();

			if ((animalType.compareToIgnoreCase("monkey") == 0) || (animalType.compareToIgnoreCase("dog") == 0)) {
				validType = true;
			} else {
				System.out.println("\nInvalid type, please enter monkey or dog.\n");
			}
		}

		// Get service country
		System.out.println("What country will the animal service?");
		String serviceCountry = scanner.nextLine();

		// Initialize index to -1 for validation
		int animalIndex = -1;

		// Check dog list for available animals and get its index
		if (animalType.compareToIgnoreCase("dog") == 0) {
			for (Dog dog : dogList) {
				if ((!dog.getReserved()) && (dog.getInServiceLocation().compareToIgnoreCase(serviceCountry) == 0)) {
					animalIndex = dogList.indexOf(dog);
					break;
				}
			}

			// Reserve dog if available and inform user if not
			if (animalIndex != -1) {
				dogList.get(animalIndex).setReserved(true);
				System.out.println(dogList.get(animalIndex).getName() + " has been reserved for service.");
			} else {
				System.out.println("No dog is available for service in that country.");
			}
		}

		// Check monkey list for available animals and get its index
		if (animalType.compareToIgnoreCase("monkey") == 0) {
			for (Monkey monkey : monkeyList) {
				if ((!monkey.getReserved())
						&& (monkey.getInServiceLocation().compareToIgnoreCase(serviceCountry) == 0)) {
					animalIndex = monkeyList.indexOf(monkey);
					break;
				}
			}

			// Reserve monkey if available and inform user if not
			if (animalIndex != -1) {
				monkeyList.get(animalIndex).setReserved(true);
				System.out.println(monkeyList.get(animalIndex).getName() + " has been reserved for service.");
			} else {
				System.out.println("No monkey is available for service in that country.");
			}
		}

	}

	// Prints animals depending on list type
	// dog - prints all dogs in list
	// monkey - prints all monkeys in list
	// available - prints all animals that are not reserved and fully trained
	public static void printAnimals(String listType) {
		System.out.println("");

		switch (listType) {

		case "dog": // Prints all dogs
			System.out.println("---------------");
			for (Dog dog : dogList) {
				dog.printAnimal();
			}
			break;
		case "monkey": // Prints all monkeys
			System.out.println("---------------");
			for (Monkey monkey : monkeyList) {
				monkey.printAnimal();
			}
			break;
		case "available": // Print all available animals
			System.out.println("---------------");
			for (Monkey monkey : monkeyList) {
				if ((monkey.getTrainingStatus().compareToIgnoreCase("in service") == 0) && (!monkey.getReserved())) {
					monkey.printAnimal();
				}
			}
			for (Dog dog : dogList) {
				if ((dog.getTrainingStatus().compareToIgnoreCase("in service") == 0) && (!dog.getReserved())) {
					dog.printAnimal();
				}
			}
			break;
		default:
			System.out.println("An error has occurred while trying to print animals."); // This line should never be
																						// reached under normal usage
			break;
		}
	}

	// Method for validating input for yes or no questions
	// Returns true for yes, false for no, and throws an exception otherwise
	public static boolean yesOrNo(String input) throws Exception {
		if (input == null) {
			throw new Exception("\nInvalid input, please enter yes or no.\n");
		}

		switch (input.toLowerCase()) {
		case "y":
		case "yes":
			return true;
		case "n":
		case "no":
			return false;
		default:
			throw new Exception("\nInvalid input, please enter yes or no.\n");
		}

	}

	// Method for validating input strings as numeric
	public static boolean isNumber(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Double.parseDouble(strNum);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	// Method for validating gender string as male, female, or other
	public static boolean isValidGender(String gender) {
		if (gender == null) {
			return false;
		}
		switch (gender.toLowerCase()) {
		case "male":
		case "female":
		case "other":
			return true;
		default:
			return false;
		}
	}

	// Method for date validation in MM-dd-yyyy format
	public static boolean isValidDate(String date) {
		if (date == null) {
			return false;
		}
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		try {
			dateFormatter.parse(date);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
}
