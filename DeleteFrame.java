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
		lblDeleteRno=new JLabel("Enter ID of Employee whose data you want Delete:");
		txtDeleteRno=new JTextField(30);
		btnDeleteSave=new JButton("Save");
		btnDeleteBack=new JButton("Back");
		
		
		c.add(lblDeleteRno);
		c.add(txtDeleteRno);
		c.add(btnDeleteSave);
		c.add(btnDeleteBack);
		
		ActionListener a6=(ae)->{
					String rno=txtDeleteRno.getText();
					Employee e=new Employee(rno,null,null,null,null,null);
					DbOperation db=new DbOperation();
					db.deleteEmployee(e);
		};
		btnDeleteSave.addActionListener(a6);
		
		ActionListener a7=(ae)->{
			MainFrame a=new MainFrame();
			dispose();
		};
		btnDeleteBack.addActionListener(a7);
		
		
		setTitle("EmployeeManagementSystem:DeleteFrame");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
