import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class DeleteFrame extends JFrame
{
	Container c;
	JLabel lblDeleteRno;
	JTextField txtDeleteRno;
	JButton btnDeleteSave,btnDeleteBack;
	
	public DeleteFrame()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		lblDeleteRno=new JLabel("Enter ID of Student whose data use want Delete:");
		txtDeleteRno=new JTextField(30);
		btnDeleteSave=new JButton("Save");
		btnDeleteBack=new JButton("Back");
		
		
		c.add(lblDeleteRno);
		c.add(txtDeleteRno);
		c.add(btnDeleteSave);
		c.add(btnDeleteBack);
		
		ActionListener a6=(ae)->{
					String rno=txtDeleteRno.getText();
					//String name=txtAddName.getText();
					Student s=new Student(Integer.parseInt(rno),null);
					DbOperation db=new DbOperation();
					db.deleteStudent(s);

			
			
		};
		btnDeleteSave.addActionListener(a6);
		
		ActionListener a7=(ae)->{
			MainFrame a=new MainFrame();
			dispose();
		};
		btnDeleteBack.addActionListener(a7);
		
		
		setTitle("StudentManagementSystem:DeleteFrame");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}