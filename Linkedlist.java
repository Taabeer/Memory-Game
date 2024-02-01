public class Linkedlist 
{
	public Node head;
	public Node tail;
	public Node current;
	public String data;
	public Linkedlist insert(Linkedlist list, String data)
    {
        Node newNode = new Node(data);
        if (this.head == null) 
        {
            this.head = newNode;
            this.tail=newNode;
        }
        else 
        {
            tail.setNext(newNode);
            this.tail=newNode;
        }
        return list;
    }	
	public String toString(Linkedlist list) 
	{
		String linkedlist=null;
		Node temporarypointer=new Node (null);
		temporarypointer=this.head;
		while (temporarypointer!=null)
        {
        	data= temporarypointer.getData();
        	if (linkedlist==null)
        	{
        		linkedlist=data;
        	}
        	else 
        	{
        		linkedlist= linkedlist+"\n"+data;
        	}
        	temporarypointer=temporarypointer.getNext();
        }
		temporarypointer=this.head;
		return linkedlist;

	}
	public int length(Linkedlist list) 
	{
		int pointer=0;
		Node temporarypointer=new Node (null);
		temporarypointer=this.head;
		while (temporarypointer!=null) 
		{
			pointer++;
			temporarypointer=temporarypointer.getNext();
		}
		temporarypointer=this.head;
		return pointer; 
	}
	public boolean isEmpty(Linkedlist list) 
	{
		int length= this.length(list);
		boolean empty=false;
		if (length==0) 
		{
			empty=true;
		}
		return empty;
	}
	public String positionfinder(Linkedlist list, int position) 
	{
		String founddata = null;
		Node temporarypointer=new Node (null);
		temporarypointer=this.head;
		int length=this.length(list);
		for (int x=0;x<length;x++)
		{
			data=temporarypointer.getData();
			if (position==x) 
			{
				founddata=data; 
			}
			else 
			{
				temporarypointer=temporarypointer.getNext();
			}
		}
		temporarypointer=this.head;
		return founddata;
	}
	public boolean duplicateCheck(Linkedlist list,String data) 
	{
		boolean duplicate=false;
		Node temporarypointer=new Node (null);
		temporarypointer=this.head;
		int length=this.length(list);
		for (int x=0;x<length;x++)
		{
			String currData=temporarypointer.getData();
			if (currData.equals(data)) 
			{
				duplicate=true;
			}
			else 
			{
				temporarypointer=temporarypointer.getNext();
			}
		}
		temporarypointer=this.head;
		return duplicate;
	}
	public Linkedlist editinsertion(Linkedlist list,String data, int position)
	{
			Node newNode = new Node(data);
			if (position==0) 
			{
				this.head=newNode;
			}
			else if (position==list.length(list)-1)
			{
				tail.setNext(newNode);
	            this.tail=newNode;
			}
			else 
			{
				int listlength= list.length(list);
				this.current=this.head;
				for (int x=0;x<listlength;x++)
				{
					
					if (x==position) 
					{
						this.current.setData(data);
					}
					else 
					{
						this.current=current.getNext();
					}
					
					}
				}
			
		this.current=this.head;
		return list;
	}
}
