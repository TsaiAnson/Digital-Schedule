import java.text.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DiaryGUI 
{
	//Creating Diary
	private Diary d1 = new Diary();
	
	@SuppressWarnings("serial")
	public DiaryGUI() throws ParseException
	{	
		//Creating Some Sample Contacts/Events
		d1.addContact("Bobby","888-888-8888");
		d1.addContact("Samuel", "777-777-7777");
		d1.addContact("C", "777-777-7771");
		d1.addEvent("Finish This Project", "Please Present This Project", 2015, 11, 3, 10, 00, 2015, 11, 3, 10, 30);
		d1.addEvent("Do Laundry", "Throw clothes into washing machine",2015, 11, 05, 15, 00, 2015, 11, 05, 15, 30);
		
		final JFrame DA = new JFrame();//DA stands for Diary
	    DA.setSize(850, 600);
	    DA.setTitle("Digital Schedule");
	    DA.setResizable(false);
	    DA.setLocationRelativeTo(null); //Makes the window appear in the center of the screen
	    
	    JPanel mainP = new JPanel();
	    mainP.setLayout(new GridLayout(7,1));
	    
	    JLabel titleL = new JLabel("~~Digital Schedule~~");
	    titleL.setFont(new Font("Italic", Font.BOLD, 25));
	    
	    JButton eventsB = new JButton("Events");
	    eventsB.setFont(new Font("Arial",Font.BOLD,20));
	    Action acteventsB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
                eventsGUI();
            }
        };
	    eventsB.addActionListener(acteventsB);
        
	    JButton contactsB = new JButton("Contacts");
	    contactsB.setFont(new Font("Arial",Font.BOLD,20));
	    Action actcontactsB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
                contactsGUI();
            }
        };
        contactsB.addActionListener(actcontactsB);
	    
	    JButton exitB = new JButton("Exit");
	    exitB.setFont(new Font("Arial",Font.BOLD,20));
	    Action actexitB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
                DA.setVisible(false);
            }
        };
        exitB.addActionListener(actexitB);
	    
	    mainP.add(titleL);
	    mainP.add(new JLabel(""));
	    mainP.add(eventsB);
	    mainP.add(new JLabel(""));
	    mainP.add(contactsB);
	    mainP.add(new JLabel(""));
	    mainP.add(exitB);
	    
	    JPanel col = new JPanel();
	    col.setLayout(new GridLayout(1, 3));
	    
	    col.add(new JLabel(""));
	    col.add(mainP);
	    col.add(new JLabel(""));
	    
	    DA.add(col);
	    
	    DA.setVisible(true);
	    
	    try 
	    {
	        while (true) 
	        {
	            alert();
	            Thread.sleep(30 * 1000);
	        }
	    } 
	    catch (InterruptedException e) 
	    {
	        e.printStackTrace();
	    }
	}
	
	JTextField CName = new JTextField(); /*I added the text fields here because I needed 
    the text fields to be static in order for the actionListener to be able to grab the text*/
    JTextField CPhone = new JTextField();
    JTextField CRem = new JTextField();
    JTextField EName = new JTextField();
    JTextField ERemind = new JTextField();
    JTextField EDateMonth = new JTextField();
    JTextField EDateDay = new JTextField();
    JTextField EDateYear = new JTextField();
    JTextField EDateHour = new JTextField();
    JTextField EDateMin = new JTextField();
    JTextField EeDateMonth = new JTextField();
    JTextField EeDateDay = new JTextField();
    JTextField EeDateYear = new JTextField();
    JTextField EeDateHour = new JTextField();
    JTextField EeDateMin = new JTextField();
    JTextField ERem = new JTextField();
	
	@SuppressWarnings("serial")
	public void eventsGUI()
	{
		final JFrame EV = new JFrame();
	    EV.setSize(1200, 600);
	    EV.setTitle("Events");
	    EV.setResizable(false);
	    EV.setLocationRelativeTo(null);
		
	    JPanel eventsP = new JPanel();
	    eventsP.setLayout(new GridLayout(1,2));
	    
	    DefaultListModel<String> model = new DefaultListModel<>();
	    ListNode events = d1.getEvents();
	    while (events != null)
	    {
	    	model.addElement("<html>"+((Event) events.getValue()).getName()+"<br> Start:"+((Event) events.getValue()).getDate()+"<br> End:"+((Event) events.getValue()).geteDate()+"</span><html>");
	    	events = events.getNext();
	    }
	    JList<String> eventsL = new JList<>(model);
	    eventsL.setFont(new Font("Arial",Font.BOLD,20));
	    JScrollPane contactsLS = new JScrollPane(eventsL);
	    
	    eventsP.add(contactsLS);
	    
	    JPanel eventsBP = new JPanel();
	    eventsBP.setLayout(new GridLayout(8, 1));
	    
	    JButton addEB = new JButton("Add Event");
	    addEB.setFont(new Font("Arial",Font.BOLD,20));
	    Action actaddEB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
                EV.setVisible(false);
                addEGUI();
            }
        };
        addEB.addActionListener(actaddEB);
	    
        JButton eEB = new JButton("Edit Event");
        eEB.setFont(new Font("Arial",Font.BOLD,20));
        Action acteEB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
                
            	int i = eventsL.getSelectedIndex();
            	
            	if (i != -1)
            	{	
            		EV.setVisible(false);
            		
            		Event e1 = d1.getEvent(i);
                	
                	Date da1 = e1.getDate();
                	
                	Calendar cal = Calendar.getInstance();
                	cal.setTime(da1);
                	int mon = cal.get(Calendar.MONTH)+1;
                	int day = cal.get(Calendar.DAY_OF_MONTH);
                	int yr = cal.get(Calendar.YEAR);
                	int hr = cal.get(Calendar.HOUR_OF_DAY);
                	int min = cal.get(Calendar.MINUTE);
                	
                	Date da2 = e1.geteDate();
                	
                	cal.setTime(da2);
                	int emon = cal.get(Calendar.MONTH)+1;
                	int eday = cal.get(Calendar.DAY_OF_MONTH);
                	int eyr = cal.get(Calendar.YEAR);
                	int ehr = cal.get(Calendar.HOUR_OF_DAY);
                	int emin = cal.get(Calendar.MINUTE);
                	
                	EName.setText(e1.getName());
                	ERemind.setText(e1.getDetails());
                	EDateMonth.setText(""+mon+"");
                	EDateDay.setText(""+day+"");
                	EDateYear.setText(""+yr+"");
                	EDateHour.setText(""+hr+"");
                	EDateMin.setText(""+min+"");
                	EeDateMonth.setText(""+emon+"");
                	EeDateDay.setText(""+eday+"");
                	EeDateYear.setText(""+eyr+"");
                	EeDateHour.setText(""+ehr+"");
                	EeDateMin.setText(""+emin+"");
                	
                	d1.delEvent(i);
                	
                	addEGUI();
            	}
            	
            	//EV.setVisible(false);
                //eEGUI();
            }
        };
        eEB.addActionListener(acteEB);
        
	    JButton delEB = new JButton("Delete Event");
	    delEB.setFont(new Font("Arial",Font.BOLD,20));
	    Action actdelEB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
                
            	if (eventsL.getSelectedIndex() != -1)
            	{
            		EV.setVisible(false);
            		d1.delEvent(eventsL.getSelectedIndex());
            		eventsGUI();
            	}
            }
        };
        delEB.addActionListener(actdelEB);
        
	    JButton exitB = new JButton("Exit");
	    exitB.setFont(new Font("Arial",Font.BOLD,20));
	    Action actexitB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
                EV.setVisible(false);
            }
        };
        exitB.addActionListener(actexitB);
        
        eventsBP.add(new JLabel(""));
        eventsBP.add(addEB);
        eventsBP.add(new JLabel(""));
        eventsBP.add(eEB);
        eventsBP.add(new JLabel(""));
        eventsBP.add(delEB);
        eventsBP.add(new JLabel(""));
        eventsBP.add(exitB);
	    
	    eventsP.add(eventsBP);
	    
	    EV.add(eventsP);
	    
		EV.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	public void addEGUI()
	{
		final JFrame aEV = new JFrame();
	    aEV.setSize(600, 800);
	    aEV.setTitle("Add Event");
	    aEV.setResizable(false);
	    aEV.setLocationRelativeTo(null);
	    
	    JPanel addEP = new JPanel();
	    addEP.setLayout(new GridLayout(18, 1));
		
	    JLabel ENameL = new JLabel("Please enter the event's description/name:");
	    ENameL.setFont(new Font("Arial",Font.BOLD,15));
	    JLabel EDetailL = new JLabel("Please enter the event's reminder:");
	    EDetailL.setFont(new Font("Arial",Font.BOLD,15));
	    ENameL.setFont(new Font("Arial",Font.BOLD,15));
	    JLabel startL = new JLabel("Start Date:");
	    startL.setFont(new Font("Arial",Font.BOLD, 15));
	    JLabel endL = new JLabel("End Date:");
	    endL.setFont(new Font("Arial",Font.BOLD, 15));
		JLabel EDateML = new JLabel("Month:");
		EDateML.setFont(new Font("Arial",Font.BOLD,15));
		JLabel EDateDL = new JLabel("Day:");
		EDateDL.setFont(new Font("Arial",Font.BOLD,15));
		JLabel EDateYL = new JLabel("Year:");
		EDateYL.setFont(new Font("Arial",Font.BOLD,15));
		JLabel EDateHL = new JLabel("Hour:");
		EDateHL.setFont(new Font("Arial",Font.BOLD,15));
		JLabel EDateMiL = new JLabel("Min:");
		EDateMiL.setFont(new Font("Arial",Font.BOLD,15));
		JLabel EeDateML = new JLabel("Month:");
		EeDateML.setFont(new Font("Arial",Font.BOLD,15));
		JLabel EeDateDL = new JLabel("Day:");
		EeDateDL.setFont(new Font("Arial",Font.BOLD,15));
		JLabel EeDateYL = new JLabel("Year:");
		EeDateYL.setFont(new Font("Arial",Font.BOLD,15));
		JLabel EeDateHL = new JLabel("Hour:");
		EeDateHL.setFont(new Font("Arial",Font.BOLD,15));
		JLabel EeDateMiL = new JLabel("Min:");
		EeDateMiL.setFont(new Font("Arial",Font.BOLD,15));
		
		JButton doneB = new JButton("Done");
		doneB.setFont(new Font("Arial",Font.BOLD,20));
		Action actdoneB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
            	aEV.setVisible(false);

            	String nm = EName.getText();
            	String rm = ERemind.getText();
            	int mon = Integer.parseInt(EDateMonth.getText());
            	int day = Integer.parseInt(EDateDay.getText());
            	int yr = Integer.parseInt(EDateYear.getText());
            	int hr = Integer.parseInt(EDateHour.getText());
            	int min = Integer.parseInt(EDateMin.getText());
            	int emon = Integer.parseInt(EeDateMonth.getText());
            	int eday = Integer.parseInt(EeDateDay.getText());
            	int eyr = Integer.parseInt(EeDateYear.getText());
            	int ehr = Integer.parseInt(EeDateHour.getText());
            	int emin = Integer.parseInt(EeDateMin.getText());
            	
            	EName.setText("");
            	ERemind.setText("");
            	
            	EDateMonth.setText("");
            	EDateDay.setText("");
            	EDateYear.setText("");
            	EDateHour.setText("");
            	EDateMin.setText("");
            	
            	EeDateMonth.setText("");
            	EeDateDay.setText("");
            	EeDateYear.setText("");
            	EeDateHour.setText("");
            	EeDateMin.setText("");
            	
            	try {
					d1.addEvent(nm, rm, yr, mon, day, hr, min, eyr, emon, eday, ehr, emin);
				} catch (ParseException e) {
					e.printStackTrace();
				}
            	
            	eventsGUI();
            }
        };
        doneB.addActionListener(actdoneB);
		
        JPanel dateP = new JPanel();
        dateP.setLayout(new GridLayout(1, 6));
        dateP.add(EDateML);
        dateP.add(EDateMonth);
        dateP.add(EDateDL);
        dateP.add(EDateDay);
        dateP.add(EDateYL);
        dateP.add(EDateYear);
        
        JPanel timeP = new JPanel();
        timeP.setLayout(new GridLayout(1,4));
        timeP.add(EDateHL);
        timeP.add(EDateHour);
        timeP.add(EDateMiL);
        timeP.add(EDateMin);
        
        JPanel edateP = new JPanel();
        edateP.setLayout(new GridLayout(1, 6));
        edateP.add(EeDateML);
        edateP.add(EeDateMonth);
        edateP.add(EeDateDL);
        edateP.add(EeDateDay);
        edateP.add(EeDateYL);
        edateP.add(EeDateYear);
        
        JPanel etimeP = new JPanel();
        etimeP.setLayout(new GridLayout(1,4));
        etimeP.add(EeDateHL);
        etimeP.add(EeDateHour);
        etimeP.add(EeDateMiL);
        etimeP.add(EeDateMin);
        
		addEP.add(ENameL);
		addEP.add(EName);
		addEP.add(EDetailL);
		addEP.add(ERemind);
		addEP.add(startL);
	    addEP.add(dateP);
	    addEP.add(timeP);
	    addEP.add(endL);
	    addEP.add(edateP);
	    addEP.add(etimeP);
	    addEP.add(new JLabel(""));
	    addEP.add(new JLabel(""));
	    addEP.add(doneB);
	    
	    aEV.add(addEP);
	    
	    aEV.setVisible(true);
	}
	
	
	
	@SuppressWarnings("serial")
	public void contactsGUI()
	{
		final JFrame CT = new JFrame();
	    CT.setSize(800, 400);
	    CT.setTitle("Contacts");
	    CT.setResizable(false);
	    CT.setLocationRelativeTo(null);
	    
	    JPanel contactsP = new JPanel();
	    contactsP.setLayout(new GridLayout(1,2));
	    
	    DefaultListModel<String> model = new DefaultListModel<>();
	    ListNode contacts = d1.getContacts();
	    while (contacts != null)
	    {
	    	model.addElement("<html>"+((Contact) contacts.getValue()).getName()+"<br>"+((Contact) contacts.getValue()).getNumb()+"</span><html>");
	    	contacts = contacts.getNext();
	    }
	    JList<String> contactsL = new JList<>(model);
	    contactsL.setFont(new Font("Arial",Font.BOLD,20));
	    JScrollPane contactsLS = new JScrollPane(contactsL);
	    
	    contactsP.add(contactsLS);
	    
	    JPanel contactsBP = new JPanel();
	    contactsBP.setLayout(new GridLayout(8, 1));
	    
	    JButton addCB = new JButton("Add Contact");
	    addCB.setFont(new Font("Arial",Font.BOLD,20));
	    Action actaddCB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
                CT.setVisible(false);
                addCGUI();
            }
        };
        addCB.addActionListener(actaddCB);
	    
        JButton eCB = new JButton("Edit Contact");
        eCB.setFont(new Font("Arial",Font.BOLD,20));
        Action acteCB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
                
            	int i = contactsL.getSelectedIndex();
            	
            	if (i != -1)
            	{
            		CT.setVisible(false);
            		Contact c1 = d1.getContact(i);
            		CName.setText(c1.getName());
            		CPhone.setText(c1.getNumb());
            		d1.delContact(i);
            		addCGUI();
            	}
            }
        };
        eCB.addActionListener(acteCB);
        
	    JButton delCB = new JButton("Delete Contact");
	    delCB.setFont(new Font("Arial",Font.BOLD,20));
	    Action actdelCB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
                
                int i = contactsL.getSelectedIndex();
                
                if (i != -1)
                {
                	CT.setVisible(false);
                	d1.delContact(i);
                	contactsGUI();
                }
                
            }
        };
        delCB.addActionListener(actdelCB);
        
	    JButton exitB = new JButton("Exit");
	    exitB.setFont(new Font("Arial",Font.BOLD,20));
	    Action actexitB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
                CT.setVisible(false);
            }
        };
        exitB.addActionListener(actexitB);
        
        contactsBP.add(new JLabel(""));
        contactsBP.add(addCB);
        contactsBP.add(new JLabel(""));
        contactsBP.add(eCB);
        contactsBP.add(new JLabel(""));
        contactsBP.add(delCB);
        contactsBP.add(new JLabel(""));
        contactsBP.add(exitB);
	    
	    contactsP.add(contactsBP);
	    
	    CT.add(contactsP);
	    
		CT.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	public void addCGUI()
	{
		final JFrame aCT = new JFrame();
		aCT.setSize(400, 400);
		aCT.setTitle("Add Contact");
		aCT.setResizable(false);
		aCT.setLocationRelativeTo(null);
	    
	    JPanel addCP = new JPanel();
	    addCP.setLayout(new GridLayout(8, 1));
		
		JLabel CNameL = new JLabel("Please enter the contact's name:");	
		CNameL.setFont(new Font("Arial",Font.BOLD,15));
		JLabel CPhoneL = new JLabel("Please enter the contact's phone number:");
		CPhoneL.setFont(new Font("Arial",Font.BOLD,15));
		
		JButton doneB = new JButton("Done");
		doneB.setFont(new Font("Arial",Font.BOLD,20));
		Action actdoneB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
            	aCT.setVisible(false);
            	
            	String nm = CName.getText();
            	String nb = CPhone.getText();
            	CName.setText("");
            	CPhone.setText("");
            	
            	d1.addContact(nm, nb);
            	
            	contactsGUI();
            }
        };
        doneB.addActionListener(actdoneB);
		
		addCP.add(CNameL);
	    addCP.add(CName);
	    addCP.add(CPhoneL);
	    addCP.add(CPhone);
	    addCP.add(new JLabel(""));
	    addCP.add(doneB);
	    
	    aCT.add(addCP);
	    
	    aCT.setVisible(true);
	}
	
		public void alert()
	{
		Event e1 = (Event) d1.getEvents().getValue();
		
		if (e1.checkDate())
		{
			alertGUI(e1);
		}
	}
	
	@SuppressWarnings("serial")
	public void alertGUI(Event e1)
	{
		final JFrame AL = new JFrame();
	    AL.setSize(400, 400);
	    AL.setTitle("Reminder");
	    AL.setResizable(false);
	    AL.setLocationRelativeTo(null);
	    
	    JPanel ALP = new JPanel();
	    ALP.setLayout(new GridLayout(8, 1));
		
		JButton doneB = new JButton("Snooze");
		doneB.setFont(new Font("Arial",Font.BOLD,20));
		Action actdoneB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
            	AL.setVisible(false);
            }
        };
        doneB.addActionListener(actdoneB);
		
        JButton delB = new JButton("Finish");
		delB.setFont(new Font("Arial",Font.BOLD,20));
		Action actdelB = new AbstractAction(){ //This is what is going to happen if the button is pressed
            public void actionPerformed(ActionEvent evt){
            	AL.setVisible(false);
            	
            	d1.delEvent(0);
            }
        };
        delB.addActionListener(actdelB);
        
        JPanel DC = new JPanel();
        DC.setLayout(new GridLayout(1, 2));
        DC.add(doneB);
        DC.add(delB);
        
        JLabel ex = new JLabel("The following event has expired:");
        ex.setFont(new Font("Arial",Font.BOLD,20));
        JLabel nm = new JLabel(e1.getName());
        nm.setFont(new Font("Arial",Font.BOLD,20));
        JLabel dt = new JLabel("Details:");
        dt.setFont(new Font("Arial",Font.BOLD,20));
        JLabel rm = new JLabel(e1.getDetails());
        rm.setFont(new Font("Arial",Font.BOLD,20));
        
		ALP.add(ex);
		ALP.add(nm);
		ALP.add(dt);
		ALP.add(rm);
		ALP.add(new JLabel(""));
		ALP.add(new JLabel(""));
		ALP.add(DC);
		
		AL.add(ALP);
		
		AL.setVisible(true);
	}
	
}