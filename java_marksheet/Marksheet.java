//Author : Gaurav Amarnani.

//Imported Packages : 
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;


//Getting Input from users : 
class Marksheet extends JFrame 
{
	public JLabel head;
	public JLabel jLabel2;
	public JTextField input;
	public JButton submitButton;  
	
	//Object of Marksheet : 
	DisplayMarksheet dm; 

	//
	public Marksheet() 
	{
		Font f1 = new Font("Comic Sans MS" , 3 , 36);
		Font f2 = new Font("Comic Sans MS" , Font.BOLD , 24);
		head = new JLabel();
		submitButton = new JButton();
		jLabel2 = new JLabel();
		input = new JTextField();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setLocation(new Point(500, 300));

		head.setBackground(Color.BLACK);
		head.setFont(f1); 
		head.setForeground(Color.YELLOW);
		head.setText("Welcome to Results : ");

		submitButton.setBackground(Color.WHITE);
		submitButton.setFont(f2); 
		submitButton.setText("Submit.");
		submitButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				submitButtonActionPerformed(evt);
			}
		});

		jLabel2.setBackground(Color.BLACK);
		jLabel2.setFont(f2); 
		jLabel2.setForeground(Color.YELLOW);
		jLabel2.setText("Enter Enrollment No. ");

		input.setFont(f2); 
		input.setCursor(new Cursor(Cursor.TEXT_CURSOR));

		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.BLACK);

		head.setBounds(40,15,426,60);
		jLabel2.setBounds(110,90,286,40);
		input.setBounds(140,150,200,40);
		submitButton.setBounds(165,215,150,40);

		c.add(head);
		c.add(jLabel2);
		c.add(input);
		c.add(submitButton);

		pack();
	}

	//Displaying Marksheet : 	
	private void submitButtonActionPerformed(ActionEvent evt) 
	{                                             
		String enroll_no = input.getText();
		if(enroll_no.isBlank())
		{
			JOptionPane.showMessageDialog(this , "No Data Enetered.");
		}
		else
		{
			if(!(enroll_no.equals("1800040181") || enroll_no.equals("1800040182") 
			|| enroll_no.equals("1800040183") || enroll_no.equals("1800040184")))
			{
				JOptionPane.showMessageDialog(this , "Entered Data does not exist.");
				input.setText("");                
			}
			else
			{
				dm = new DisplayMarksheet(enroll_no);
			}
		}
	}                                            

	//Main Method : 
	public static void main(String args[]) 
	{
		Marksheet m = new Marksheet();
		m.setVisible(true);
		m.setSize(486,310);
		m.setLocation(500,300);
		m.setTitle("Result Page.");
	}             
}

//Class for Displaying Marksheet : 
class DisplayMarksheet extends JFrame
{
	//Variables : 
	JTable t;
	JLabel uname , upercentage;
    	Object[][] data;

