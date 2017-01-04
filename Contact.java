/**
 * Represents the contact object. Contains a name and a phone number (address).
 * @author Yuan-Cheng Tsai
 */


public class Contact 
{
    /** String NAME that holds the name of the contact. */
	private String name;

    /** String ADDRESS that holds the phone-number of the contact. */
	private String address;

	/** Constructor for Contact object. */
	public Contact(String st)
	{
		name = st;
	}

	/** Returns the string NAME. */
	public String getName()
	{
		return name;
	}

    /** Sets string ADDRESS to the string NUMBER. */
	public void setNumb(String number)
	{
		address = number;
	}

    /** Returns the string ADDRESS. */
	public String getNumb()
	{
		return address;
	}
}
