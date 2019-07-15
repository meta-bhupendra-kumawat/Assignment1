import java.util.Scanner;

/* The Execution starts form here.
 * This is an Application Class for HexCalc Scheduler.
 */
public class UseCalc {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		
		//		Calc object to its instance methods
		Calc hc = new HexCalc();
		
		//		Scanner object for user input at runtime
		Scanner sc = new Scanner(System.in);
		
		//		Variables for user input
		int option;												// User option for selecting operation
		String hex1;											// Variable to store First Hexa Decimal Number
		String hex2;											// Variable to store Second Hexa Decimal Number

		while (true) {
			//			Displaying MENU along with options
			System.out.println("\nEnter the option as ");
			System.out.println("1. For Addition.");
			System.out.println("2. For Subtraction.");
			System.out.println("3. For Multiplication.");
			System.out.println("4. For Division.");
			System.out.println("5. For Equality check.");
			System.out.println("6. For HexaDecimal number is greater than the other.");
			System.out.println("7. For Hexadecimal Number is smaller than the other.");
			System.out.println("8. For Decimal Representation.");
			System.out.println("9. For HexaDecimal Representation.");
			System.out.println("10. Exit.");
			System.out.println("Enter an option:");

			option = sc.nextInt();								// Taking user input to select the operation to perform
			switch (option) {
				//			For Addition.
			case 1:
				System.out.println("Enter 2 hexadecimal Number to Add:");
				hex1 = sc.next();
				hex2 = sc.next();
				System.out.println("Addition = "+hc.add(hex1, hex2));
				break;

				//			For Subtraction.
			case 2:
				System.out.println("Enter 2 hexadecimal Number to Subtract:");
				hex1 = sc.next();
				hex2 = sc.next();
				System.out.println("Subtraction = "+hc.subtract(hex1, hex2));
				break;

				//			For Multiplication.
			case 3:
				System.out.println("Enter 2 hexadecimal Number to Multiply:");
				hex1 = sc.next();
				hex2 = sc.next();
				System.out.println("Multiplication = " + hc.multiply(hex1, hex2));
				break;

				//			For Division.
			case 4:
				System.out.println("Enter 2 hexadecimal Number to Divide:");
				hex1 = sc.next();
				hex2 = sc.next();
				System.out.println("Division = " + hc.divide(hex1, hex2));
				break;

				//			For Equality check.
			case 5:
				System.out.println("Enter 2 hexadecimal and find they are Equal");
				hex1 = sc.next();
				hex2 = sc.next();
				System.out.println(HexCalc.isEqual(hex1, hex2));
				break;

				//			For HexaDecimal number is greater than the other.
			case 6:
				System.out.println("Enter 2 hexadecimal Number to check first number is greater than the other:");
				hex1 = sc.next();
				hex2 = sc.next();
				System.out.println(HexCalc.isGreater(hex1, hex2));
				break;

				//			For Hexadecimal Number is smaller than the other.	
			case 7:
				System.out.println("Enter 2 hexadecimal Number to check first number is smaller than the other:");
				hex1 = sc.next();
				hex2 = sc.next();
				System.out.println(HexCalc.isSmaller(hex1, hex2));
				break;

				//			For Decimal Representation.
			case 8:
				System.out.println("Enter a HexaDecimal number to find its corresponding Decimal number:");
				hex1 = sc.next();
				System.out.println(HexCalc.hexToDeci(hex1));
				break;

				//			For HexaDecimal Representation.
			case 9:
				System.out.println("Enter a Decimal number to find its corresponding HexaDecimal number:");
				int n = sc.nextInt();
				System.out.println(HexCalc.deciToHex(n));
				break;

				//			For terminating the program.
			case 10:
				sc.close();
				System.exit(0);

				//			For Invalid user input.
			default:
				System.out.println("Invalid Input");
			}

		}
	}

}
