import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class UploadFrame extends JFrame
{
	Container c;
	JLabel lblUploadRno,lblUploadName;
	JTextField txtUploadRno,txtUploadName;
	JButton btnUploadSave,btnUploadBack;
	
	public UploadFrame()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		lblUploadRno=new JLabel("Enter ID of Student whose data use want change:");
		txtUploadRno=new JTextField(30);
		lblUploadName=new JLabel("Enter Name:");
		txtUploadName=new JTextField(30);
		btnUploadSave=new JButton("Save");
		btnUploadBack=new JButton("Back");
		
		
		c.add(lblUploadRno);
		c.add(txtUploadRno);
		c.add(lblUploadName);
		c.add(txtUploadName);
		c.add(btnUploadSave);
		c.add(btnUploadBack);
		
		ActionListener a4=(ae)->{
					String rno=txtUploadRno.getText();;
					String name=txtUploadName.getText();
					Student s=new Student(Integer.parseInt(rno),name);
					DbOperation db=new DbOperation();
					db.updateStudent(s);
			
		};
		btnUploadSave.addActionListener(a4);
		
		ActionListener a5=(ae)->{
			MainFrame a=new MainFrame();
			dispose();
		};
		btnUploadBack.addActionListener(a5);
		
		
		setTitle("StudentManagementSystem:UploadFrame");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}