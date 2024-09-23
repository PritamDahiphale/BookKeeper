import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class LoginPage extends javax.swing.JFrame  {

	private JPanel contentPane;
	private JTextField txtusername;

	/**
	 * Launch the application.
	 */
	public static void LoginPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	
	/**
	 * Create the frame.
	 */
	public LoginPage()
	{
		initialize();
		con=DBConnection.getConnection();
	}

	private void initialize() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(102, 102, 255), new Color(102, 102, 255), new Color(102, 102, 255), new Color(102, 102, 255)));
		panel.setBounds(10, 183, 354, 422);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
		lblNewLabel_1.setBounds(44, 160, 149, 34);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(44, 38, 149, 34);
		panel.add(lblNewLabel_1_1);

		txtusername = new JTextField();
		txtusername.setColumns(10);
		txtusername.setBounds(44, 79, 273, 34);
		panel.add(txtusername);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember Me");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
		chckbxNewCheckBox.setBounds(44, 279, 174, 21);
		panel.add(chckbxNewCheckBox);

		Button BLOGIN = new Button("LOGIN   ");
		BLOGIN.setForeground(new Color(255, 255, 255));
		BLOGIN.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		BLOGIN.setBackground(new Color(102, 102, 255));
		BLOGIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String username,password;

				
				username=txtusername.getText();
				password=txtpassword.getText();


				try {

					pst=con.prepareStatement("select username,password from signup where username=? and password=?");
					
					pst.setString(1, username);
					pst.setString(2, password);
					
					ResultSet rs =pst.executeQuery();
					if(rs.next()==true)
					{

						JOptionPane.showMessageDialog( null,"Logged in Succcessfully");
						if(e.getSource()==BLOGIN)
						{
							BookCrud b=new BookCrud();
							b.BookCrud();
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
		BLOGIN.setBounds(89, 333, 149, 42);
		panel.add(BLOGIN);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(44, 203, 273, 34);
		panel.add(txtpassword);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 255));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 104, 354, 82);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("  LOGIN ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		lblNewLabel.setBounds(68, 10, 203, 62);
		panel_1.add(lblNewLabel);
		
		Button BHOME = new Button("HOME      ");
		BHOME.setForeground(new Color(255, 255, 255));
		BHOME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					HomeGUI.main(new String[]{});
					dispose();
				
				
			}
		});
		BHOME.setFont(new Font("Dubai", Font.BOLD, 20));
		BHOME.setBackground(new Color(102, 102, 255));
		BHOME.setBounds(97, 626, 154, 42);
		contentPane.add(BHOME);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\WhatsApp Image 2021-10-15 at 2.54.33 PM.jpeg"));
		lblNewLabel_2.setBounds(376, 0, 890, 743);
		contentPane.add(lblNewLabel_2);
	}
}
