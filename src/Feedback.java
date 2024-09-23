import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Feedback extends JFrame {

	private JPanel contentPane;
	private JTextField txtFeedback;
	private JTextField txtfname;
	private JTextField txtemail;
	private JTextField txtfeedback;
	private JTextField txtlname;

	/**
	 * Launch the application.
	 */
	public static void feedback() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback frame = new Feedback();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement pst;


	
	public Feedback() 
	{
		initialize();
		con=DBConnection.getConnection();
	}

	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 787);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(153, 204, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("First Name");
		lblNewLabel_1_1.setBounds(20, 171, 126, 25);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("Email ID");
		lblNewLabel_1_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_2.setBounds(20, 378, 123, 28);
		contentPane.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("We would love to hear your thougths,suggetions,concern or problems ");
		lblNewLabel_1_2_2_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_2_1_1.setBounds(246, 74, 715, 28);
		contentPane.add(lblNewLabel_1_2_2_1_1);

		JLabel lblNewLabel_1_2_2_1_1_1 = new JLabel(" with anything so we can improve!");
		lblNewLabel_1_2_2_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_2_1_1_1.setBounds(412, 100, 364, 28);
		contentPane.add(lblNewLabel_1_2_2_1_1_1);

		txtFeedback = new JTextField();
		txtFeedback.setText("FEEDBACK");
		txtFeedback.setForeground(new Color(0, 0, 0));
		txtFeedback.setFont(new Font("Monotype Corsiva", Font.BOLD, 45));
		txtFeedback.setColumns(10);
		txtFeedback.setBackground(new Color(153, 204, 255));
		txtFeedback.setBounds(428, 10, 258, 69);
		contentPane.add(txtFeedback);

		JLabel lblNewLabel_1_2_2_1_2 = new JLabel("Describe your feedback");
		lblNewLabel_1_2_2_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_2_1_2.setBounds(20, 477, 248, 28);
		contentPane.add(lblNewLabel_1_2_2_1_2);

		txtfname = new JTextField();
		txtfname.setColumns(10);
		txtfname.setBounds(20, 206, 347, 34);
		contentPane.add(txtfname);

		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(20, 416, 347, 39);
		contentPane.add(txtemail);

		txtfeedback = new JTextField();
		txtfeedback.setColumns(10);
		txtfeedback.setBounds(20, 512, 364, 74);
		contentPane.add(txtfeedback);

		txtlname = new JTextField();
		txtlname.setColumns(10);
		txtlname.setBounds(20, 309, 347, 32);
		contentPane.add(txtlname);

		Button BSUBMIT = new Button("SUBMIT     ");
		BSUBMIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fname,lname,email,feedback;

				fname=txtfname.getText();
				lname= txtlname.getText();
				email=txtemail.getText();
				feedback=txtfeedback.getText();



				try {

					pst=con.prepareStatement("insert into feedback(fname,lname,email,feedback) values(?,?,?,?)");
					pst.setString(1, fname);
					pst.setString(2, lname);
					pst.setString(3, email);
					pst.setString(4, feedback);

					pst.executeUpdate();
					JOptionPane.showMessageDialog( null,"Thanks for your feedback");

					txtfname.setText("");
					txtlname.setText("");
					txtemail.setText("");
					txtfeedback.setText("");

					txtfname.requestFocus();
					
					HomeGUI.main(new String[]{});
					dispose();

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
			}
		});
		BSUBMIT.setForeground(Color.WHITE);
		BSUBMIT.setFont(new Font("Dialog", Font.BOLD, 20));
		BSUBMIT.setBackground(new Color(255, 0, 51));
		BSUBMIT.setBounds(28, 611, 132, 41);
		contentPane.add(BSUBMIT);

		JLabel lblNewLabel_1_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(20, 274, 126, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\WhatsApp Image 2021-10-15 at 2.54.32 PM (1).jpeg"));
		lblNewLabel.setBounds(0, 138, 1295, 602);
		contentPane.add(lblNewLabel);
	}
}
