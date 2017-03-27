/**
 * An object that represents a list of CONTACTS. Uses LISTNODE objects as a linked-list.
 * @author Yuan-Cheng Tsai
 */


public class ContactList 
{
	/** ListNode CONTACTS is the head of the linked-list that holds CONTACT objects. */
	private ListNode contacts;

	/** Constructor for ContactList. */
	public ContactList()
	{
		contacts = null;
	}

	/** Returns ListNode CONTACTS. */
	public ListNode getC()
	{
		return contacts;
	}

	/** Adds contact CT to ListNode CONTACTS. */
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

	/** Returns the CONTACT object at the specified INDEX of the ListNode CONTACTS. */
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

	/** Removes the CONTACT object at the specified INDEX of the ListNode CONTACTS. */
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
