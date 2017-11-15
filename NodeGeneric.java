
public class NodeGeneric<T>
{
	private T item;
	private NodeGeneric<T> next;
	
	public NodeGeneric(T newItem)
	{
		item = newItem;
		next = null;
	}
	
	public NodeGeneric(T newItem, NodeGeneric<T> nextNode)
	{
		item = newItem;
		next = nextNode;
	}
	
	public void setItem(T newItem)
	{
		item = newItem;
	}
	
	public void setNext(NodeGeneric<T> nextNode)
	{
		next = nextNode;
	}
	
	public T getItem()
	{
		return item;
	}
	
	public NodeGeneric<T> getNext()
	{
		return next;
	}
}