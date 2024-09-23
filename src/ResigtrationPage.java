import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class ResigtrationPage extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField txtfname;

	/**
	 * Launch the application.
	 */
	public static void  ResigtrationPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResigtrationPage frame = new ResigtrationPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con;
	PreparedStatement pst;
	private JTextField txtmname;
	private JTextField txtlname;
	private JTextField txtusername;
	private JTextField txtpassword;
	private JTextField txtemail;
	

	/**
	 * Create the frame.
	 */
	public ResigtrationPage()
	{
		initialize();
		con=DBConnection.getConnection();		
	}
	
	private void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1260, 777);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Signup");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
		lblNewLabel.setBounds(140, 52, 327, 64);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 102));
		panel.setBounds(30, 174, 431, 493);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("First Name");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(10, 46, 155, 25);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Middle Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 102, 163, 28);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Last Name");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setBounds(10, 157, 163, 28);
		panel.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel Username = new JLabel("Username");
		Username.setForeground(Color.WHITE);
		Username.setBounds(10, 220, 155, 28);
		panel.add(Username);
		Username.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Password");
		lblNewLabel_1_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_2_1.setBounds(10, 286, 123, 28);
		panel.add(lblNewLabel_1_2_2_1);
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Email ID");
		lblNewLabel_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_1_2_2.setBounds(10, 344, 123, 28);
		panel.add(lblNewLabel_1_2_2);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		txtfname = new JTextField();
		txtfname.setColumns(10);
		txtfname.setBounds(175, 44, 235, 34);
		panel.add(txtfname);
		
		Button BLOGIN = new Button("LOGIN");
		BLOGIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==BLOGIN)
				{
					LoginPage l=new LoginPage();
					l. LoginPage();
					dispose();
				}
				
			}
		});
		BLOGIN.setForeground(Color.WHITE);
		BLOGIN.setFont(new Font("Dialog", Font.BOLD, 20));
		BLOGIN.setBackground(new Color(0, 0, 153));
		BLOGIN.setBounds(217, 417, 132, 41);
		panel.add(BLOGIN);
		
		Button BSIGNUP = new Button("SIGNUP  ");
		BSIGNUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname,mname,lname,username,password,email;
                
				fname=txtfname.getText();
				mname=txtmname.getText();
				lname=txtlname.getText();
				username=txtusername.getText();
				password=txtpassword.getText();
				email=txtemail.getText();


				try {
					
					pst=con.prepareStatement("insert into signup(fname,mname,lname,username,password,email) values(?,?,?,?,?,?)");
					pst.setString(1, fname);
					pst.setString(2, mname);
					pst.setString(3, lname);
					pst.setString(4, username);
					pst.setString(5, password);
					pst.setString(6, email);
					pst.executeUpdate();
					JOptionPane.showMessageDialog( null,"Account Created Sucessfully");
					

					txtfname.setText("");
					txtmname.setText("");
					txtlname.setText("");
					txtusername.setText("");
					txtpassword.setText("");
					txtemail.setText("");
					txtfname.requestFocus();

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
				
				
					
					if(e.getSource()==BSIGNUP)
					{
						BookCrud b=new BookCrud();
						b.BookCrud();
						dispose();
					}
					
			}
			
				
			
		});
		BSIGNUP.setForeground(Color.WHITE);
		BSIGNUP.setFont(new Font("Dialog", Font.BOLD, 20));
		BSIGNUP.setBackground(new Color(255, 0, 51));
		BSIGNUP.setBounds(33, 417, 132, 41);
		panel.add(BSIGNUP);
		
		txtmname = new JTextField();
		txtmname.setColumns(10);
		txtmname.setBounds(175, 102, 235, 34);
		panel.add(txtmname);
		
		txtlname = new JTextField();
		txtlname.setColumns(10);
		txtlname.setBounds(175, 161, 235, 34);
		panel.add(txtlname);
		
		txtusername = new JTextField();
		txtusername.setColumns(10);
		txtusername.setBounds(175, 224, 235, 34);
		panel.add(txtusername);
		
		txtpassword = new JTextField();
		txtpassword.setColumns(10);
		txtpassword.setBounds(175, 280, 235, 34);
		panel.add(txtpassword);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(175, 338, 235, 34);
		panel.add(txtemail);
		
		JLabel lblNewLabel_2 = new JLabel("Create New Account Here....");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(104, 112, 272, 52);
		contentPane.add(lblNewLabel_2);
		
		Button BHOME = new Button("HOME  PAGE       ");
		BHOME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomeGUI.main(new String[]{});
				dispose();
				
				
			}
		});
		BHOME.setForeground(Color.WHITE);
		BHOME.setFont(new Font("Dubai", Font.BOLD, 15));
		BHOME.setBackground(new Color(102, 102, 255));
		BHOME.setBounds(134, 668, 179, 43);
		contentPane.add(BHOME);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\WhatsApp Image 2021-10-15 at 2.54.33 PM (1).jpeg"));
		lblNewLabel_3.setBounds(471, 0, 775, 740);
		contentPane.add(lblNewLabel_3);
	}
}
