import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class HomeGUI extends JFrame  {

	JButton BSIGNUP,BLOGIN;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeGUI frame = new HomeGUI();
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
	public HomeGUI()
	{
		
		initialize(); 
	}

	private void initialize() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1237, 794);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 102));
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(102, 0, 153));
		panel_1.setBounds(0, 0, 229, 789);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Dashboard");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(41, 55, 147, 35);
		panel_1.add(lblNewLabel_1_1);

		Button BFEEDBACK = new Button("FEEDBACK       ");
		BFEEDBACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==BFEEDBACK)
				{
					Feedback b=new Feedback();
					b.feedback();
					dispose();
				}
			}
		});
		BFEEDBACK.setBackground(Color.WHITE);
		BFEEDBACK.setForeground(Color.BLACK);
		BFEEDBACK.setFont(new Font("Dialog", Font.BOLD, 15));
		BFEEDBACK.setBounds(29, 659, 172, 35);
		panel_1.add(BFEEDBACK);

		Button BSTOCK = new Button("BOOK STOCK     ");
		BSTOCK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(e.getSource()==BSTOCK)
				{
					BookStock b=new BookStock();
					b. BookStock();
					dispose();
				}

			}
		});
		BSTOCK.setForeground(Color.BLACK);
		BSTOCK.setBackground(Color.WHITE);
		BSTOCK.setFont(new Font("Dialog", Font.BOLD, 15));
		BSTOCK.setBounds(29, 134, 172, 35);
		panel_1.add(BSTOCK);

		Button ABLOGIN = new Button("ADMIN LOGIN     ");
		ABLOGIN.setBackground(Color.WHITE);
		ABLOGIN.setForeground(Color.BLACK);
		ABLOGIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(e.getSource()==ABLOGIN)
				{
					AdminLogin a=new AdminLogin();
					a. AdminLogin();
					dispose();
				}

			}
		});
		ABLOGIN.setFont(new Font("Dialog", Font.BOLD, 15));
		ABLOGIN.setBounds(29, 266, 172, 35);
		panel_1.add(ABLOGIN);

		Button BSIGN = new Button("SIGNUP       ");
		BSIGN.setForeground(Color.BLACK);
		BSIGN.setBackground(Color.WHITE);
		BSIGN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==BSIGN)
				{
					ResigtrationPage r=new ResigtrationPage();
					r. ResigtrationPage();
					dispose();
				}
			}
		});
		BSIGN.setFont(new Font("Dialog", Font.BOLD, 15));
		BSIGN.setBounds(29, 389, 172, 35);
		panel_1.add(BSIGN);

		Button BLOGIN_1 = new Button("LOGIN      ");
		BLOGIN_1.setBounds(29, 524, 172, 32);
		panel_1.add(BLOGIN_1);
		BLOGIN_1.setFont(new Font("Dialog", Font.BOLD, 14));
		BLOGIN_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(e.getSource()==BLOGIN_1)
				{
					LoginPage l=new LoginPage();
					l. LoginPage();
					dispose();
				}

			}
		});
		BLOGIN_1.setForeground(Color.BLACK);
		BLOGIN_1.setBackground(Color.WHITE);

		JLabel lblNewLabel_2_1 = new JLabel("Havan't Account yet ? ...Click signup to Create new account ");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setBounds(303, 702, 564, 32);
		contentPane.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Sitka Subheading", Font.BOLD, 20));

		Button BSIGNUP_1 = new Button("SIGNUP PAGE  ");
		BSIGNUP_1.setBounds(887, 702, 150, 32);
		contentPane.add(BSIGNUP_1);
		BSIGNUP_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(e.getSource()==BSIGNUP_1)
				{
					ResigtrationPage r=new ResigtrationPage();
					r. ResigtrationPage();
					dispose();
				}


			}
		});
		BSIGNUP_1.setFont(new Font("Dialog", Font.BOLD, 10));
		BSIGNUP_1.setForeground(Color.WHITE);
		BSIGNUP_1.setBackground(new Color(255, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon("E:\\WhatsApp Image 2021-10-15 at 2.54.32 PM (2).jpeg"));
		lblNewLabel_1.setBounds(230, 23, 993, 747);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("            Welcome to E-Library");
		lblNewLabel.setBounds(216, 21, 983, 70);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 45));



	}
}