
/**
 * An object that represents a list of EVENT objects.
 * Using LISTNODE objects as a linked-list.
 * @author Yuan-Cheng Tsai
 */

public class EventList 
{
    /** ListNode EVENTS is the head of the list-node holding EVENT objects. */
	private ListNode events;

    /** Constructor for EVENTS. */
	public EventList()
	{
		events = null;
	}

    /** Returns the ListNode EVENTS. */
	public ListNode getE()
	{
		return events;
	}

    /** Adds the event ET to the end of ListNode EVENTS. */
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

    /** Returns the EVENT at the specific index INDEX of ListNode EVENTS. */
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

    /** Removes the EVENT at the specific index INDEX of ListNode EVENTS. */
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
