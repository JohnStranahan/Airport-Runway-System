public class Runway
{
	String runwayName;
	
	ListArrayBasedGeneric<Plane> arrayOfPlanes = new ListArrayBasedGeneric<Plane>();
	
	public Runway(String runwayName)
	{
		this.runwayName = runwayName;
	}
	
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
	
	public String launchPlane()
	{
		String flightNumber = arrayOfPlanes.get(0).getFlightNumber();
		
		// Remove the 1st flight
		arrayOfPlanes.remove(0);
		
		return flightNumber;
	} // END launchPlane() method
	
	public ListArrayBasedGeneric<Plane> getListOfPlanes()
	{
		return arrayOfPlanes;
	}
	
	public void setRunwayName(String runwayName)
	{
		this.runwayName = runwayName;
	} // END setRunwayName() method
	
	public String getRunwayName()
	{
		return runwayName;
	} // 

	@Override
	public String toString() 
	{
		return "Runway [runwayName=" + runwayName + ", arrayOfPlanes=" + arrayOfPlanes + "]\n";
	}
} // END CLASS Runway{}
