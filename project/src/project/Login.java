package project;
import javax.swing.*;
import java.awt.*;  //USED FOR GETTING COLOR NORTMAL OR RGB
import java.awt.event.*;
import java.sql.*;



public class Login extends JFrame implements ActionListener{
	JButton submit,close,reset;
	JTextField tfusername;
	JPasswordField  tfpassword;
	public Login() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null); //USED TO REMOVE DEFAULT LAYOUT TO PUT TEXT IN THE FRAME /BOX
		
		JLabel lblusername=new JLabel("USERNAME"); //PUTS TEXT IN A VARIABLE TO BE ADDED TO A FRAME 
		lblusername.setBounds(20,20,100,20);//(from left,from top,length,height)
		add(lblusername);  //used to add text to frame
		
	    tfusername=new JTextField();
		 tfusername.setBounds(130, 20, 200,20);
		 add(tfusername);
		
		JLabel password=new JLabel("PASSWORD"); //PUTS TEXT IN A VARIABLE TO BE ADDED TO A FRAME 
		password.setBounds(20,60,100,20);//(from left,from top,length,height)
		add(password); 
		
		tfpassword =new JPasswordField();
		tfpassword.setBounds(130,60,200,20);
		add(tfpassword);
		
		reset=new JButton("RESET");
		reset.setBounds(40, 120, 120, 20);
		reset.addActionListener(this);
		add(reset);
		
		submit=new JButton("SUBMIT");
	    submit.setBounds(200,120,120,20);
	    submit.addActionListener(this);
	    add(submit);
		
	close=new JButton("CLOSE");
	    close.setBounds(120,160,120,20);
	    close.addActionListener(this);
	    add(close);
	    
		setSize(400,250); //(LENGTH,BREATH) OF FRAME
		setLocation(600,250); //POSITION OF FRAME on the screen (CENTRE)
		setVisible(true);//IF THIS IS NOT THERE FRAME DOES NOT APPEAR
	}
	
	
	//ACTION FOR BUTTONS AND SQL CONNETIVIVTY 
public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			String username=tfusername.getText();
			String password = new String(tfpassword.getPassword());
			
			try {
				Conn c=new Conn();
				
				String query="select  * from login  where username='"+username+"'and password='"+password+"'";
				
				ResultSet rs=c.s.executeQuery(query);
				
				if(rs.next()) {
				new Home();
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid USER NAME OR PASSWORD");
					setVisible(false);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==close) {
			setVisible(false);
		}
		else if(ae.getSource() ==reset) {
			tfusername.setText("");
			tfpassword.setText("");
		}
	}
public static void main(String args[]) {
	new Login(); 
		
}
}
