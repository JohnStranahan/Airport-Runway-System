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
	
	public Runway(String runwayName)
	{
		this.runwayName = runwayName;
	} // END Runway() Constructor
	
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
	
	public void addPlane(Plane plane)
	{
		int size = arrayOfPlanes.size();
		arrayOfPlanes.add(size, plane);
	}// END addPlane() method	

	public void takeOff()
	{
		arrayOfPlanes.remove(0);
	} // END takeOff() method
	

	public Plane removeFromRunway(int index)
	{
		Plane temp = arrayOfPlanes.get(index);
		
		arrayOfPlanes.remove(index);
		
		return temp;
	} // END removeFromRunway() method
	
	public ListArrayBasedGeneric<Plane> getListOfPlanes()
	{
		return arrayOfPlanes;
	} // END getListOfPlanes() method
	
	public void setRunwayName(String runwayName)
	{
		this.runwayName = runwayName;
	} // END setRunwayName() method
	
	public String getRunwayName()
	{
		return runwayName;
	} // END getRunwayName() method

	@Override
	public String toString() 
	{
		return "Runway [runwayName=" + runwayName + ", arrayOfPlanes=" + arrayOfPlanes + "]\n";
	} // END toString() method
	
} // END CLASS Runway{}
