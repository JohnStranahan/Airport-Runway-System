
public class Runway
{
	String runwayName;
	
	ListReferenceBasedGeneric<Plane> listOfPlanes = new ListReferenceBasedGeneric<Plane>();
	
	public Runway(String runwayName)
	{
		this.runwayName = runwayName;
	}
	
	public void addPlane(String flightNumber, String destination, String runway)
	{
		Plane newPlane = new Plane(flightNumber, destination, runway);
		
		listOfPlanes.add(0, newPlane);
	}
	
	public void setRunwayName(String runwayName)
	{
		this.runwayName = runwayName;
	}
	
	public String getRunwayName()
	{
		return runwayName;
	}
	
	public ListReferenceBasedGeneric<Plane> getListOfPlanes()
	{
		return listOfPlanes;
	}
} // END CLASS Runway{}
