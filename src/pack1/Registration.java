package pack1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.BorderLayout;

public class Registration extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final JTextComponent UserName = null;
	protected static final JTextComponent register = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField UN;
	private JTextField PS;
	protected Object conn;
	private JTextField textField_3;
	private final JLabel label = new JLabel("New label");
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField UserId;
	private JTextField Pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		getContentPane().setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 159, 40, -111);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(45, 87, 46, -30);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		UserId = new JTextField();
		UserId.setBounds(32, 68, 86, 20);
		getContentPane().add(UserId);
		UserId.setColumns(10);
		
		Pass = new JTextField();
		Pass.setColumns(10);
		Pass.setBounds(32, 128, 86, 20);
		getContentPane().add(Pass);
		
		JLabel PassLabel = new JLabel("Passowrd:");
		PassLabel.setBounds(32, 115, 66, 14);
		getContentPane().add(PassLabel);
		
		JLabel UserLabel = new JLabel("Username:");
		UserLabel.setBounds(32, 43, 66, 14);
		getContentPane().add(UserLabel);
		getContentPane().add(label, BorderLayout.WEST);
		textField_4.setColumns(10);
		
		textField_3 = new JTextField();
		getContentPane().add(textField_3, BorderLayout.CENTER);
		textField_3.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(37, 88, 41, -6);
		contentPane.add(textField);
		textField.setColumns(10);
		
		UN = new JTextField();
		UN.setBounds(38, 57, 146, 20);
		contentPane.add(UN);
		UN.setColumns(10);
		
		PS = new JTextField();
		PS.setColumns(10);
		PS.setBounds(37, 116, 146, 20);
		contentPane.add(PS);
		
		JLabel UserId = new JLabel("UserName:");
		UserId.setBounds(37, 42, 147, 14);
		contentPane.add(UserId);
		
		JLabel Pass = new JLabel("Password:");
		Pass.setBounds(37, 103, 147, 14);
		contentPane.add(Pass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
					Statement stmt = con.createStatement();
					String sql= "select * from register where UserName='" +UN.getText()+"' and Password='"+PS.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Sucessfully!!!!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect Username and Password.....");
						
					}
					con.close();
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(95, 173, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
					PreparedStatement ps = con.prepareStatement("insert into register(UserName, Password) values(?,?)");
					ps.setString(1, UN.getText());
					ps.setString(2, PS.getText());
					int x = ps.executeUpdate();
					if(x> 0)
					{
						System.out.println("Registration is Sucessfully Done!!!!");
					}
					else
					{
						System.out.println("Registration Failed...Please try Again!!");
					}
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnNewButton_1.setBounds(241, 173, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