	//Marksheet Info : 
	public DisplayMarksheet(String enroll)
	{	
		//Checking Enrollment no. of User : 	
		setData(enroll);

		//Details of Marksheet : 
		setSize(1300,400);
		setLocation(100,250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Marksheet.");
		setVisible(true);

		//Font and Container Info :         	
		Font f = new Font("Comics Sans MS" , Font.BOLD , 22);
		Container c = this.getContentPane();
		c.setLayout(null);
		
		//Name Info : 
		JLabel lname = new JLabel("Name           : ");
		lname.setFont(f);
		lname.setBounds(20, 20, 200, 30);
		uname.setFont(f);
		uname.setBounds(250, 20, 400, 30);
					
		//Percentage Info : 					
		JLabel lpercentage = new JLabel("Percentage  : ");
		lpercentage.setFont(f);
		lpercentage.setBounds(20, 50, 200, 30);
		upercentage.setFont(f);
		upercentage.setBounds(250, 50, 400, 30);

		//Course Info : 
		JLabel lcourse = new JLabel("Course         : ");
		lcourse.setFont(f);
		lcourse.setBounds(20,80, 200, 30);
		JLabel ucourse = new JLabel("Computer Engineering.");
		ucourse.setFont(f);
		ucourse.setBounds(250,80, 400, 30);

		//Semester Info : 
		JLabel lsemester = new JLabel("Semester     : ");
		lsemester.setFont(f);
		lsemester.setBounds(20,110, 200, 30);
		JLabel usemester = new JLabel("Fourth.");
		usemester.setFont(f);
		usemester.setBounds(250,110, 400, 30);

		//Table Info : 
        	String[] columnNames = {"Title of Course : " , "Max Marks : " , "Obtained Marks : " , "Credit :"};
		DefaultTableModel dtm = new DefaultTableModel(data , columnNames);
        	t = new JTable();
        	t.setModel(dtm);
		t.setRowHeight(30);
		TableColumnModel tcm = t.getColumnModel();
        	tcm.getColumn(0).setPreferredWidth(250);
        	tcm.getColumn(1).setPreferredWidth(250);
        	tcm.getColumn(2).setPreferredWidth(250);
        	tcm.getColumn(3).setPreferredWidth(250);
		t.setEnabled(false);
        	t.setPreferredScrollableViewportSize(new Dimension(1250,150));
        	t.setFillsViewportHeight(true);
		t.setFont(f);
		JScrollPane sp = new JScrollPane(t);
		sp.setEnabled(false);
		sp.setBounds(20, 150, 1250, 173);

		//Adding elements into Marksheet : 
		add(lname);
		add(lpercentage);
		add(lcourse);
		add(lsemester);
		add(uname);
		add(upercentage);
		add(ucourse);
		add(usemester);
		add(sp);
	}

	//Setting User info using Enrollment no. provided by User : 
	public void setData(String enroll)
	{
		if(enroll.equals("1800040181"))
		{
			uname = new JLabel("Guarav Amarnani.");
			upercentage = new JLabel("95.20%.");
			data = new Object[][]
			{
				{"JAVA PROGRAMMING."  , 100 , 95 , 7} ,
				{"SOFTWARE ENGINEERING." , 100,  95, 5},
				{"DATA COMMUNICATION." , 100, 93, 6},
				{"MICROPROCESSORS." , 100, 93, 6},
				{"GUI APP DEVELOPMENT." , 100, 96, 6},
			};
		}
		else if(enroll.equals("1800040182"))
		{
			uname = new JLabel("Archita Sehgal.");
			upercentage = new JLabel("96.13%.");
			data = new Object[][]
			{
				{"JAVA PROGRAMMING."  , 100 , 96 , 7} ,
				{"SOFTWARE ENGINEERING." , 100,  93, 5},
				{"DATA COMMUNICATION." , 100, 95, 6},
				{"MICROPROCESSORS." , 100, 96, 6},
				{"GUI APP DEVELOPMENT." , 100, 97, 6},
			};
		}
		else if(enroll.equals("1800040183"))
		{
			uname = new JLabel("Neha Auti.");
			upercentage = new JLabel("92.40%.");
			data = new Object[][]
			{
				{"JAVA PROGRAMMING."  , 100 , 89 , 7} ,
				{"SOFTWARE ENGINEERING." , 100,  93, 5},
				{"DATA COMMUNICATION." , 100, 90, 6},
				{"MICROPROCESSORS." , 100, 89, 6},
				{"GUI APP DEVELOPMENT." , 100, 94, 6},
			};
		}
		else 
		{
			uname = new JLabel("Komal Aayre.");
			upercentage = new JLabel("95.20%.");
			data = new Object[][]
			{
				{"JAVA PROGRAMMING."  , 100 , 82 , 7} ,
				{"SOFTWARE ENGINEERING." , 100,  79, 5},
				{"DATA COMMUNICATION." , 100, 80, 5},
				{"MICROPROCESSORS." , 100, 85, 8},
				{"GUI APP DEVELOPMENT." , 100, 96, 6},
			};
		}
	}
}