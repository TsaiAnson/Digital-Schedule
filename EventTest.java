import java.text.ParseException;

public class EventTest 
{
	public static void main(String[] args) throws ParseException
	{
		EventList el1 = new EventList();
		Event e1 = new Event("Hello");
		e1.setDate(2015, 12, 2, 6, 20);
		Event e2 = new Event("My");
		e2.setDate(2015, 12, 2, 6, 30);
		Event e3 = new Event("Name");
		e3.setDate(2015, 12, 2, 6, 40);
		Event e4 = new Event("Is");
		e4.setDate(2015, 12, 2, 6, 50);
		Event e5 = new Event("Bob");
		e5.setDate(2015, 12, 2, 7, 00);
		el1.addE(e5);
		el1.addE(e1);
		el1.addE(e3);
		el1.addE(e2);
		el1.addE(e4);
		System.out.println(el1);
	}
}
