
import java.io.*;

public class Driver 
{
static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String [] args) throws IOException
	{
		int userSelection = -1;
		int numberOfRunways = 0;
		
		// Declare any data structures under here
		/*ListReferenceBasedGeneric<ListReferenceBasedGeneric<Runway>> airport = new ListReferenceBasedGeneric<>();
		
		airport.add(0, new ListReferenceBasedGeneric<Runway>());
		
		System.out.println(airport.get(0));
		
		airport.get(0).add(0,  new Runway("NorthWest"));
		
		
		ListReferenceBasedGeneric<Runway> airport1 = new ListReferenceBasedGeneric<Runway>();
		
		airport1.add(0, new Runway("NorthWest"));
		
		// Northwest --> add plane airfrance 102 to runway
		airport1.get(0).addPlane(new Plane("AirFrance102", "London", "NorthWest"));
		
		System.out.println(airport1.get(0).getRunwayName());
		*/
		
		ListReferenceBasedGeneric<Plane> airport = new ListReferenceBasedGeneric<Plane>();
		
		
		
		System.out.println("Welcome to the Airport program!");
		System.out.print("Enter the number of runways: ");
		numberOfRunways = Integer.parseInt(stdin.readLine().trim());
		System.out.println(numberOfRunways);
		
		/**
		 * Input the runway names, and make sure that they
		 * are not duplicated
		 */
		for(int i = 0; i < numberOfRunways; i++)
		{
			String runwayName = "";
			
			System.out.print("\tEnter the name of runway number: " + (i + 1) + ": ");
			runwayName = stdin.readLine().trim();
			System.out.println(runwayName);
			
			
		} // END FOR
		
		
		
		while(userSelection != 9) 
		{
			System.out.println("Select from the following menu:");
			System.out.println("\t1. Plane enters the system.");
			System.out.println("\t2. Plane takes off.");
			System.out.println("\t3. Plane is allowed to re-enter a runway.");
			System.out.println("\t4. Runway opens.");
			System.out.println("\t5. Runway closes.");
			System.out.println("\t6. Display info about planes waiting to take off.");
			System.out.println("\t7. Display info about planes waiting to be allowed to re-enter a runway.");
			System.out.println("\t8. Display number of planes who have taken off.");
			System.out.println("\t9. Exit program");
			System.out.print("Make your menu selection now: ");
			userSelection = Integer.parseInt(stdin.readLine().trim());
			
			System.out.println(userSelection);
			
			/**
			 * For each option, call static in the Driver class that handle
			 * the input and output.
			 */
			switch(userSelection)
			{
				case 1: // 
				{
					
					break;
				}
				case 2: // 
				{
					
					break;
				}
				case 3: // 
				{
					
					break;
				}
				case 4: // 
				{
					
					break;
				}
				case 5: // 
				{
					
					break;
				}
				case 6: // 
				{
					
					break;
				}
				case 7: // 
				{
					
					break;
				}
				case 8: // 
				{
					
					break;
				}
				case 9: // Exit the program
				{
					System.out.print("\tExiting the program -- Goodbye!");
					break;
				}
				default: // Invalid selection
				{
					System.out.println("\tInvalid selection. Please try again\n");
					break;
				}
			} // END SWITCH
		} // END WHILE
	} // END main() method
	
	
	private int binarySearch()
	{
		return 1;
	}
} // END CLASS Driver {}
