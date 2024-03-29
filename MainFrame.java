import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainFrame extends JFrame
{
	Container c;
	JButton btnAdd,btnView,btnUpload,btnDelete;
	
	public MainFrame()
	{
		c=getContentPane();
		c.setLayout(null);
		btnAdd=new JButton("Add");
		btnView=new JButton("View");
		btnUpload=new JButton("Update");
		btnDelete=new JButton("Delete");
		
		btnAdd.setBounds(85,120,95,30);
		btnView.setBounds(85,170,95,30);
		btnUpload.setBounds(210,120,95,30);
		btnDelete.setBounds(210,170,95,30);
		c.add(btnAdd);
		c.add(btnView);
		c.add(btnUpload);
		c.add(btnDelete);
		
		ActionListener a1=(ae)->{
			AddFrame a=new AddFrame();
			dispose();
		};
		btnAdd.addActionListener(a1);
		
		ActionListener a2=(ae)->{
			ViewFrame a=new ViewFrame();
			dispose();
		};
		btnView.addActionListener(a2);
		
		ActionListener a3=(ae)->{
			UpdateFrame a=new UpdateFrame();
			dispose();
		};
		btnUpload.addActionListener(a3);
		
		ActionListener a4=(ae)->{
			DeleteFrame a=new DeleteFrame();
			dispose();
		};
		btnDelete.addActionListener(a4);
		
		setTitle("EmployeeManagementSystem");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main (String args[])
	{
		MainFrame m =new MainFrame();
	}
}
class Employee
{
	private String empid;
	private String name;
	private String dob;
	private String deptid;
	private String deptname;
	private String salary;
	
	// public Employee()
	// {
	// }
	public Employee(String empid,String name, String dob, String deptid, String deptname, String salary)
	{
		this.empid=empid;
		this.name=name;
		this.dob=dob;
		this.deptid=deptid;
		this.deptname=deptname;
		this.salary=salary;
	}
	public String getempid()
	{
		return empid;
	}
	public void setempid(String empid)
	{
		this.empid=empid;
	}
	public String getname()
	{
		return name;
	}
	public void setname(String name)
	{
		this.name=name;
	}
		public String getdob()
	{
		return dob;
	}
	public void setdob(String dob)
	{
		this.dob=dob;
	}
		public String getdeptid()
	{
		return deptid;
	}
	public void setdeptid(String deptid)
	{
		this.deptid=deptid;
	}
		public String getdeptname()
	{
		return deptname;
	}
	public void setdeptname(String deptname)
	{
		this.deptname=deptname;
	}
		public String getsalary()
	{
		return salary;
	}
	public void setsalary(String salary)
	{
		this.salary=salary;
	}
}
class DbOperation
{
	public void addEmployee(Employee emp)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			String s1="insert into employee values(?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(s1);
			String empid=emp.getempid();
			String name=emp.getname();
			String dob=emp.getdob();
			String deptid=emp.getdeptid();
			String deptname=emp.getdeptname();
			String salary=emp.getsalary();
			pst.setString(1,empid);
			pst.setString(2,name);
			pst.setString(3,dob);
			pst.setString(4,deptid);
			pst.setString(5,deptname);
			pst.setString(6,salary);
			int r=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+"record inserted");
			pst.close();
			con.close();
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),"Insert Issues:"+e);
			System.out.println(e);
		}
	}
	
	public String viewEmployee()
	{
		StringBuffer sb=new StringBuffer();
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			String s1="select * from employee";
			Statement s2=con.createStatement();
			ResultSet rs=s2.executeQuery(s1);
			while(rs.next())
			{
				String empid=rs.getString(1);
				String name=rs.getString(2);
				String dob =rs.getString(3);
				String deptid =rs.getString(4);
				String deptname =rs.getString(5);
				String sal =rs.getString(6);
				sb.append("Empid: "+empid+" Name: "+name+" Deptid: "+deptid+" Salary: "+sal+"\n");
			}
			rs.close();
			s2.close();
			con.close();
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),"Insert Issues:"+e);
		}
		return sb.toString();	
	}
	
	public void updateEmployee(Employee emp)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			String s1="update employee set name=?,dob=?,deptid=?,deptname=?,sal=? where empid=?";
			PreparedStatement pst=con.prepareStatement(s1);
			String empid=emp.getempid();
			String name=emp.getname();
			String dob=emp.getdob();
			String deptid=emp.getdeptid();
			String deptname=emp.getdeptname();
			String sal=emp.getsalary();
			pst.setString(1,name);
			pst.setString(2,dob);
			pst.setString(3,deptid);
			pst.setString(4,deptname);
			pst.setString(5,sal);
			pst.setString(6,empid);
			int r=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+"record updated");
			pst.close();
			con.close();
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),"Update Issues:"+e);
		}
	}
	
	public void deleteEmployee(Employee emp)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			String s1="delete from employee where empid=?";
			PreparedStatement pst=con.prepareStatement(s1);
			String empid=emp.getempid();
			pst.setString(1,empid);
			int r=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+"record deleted");
			pst.close();
			con.close();
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),"Delete Issues:"+e);
		}
	}
}