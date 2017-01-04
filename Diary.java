import java.text.ParseException;

/**
 * A Diary object that holds a ContactList and EventList. Also includes a Status for the user.
 * @author Yuan-Cheng Tsai
 */

public class Diary 
{
    /** String STATUS that holds the status of the user. */
	private String status;

    /** ContactList CONTACTS that holds the contacts. */
	private ContactList contacts = new ContactList();

    /** EventList EVENTS that holds the events. */
	private EventList events = new EventList();

    /** Constructor for Diary. */
	public Diary()
	{
		status = "Hello!";
	}

    /** Returns string STATUS. */
	public String getStatus()
	{
		return status;
	}

    /** Sets string STATUS to the given string ST. */
	public void setStatus(String st)
	{
		status = st;
	}

    /** Adds a new CONTACT object from the given string NAME and string NUMB. */
	public void addContact(String name, String numb)
	{
		Contact c1 = new Contact(name);
		c1.setNumb(numb);
		contacts.addC(c1);
	}

    /** Returns the CONTACT at the specific index I of ContactList CONTACTS. */
	public Contact getContact(int i)
	{
		return contacts.getC(i);
	}

    /** Removes the CONTACT at the given specific index I of ContactList CONTACTS. */
	public void delContact(int i)
	{
		contacts.delC(i);
	}

    /** Returns ContactList CONTACTS. */
	public ListNode getContacts()
	{
		return contacts.getC();
	}

    /** Adds an EVENT object to the EventList EVENTS with the given ARGUMENTS. */
	public void addEvent(String name, String remind, int year, int month, int day, int hour, int min, int eyear,
                         int emonth, int eday, int ehour, int emin) throws ParseException
	{
		Event e1 = new Event(name);
		e1.setDate(year, month, day, hour, min);
		e1.seteDate(eyear, emonth, eday, ehour, emin);
		e1.setDetail(remind);
		events.addE(e1);
	}

    /** Returns an EVENT object at the given specific index I of EventList EVENTS. */
	public Event getEvent(int i)
	{
		return events.getE(i);
	}

    /** Removes the EVENT at the given specific index I of EventList EVENTS. */
	public void delEvent(int i)
	{
		events.delE(i);
	}

    /** Returns EventList EVENTS. */
	public ListNode getEvents()
	{
		return events.getE();
	}
}
