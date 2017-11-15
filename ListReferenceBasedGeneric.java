
public class ListReferenceBasedGeneric<T> implements ListInterfaceGeneric<T>
{
	private NodeGeneric<T> head;
	
	public ListReferenceBasedGeneric()
	{
		head = null;
	}
	
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	public int size()
	{
		int size = 0;
		
		NodeGeneric<T> currentNode = head;
		
		while(currentNode != null)
		{
			currentNode = currentNode.getNext();
			size++;
		}
		
		return size;
	}
	
	private NodeGeneric<T> find(int index)
	{
		NodeGeneric<T> curr = head;
		
		for(int skip = 0; skip < index; skip++)
		{
			curr = curr.getNext();
		}
		
		return curr;
	}
	
	public T get(int index) throws ListIndexOutOfBoundsException
	{
		if(index >= 0 && index < size())
		{
			NodeGeneric<T> curr = find(index);
			T dataItem = curr.getItem();
			return dataItem;
		}
		else
		{
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on get");
		}
	}
	
	public void add(int index, T item) throws ListIndexOutOfBoundsException
	{
		if(index >= 0 && index < size() + 1)
		{
			if(index == 0)
			{
				NodeGeneric<T> newNode = new NodeGeneric<T>(item, head);
				
				head = newNode;
			}
			else
			{
				NodeGeneric<T> prev = find(index - 1);
				
				NodeGeneric<T> newNode = new NodeGeneric<T>(item, prev.getNext());
				
				prev.setNext(newNode);
			}
		}
		else
		{
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on add");
		}
	}
	
	public void remove(int index) throws ListIndexOutOfBoundsException
	{
		if(index >= 0 && index < size())
		{
			if(index == 0)
			{
				head = head.getNext();
			}
			else
			{
				NodeGeneric<T> prev = find(index - 1);
				NodeGeneric<T> curr = prev.getNext();
				prev.setNext(curr.getNext());
			}
		}
		else
		{
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on remove");
		}
	}
	
	public void removeAll()
	{
		head = null;
	}
	
	public String toString()
	{
		String listElements = "";
	      
	      NodeGeneric<T> tempNode = head;
	      
	      while(tempNode != null)
	      {
	          listElements += (tempNode.getItem() + " ");
	          tempNode = tempNode.getNext();
	      } // END WHILE
	      
	      return listElements;
	}
}
