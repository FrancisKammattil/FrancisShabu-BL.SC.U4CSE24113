package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class addcustomer extends JFrame implements ActionListener {
	JTextField tfname,tfnationality,tfaddress,tfphone , tfaadhar;
	JRadioButton rbmale, rbfemale;
	public addcustomer(){
	   getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("ADD CUSTOMER DETAILS");
		heading.setBounds(420,20,500,35);
		heading.setFont(new Font("Tahoma",Font.PLAIN,32));
		heading.setForeground(Color.BLUE);
		add(heading);
		
		 //NAME  AND ITS TEXTFIELD 
		JLabel lblname=new JLabel("Name");
		lblname.setBounds(60, 80,150,25);
		lblname.setFont(new Font("Tahoma",Font.PLAIN,32));
		add(lblname);
		
		tfname =new JTextField();
		tfname.setBounds(220,80,150,25);
		add(tfname);

		 //Nationality  AND ITS TEXTFIELD 
		JLabel lblnationality=new JLabel("Nationality");
		lblnationality.setBounds(60, 130,150,25);
		lblnationality.setFont(new Font("Tahoma",Font.PLAIN,32));
		add(lblnationality);
		
	    tfnationality =new JTextField();
		tfnationality.setBounds(220,130,150,25);
		add(tfnationality);
		
		 //Aadhar Number  AND ITS TEXTFIELD 
		JLabel lblaadhar=new JLabel("Aadhar Number");
		lblaadhar.setBounds(60, 180,150,25);
		lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,32));
		add(lblaadhar);
		
	    tfaadhar =new JTextField();
		tfaadhar.setBounds(220,180,150,25);
		add(tfaadhar);
		
		 //Address AND ITS TEXTFIELD 
		JLabel lbladdress=new JLabel("Address");
		lbladdress.setBounds(60, 230,150,25);
		lbladdress.setFont(new Font("Tahoma",Font.PLAIN,32));
		add(lbladdress);
		
	    tfaddress =new JTextField();
		tfaddress.setBounds(220,230,150,25);
		add(tfaddress);
		
		 //Gender AND ITS BUTTON
		JLabel lblgender=new JLabel("Gender");
		lblgender.setBounds(60, 280,150,25);
		lblgender.setFont(new Font("Tahoma",Font.PLAIN,32));
		add(lblgender);
		
		ButtonGroup gendergroup =new ButtonGroup();  //PREVENTS multiple selection of buttons for same use 
		
		rbmale=new JRadioButton("Male");
		rbmale.setBounds(220,280,70,25);
		rbmale.setBackground(Color.WHITE);
		add(rbmale);
		
		 rbfemale=new JRadioButton("Female");
		rbfemale.setBounds(300,280,70,25);
		rbfemale.setBackground(Color.WHITE);
		add(rbfemale);
		
		gendergroup.add(rbmale);
		gendergroup.add(rbfemale);
		
		//PASSWORD AND TextField
		JLabel lblphone=new JLabel("Phone No:");
		lblphone.setBounds(60, 330,150,25);
		lblphone.setFont(new Font("Tahoma",Font.PLAIN,32));
		add(lblphone);
		
		tfphone =new JTextField();
		tfphone.setBounds(220,330,150,25);
		add(tfphone);
		
		JButton save=new JButton("Save");
		save.setBackground(Color.WHITE);
		save.setBounds(220,380,150,30);
		save.setForeground(Color.BLACK);
		save.addActionListener(this);
		add(save);
		
		ImageIcon image =new ImageIcon("C:\\Users\\franc\\Downloads\\emp.png");
	    JLabel lblimage=new JLabel(image);
	    lblimage.setBounds(0,0,1600,800);
	    add(lblimage);
	    
	    
		setSize(900,600);
		setLocation(300,350);
		setVisible(true);
 
    }
   public void actionPerformed(ActionEvent ae ) {
	   String name =tfname.getText();
	   String nationality=tfnationality.getText();
	   String phone=tfphone.getText();
	   String address=tfaddress.getText();
	   String gender=null;
	   String aadhar=tfaddress.getText();
	   if(rbmale.isSelected()) {
		   gender="Male";
	   }
	   else {
		   gender="Female";
	   }
   
   try {
	   Conn conn=new Conn();
	   String query="insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"')";
       
	   conn.s.executeUpdate(query);
	   
	   JOptionPane.showMessageDialog(null,"CUSTOMER DETAILS ADDED SUCESSFULLY");
	   setVisible(false);
	   
	   
	   
   }catch(Exception e) {
	   e.printStackTrace();
	   
   }
   }
	public static void main(String[] args) {
		
        new addcustomer();
	}

}
