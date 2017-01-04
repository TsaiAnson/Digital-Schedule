import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Represents the EVENT object.
 * @author Yuan-Cheng Tsai
 */

public class Event 
{
    /** String NAME and DETAILS that holds the name and details of the event. */
	private String name, details;

    /** DateFormat DATEFORM that sets the date-format MM-dd-yyyy HH:mm. */
	private DateFormat dateform = new SimpleDateFormat("MM-dd-yyyy HH:mm");

    /** Date DATE and EDATE that holds the date boundaries for the event. */
	private Date date, edate;

    /** Constructor for the EVENT object. */
	public Event(String st)
	{
		name = st;
	}

    /** Returns the string NAME. */
	public String getName()
	{
		return name;
	}

    /** Sets string DETAILS with the given string DT. */
	public void setDetail(String dt)
	{
		details = dt;
	}

    /** Returns the string DETAILS. */
	public String getDetails()
	{
		return details;
	}

    /** Sets the first date boundary to the given PARAMETERS. */
	public void setDate(int year, int month, int day, int hour, int minute) throws ParseException
	{
		date = dateform.parse(""+month+"-"+day+"-"+year+" "+hour+":"+minute+"");
	}

    /** Returns the first date boundary. */
	public Date getDate()
	{
		return date;
	}

    /** Sets the second date boundary to the given PARAMETERS. */
	public void seteDate(int year, int month, int day, int hour, int minute) throws ParseException
	{
		edate = dateform.parse(""+month+"-"+day+"-"+year+" "+hour+":"+minute+"");
	}

    /** Returns the second date boundary. */
	public Date geteDate()
	{
		return edate;
	}

    /** Checks if current date of the system is after the first date boundary and returns TRUE if so. */
	public boolean checkDate()
	{
		Date currDate = new Date();
		if (date.compareTo(currDate) < 0)
			return true;
		return false;
	}
}
