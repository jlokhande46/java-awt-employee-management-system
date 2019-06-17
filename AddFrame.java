import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddFrame extends JFrame
{
	Container c;
	JLabel lblAddRno,lblAddName;
	JTextField txtAddRno,txtAddName;
	JButton btnAddSave,btnAddBack;
	
	public AddFrame()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		lblAddRno=new JLabel("Enter RollNo:");
		txtAddRno=new JTextField(30);
		lblAddName=new JLabel("Enter Student Name:");
		txtAddName=new JTextField(30);
		btnAddSave=new JButton("Save");
		btnAddBack=new JButton("Back");
		
		c.add(lblAddRno);
		c.add(txtAddRno);
		c.add(lblAddName);
		c.add(txtAddName);
		c.add(btnAddSave);
		c.add(btnAddBack);
		
		ActionListener a1 =(ae)->{
			String rno=txtAddRno.getText();;
			String name=txtAddName.getText();
			
			Student s=new Student(Integer.parseInt(rno),name);
			DbOperation db=new DbOperation();
			db.addStudent(s);
				
		};
		btnAddSave.addActionListener(a1);
		
		ActionListener a2=(ae)->{
			MainFrame a=new MainFrame();
			dispose();
		};
		btnAddBack.addActionListener(a2);
		
		
		setTitle("StudentManagementSystem:AddFrame");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}