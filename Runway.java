
public class Runway
{
	String runwayName;
	
	ListReferenceBasedGeneric<Plane> listOfPlanes = new ListReferenceBasedGeneric<Plane>();
	
	public Runway(String runwayName)
	{
		this.runwayName = runwayName;
	}
	
	public void Runway(String flightNumber, String destination, String runway)
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
	
	
} // END CLASS Runway{}
