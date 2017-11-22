/**
 * Purpose: Data Structures and Algorithms Lab 6 Problem 1
 * Status: Complete and throughly tested
 * Last Update: 10/9/17
 * Submitted: 10/12/17
 * Comment: Test suite and sample run attached
 * @author Tapan Soni
 * @version 2017.10.9
 */

public class QueueArrayBased<T> implements QueueInterface<T>
{
	protected T [] items;
	protected int numItems;
	protected int front;
	protected int back;
	
	/** --------------------------------------------------------------------------
	 * 
	 * QueueArrayBased() -- Default Constructor
	 * Initializes the items array, numItems,
	 * front, and back to their default values
	 */
	public QueueArrayBased()
	{
		items = (T[]) new Object[3];
		numItems = 0;
		front = 0;
		back = 0;
	} // END QueueArrayBased() Default Constructor
	
	/** --------------------------------------------------------------------------
	 * 
	 * isEmpty() -- Returns a boolean value that is 
	 * the comparison of if numItems is equal to -1
	 * 
	 * @return boolean true if empty, false if not empty
	 */
	public boolean isEmpty() 
	{
		return numItems == 0;
	} // END isEmpty() method

	/** --------------------------------------------------------------------------
	 * 
	 * enqueue() -- This method checks if the the limit
	 * of the array has been hit, if it has, then it calls
	 * the internal resize() method. Then it adds the
	 * item to the back of the queue. It circularly increments
	 * the queue using magic, and increments numItems
	 * 
	 * @param T newItem
	 */
	public void enqueue(T newItem) throws QueueException
	{
		// If the array is at limit, resize
		if(numItems == items.length)
		{
			resize();
		} // END IF
		
		/**
		 * Assign newItem to the back --> back
		 * is the position of the next AVAILABLE space
		 * Back is incremented in a circular fashion
		 * numItems is incremented
		 */
		items[back] = newItem;
		back = (back + 1) % items.length;
		numItems++;
	} // END enqueue() method
	
	/** --------------------------------------------------------------------------
	 * 
	 * resize() -- Internal method which resizes the array items
	 * and copies over everthing in a circular fashion. It also
	 * assigns front to the beginning of the array, and back
	 * to the numItems index --> first available position
	 */
	protected void resize()
	{
		// 1.5 times bigger than the old array
		T [] resizedArray = (T[]) new Object [((numItems * 3) / 2) + 1];
		
		// Copy over everything in a circular fashion
		for(int i = 0; i < numItems; i++)
		{
			resizedArray[i] = items[(front + i) % items.length];
		} // END FOR
		
		front = 0;
		back = numItems;
		items = resizedArray;
	} // END resize() method

	/** --------------------------------------------------------------------------
	 * 
	 * dequeue() -- This method returns the item at the front of
	 * the queue, drops the null, and increments front in a circular
	 * fashion, and decrements numItems
	 * 
	 * @return T tempItem
	 */
	public T dequeue() throws QueueException
	{
		if(numItems != 0)
		{
			T tempItem = items[front];
			items[front] = null;
			front = (front + 1) % items.length;
			numItems--;
			return tempItem;
		}
		else
		{
			throw new QueueException("QueueException on dequeue");
		} // END IF/ELSE
	} // END dequeue() method

	/** --------------------------------------------------------------------------
	 * 
	 * dequeueAll() -- This method reassigns the items reference
	 * to a new T array of size 3. numItems, front, and back
	 * are assigned the value of 0
	 */
	public void dequeueAll()
	{
		items = (T[]) new Object[3];
		numItems = 0;
		front = 0;
		back = 0;
	} // END dequeueAll() method
	
	/** --------------------------------------------------------------------------
	 * 
	 * peek() -- This method returns the front element in
	 * the queue. It doesn't remove it, just shows it
	 * 
	 * @return T items[front]
	 */
	public T peek() throws QueueException 
	{
		if(numItems != 0)
		{
			return items[front];
		}
		else
		{
			throw new QueueException("QueueException on peek");
		} // END IF/ELSE
	} // END peek() method
	
	/** --------------------------------------------------------------------------
	 * 
	 * toString() -- Returns the string implementation
	 * of the queue
	 * 
	 * @return String qElements
	 */
	public String toString()
	{
		String qElements = "";
		
		for(int i = 0; i < numItems; i++)
		{
			qElements += items[(front + i) % items.length] + " ";
		} // END FOR
		
		return qElements;
	} // END toString() method
} // END class QueueArrayBased {}
