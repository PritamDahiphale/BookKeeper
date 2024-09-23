import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;

	/**
	 * Launch the application.
	 */
	public static void AdminLogin()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	PreparedStatement pst;
	private JPasswordField txtpassword;
	
	/*public void Connect()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		} catch (ClassNotFoundException ex) {

		}
		catch(SQLException ex)
		{

		}
	}
 */
	public void connect() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/your_database_name";
	        String username = "system";
	        String password = "system";
	        Connection con = DriverManager.getConnection(url, username, password);
	        // Use the connection 'con' to perform database operations
	    } catch (ClassNotFoundException ex) {
	        // Handle ClassNotFoundException
	    } catch (SQLException ex) {
	        // Handle SQLException
	    }
	}
	/**
	 * Create the frame.
	 */
	public AdminLogin()
	{
		initialize();
		connect();
	}

	
	/**
	 * Create the frame.
	 */
	private void initialize() 
	 {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1242, 775);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(255, 255, 204));
		contentPane_1.setBounds(757, 114, 461, 594);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(204, 204, 0), new Color(204, 204, 0), new Color(204, 204, 0), new Color(204, 204, 0)));
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(43, 127, 391, 339);
		contentPane_1.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		lblNewLabel_1.setBounds(44, 131, 149, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(44, 38, 149, 34);
		panel.add(lblNewLabel_1_1);
		
		txtusername = new JTextField();
		txtusername.setColumns(10);
		txtusername.setBounds(44, 70, 209, 34);
		panel.add(txtusername);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember Me");
		chckbxNewCheckBox.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(44, 236, 174, 21);
		panel.add(chckbxNewCheckBox);
		
		Button ABLOGIN = new Button("LOGIN   ");
		ABLOGIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            String username,password;

				
				username=txtusername.getText();
				password=txtpassword.getText();


				try {

					pst=con.prepareStatement("select username,password from adminlogin where username=? and password=?");
					
					pst.setString(1, username);
					pst.setString(2, password);
					
					ResultSet rs =pst.executeQuery();
					if(rs.next()==true)
					{

						JOptionPane.showMessageDialog( null,"Logged in Succcessfully");
						if(e.getSource()==ABLOGIN)
						{
							AdminCrud  r=new AdminCrud();
							r. AdminCrud();
							dispose();
						}
						

					}   
					else
					{
						JOptionPane.showMessageDialog( null,"Wrong username & password");

					}
					
					txtusername.setText("");
					txtpassword.setText("");
					txtusername.requestFocus();
										

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
			}
		});
		ABLOGIN.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		ABLOGIN.setBackground(new Color(204, 204, 0));
		ABLOGIN.setBounds(116, 275, 137, 42);
		panel.add(ABLOGIN);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(44, 175, 209, 34);
		panel.add(txtpassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(204, 204, 0));
		panel_1.setBounds(43, 50, 396, 82);
		contentPane_1.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("  LOGIN ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		lblNewLabel.setBounds(76, 22, 215, 39);
		panel_1.add(lblNewLabel);
		
		Button BHOME = new Button("Home   ");
		BHOME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomeGUI.main(new String[]{});
				dispose();
			}
			
		});
		BHOME.setFont(new Font("Dubai", Font.BOLD, 20));
		BHOME.setBackground(new Color(255, 69, 0));
		BHOME.setBounds(166, 484, 125, 51);
		contentPane_1.add(BHOME);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\WhatsApp Image 2021-10-15 at 2.54.02 PM.jpeg"));
		lblNewLabel_2.setBounds(10, 56, 756, 623);
		contentPane.add(lblNewLabel_2);
	}
}
