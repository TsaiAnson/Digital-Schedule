
public class EventList 
{
	private ListNode events;
	
	public EventList()
	{
		events = null;
	}
	
	public ListNode getE()
	{
		return events;
	}
	
	public void addE(Event et)
	{
		ListNode node = new ListNode (et, null);
		ListNode current, remainder = null;
		
		if (events == null)
			events = node;
		
		else if (((Event) events.getValue()).getDate().compareTo(et.getDate()) > 0)
		{
			events = new ListNode (et, events);
		}
		
		else
		{
			current = events;
			while (current.getNext() != null)
			{
				if (((Event) current.getNext().getValue()).getDate().compareTo(et.getDate()) > 0)
				{
					remainder = current.getNext();
					ListNode node1 = new ListNode(et, remainder);
					current.setNext(node1);
					return;
				}
				current = current.getNext();
			}
			current.setNext(node);
		}
	}
	
	public Event getE(int index)
	{
		ListNode current = events;
		
		if(index == 0)
		{
			return (Event) current.getValue();
		}
		
		while (index > 1)
		{
			current = current.getNext();
			index --;
		}
		return (Event) current.getNext().getValue();
	}
	
	public void delE(int index)
	{
		ListNode current = events;
		
		if(index == 0)
		{
			events = events.getNext();
			return;
		}
		
		while (index > 1)
		{
			current = current.getNext();
			index --;
		}
		current.setNext(current.getNext().getNext());
	}
	
	public String toString()
	{
		String result = "";
		ListNode current = events;
		while (current != null)
		{
			result += ((Event) current.getValue()).getName() + "\n";
			current = current.getNext();
		}
		
		return result;
	}

}
