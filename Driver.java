
import java.io.*;

public class Driver 
{
static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String [] args) throws IOException
	{
		int userSelection = -1;
		int numberOfRunways = 0;
		
		ListReferenceBasedGeneric<Runway> runwayList = new ListReferenceBasedGeneric<Runway>();
		
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
			
			while(searchResult < 0)
			{
				System.out.println("");
			}
			
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
	
	public static void addPlane(ListReferenceBasedGeneric<Runway> runwayList) throws IOException
	{
		/**
		 * Get the input --> flight number, destination, and runway
		 * 
		 * Add by runway
		 * 
		 * use the binary search method to 
		 */
		
		
		
		runwayList.get(0).addPlane(flightNumber, destination, runway);
	}
	
	private static int binarySearch(String item, ListReferenceBasedGeneric<Runway> runwayList, String searchFor)
	{
		int low = 0;
		int high = runwayList.size();
		int mid = 0;
		
		switch(searchFor)
		{
			case "r":
			{
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
			case "f":
			{
				while(low <= high)
				{
					mid = (low + high) / 2;
					
					if(runwayList.get(mid).get().compareToIgnoreCase(item) == 0)
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
			case "d":
			{
				
			}
			default:
			{
				System.out.println("\tError searching");
				return -1;
			}
		}
	}
} // END CLASS Driver {}
