public class ListArrayBasedGeneric<T> implements ListInterfaceGeneric<T>
{
	private T [] items;
	private int numItems;
	
	/**
	 * ListArrayBasedGeneric() -- Default constructor 
	 * initializes the items array and numItems
	 */
	ListArrayBasedGeneric()
	{
		items = (T[]) new Object[3];
		numItems = 0;
	} // END ListArrayBasedGeneric() Default Constructor

	/**
	 * isEmpty() -- Tells the invoking object if
	 * the items array is empty
	 * 
	 * @return boolean true if empty, false if not empty
	 */
	public boolean isEmpty()
	{
		return (numItems == 0);
	} // END isEmpty() method
	
	/**
	 * size() -- Returns the amount of items in the items array
	 * 
	 * @return int numItems
	 */
	public int size()
	{
		return numItems;
	} // END size()
	
	public void add(int index, T item) throws ListIndexOutOfBoundsException
	{
		if(numItems == items.length)
		{
			resize();
		}
		
		if(index >= 0 && index <= numItems)
		{
			for(int pos = numItems - 1; pos >= index; pos--)
			{
				items[pos + 1] = items[pos];
			}
			
			items[index] = item;
			numItems++;
		}
		else
		{
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on add");
		}
	}
	
	private void resize()
	{
		T [] resizedArray = (T[]) new Object[((numItems * 3) / 2) + 1];
		
		for(int i = 0; i < items.length; i++)
		{
			resizedArray[i] = items[i];
			items[i] = null;
		}
		
		items = resizedArray;
	}
	
	public T get(int index) throws ListIndexOutOfBoundsException
	{
		if(index >= 0 && index < numItems)
		{
			return items[index];
		}
		else
		{
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on get");
		}
	}
	
	public void remove(int index) throws ListIndexOutOfBoundsException
	{
		if(index >= 0 && index < numItems)
		{
			for(int pos = index + 1; pos < numItems; pos++)
			{
				items[pos - 1] = items[pos];
			}
			
			numItems--;
			
			items[numItems] = null;
		}
		else
		{
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on remove");
		}
	}
	
	public void removeAll()
	{
		items = (T[]) new Object[3];
		numItems = 0;
	}
	
	public String toString()
	{
		String arrayElements = "";
		
		for(int i = 0; i < numItems; i++)
		{
			arrayElements += items[i] + " ";
		}
		
		return arrayElements;
	}
}
