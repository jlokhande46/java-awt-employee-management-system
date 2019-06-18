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
		c.setLayout(new FlowLayout());
		btnAdd=new JButton("Add");
		btnView=new JButton("View");
		btnUpload=new JButton("Upload");
		btnDelete=new JButton("Delete");
		
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
			UploadFrame a=new UploadFrame();
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
	private int Empid;
	private String name;
	
	public Employee()
	{
	}
	public Student(int Empid,String name)
	{
		this.Empid=Empid;
		this.name=name;
	}
	public int getEmpid()
	{
		return Empid;
	}
	public String getName()
	{
		return name;
	}
	public void setEmpid(int Empid)
	{
		this.Empid=Empid;
	}
	public void setName(String name)
	{
		this.name=name;
	}
}
class DbOperation
{
	public void addEmployee(Employee e)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			String s1="insert into student values(?,?)";
			PreparedStatement pst=con.prepareStatement(s1);
			int empid=s.getEmpid();
			String name=s.getName();
			pst.setInt(1,Empid);
			pst.setString(2,name);
			int r=pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(),r+"record inserted");
			pst.close();
			con.close();
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(new JDialog(),"Insert Issues:"+e);
		}
	}
	
	public String viewEmployee()
	{
					StringBuffer sb=new StringBuffer();

		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			String s1="select *from student";
			Statement s2=con.createStatement();
			ResultSet rs=s2.executeQuery(s1);
			while(rs.next())
			{
				int rno=rs.getInt(1);
				String name=rs.getString(2);
				sb.append("Rno:"+rno+"\tName:"+name+"\n");
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
	
	public void updateEmployee(Employee e)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			String s1="update employee set name=? where rno=?";
			PreparedStatement pst=con.prepareStatement(s1);
			int rno=s.getEmpid();
			String name=s.getName();
			pst.setString(1,name);
			pst.setInt(2,empid);
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
	
	public void deleteEmployee(Employee e)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			String s1="delete from student where rno=?";
			PreparedStatement pst=con.prepareStatement(s1);
			int empid=s.getEmpid();
			//String name=s.getName();
			pst.setInt(1,empid);
			//pst.setString(2,name);
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