
import java.io.*;

public class Driver 
{
static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String [] args) throws IOException
	{
		int userSelection = -1;
		int numberOfRunways = 0;
		
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
				
				System.out.println("Invalid runway name, please enter another one: ");
				
				runwayName = stdin.readLine().trim();
				
				System.out.println(runwayName);
				
				searchResult = search(runwayName, runwayList, "r");
				
				System.out.println(searchResult);
			}
			
			// Add the new runway			
			runwayList.add(i + 1, new Runway(runwayName));
			
			System.out.println(runwayList.toString());
			
		} // END FOR
		
		for(int i = 1; i <= numberOfRunways; i++) // Start at 1, to skip Purgatory printing
		System.out.print(runwayList.get(i).toString());
		
		/*runwayList.get(1).getListOfPlanes().get(1).setDestination("London");
		
		runwayList.get(3).addPlane("123", "london", "south");*/
		
		runwayList.get(1).addPlane("FranceAir133", "London", "SouthWest");
		runwayList.get(1).addPlane("United223", "London", "SouthWest");
		runwayList.get(1).addPlane("American334", "London", "SouthWest");
		
		System.out.println("\nPrinting out plane");
		System.out.println(runwayList.get(1).toString());
		
		System.out.println("\nLaunching plane 1");
		// Store plane that is to be launched so we can display which plane was launched
		//runwayList.get(1).launchPlane();
		
		System.out.println(runwayList.get(1).launchPlane() + " has now taken off from runway " + runwayList.get(1).getRunwayName());
		
		System.out.println("\n" + runwayList.get(1).toString());
		
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
		
		//searchReturn = binarySearch(flightNumber, runwayList, "f");
		
		while(searchReturn > 0)
		{
			System.out.println("\tInvalid flight number. Please re-enter the flight number: ");
			
			flightNumber = stdin.readLine().trim();
			
			System.out.println(flightNumber);
			
			//searchReturn = binarySearch(flightNumber, runwayList, "f");
		}
		
		System.out.print("\tEnter the destination: ");
		destination = stdin.readLine().trim();
		System.out.println(destination);
		
		System.out.print("\tEnter the runway: ");
		runway = stdin.readLine().trim();
		System.out.println(runway);
		
		//searchReturn = binarySearch(runway, runwayList, "r");
		
		while(searchReturn > 0)
		{
			System.out.println("\tInvalid runway. Please re-enter the runway: ");
			
			runway = stdin.readLine().trim();
			
			System.out.println(runway);
			
			//searchReturn = binarySearch(runway, runwayList, "r");
		}
		
		/**
		 * If it gets to this point, searchReturn will be the index of the 
		 * runway that was found, then add the plane to that plane
		 */
		runwayList.get(searchReturn).addPlane(flightNumber, destination, runway);
		
		System.out.println();
	}
	
	public static void addPlane()
	{
		// If yes, add it to the specfic runway
		
		// If no, add it to runwayList.get(0) ---> Purgatory
	}
	
	public static void displayInfoAboutTakeOffWait(ListArrayBasedGeneric<Runway> runwayList) // Option # 6
	{
		
	} // END displayInfoAboutTakeOffWait() method
	
	public static void displayInfoAboutReEntry() // Option # 7
	{
		
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
