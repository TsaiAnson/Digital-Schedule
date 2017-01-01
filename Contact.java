
public class Contact 
{
	private String name;
	private String address;
	
	public Contact(String st)
	{
		name = st;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setNumb(String place)
	{
		address = place;
	}
	
	public String getNumb()
	{
		return address;
	}
}
