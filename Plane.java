public class Plane 
{
	private String flightNumber;
	private String destination;
	private String runway;

	public Plane(String flightNumber, String destination, String runway) 
	{
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.runway = runway;
	} // END Plane() Constructor

	public String getFlightNumber()
	{
		return flightNumber;
	} // END getFlightNumber() method

	public void setFlightNumber(String flightNumber)
	{
		this.flightNumber = flightNumber;
	}

	public String getDestination()
	{
		return destination;
	}

	public void setDestination(String destination) 
	{
		this.destination = destination;
	}

	public String getRunway() 
	{
		return runway;
	}

	public void setRunway(String runway) 
	{
		this.runway = runway;
	}
	
	public String toString()
	{
		return "Flight " + flightNumber + " to " + destination;
	}
} // END CLASS Plane {}