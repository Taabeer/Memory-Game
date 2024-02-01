public class Node 
{
	private String data;
	private Node next;
	public Node (String d) 
	{
		setData(d);
		next=null;
	}
	public Node getNext()
	{
		return next;
	}
	public void setNext(Node next)
	{
		this.next=next;
	}
	public String getData() 
	{
		return data;
	}
	public void setData(String data) 
	{
		this.data = data;
	}
}
