/**
 * Purpose: Data Structure and Algorithms Fall 2017 Final Project
 * Status: Complete and throughly tested
 * Last Update: 12/4/17
 * Submitted: 12/5/17
 * Comment: Test suite and sample run attached
 * @author Tapan Soni
 * @author John Stranahan
 * @version 2017.4.12
 */

import java.io.*;

public class Driver 
{
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	private static int launchOrder = 1; // We want launch to occur AFTER Purgatory
	private static int flightTakeOffCounter = 0;
	
	public static void main(String [] args) throws IOException
	{
		int userSelection = -1;
		int numberOfRunways = 0;

		ListArrayBasedGeneric<Runway> runwayList = new ListArrayBasedGeneric<Runway>();
		AOSLArrayBased listOfPlanes = new AOSLArrayBased();

		// Add the purgatory element		
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
			searchResult = search(runwayName, runwayList);


			while(searchResult >= 0) // If Purgatory is entered or any other invalid name is entered
			{
				System.out.println();

				System.out.print("\tInvalid runway name, please enter another runway name: ");

				runwayName = stdin.readLine().trim();

				System.out.println(runwayName);

				searchResult = search(runwayName, runwayList);
			} // END WHILE

			if(searchResult < 0)
			{
				System.out.println("\tRunway " + runwayName + " added successfully\n");
			} // END IF

			/**
			 * Add the new runway one after another like so:
			 * Purgatory -- Always first
			 * A
			 * B
			 * C
			 * ...
			 */
			runwayList.add(i + 1, new Runway(runwayName));
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
				case 1: // Add a plane
				{
					addPlane(runwayList, listOfPlanes);
					break;
				}
				case 2: // Plane takes off
				{
					launchPlane(runwayList, listOfPlanes);	
					break;
				}
				case 3: // Plane is allowed to re-enter a runway
				{
					reEnter(runwayList);
					break;
				}
				case 4: // Runway opens
				{
					openRunway(runwayList);
					break;
				}
				case 5: // Runway closes
				{	
					closeRunway(runwayList);
					break;
				}
				case 6: // Display info about planes waiting to take off
				{
					displayInfoForTakeOff(runwayList);
					break;
				}
				case 7: // Display info about planes waiting to be allowed to re-enter a runway
				{
					displayInfoForReEntry(runwayList);
					break;
				}
				case 8: // Display number of planes taken off
				{
					displayNumOfPlanesTakenOff();
					break;
				}
				case 9: // Exit the program
				{
					System.out.print("\tThank you for using the Airport Program -- Goodbye!");
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

	/**
	 * addPlane() -- This method takes in input and uses the runwayList's 
	 * addPlane() functionality to add the plane using the input. It checks
	 * for the duplicates for flight name using the AOSL and checks for duplicates
	 * for the runway using the search() method.
	 * 
	 * @param runwayList
	 * @param listOfPlanes
	 * @throws IOException
	 */
	public static void addPlane(ListArrayBasedGeneric<Runway> runwayList, AOSLArrayBased listOfPlanes) throws IOException // Option # 1
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

		searchReturn = planeSearch(flightNumber, listOfPlanes);

		while(searchReturn == 1)
		{
			System.out.print("\tInvalid flight number. Please re-enter the flight number: ");
			flightNumber = stdin.readLine().trim();
			System.out.println(flightNumber);
			searchReturn = planeSearch(flightNumber, listOfPlanes);
		} // END WHILE

		// Valid flight number, add it to the list to keep track of it's uniqueness for later
		listOfPlanes.add(flightNumber);

		System.out.print("\tEnter the destination: ");
		destination = stdin.readLine().trim();
		System.out.println(destination);

		System.out.print("\tEnter the runway: ");
		runway = stdin.readLine().trim();
		System.out.println(runway);

		searchReturn = search(runway, runwayList);

		while(searchReturn < 0) // If the run way was not found, then re prompt
		{
			System.out.print("\tInvalid runway. Please re-enter the runway: ");

			runway = stdin.readLine().trim();

			System.out.println(runway);

			searchReturn = search(runway, runwayList);
		} // END WHILE

		/**
		 * If it gets to this point, searchReturn will be the index of the 
		 * runway that was found, then add the plane to that plane
		 */
		runwayList.get(searchReturn).addPlane(flightNumber, destination, runway);

		System.out.println("\tFlight " + flightNumber + " is now waiting for takeoff on runway " + runway);

		System.out.println();
	} // END addPlane() method
	
	/**
	 * launchPlane() -- This method launches the first method in each plane in a round
	 * robin manner. It starts at 1, after Purgatory, then increments the launch order
	 * by 1. If the runway doesn't have any planes to launch, it skips to the next
	 * runway. When the launch counter reaches the last element, it is reset to 1, so
	 * it starts back at 1.
	 * 
	 * @param runwayList
	 * @param listOfPlanes
	 * @throws IOException
	 */
	public static void launchPlane(ListArrayBasedGeneric<Runway> runwayList, AOSLArrayBased listOfPlanes) throws IOException // Option # 2
	{
		int sizeOfAirport = runwayList.size();
		int sizeOfRunway = 0;
		String flightNumber = "";
		String runwayName = "";
		char userInput = '!';
		boolean readyToLaunch = false;
		int orderOfLaunch;
		int numberOfPlanes = 0;
		
		// Can't rely on the listOfPlanes' size because if planes are in purgatory, then they
		// are not taken out of the listOfPlanes' list and still CONTRIBUTE to the size even
		// though they are not on the runways to take off, so have to go through each runway 
		// and count the size and total them up to get a accurate, updated count for the
		// number of planes
		for(int i = 1; i < sizeOfAirport; i++)
		{
			numberOfPlanes += runwayList.get(i).getListOfPlanes().size();
		}
		
		if(numberOfPlanes > 0) // Only launch, if there is a runway
		{
			while(readyToLaunch == false)
			{
				// Get the launch order and size of the runway
				orderOfLaunch = getLaunchOrder();
				
				// Get the size of the runway that is set to launch
				sizeOfRunway = runwayList.get(orderOfLaunch).getListOfPlanes().size();
				
				if(sizeOfRunway > 0) // Has atleast 1 plane in it
				{
					// Get the flight number from the runway
					flightNumber = runwayList.get(orderOfLaunch).getListOfPlanes().get(0).getFlightNumber();
					
					System.out.print("\tFlight " + flightNumber + " cleared for takeoff(Y/N): ");
					userInput = stdin.readLine().trim().charAt(0);
					System.out.println(userInput);
					
					if(userInput == 'Y' || userInput == 'y') // Yes --> Take off
					{
						// Get the runway name to display it
						runwayName = runwayList.get(orderOfLaunch).getListOfPlanes().get(0).getRunway();
						
						// Launch the plane
						runwayList.get(orderOfLaunch).takeOff();
						
						System.out.println("\tFlight " + flightNumber + " has now taken off from runway " + runwayName);
						
						// Remove it from the list of planes, so it can be added back in the future
						listOfPlanes.remove(listOfPlanes.search(flightNumber));
						
						// Increment flight counter and launch order
						/**
						 * sizeOfAirport - 1 because:
						 * P A B C
						 *   1 2 3
						 *   reset to 1 when launchOrder reaches 3 which is
						 *   size of the runway (4) - 1
						 */
						if(launchOrder == sizeOfAirport - 1)
						{
							setLaunchOrder(1);
						}
						else
						{
							incrementLaunchOrder();
						} // END IF/ELSE
						
						// Increment flight counter
						incrementFlightTakeOffCounter();
					}
					else // User didn't give clearance --> Add it to purgatory and increment launch order but not the flight counter
					{
						System.out.println("\tFlight " + flightNumber + " is now waiting to be allowed to re-enter a runway");
						
						runwayList.get(0).addPlane(runwayList.get(orderOfLaunch).removeFromRunway(0));
						
						// Increment launch order
						if(launchOrder == sizeOfAirport - 1)
						{
							setLaunchOrder(1);
						}
						else
						{
							incrementLaunchOrder();
						} // END IF/ELSE
					} // END IF/ELSE
					
					readyToLaunch = true; // Quit after 1 iteration, whether the plane is launched or not
				}
				else // Get it to a launch order where it will have a plane
				{
					if(launchOrder == sizeOfAirport - 1) // It has reached the end of the runway count, so reset it to start at 1 (AFTER purgatory)
					{
						setLaunchOrder(1); // Set it back to 1 so it can start again
					}
					else // Launch order hasn't reached the end, increment it by 1
					{
						incrementLaunchOrder();
					} // END IF/ELSE
				} // END IF/ELSE
			} // END WHILE
		}
		else
		{
			System.out.println("\tNo planes on any runway!");
		} // END IF/ELSE
		
		System.out.println();
	} // END launchPlane() method
	
	/**
	 * reEnter() -- This method takes in a String input which is the flight number
	 * and then searches through Purgatory to get that element It then re-adds 
	 * this Plane to the correct runway
	 * 
	 * @param runwayList
	 * @throws IOException
	 */
	public static void reEnter(ListArrayBasedGeneric<Runway> runwayList) throws IOException // Option 3
	{
		String flightNumber = "";
		String flightWaitingForTakeOff = "";
		String runway = "";
		boolean found = false;
		int sizeOfPurgatory = runwayList.get(0).getListOfPlanes().size();
		int indexToAddAt = 0;

		if(sizeOfPurgatory > 0)
		{
			while(found == false) // No initial match found
			{
				System.out.print("\tEnter the flight number: "); // Get the flight number
				flightNumber = stdin.readLine().trim();
				System.out.println(flightNumber);

				// Search purgatory if there are any matches for the flight number
				for(int i = 0; i < sizeOfPurgatory && found == false; i++)
				{
					flightWaitingForTakeOff = runwayList.get(0).getListOfPlanes().get(i).getFlightNumber(); // Get each flight number from purgatory

					if(flightWaitingForTakeOff.compareToIgnoreCase(flightNumber) == 0) // If it's a match, then add it back to the queue
					{
						found = true;
						runway = runwayList.get(0).getListOfPlanes().get(i).getRunway(); // Get the runway of the found plane

						System.out.println("\tFlight " + flightNumber + " is now waiting for takeoff on runway " + runway);

						indexToAddAt = search(runway, runwayList); // Returns the index of the runway found

						// Add it to the original runway
						runwayList.get(indexToAddAt).addPlane(runwayList.get(0).removeFromRunway(i));
					} // END IF
				} // END FOR

				if(found == false) // If not found, then notify the user that the plane isn't waiting for clearance
				{
					System.out.println("\tFlight " + flightNumber + " is not waiting for clearance");
				} // END IF
			} // END WHILE
		}
		else
		{
			System.out.println("\tThere are no planes waiting for clearance");
		} // END IF/ELSE

		System.out.println();
	} // END reEnter() method
	
	/**
	 * openRunway() -- This method opens up a runway. It takes in an input of 
	 * a String, and checks for duplicates (cannot have duplicates). It then
	 * adds the unique runway at the end of the runwayList list.
	 * 
	 * @param runwayList
	 * @throws IOException
	 */
	public static void openRunway(ListArrayBasedGeneric<Runway> runwayList) throws IOException // Option # 4
	{
		String runwayName = "";
		int searchReturn = 0;
		int size = runwayList.size();
		
		System.out.print("\tEnter the name of the new runway: ");
		runwayName = stdin.readLine().trim();
		System.out.println(runwayName);
		
		// Check for duplicates
		searchReturn = search(runwayName, runwayList);
		
		while(searchReturn >= 0) // If Purgatory is entered or any other invalid name is entered
		{
			System.out.println("\tRunway " + runwayName + " already exists, please choose another name");
			
			System.out.print("\tEnter the name of the new runway: ");

			runwayName = stdin.readLine().trim();

			System.out.println(runwayName);

			// Check for duplicates again
			searchReturn = search(runwayName, runwayList);
		} // END WHILE

		if(searchReturn < 0)
		{
			System.out.println("\tRunway " + runwayName + " has opened\n");
		} // END IF

		// Add the new runway at the end
		runwayList.add(size, new Runway(runwayName));
	} // END openRunway() method
	
	/**
	 * closeRunway() -- This method closes a runway. It starts by first going through the
	 * runway itself and reassigning those planes' runways to new runways. It checks
	 * for validatity -- cannot be the runway that is being closed or a runway that is
	 * not in the runwayList. It then goes through Purgatory and searches through
	 * each element to see if it has the same runway name and then it prompts for a new
	 * runway for that Plane
	 * 
	 * @param runwayList
	 * @throws IOException
	 */
	public static void closeRunway(ListArrayBasedGeneric<Runway> runwayList) throws IOException // Option # 5
	{
		String runwayNameToDelete = "";
		String newRunwayForPlanes = "";
		String runwayNameInPurgatory = "";
		String flightNumber = "";
		int searchReturn = 0;
		int sizeOfRunwayToDelete = 0;
		int sizeOfPurgatory = 0;
		int indexOfTheRunwayToDelete = 0;
		int sizeOfAirport = runwayList.size();
		
		if(sizeOfAirport > 1) // More than purgatory, can't delete purgatory
		{
			System.out.print("\tEnter the runway to close: ");
			runwayNameToDelete = stdin.readLine().trim();
			System.out.println(runwayNameToDelete);

			// Check to see if the runway that is to be deleted is valid
			searchReturn = search(runwayNameToDelete, runwayList);

			// Validate that the runway exists in the runway list
			while(searchReturn < 0)
			{
				System.out.println("\tNo such runway!");
				System.out.print("\tEnter the runway to close: ");
				runwayNameToDelete = stdin.readLine().trim();
				System.out.println(runwayNameToDelete);

				searchReturn = search(runwayNameToDelete, runwayList);
			} // END WHILE

			// Searchreturn is the indexOf the runway, so set it to a value --> indexOfTheRunwayToDelete
			sizeOfRunwayToDelete = runwayList.get(searchReturn).getListOfPlanes().size();
			indexOfTheRunwayToDelete = searchReturn; // Just so we don't mess it up later

			// Go through the runway itself first
			for(int i = 0; i < sizeOfRunwayToDelete; i++)
			{
				// Get the flight number of the plane
				flightNumber = runwayList.get(indexOfTheRunwayToDelete).getListOfPlanes().get(0).getFlightNumber();

				System.out.print("\tEnter a new runway for plane " + flightNumber + ": ");
				newRunwayForPlanes = stdin.readLine().trim();
				System.out.println(newRunwayForPlanes);

				// Check if the new runway is valid
				searchReturn = search(newRunwayForPlanes, runwayList);

				// New runway has to be in the runway list AND not equal to the runway that is to be deleted
				while(searchReturn < 0 || searchReturn == indexOfTheRunwayToDelete)
				{
					if(searchReturn == indexOfTheRunwayToDelete) // If the runway is the one that is going to be deleted
					{
						System.out.println("\tThis is the runway that is runway that is closing!");
					}
					else // If the runway isn't in the list
					{
						System.out.println("\tNo such runway!");
					} // END IF/ELSE

					// Get the input again
					System.out.print("\tEnter a new runway for plane " + flightNumber + ": ");
					newRunwayForPlanes = stdin.readLine().trim();
					System.out.println(newRunwayForPlanes);

					// Check if the new runway is valid
					searchReturn = search(newRunwayForPlanes, runwayList);
				} // END WHILE

				// Remove the plane from runway to delete and add it to the new runway
				// searchReturn is the new runway's index so just use that
				// Set the new runway for that element then add
				runwayList.get(indexOfTheRunwayToDelete).getListOfPlanes().get(0).setRunway(newRunwayForPlanes);
				runwayList.get(searchReturn).addPlane(runwayList.get(indexOfTheRunwayToDelete).removeFromRunway(0));

				// Echo it out
				System.out.println("\tFlight " + flightNumber + " is now waiting for takeoff on runway " + newRunwayForPlanes);
			} // END FOR

			// Go through purgatory, get the size of purgatory
			sizeOfPurgatory = runwayList.get(0).getListOfPlanes().size();

			// Go through purgatory
			for(int i = 0; i < sizeOfPurgatory; i++)
			{
				// Get the runway name of each element, so we can compare it with the runwayNameToDelete
				runwayNameInPurgatory = runwayList.get(0).getListOfPlanes().get(0).getRunway();

				// Get the flight number of each element
				flightNumber = runwayList.get(0).getListOfPlanes().get(0).getFlightNumber();

				// If the runwayNameInPutgatory is equivalent to the runwayNameToDelete, then prompt
				// for a new runway, and do the checking
				if(runwayNameInPurgatory.equalsIgnoreCase(runwayNameToDelete))
				{
					System.out.print("\tEnter a new runway for plane " + flightNumber + ": ");
					newRunwayForPlanes = stdin.readLine().trim();
					System.out.println(newRunwayForPlanes);

					// Check if the new runway is valid
					searchReturn = search(newRunwayForPlanes, runwayList);

					// New runway has to be in the runway list AND not equal to the runway that is to be deleted
					while(searchReturn < 0 || (searchReturn == indexOfTheRunwayToDelete))
					{
						if(searchReturn == indexOfTheRunwayToDelete) // If the runway is the one that is going to be deleted
						{
							System.out.println("\tThis is the runway that is closing!");
						}
						else // If the runway isn't in the list
						{
							System.out.println("\tNo such runway!");
						} // END IF/ELSE

						// Get the input again
						System.out.print("\tEnter a new runway for plane " + flightNumber + ": ");
						newRunwayForPlanes = stdin.readLine().trim();
						System.out.println(newRunwayForPlanes);

						// Check if the new runway is valid
						searchReturn = search(newRunwayForPlanes, runwayList);
					} // END WHILE

					// Remove the plane from runway to delete and add it to the new runway
					// searchReturn is the new runway's index so just use that
					// REASSIGN THE RUNWAY --> DON'T ADD IT TO THE NEW RUNWAY BECAUSE
					// IT'S IN PURGATORY --> NEED CLEARANCE TO RE-ENTER
					// runwayList.get(searchReturn).addPlane(runwayList.get(0).removeFromRunway(0));
					// Bug Fixed
					runwayList.get(0).getListOfPlanes().get(0).setRunway(newRunwayForPlanes);
					
					// Echo it out
					System.out.println("\tFlight " + flightNumber + " is now waiting for takeoff on runway " + newRunwayForPlanes);
				} // END IF
			} // END FOR

			// Delete the runway element from the runwayList
			runwayList.remove(indexOfTheRunwayToDelete);

			System.out.println("\tRunway " + runwayNameToDelete + " has been closed");
		}
		else // No runways on the airport
		{
			System.out.println("\tThere are no runways to delete");
		} // END IF/ELSE
		
		System.out.println();
	} // END closeRunway() method

	/**
	 * displayInfoForTakeOff() -- This method goes through each runway and prints out the planes
	 * on that runway. If there are no planes on the runway, it prints out that there are no 
	 * planes on that runway.
	 * 
	 * @param runwayList
	 */
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
				} // END FOR
			}
			else // Else, display that no planes are waiting for take off
			{
				System.out.println("\tNo planes are waiting for takeoff on runway " + runwayName + "!");
			} // END IF/ELSE
		} // END FOR

		System.out.println();
	} // END displayInfoAboutTakeOffWait() method

	/**
	 * displayInfoForReEntry() -- This method displays all the planes that are waiting in
	 * purgatory.
	 * 
	 * @param runwayList
	 */
	public static void displayInfoForReEntry(ListArrayBasedGeneric<Runway> runwayList) // Option # 7
	{
		// We are only printing out the contents of Purgatory
		int sizeOfPurgatory = runwayList.get(0).getListOfPlanes().size();
		String flightNumber = "", destination = "";

		if(sizeOfPurgatory > 0) // If there is at least 1 plane in purgatory, print it
		{
			System.out.println("\tThese planes are waiting to be cleared to re-enter a runway:");

			for(int i = 0; i < sizeOfPurgatory; i++)
			{
				flightNumber = runwayList.get(0).getListOfPlanes().get(i).getFlightNumber();
				destination = runwayList.get(0).getListOfPlanes().get(i).getDestination();

				System.out.println("\t\tFlight " + flightNumber + " to " + destination);
			} // END FOR
		}
		else // No planes in purgatory
		{
			System.out.println("\tNo planes are waiting to be cleared to re-enter a runway!");
		} // END IF/ELSE

		System.out.println();
	} // END displayInfoForReEntry() method
	
	/**
	 * displayNumOfPlanesTakenoff() -- This method displays the number of planes
	 * that have taken off using the getFlightTakeOffCount() method
	 */
	public static void displayNumOfPlanesTakenOff() // Option # 8
	{
		int numOfPlanesTakenOff = getFlightTakeOffCount();
		
		System.out.println("\t" + numOfPlanesTakenOff + " planes have taken off from the airport");
		
		System.out.println();
	} // END displayNumOfPlanesTakenOff() method

	/**
	 * search() -- This method searches through the runwayList for a runway
	 * using the item as the key
	 * 
	 * @param item
	 * @param runwayList
	 * @return i -- The index of the runway or -1 if not found
	 */
	private static int search(String item, ListArrayBasedGeneric<Runway> runwayList)
	{
		int size = runwayList.size();
		String itemFromList = "";

		for(int i = 0; i < size; i++)
		{
			itemFromList = runwayList.get(i).getRunwayName();

			if(itemFromList.compareToIgnoreCase(item) == 0)
			{
				return i;
			} // END IF
		} // END FOR

		return -1;
	} // END search() method

	/**
	 * planeSearch() -- This method uses the AOSL's built in
	 * binary search to search for an element. It returns either a 1
	 * if a duplicate was found, or 0 if not found
	 * 
	 * @param item
	 * @param listOfPlanes
	 * @return 1 if found, 0 if not found
	 */
	private static int planeSearch(String item, AOSLArrayBased listOfPlanes)
	{
		int returnedValue = 0;

		// Uses the listOfPlanes' search method to search for duplicates in
		// the ordered listOfPlanes
		returnedValue = listOfPlanes.search(item);

		if(returnedValue >= 0) // There are duplicates
		{
			return 1; // Duplicate
		}
		else
		{
			return 0; // No duplicate 
		} // END IF/ELSE
	} // END planeSearch() method
	
	/**
	 * setLaunchOrder() -- Sets the launchOrder back to
	 * the parameter. It is used when the launchOrder
	 * reaches the end of the runwayList to set it back
	 * to 1.
	 * 
	 * @param i
	 */
	private static void setLaunchOrder(int i)
	{
		launchOrder = i;
	} // END setLaunchOrder() method
	
	/**
	 * incrementLaunchOrder() -- Increments launchOrder
	 * by 1. It is used to move the launchOrder from one
	 * runway to another
	 */
	private static void incrementLaunchOrder()
	{
		launchOrder++;
	} // END incrementLaunchOrder() method
	
	/**
	 * getLaunchOrder() -- Returns the launchOrder variable
	 * 
	 * @return launchOrder
	 */
	private static int getLaunchOrder()
	{
		return launchOrder;
	} // END getLaunchOrder() method
	
	/**
	 * incrementFlightTakeOffCounter() -- This method 
	 * increments the flightTakeOffCounter by 1. Used
	 * when a plane is successfully launched.
	 */
	private static void incrementFlightTakeOffCounter()
	{
		flightTakeOffCounter++;
	} // END incrementFlightTakeOffCounter() method
	
	/**
	 * getFlightTakeOffCount() -- This method returns
	 * the flightTakeOffCounter variable
	 * 
	 * @return flightTakeOffCounter
	 */
	private static int getFlightTakeOffCount()
	{
		return flightTakeOffCounter;
	} // END getFlightTakeOffCount() method
} // END CLASS Driver {}