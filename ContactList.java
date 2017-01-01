
public class ContactList 
{
	private ListNode contacts;
	
	public ContactList()
	{
		contacts = null;
	}
	
	public ListNode getC()
	{
		return contacts;
	}
	
	public void addC(Contact ct)
	{
		ListNode node = new ListNode (ct, null);
		ListNode current, remainder = null;
		
		if (contacts == null)
			contacts = node;
		
		else if (((Contact) contacts.getValue()).getName().compareTo(ct.getName()) > 0)
		{
			contacts = new ListNode (ct, contacts);
		}
		
		else
		{
			current = contacts;
			while (current.getNext() != null)
			{
				if (((Contact) current.getNext().getValue()).getName().compareTo(ct.getName()) > 0)
				{
					remainder = current.getNext();
					ListNode node1 = new ListNode(ct, remainder);
					current.setNext(node1);
					return;
				}
				current = current.getNext();
			}
			current.setNext(node);
		}
	}
	
	public Contact getC(int index)
	{
		ListNode current = contacts;
		
		if(index == 0)
		{
			return (Contact) current.getValue();
		}
		
		while (index > 1)
		{
			current = current.getNext();
			index --;
		}
		return (Contact) current.getNext().getValue();
	}
	
	public void delC(int index)
	{
		ListNode current = contacts;
		
		if(index == 0)
		{
			contacts = contacts.getNext();
			return;
		}
		
		while (index > 1)
		{
			current = current.getNext();
			index --;
		}
		current.setNext(current.getNext().getNext());
	}

}
