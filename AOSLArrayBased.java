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

public class AOSLArrayBased implements AscendinglyOrderedStringListInterface
{
	private String [] items;
	private int numItems;

	public AOSLArrayBased()
	{
		items = new String[3];
		numItems = 0;
	} // END AOSLArrayBased() Constructor
	
	public boolean isEmpty()
	{
		return numItems == 0;
	} // END isEmpty() method
	
	public int size()
	{
		return numItems;
	} // END size() method
	
	private void resize()
	{
		String [] resizedArray = new String[((numItems * 3) / 2) + 1]; // 1.5 times the original array

		// Copy everything over
		for(int i = 0; i < items.length; i++)
		{
			resizedArray[i] = items[i];
			items[i] = null;
		} // END FOR

		items = resizedArray;
	} // END resize() method
	
	public String get(int index) throws ListIndexOutOfBoundsException
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
	
	public void add(String item) throws ListIndexOutOfBoundsException
	{
		int indexToAddAt = 0;
		
		if(numItems == items.length)
		{
			resize();
		} // END IF
		
		indexToAddAt = search(item);
		
		if(indexToAddAt < 0)
		{
			indexToAddAt = 0 - (indexToAddAt + 1);
			
			for(int pos = numItems - 1; pos >= indexToAddAt; pos--)
			{
				items[pos + 1] = items[pos];
			} // END FOR 
			
			items[indexToAddAt] = item;
			numItems++;
		}
		else
		{
			throw new ListIndexOutOfBoundsException("\tError adding to the list");
		} // END IF/ELSE
	} // END add() method
	
	public int search(String item)
	{
		int low = 0;
		int high = numItems - 1;
		int mid = 0;
		
		while(low <= high)
		{
			mid = (low + high) / 2;
			
			if(items[mid].compareToIgnoreCase(item) == 0)
			{
				return mid;
			}
			else if(items[mid].compareToIgnoreCase(item) < 0)
			{
				high = mid - 1;
			}
			else
			{
				low = mid + 1;
			} // END IF/ELSE
		} // END WHILE
		
		return (0 - low - 1);
	} // END search() method

	public void clear() 
	{
		items = new String[3];
		numItems = 0;
	} // END clear() method
	
	public String toString()
	{
		String elements = "";
		
		for(int i = 0; i < numItems; i++)
		{
			elements += items[i] + " ";
		} // END FOR
		
		return elements;
	} // END toString() method
} // END CLASS AOSLArrayBased {}
