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
		
		setTitle("StudentManagementSystem");
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
class Student
{
	private int rno;
	private String name;
	
	public Student()
	{
	}
	public Student(int rno,String name)
	{
		this.rno=rno;
		this.name=name;
	}
	public int getRno()
	{
		return rno;
	}
	public String getName()
	{
		return name;
	}
	public void setRno(int rno)
	{
		this.rno=rno;
	}
	public void setName(String name)
	{
		this.name=name;
	}
}
class DbOperation
{
	public void addStudent(Student s)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			String s1="insert into student values(?,?)";
			PreparedStatement pst=con.prepareStatement(s1);
			int rno=s.getRno();
			String name=s.getName();
			pst.setInt(1,rno);
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
	
	public String viewStudent()
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
	
	public void updateStudent(Student s)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			String s1="update student set name=? where rno=?";
			PreparedStatement pst=con.prepareStatement(s1);
			int rno=s.getRno();
			String name=s.getName();
			pst.setString(1,name);
			pst.setInt(2,rno);
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
	
	public void deleteStudent(Student s)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			String s1="delete from student where rno=?";
			PreparedStatement pst=con.prepareStatement(s1);
			int rno=s.getRno();
			//String name=s.getName();
			pst.setInt(1,rno);
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