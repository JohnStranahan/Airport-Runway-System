
import java.io.*;

public class Driver 
{
static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String [] args) throws IOException
	{
		int userSelection = -1;
		int numberOfRunways = 0;
		
		/**
		 * *&^#*^$%)(*&#^$)(*#&$(*) EXPERIMENTAL!!!!!
		 * SEEING IF THIS WORKS FOR THE NUMBER OF TAKE OFFS AND KEEPING
		 * TRACK OF THE TAKE OFF ORDER BECAUSE Integer IS A OBJECT
		 * 
		 * launchOrder is 1 because we want to start off at the run way 
		 * AFTER Purgatory
		 */
		Integer flightTakeOffCounter = 0, launchOrder = 1;
		
		ListArrayBasedGeneric<Runway> runwayList = new ListArrayBasedGeneric<Runway>();
		
		// Add the purgatory/pool
		
		runwayList.add(0, new Runway("Purgatory"));
		
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
			int searchResult = 0;
			
			System.out.print("Enter the name of runway number: " + (i + 1) + ": ");
			runwayName = stdin.readLine().trim();
			System.out.println(runwayName);
			
			// NEED TO CHECK FOR DUPLICATES
			searchResult = search(runwayName, runwayList, "r");
			
			System.out.println(searchResult);
			
			while(searchResult >= 0) // If Purgatory is entered or any other invalid name is entered
			{
				System.out.println();
				
				System.out.print("\tInvalid runway name, please enter another runway name: ");
				
				runwayName = stdin.readLine().trim();
				
				System.out.println(runwayName);
				
				searchResult = search(runwayName, runwayList, "r");
				
				System.out.println(searchResult);
			}
			
			/**
			 * Add the new runway one after another like so:
			 * Purgatory -- Always first
			 * A
			 * B
			 * C
			 * ...
			 */
			runwayList.add(i + 1, new Runway(runwayName));
			
			//System.out.println(runwayList.toString());
			
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
					addPlane(runwayList);
					break;
				}
				case 2: // 
				{	
					launch(runwayList, flightTakeOffCounter, launchOrder);
					System.out.println("\n\nLAUNCH ORDER: " + launchOrder); // NOT INCREMENTING LIKE IT SHOULD!
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
					displayInfoForTakeOff(runwayList);
					break;
				}
				case 7: // 
				{
					displayInfoForReEntry(runwayList);
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
	
	public static void addPlane(ListArrayBasedGeneric<Runway> runwayList) throws IOException
	{
		/**
		 * Get the input --> flight number, destination, and run way
		 * 
		 * Add by run way
		 * 
		 * use the search method to see if there are duplicates for the run way
		 * name (which we want), and none for the flight number (uniqueness)
		 */
		String flightNumber = "", destination = "", runway = "";
		
		int searchReturn = 0;
		
		System.out.print("\tEnter the flight number: ");
		flightNumber = stdin.readLine().trim();
		System.out.println(flightNumber);
		
		//searchReturn = binarySearch(flightNumber, runwayList, "f");
		searchReturn = search(flightNumber, runwayList, "f");
		
		while(searchReturn >= 0)
		{
			System.out.println("\tInvalid flight number. Please re-enter the flight number: ");
			
			flightNumber = stdin.readLine().trim();
			
			System.out.println(flightNumber);
			
			searchReturn = search(flightNumber, runwayList, "f");
		}
		
		System.out.print("\tEnter the destination: ");
		destination = stdin.readLine().trim();
		System.out.println(destination);
		
		System.out.print("\tEnter the runway: ");
		runway = stdin.readLine().trim();
		System.out.println(runway);
		
		searchReturn = search(runway, runwayList, "r");
		
		while(searchReturn < 0) // If the run way was not found, then re prompt
		{
			System.out.print("\tInvalid runway. Please re-enter the runway: ");
			
			runway = stdin.readLine().trim();
			
			System.out.println(runway);
			
			searchReturn = search(runway, runwayList, "r");
		}
		
		/**
		 * If it gets to this point, searchReturn will be the index of the 
		 * runway that was found, then add the plane to that plane
		 */
		runwayList.get(searchReturn).addPlane(flightNumber, destination, runway);
		
		System.out.println("\tFlight " + flightNumber + " is now waiting for takeoff on runway " + runway);
		
		System.out.println();
	}
	
	/**
	 * NOT WORKING
	 * NOT WORKING
	 * NOT WORKING
	 * NOT WORKING
	 * NOT WORKING
	 * NOT WORKING
	 * NOT WORKING
	 * NOT WORKING
	 * 
	 * @param runwayList
	 * @param flightTakeOffCounter
	 * @param launchOrder
	 * @throws IOException
	 */
	public static void launch(ListArrayBasedGeneric<Runway> runwayList, Integer flightTakeOffCounter, Integer launchOrder) throws IOException
	{
		int size = runwayList.size();
		int sizeOfPurgatory = runwayList.get(0).getListOfPlanes().size();
		int sizeOfRunway = 0;
		String flightNumber = "";
		char userInput = '@';
		
		/**
		 * We want launchOrder to start AFTER purgatory
		 * but we don't want to go out of bounds
		 */
		if(launchOrder >= 1 && launchOrder < size)
		{
			sizeOfRunway = runwayList.get(launchOrder).getListOfPlanes().size();
			
			if(sizeOfRunway > 0) // Launch the first put in plane
			{
				// Get the flight number
				flightNumber = runwayList.get(launchOrder).getListOfPlanes().get(0).getFlightNumber();
				
				System.out.print("\tIs flight " + flightNumber + " cleared for takeoff (Y/N): ");
				userInput = stdin.readLine().trim().charAt(0);
				System.out.println(userInput);
				
				if(userInput == 'Y' || userInput == 'y') // Take off, increment the launchOrder
				{
					runwayList.get(launchOrder).takeOff();
					flightTakeOffCounter++;
					launchOrder++;
					Integer.sum(launchOrder, 1);
				}
				else // Put it in purgatory, and increment launchOrder
				{
					/**
					 * Use the removeFromRunway() method which returns the element that was removed, and adds
					 * it to the purgatory list
					 */
					runwayList.get(0).getListOfPlanes().add(sizeOfPurgatory, runwayList.get(launchOrder).removeFromRunway());
					System.out.println("\tFlight " + flightNumber + " is now waiting to re-enter a runway");
					launchOrder++;
				}
			}
			else // No planes on the runway, increment the launch order to the next runway
			{
				System.out.println("\tThere are no planes on the runway");
				launchOrder++;
			}
		}
		else // If the launchOrder has reached the end, start at 1 again, in a circular fashion
		{
			launchOrder = 1;
		}
		
		System.out.println();
	}
	
	public static void displayInfoForTakeOff(ListArrayBasedGeneric<Runway> runwayList) // Option # 6
	{
		int size = runwayList.size();
		int sizeOfRunway = 0;
		String runwayName = "", flightNumber = "", destination = "";
		
		for(int i = 1; i < size; i++) // We want to display all run ways, except Purgatory
		{
			// Get the run way name and the size of that run way
			sizeOfRunway = runwayList.get(i).getListOfPlanes().size();
			runwayName = runwayList.get(i).getRunwayName();
			
			
			if(sizeOfRunway > 0) // If the runway has planes on it, display them
			{
				System.out.println("\tThese planes are waiting for takeoff on runway " + runwayName);
				
				for(int j = 0; j < sizeOfRunway; j++) // Go through the runway and print out planes and their destination
				{
					flightNumber = runwayList.get(i).getListOfPlanes().get(j).getFlightNumber();
					destination = runwayList.get(i).getListOfPlanes().get(j).getDestination();
					
					System.out.println("\t\tFlight " + flightNumber + " to " + destination);
				}
			}
			else // Else, display that no planes are waiting for take off
			{
				System.out.println("\tNo planes are waiting for takeoff on runway " + runwayName + "!");
			}
		}
		
		System.out.println();
	} // END displayInfoAboutTakeOffWait() method
	
	public static void displayInfoForReEntry(ListArrayBasedGeneric<Runway> runwayList) // Option # 7
	{
		// We are only printing out the contents of Purgatory
		int sizeOfPurgatory = runwayList.get(0).getListOfPlanes().size();
		String flightNumber = "", destination = "";
		
		if(sizeOfPurgatory > 0)
		{
			System.out.println("\tThese planes are waiting to be cleared to re-enter a runway:");
			
			for(int i = 0; i < sizeOfPurgatory; i++)
			{
				flightNumber = runwayList.get(0).getListOfPlanes().get(i).getFlightNumber();
				destination = runwayList.get(0).getListOfPlanes().get(i).getDestination();
				
				System.out.println("\t\tFlight " + flightNumber + " to " + destination);
			}
		}
		else
		{
			System.out.println("\tNo planes are waiting to be cleared to re-enter a runway!");
		}
		
		System.out.println();
	}
	
	private static int search(String item, ListArrayBasedGeneric<Runway> runwayList, String option)
	{
		int size = runwayList.size();
		int sizeOfRunway = 0;
		String itemFromList = "";
		
		switch(option)
		{
			case "r":
			{
				for(int i = 0; i < size; i++)
				{
					itemFromList = runwayList.get(i).getRunwayName();
					
					if(itemFromList.compareToIgnoreCase(item) == 0)
					{
						return i;
					}
				}
				
				return -1;
			}
			case "f":
			{
				for(int i = 0; i < size; i++)
				{
					sizeOfRunway = runwayList.get(i).getListOfPlanes().size();
					
					for(int j = 0; j < sizeOfRunway; j++)
					{
						itemFromList = runwayList.get(i).getListOfPlanes().get(j).getFlightNumber();
						
						if(itemFromList.compareToIgnoreCase(item) == 0)
						{
							return i;
						}
					}
				}
				
				return -1;
			}
			default:
			{
				System.out.println("Cannot do anything");
			}
		}
		
		return 1;
	}
	
	/**
	 * NOT USED
	 * NOT USED
	 * NOT USED
	 * NOT USED
	 * NOT USED
	 * NOT USED
	 * NOT USED
	 * NOT USED
	 * 
	 * @param item
	 * @param runwayList
	 * @param option
	 * @return
	 */
	private static int binarySearch(String item, ListArrayBasedGeneric<Runway> runwayList, String option)
	{
		int high = runwayList.size() - 1;
		int low = 0;
		int mid = 0;
		
		switch(option)
		{
			case "r": // Search for duplicate runways
			{
				while(low <= high)
				{
					mid = (low + high) / 2;
					
					if(runwayList.get(mid).getRunwayName().compareToIgnoreCase(item) < 0)
					{
						low = mid + 1;
					}
					else if(runwayList.get(mid).getRunwayName().compareToIgnoreCase(item) > 0)
					{
						high = mid - 1;
					}
					else
					{
						return mid;
					}
				}
				
				// Not found
				return -1;
			}
			case "f": // Search for duplicate flight numbers
			{
				int size = runwayList.size();
				
				for(int i = 0; i < size; i++) // Start at 0 because we need to check purgatory
				{
					while(low <= high)
					{
						mid = low + high / 2;
						
						if(runwayList.get(i).getListOfPlanes().get(mid).getFlightNumber().compareToIgnoreCase(item) < 0)
						{
							low = mid + 1;
						}
						else if(runwayList.get(i).getListOfPlanes().get(mid).getFlightNumber().compareToIgnoreCase(item) > 0)
						{
							high = mid - 1;
						}
						else
						{
							return mid;
						}
					}
				}
				
				return -1;
			}
			default:
			{
				System.out.println("Invalid option");
			}
		}
		
		return 1;
	}
} // END CLASS Driver {}
