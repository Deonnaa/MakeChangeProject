package makechange;

public class Register {

	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);

		System.out.print("Enter Purchase Price: $");
		double purchasePrice = scanner.nextDouble();

		System.out.print("Enter Amount Tendered: $");
		double amountTendered = scanner.nextDouble();

		double change = amountTendered - purchasePrice;
		change += .0005;

		// Prints out change <0, >0, =0
		if (change < 0) {
			System.err.println("You are short: $" + ((amountTendered - purchasePrice) * -1)); // Payment too low
		} else if (change == 0) {
			System.out.println("You are owed: $0.00"); // Exact change output
		} else {
			System.out.println("You are owed: $" + change); // Bills and cents output

			int numOfDenom = 0;

			// Prints out bills
			if (change / 20 >= 1) {
				numOfDenom = (int) (change / 20);
				change = change % 20;
				System.out.print("Twenties: " + numOfDenom + ", ");
			}
			if (change / 10 >= 1) {
				numOfDenom = (int) (change / 10);
				change = change % 10;
				System.out.print("Tens: " + numOfDenom + ", ");
			}
			if (change / 5 >= 1) {
				numOfDenom = (int) (change / 5);
				change = change % 5;
				System.out.print("Fives: " + numOfDenom + ", ");
			}
			if (change / 1 >= 1) {
				numOfDenom = (int) (change / 1);
				change = change % 1;
				System.out.print("Ones: " + numOfDenom + ", ");
			}

			// Prints out cents
			if (change / .25 >= 1) {
				numOfDenom = (int) (change / .25);
				change = change % .25;
				System.out.print("Quarters: " + numOfDenom + ", ");
			}
			if (change / .10 >= 1) {
				numOfDenom = (int) (change / .10);
				change = change % .10;
				System.out.print("Dimes: " + numOfDenom + ", ");
			}
			if (change / .05 >= 1) {
				numOfDenom = (int) (change / .05);
				change = change % .05;
				System.out.print("Nickles: " + numOfDenom + ", ");
			}
			if (change / .01 >= 1) {
				numOfDenom = (int) (change / .01);
				change = change % .01;
				System.out.print("Pennies: " + numOfDenom);
			}

		}
		scanner.close();
	}

}

//In the cash register we will calculate the amount of change returned to a customer based on the 
//purchase price and the amount tendered. We will also notify the attendant how many of each type of 
//currency ($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c) is needed to make the change for the customer.
//
//Change will be provided using a combination of the largest bill and coin denominations as possible.
//
//Denominations that are not used will not be displayed.
//
//Hint: Mod operator
//
//User Story #1
//The user is prompted asking for the price of the item.
//
//User Story #2
//The user is then prompted asking how much money was tendered by the customer.
//
//User Story #3
//Display an appropriate message if the customer provided too little money or the exact amount.
//
//User Story #4
//If the amount tendered is more than the cost of the item, display the number of bills and coins that 
//should be given to the customer. Denominations that are not used will not be displayed.

//Here are example test conditions:
//
//Amount: .67, Tendered: .50, Result: Error message
//Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
//Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
//Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill, 1 one dollar bill, 
//4 pennies.
//Amount: any amount less than 20.00, Tendered: anything greater than amount: correct denominations 
//for correct change.
