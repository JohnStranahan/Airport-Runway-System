
public class Runway 
{
	String runwayName;
	
	ListReferenceBasedGeneric<Plane> runway = new ListReferenceBasedGeneric<Plane>();
	
	public Runway(String runwayName)
	{
		this.runwayName = runwayName;
	}
	
	public void setRunwayName(String runwayName)
	{
		this.runwayName = runwayName;
	}
	
	public String getRunwayName()
	{
		return runwayName;
	}
	
	public String toString()
	{
		return runwayName;
	}
} // END CLASS Runway{}
