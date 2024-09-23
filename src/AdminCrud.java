import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class AdminCrud extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void AdminCrud() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCrud frame = new AdminCrud();
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
	public AdminCrud()
	{
		initialize();
	}
	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 766);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Admin Dashboard", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(111, 94, 461, 584);
		contentPane.add(panel_1);
		
		Button BUPDATE = new Button("Update Books");
		BUPDATE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==BUPDATE)
				{
					UpdateBook a=new UpdateBook();
					a. UpdateBook();
					dispose();
				}
			}
		});
		BUPDATE.setForeground(Color.WHITE);
		BUPDATE.setFont(new Font("Dialog", Font.BOLD, 15));
		BUPDATE.setBackground(new Color(0, 0, 102));
		BUPDATE.setBounds(90, 226, 244, 35);
		panel_1.add(BUPDATE);
		
		Button BVIEW = new Button("View Participents    ");
		BVIEW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==BVIEW)
				{
					AllUsers a=new AllUsers();
					a. AllUsers();
					dispose();
				}
				
			}
		});
		BVIEW.setForeground(Color.WHITE);
		BVIEW.setFont(new Font("Dialog", Font.BOLD, 15));
		BVIEW.setBackground(new Color(0, 0, 102));
		BVIEW.setBounds(90, 56, 244, 35);
		panel_1.add(BVIEW);
		
		Button badd = new Button("Add Books");
		badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==badd)
				{
					AddBooks a=new AddBooks();
					a. AddBooks();
					dispose();
				}
				
			}
		});
		badd.setForeground(Color.WHITE);
		badd.setFont(new Font("Dialog", Font.BOLD, 15));
		badd.setBackground(new Color(0, 0, 102));
		badd.setBounds(90, 140, 244, 35);
		panel_1.add(badd);
		
		Button BDELETE = new Button("Delete Book");
		BDELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==BDELETE)
				{
					DeleteBook r=new DeleteBook();
					r. DeleteBook();
					dispose();
				}
			}
		});
		BDELETE.setForeground(Color.WHITE);
		BDELETE.setFont(new Font("Dialog", Font.BOLD, 15));
		BDELETE.setBackground(new Color(0, 0, 102));
		BDELETE.setBounds(90, 312, 244, 35);
		panel_1.add(BDELETE);
		
		Button BSEARCH = new Button("Search Book");
		BSEARCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==BSEARCH)
				{
					SerachRecord b=new SerachRecord();
					b. SerachRecord();
					dispose();
				}
			}
		});
		BSEARCH.setForeground(Color.WHITE);
		BSEARCH.setFont(new Font("Dialog", Font.BOLD, 15));
		BSEARCH.setBackground(new Color(0, 0, 102));
		BSEARCH.setBounds(90, 402, 244, 35);
		panel_1.add(BSEARCH);
		
		Button BLOGOUT = new Button("Logout");
		BLOGOUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog( null,"Logged Out Succcessfully");
				HomeGUI.main(new String[]{});
				dispose();
			}
		});
		BLOGOUT.setForeground(Color.WHITE);
		BLOGOUT.setFont(new Font("Dialog", Font.BOLD, 15));
		BLOGOUT.setBackground(new Color(0, 0, 102));
		BLOGOUT.setBounds(90, 496, 244, 35);
		panel_1.add(BLOGOUT);
		
		JLabel lblNewLabel_1_1 = new JLabel("Admin Dashboard");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(198, 29, 277, 35);
		contentPane.add(lblNewLabel_1_1);
	}
}
