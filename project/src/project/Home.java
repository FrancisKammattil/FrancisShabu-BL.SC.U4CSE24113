package project;
import javax.swing.*;
import java.awt.*;  //USED FOR GETTING COLOR NORTMAL OR RGB
import java.awt.event.*;


public class Home extends JFrame implements ActionListener {
	
	
	public Home() {
		
		setLayout(null); //USED TO REMOVE DEFAULT LAYOUT TO PUT TEXT IN THE FRAME /BOX
		ImageIcon il = new ImageIcon("C:\\Users\\franc\\Downloads\\front.jpg");


	    JLabel image=new JLabel(il);
	    image.setBounds(0,0,1600,800);
	    add(image);
	    
	   
	    JLabel heading =new JLabel("Air India Welcomes You");
	    heading.setBounds(500,20,400,40);
		heading.setForeground(Color.blue);
		heading.setFont(new Font("Tahoma",Font.PLAIN,36));
	    image.add(heading);
	    
	    JMenuBar menubar =new JMenuBar();
	    setJMenuBar(menubar);
	    JMenu details=new JMenu("Details");
	    menubar.add(details);
	    
	    JMenuItem flightdetails=new JMenuItem("Flight Details");
	    flightdetails.addActionListener(this);
	    details.add(flightdetails);
	   
	    
	    
	    JMenuItem CustomerDetails=new JMenuItem("Add Customer Details");
	    CustomerDetails.addActionListener(this);
	    details.add(CustomerDetails);
	    
	    
	    JMenuItem bookFlight=new JMenuItem("Book Flight");
	    bookFlight.addActionListener(this);
	    details.add(bookFlight);

	    
	    JMenuItem journeydetails=new JMenuItem("Journey Details");
	    journeydetails.addActionListener(this);
	    details.add(journeydetails);
	
	    
	    JMenuItem ticketcancellation =new JMenuItem("Cancel Ticket");
	    ticketcancellation.addActionListener(this);
	    details.add(ticketcancellation);
	    
	    JMenu ticket=new JMenu("tickets");
	    menubar.add(ticket);
	    JMenuItem boardingPass=new JMenuItem("Boarding Pass");
	    ticket.add(boardingPass);
	    
	    
		setExtendedState(JFrame.MAXIMIZED_BOTH); //(LENGTH,BREATH) OF FRAME
		setLocation(600,250); //POSITION OF FRAME on the screen (CENTRE)
		setVisible(true);//IF THIS IS NOT THERE FRAME DOES NOT APPEAR
	}
	
	
	//ACTION FOR BUTTONS AND SQL CONNETIVIVTY 
public void actionPerformed(ActionEvent ae) {
	String text=ae.getActionCommand();
	if(text.equals("Add Customer Details")) {
		new addcustomer();
		
	}else if(text.equals("Flight Details")) {
		new FlightInfo() ;
	}
	else if(text.equals("Book Flight")) {
        new BookFlight();
}
}


public static void main(String args[]) {
	new Home(); 
		
}
}

