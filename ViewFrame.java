import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewFrame extends JFrame
{
	Container c;
	JButton btnViewBack;
	TextArea taView;
	
	public ViewFrame()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		taView=new TextArea(20,50);
		btnViewBack=new JButton("Back");
		
		c.add(taView);
		c.add(btnViewBack);
				
		ActionListener a3=(ae)->{
			MainFrame a=new MainFrame();
			dispose();
		};
		btnViewBack.addActionListener(a3);
		
		DbOperation db =new DbOperation();
		String data=db.viewStudent();
		taView.setText(data);
		
		setTitle("StudentManagementSystem:ViewFrame");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}