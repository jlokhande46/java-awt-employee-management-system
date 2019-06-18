import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddFrame extends JFrame
{
	Container c;
	JLabel lblAddID,lblAddName,lblDOB,lblDeptName,lblDeptId,lblSal;
	JTextField txtAddID,txtAddName,txtDOB,txtDeptId,txtDeptName,txtSal;
	JButton btnAddSave,btnAddBack;
	
	public AddFrame()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		lblAddID=new JLabel("Enter EmployeeID:");
		txtAddID=new JTextField(30);
		lblAddName=new JLabel("Enter Employee Name:");
		txtAddName=new JTextField(30);
		lblDOB=new JLabel("Enter Date Of Birth:");
		txtDOB=new JTextField(30);
		lblDeptId=new JLabel("Enter Department Id:");
		txtDeptId=new JTextField(30);
		lblDeptName=new JLabel("Enter Department Name:");
		txtDeptName=new JTextField(30);
		lblSal=new JLabel("Enter Salary:");
		txtSal=new JTextField(30);
		btnAddSave=new JButton("Save");
		btnAddBack=new JButton("Back");
		
		c.add(lblAddID);
		c.add(txtAddID);
		c.add(lblAddName);
		c.add(txtAddName);
		c.add(lblDOB);
		c.add(txtDOB);
		c.add(lblDeptId);
		c.add(txtDeptId);
		c.add(lblDeptName);
		c.add(txtDeptName);
		c.add(lblSal);
		c.add(txtSal);
		c.add(btnAddSave);
		c.add(btnAddBack);
		
		ActionListener a1 =(ae)->{
			String empid=txtAddID.getText();;
			String name=txtAddName.getText();
			String dob=txtDOB.getText();
			String deptid =txtDeptId.getText();
			String dept=txtDeptName.getText();
			String sal=txtSal.getText();
			
			// Employee s=new Employee(empid,name);			
			Employee s=new Employee(empid,name,dob,deptid,dept,sal);
	        DbOperation db=new DbOperation();
			db.addEmployee(s);	
		};
		btnAddSave.addActionListener(a1);
		
		ActionListener a2=(ae)->{
			MainFrame a=new MainFrame();
			dispose();
		};
		btnAddBack.addActionListener(a2);
		
		
		setTitle("EmployeeManagementSystem:AddFrame");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
