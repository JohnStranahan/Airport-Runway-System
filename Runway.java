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

public class Runway
{
	String runwayName;
	
	ListArrayBasedGeneric<Plane> arrayOfPlanes = new ListArrayBasedGeneric<Plane>();
	
	/**
	 * Runway() constructor method
	 * @param runwayName
	 */
	public Runway(String runwayName)
	{
		this.runwayName = runwayName;
	} // END Runway() Constructor
	/**
	 * addPlane() method creates a newPlane and add's it to the end of arrayOfPlanes
	 * @param flightNumber
	 * @param destination
	 * @param runway
	 */
	public void addPlane(String flightNumber, String destination, String runway)
	{
		int size = arrayOfPlanes.size();
		
		Plane newPlane = new Plane(flightNumber, destination, runway);
		
		/**
		 * Will add it in the last index
		 * Plane1
		 * Plane2
		 * Plane3 and so on
		 */
		arrayOfPlanes.add(size, newPlane);
	} // END addPlane() method
	/**
	 * addPlane() method add's a plane object to end of the arrayOfPlanes
	 * @param plane
	 */
	public void addPlane(Plane plane)
	{
		int size = arrayOfPlanes.size();
		arrayOfPlanes.add(size, plane);
	}// END addPlane() method	
	/**
	 * takeoff() removes the object at the first index of arrayOfPlanes
	 */
	public void takeOff()
	{
		arrayOfPlanes.remove(0);
	} // END takeOff() method
	
	/**
	 * removeFromRunway() creates plane object that reerences the arrayofPlanes element at the given index and removes the item 
	 * at that index and returns the removed element
	 * @param index
	 * @return temp
	 */
	public Plane removeFromRunway(int index)
	{
		Plane temp = arrayOfPlanes.get(index);
		
		arrayOfPlanes.remove(index);
		
		return temp;
	} // END removeFromRunway() method
	/**
	 * getListOfPlanes() accessor method
	 * @return arrayOfPlanes
	 */
	public ListArrayBasedGeneric<Plane> getListOfPlanes()
	{
		return arrayOfPlanes;
	} // END getListOfPlanes() method
	/**
	 * setRunwayName() mutator method
	 * @param runwayName
	 */
	public void setRunwayName(String runwayName)
	{
		this.runwayName = runwayName;
	} // END setRunwayName() method
	/**
	 * getRunwayName() accessor method
	 * @return runwayName
	 */
	public String getRunwayName()
	{
		return runwayName;
	} // END getRunwayName() method
	/**
	 * Returns a string representation of the object
	 * @return String
	 */
	@Override
	public String toString() 
	{
		return "Runway [runwayName=" + runwayName + ", arrayOfPlanes=" + arrayOfPlanes + "]\n";
	} // END toString() method
} // END CLASS Runway{}
