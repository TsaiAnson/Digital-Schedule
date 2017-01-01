import java.text.ParseException;

public class Diary 
{
	private String status;
	private ContactList contacts = new ContactList();
	private EventList events = new EventList();
	
	public Diary()
	{
		status = "Hello!";
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String st)
	{
		status = st;
	}
	
	public void addContact(String name, String numb)
	{
		Contact c1 = new Contact(name);
		c1.setNumb(numb);
		contacts.addC(c1);
	}
	
	public Contact getContact(int i)
	{
		return contacts.getC(i);
	}
	
	public void delContact(int i)
	{
		contacts.delC(i);
	}
	
	public ListNode getContacts()
	{
		return contacts.getC();
	}
	
	public void addEvent(String name, String remind, int year, int month, int day, int hour, int min, int eyear, int emonth, int eday, int ehour, int emin) throws ParseException
	{
		Event e1 = new Event(name);
		e1.setDate(year, month, day, hour, min);
		e1.seteDate(eyear, emonth, eday, ehour, emin);
		e1.setDetail(remind);
		events.addE(e1);
	}
	
	public Event getEvent(int i)
	{
		return events.getE(i);
	}
	
	public void delEvent(int i)
	{
		events.delE(i);
	}
	
	public ListNode getEvents()
	{
		return events.getE();
	}
}
