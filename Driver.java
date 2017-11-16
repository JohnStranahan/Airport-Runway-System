
import java.io.*;

public class Driver 
{
static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String [] args) throws IOException
	{
		int userSelection = -1;
		int numberOfRunways = 0;
		
		ListReferenceBasedGeneric<Runway> runwayList = new ListReferenceBasedGeneric<Runway>();
		
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
			
			searchResult = binarySearch(runwayName, runwayList, "r");
			
			while(searchResult >= 0)
			{
				System.out.print("\tInvalid runway name. Please re-enter the runway: ");
				runwayName = stdin.readLine().trim();
				System.out.println(runwayName);
				
				searchResult = binarySearch(runwayName, runwayList, "r");
			}
			
			// Add the new runway
			runwayList.add(0, new Runway(runwayName));
			
			System.out.println(runwayList.toString());
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
	
	public static void addPlane(ListReferenceBasedGeneric<Runway> runwayList) throws IOException
	{
		/**
		 * Get the input --> flight number, destination, and runway
		 * 
		 * Add by runway
		 * 
		 * use the binary search method to 
		 */
		String flightNumber = "", destination = "", runway = "";
		
		int searchReturn = 0;
		
		System.out.print("\tEnter the flight number: ");
		flightNumber = stdin.readLine().trim();
		System.out.println(flightNumber);
		
		searchReturn = binarySearch(flightNumber, runwayList, "f");
		
		while(searchReturn > 0)
		{
			System.out.println("\tInvalid flight number. Please re-enter the flight number: ");
			
			flightNumber = stdin.readLine().trim();
			
			System.out.println(flightNumber);
			
			searchReturn = binarySearch(flightNumber, runwayList, "f");
		}
		
		System.out.print("\tEnter the destination: ");
		destination = stdin.readLine().trim();
		System.out.println(destination);
		
		System.out.print("\tEnter the runway: ");
		runway = stdin.readLine().trim();
		System.out.println(runway);
		
		searchReturn = binarySearch(runway, runwayList, "r");
		
		while(searchReturn > 0)
		{
			System.out.println("\tInvalid runway. Please re-enter the runway: ");
			
			runway = stdin.readLine().trim();
			
			System.out.println(runway);
			
			searchReturn = binarySearch(runway, runwayList, "r");
		}
		
		/**
		 * If it gets to this point, searchReturn will be the index of the 
		 * runway that was found, then add the plane to that plane
		 */
		runwayList.get(searchReturn).addPlane(flightNumber, destination, runway);
		
		System.out.println();
	}
	
	public static void displayInfoAboutTakeOffWait(ListReferenceBasedGeneric<Runway> runwayList) // Option # 6
	{
		int size = runwayList.size();
		
		int sizeOfEachRunway = 0;
		
		/**
		 * size - 1 because we don't want to print out the contents
		 * of purgatory
		 */
		for(int i = 0; i < size - 1; i++)
		{
			Runway tempRunwayList = runwayList.get(i);
			
			sizeOfEachRunway = tempRunwayList.listOfPlanes.size();
			
			if(sizeOfEachRunway == 0)
			{
				System.out.println("\tNo planes are waiting for takeoff on runway " + tempRunwayList.getRunwayName());
			}
			else
			{
				for(int j = sizeOfEachRunway - 1; j >= 0; j--)
				{
					System.out.println("\tFlight " + tempRunwayList.getListOfPlanes().get(j).getFlightNumber() + " to " + tempRunwayList.getListOfPlanes().get(j).getDestination());
				}
			}
		}
	} // END displayInfoAboutTakeOffWait() method
	
	public static void displayInfoAboutReEntry() // Option # 7
	{
		
	}
	
	
	
	private static int binarySearch(String item, ListReferenceBasedGeneric<Runway> runwayList, String searchFor)
	{
		int low = 0;
		int high = 0;
		int mid = 0;
		
		switch(searchFor)
		{
			case "r": // Runways
			{
				high = runwayList.size() - 1;
				
				while(low <= high)
				{
					mid = (low + high) / 2;
					
					if(runwayList.get(mid).getRunwayName().compareToIgnoreCase(item) == 0)
					{
						return mid;
					}
					else if(runwayList.get(mid).getRunwayName().compareToIgnoreCase(item) < 0)
					{
						low = mid + 1;
					}
					else
					{
						high = mid - 1;
					}
				}
				
				// Nothing was found
				return -1;
			}
			case "f": // Flight Number
			{
				// We want it to run through all the runways to search for the flight number
				// We can't have the same flight number on 2 different runways
				
				int size = runwayList.size();
				
				// size, not size - 1, because we want to include purgatory
				for(int i = 0; i < size; i++)
				{
					// Set the high for each of the separate length runways
					high = runwayList.get(i).getListOfPlanes().size() - 1;
					
					while(low <= high)
					{
						mid = (low + high) / 2;
						
						if(runwayList.get(mid).getListOfPlanes().get(mid).getFlightNumber().compareToIgnoreCase(item) == 0)
						{
							return mid;
						}
						else if(runwayList.get(mid).getListOfPlanes().get(mid).getFlightNumber().compareToIgnoreCase(item) < 0)
						{
							low = mid + 1;
						}
						else
						{
							high = mid - 1;
						}
					}
					
					// Nothing was found
					mid = -1;
				}
				
				return mid;
			}
			default:
			{
				System.out.println("\tError searching");
				return -1;
			}
		}
	}
} // END CLASS Driver {}
