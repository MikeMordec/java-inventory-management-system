import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

public class DataStructures {


	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in); 


		String myFile = "data.txt"; 
		FileWriter file = new FileWriter(myFile); 
		PrintWriter outFile = new PrintWriter(myFile); 
		int numRecords = 0; 
		String strName = "";
		double dblCost = 0; 
		int intQuantity = 0; 
		char chrLocation = '\0'; 


		System.out.print("How many records are for processing? Answer: "); 
																			
		numRecords = scan.nextInt(); 
		System.out.printf("%n");


		for (int i = 0; i < numRecords; i++) {


			System.out.print("Enter item description: ");
			scan.nextLine();
			strName = scan.nextLine();
			System.out.print("Enter item cost: $");
			dblCost = scan.nextDouble();
			System.out.print("Enter item quantity: ");
			intQuantity = scan.nextInt();
			System.out.print("Enter item location code: ");
			chrLocation = scan.next().charAt(0);

			System.out.printf("%n"); 


			outFile.print(strName + ",");
			outFile.print(dblCost + ",");
			outFile.print(intQuantity + ",");
			outFile.println(chrLocation);
		}

		scan.close(); 
		file.close(); 
		outFile.close(); 

		String line = ""; 
		String csv = ","; 
		FileReader fileIn = new FileReader(myFile); 
		BufferedReader br = new BufferedReader(fileIn); 

		int itemsExceedingCost = 0; 
		int averageQuantity = 0; 
		int category = 0; 

		try {
			System.out.printf("%n--------------------------------------------------------------%n");
			System.out.printf("%-15s %-15s %-15s %-15s\n", "Item", "Cost", "Quantity", "Location Code");
			System.out.println("--------------------------------------------------------------");


			while ((line = br.readLine()) != null) {
				String[] data = line.split(csv);  


				if (Double.parseDouble(data[1]) > 100) {
					itemsExceedingCost++; 
				}

				averageQuantity += Integer.parseInt(data[2]); 

				if (data[3].equals("C")) {
					category++; 
				}

				System.out.printf("%-15s $%-15s %-15s %-15s\n", data[0], data[1], data[2], data[3]);
				System.out.printf("--------------------------------------------------------------%n");
			}
			System.out.printf("%n"); 
			System.out.printf("You can query data presented in the inventory table below: %n");
			System.out.printf("--------------------------------------------------------------%n");




			System.out.printf("%nQuery number of items with location code C: %d", category);
			System.out.printf("%nQuery number of items that cost over $100: %d", itemsExceedingCost);
			System.out.printf("%nQuery average quantity on hand in the inventory: %d%n", averageQuantity / intQuantity);

		} catch (IOException e) {
			e.printStackTrace();
		}

		br.close(); 
	}

}