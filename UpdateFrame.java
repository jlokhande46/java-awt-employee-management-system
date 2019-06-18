import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class UpdateFrame extends JFrame
{
	Container c;
	JLabel lblUpdateRno,lblUpdateName,lblUpdateDOB,lblUpdateDept,lblUpdateSal,lblUpdateDeptId;
	JTextField txtUpdateRno,txtUpdateName,txtUpdateDOB,txtUpdateDept,txtUpdateSal,txtUpdateDeptId;
	JButton btnUpdateSave,btnUpdateBack;
	
	public UpdateFrame()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		lblUpdateRno=new JLabel("Enter ID of Employee whose data use want change:");
		txtUpdateRno=new JTextField(30);
		lblUpdateName=new JLabel("Enter Employee Name:");
		txtUpdateName=new JTextField(30);
		lblUpdateDOB=new JLabel("Enter Date of Birth:");
		txtUpdateDOB=new JTextField(30);
		lblUpdateDeptId=new JLabel("Enter Department Id:");
		txtUpdateDeptId=new JTextField(30);
		lblUpdateDept=new JLabel("Enter Department Name:");
		txtUpdateDept=new JTextField(30);
		lblUpdateSal=new JLabel("Enter Salary:");
		txtUpdateSal=new JTextField(30);
		btnUpdateSave=new JButton("Save");
		btnUpdateBack=new JButton("Back");
		
		
		c.add(lblUpdateRno);
		c.add(txtUpdateRno);
		c.add(lblUpdateName);
		c.add(txtUpdateName);
		c.add(lblUpdateDOB);
		c.add(txtUpdateDOB);
		c.add(lblUpdateDeptId);
		c.add(txtUpdateDeptId);
		c.add(lblUpdateDept);
		c.add(txtUpdateDept);
		c.add(lblUpdateSal);
		c.add(txtUpdateSal);
		c.add(btnUpdateSave);
		c.add(btnUpdateBack);
		
		ActionListener a4=(ae)->{
					String empid=txtUpdateRno.getText();;
					String name=txtUpdateName.getText();
					String dob =txtUpdateDOB.getText();
					String deptid =txtUpdateDeptId.getText();
					String deptname =txtUpdateDept.getText();
					String sal =txtUpdateSal.getText();
					Employee emp = new Employee(empid,name,dob,deptid,deptname,sal);
					DbOperation db=new DbOperation();
					db.updateEmployee(emp);
			
		};
		btnUpdateSave.addActionListener(a4);
		
		ActionListener a5=(ae)->{
			MainFrame a=new MainFrame();
			dispose();
		};
		btnUpdateBack.addActionListener(a5);
		
		
		setTitle("EmployeeManagementSystem:UpdateFrame");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
