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
	
	/**
	 * When adding from purgatory or a closing runway
	 * @param plane
	 */
	public void addPlane(Plane plane)
	{
		int size = arrayOfPlanes.size();
		arrayOfPlanes.add(size, plane);
	}	
	/**
	 * Just removes the element from the 0th index
	 */
	public void takeOff()
	{
		arrayOfPlanes.remove(0);
	}
	
	/**
	 * Returns the element that was removed -- For adding it to purgatory
	 * or back to a runway from purgatory
	 */
	public Plane removeFromRunway(int index)
	{
		Plane temp = arrayOfPlanes.get(index);
		
		arrayOfPlanes.remove(index);
		
		return temp;
	}
	
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
	}

	@Override
	public String toString() 
	{
		return "Runway [runwayName=" + runwayName + ", arrayOfPlanes=" + arrayOfPlanes + "]\n";
	}
} // END CLASS Runway{}
