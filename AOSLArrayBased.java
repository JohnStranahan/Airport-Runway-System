
public class AOSLArrayBased implements AscendinglyOrderedStringListInterface
{
	private String [] items;
	private int numItems;
	
	public AOSLArrayBased()
	{
		items = new String[3];
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return numItems == 0;
	}
	
	public int size()
	{
		return numItems;
	}
	
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
		}
		
		indexToAddAt = search(item);
		
		if(indexToAddAt < 0)
		{
			indexToAddAt = 0 - (indexToAddAt + 1);
			
			for(int pos = numItems - 1; pos >= indexToAddAt; pos--)
			{
				items[pos + 1] = items[pos];
			}
			
			items[indexToAddAt] = item;
			numItems++;
		}
		else
		{
			throw new ListIndexOutOfBoundsException("\tError adding to the list");
		}
	}
	
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
			}
		}
		
		return (0 - low - 1);
	}

	public void clear() 
	{
		items = new String[3];
		numItems = 0;
	}
	
	public String toString()
	{
		String elements = "";
		
		for(int i = 0; i < numItems; i++)
		{
			elements += items[i] + " ";
		}
		
		return elements;
	}
}
