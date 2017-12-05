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

public class Plane 
{
	private String flightNumber;
	private String destination;
	private String runway;

	/**
	 * Plane() -- constructor method
	 * @param flightNumber
	 * @param destination
	 * @param runway
	 */
	public Plane(String flightNumber, String destination, String runway) 
	{
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.runway = runway;
	} // END Plane() Constructor
	
	/**
	 * getFlightNumber() -- accessor method
	 * @return flightNumber
	 */
	public String getFlightNumber()
	{
		return flightNumber;
	} // END getFlightNumber() method

	/**
	 * setFlightNumber() -- mutator method
	 * @param flightNumber
	 */
	public void setFlightNumber(String flightNumber)
	{
		this.flightNumber = flightNumber;
	} // END setFlightNumber() method
	
	/**
	 * getDestination() -- accessor method
	 * @return destination
	 */
	public String getDestination()
	{
		return destination;
	} // END getDestination() method
	
	/**
	 * setDestination() -- mutator method
	 * @param destination
	 */
	public void setDestination(String destination) 
	{
		this.destination = destination;
	} // END setDestinatio() method
	
	/**
	 * setDestination() -- mutator method
	 * @return runway
	 */
	public String getRunway() 
	{
		return runway;
	} // END getRunway() method
	
	/**
	 * setRunway() -- mutator method
	 * @param runway
	 */
	public void setRunway(String runway) 
	{
		this.runway = runway;
	} // END setRunway() method
	
	/**
	 * toString() -- method for Plane object
	 * @return String
	 */
	public String toString()
	{
		return "Flight " + flightNumber + " to " + destination;
	} // END toString() method
} // END CLASS Plane {}
