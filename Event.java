import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Event 
{
	private String name, details;
	private DateFormat dateform = new SimpleDateFormat("MM-dd-yyyy HH:mm");
	private Date date, edate;
	
	public Event(String st)
	{
		name = st;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setDetail(String dt)
	{
		details = dt;
	}
	
	public String getDetails()
	{
		return details;
	}
	
	public void setDate(int year, int month, int day, int hour, int minute) throws ParseException
	{
		date = dateform.parse(""+month+"-"+day+"-"+year+" "+hour+":"+minute+"");
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public void seteDate(int year, int month, int day, int hour, int minute) throws ParseException
	{
		edate = dateform.parse(""+month+"-"+day+"-"+year+" "+hour+":"+minute+"");
	}
	
	public Date geteDate()
	{
		return edate;
	}
	
	public boolean checkDate()
	{
		Date currDate = new Date();
		if (date.compareTo(currDate) < 0)
			return true;
		return false;
	}
}
