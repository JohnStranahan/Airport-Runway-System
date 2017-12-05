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

public class ListArrayBasedGeneric<T> implements ListInterfaceGeneric<T>
{
	private T [] items;
	private int numItems;
	
	ListArrayBasedGeneric()
	{
		items = (T[]) new Object[3];
		numItems = 0;
	} // END ListArrayBasedGeneric() Constructor

	public boolean isEmpty()
	{
		return (numItems == 0);
	} // END isEmpty() method
	
	public int size()
	{
		return numItems;
	} // END size() method
	
	public void add(int index, T item) throws ListIndexOutOfBoundsException
	{
		if(numItems == items.length)
		{
			resize();
		} // END IF
		
		if(index >= 0 && index <= numItems)
		{
			for(int pos = numItems - 1; pos >= index; pos--)
			{
				items[pos + 1] = items[pos];
			} // END FOR
			
			items[index] = item;
			numItems++;
		}
		else
		{
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on add");
		} // END IF/ELSE
	} // END add() method
	
	private void resize()
	{
		T [] resizedArray = (T[]) new Object[((numItems * 3) / 2) + 1];
		
		for(int i = 0; i < items.length; i++)
		{
			resizedArray[i] = items[i];
			items[i] = null;
		} // END FOR
		
		items = resizedArray;
	} // END resize() method
	
	public T get(int index) throws ListIndexOutOfBoundsException
	{
		if(index >= 0 && index < numItems)
		{
			return items[index];
		}
		else
		{
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on get");
		} // END IF/ELSE
	} // END get() method
	
	public void remove(int index) throws ListIndexOutOfBoundsException
	{
		if(index >= 0 && index < numItems)
		{
			for(int pos = index + 1; pos < numItems; pos++)
			{
				items[pos - 1] = items[pos];
			} // END FOR
			
			numItems--;
			
			items[numItems] = null;
		}
		else
		{
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on remove");
		} // END IF/ELSE
	} // END remove() method
	
	public void removeAll()
	{
		items = (T[]) new Object[3];
		numItems = 0;
	} // END removeAll() method
	
	public String toString()
	{
		String arrayElements = "";
		
		for(int i = 0; i < numItems; i++)
		{
			arrayElements += items[i] + " ";
		} // END FOR
		
		return arrayElements;
	} // END toString() method
}
