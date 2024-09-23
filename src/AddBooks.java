
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddBooks extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtprice;
	private JTextField txtedition;
	private JTextField txtid;
	private JTextField txtauthor;

	/*
	 * Launch the application.
	 */
	public static void AddBooks()  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooks frame = new AddBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	Connection con;
	PreparedStatement pst;
	
   //Database Connectivity
	public void Connect()
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
	//AddBooks method calling initialize() and connect() method
	public AddBooks() 
	{
		initialize();
		Connect();
	}
	
	private void initialize()
	{
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Book Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(108, 65, 577, 272);
		contentPane.add(panel);
		
		JLabel Author = new JLabel("Author");
		Author.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		Author.setBounds(20, 101, 107, 47);
		panel.add(Author);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price");
		lblNewLabel_1_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(20, 200, 107, 52);
		panel.add(lblNewLabel_1_1);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(196, 69, 301, 31);
		panel.add(txtname);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(196, 213, 301, 31);
		panel.add(txtprice);
		
		txtedition = new JTextField();
		txtedition.setColumns(10);
		txtedition.setBounds(196, 164, 301, 31);
		panel.add(txtedition);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblNewLabel_1.setBounds(20, 57, 138, 47);
		panel.add(lblNewLabel_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblId.setBounds(20, 10, 107, 47);
		panel.add(lblId);
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(196, 22, 301, 31);
		panel.add(txtid);
		
		JLabel lblEdition_1 = new JLabel("Edition");
		lblEdition_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblEdition_1.setBounds(20, 154, 107, 47);
		panel.add(lblEdition_1);
		
		txtauthor = new JTextField();
		txtauthor.setColumns(10);
		txtauthor.setBounds(196, 117, 301, 31);
		panel.add(txtauthor);
		
		//Invoke action event by add button
		Button BADD = new Button("ADD    ");
		BADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id,bname,author,edition,price;

				id=txtid.getText();
				bname= txtname.getText();
				author=txtauthor.getText();
				edition=txtedition.getText();
				price=txtprice.getText();
			 
					
					try {
						pst=con.prepareStatement("insert into books(id,bname,author,edition,price) values(?,?,?,?,?)");
						pst.setString(1, id);
						pst.setString(2, bname);
						pst.setString(3, author);
						pst.setString(4, edition);
						pst.setString(5, price);
						pst.executeUpdate();
						JOptionPane.showMessageDialog( null,"Record Inserted Successfully");

						txtid.setText("");
						txtname.setText("");
						txtauthor.setText("");
						txtedition.setText("");
						txtprice.setText("");
						txtname.requestFocus();
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog( null,"invalid");
					}
			}
		});
		
		BADD.setForeground(new Color(0, 0, 0));
		BADD.setFont(new Font("Dialog", Font.BOLD, 20));
		BADD.setBackground(new Color(255, 69, 0));
		BADD.setBounds(142, 373, 132, 41);
		contentPane.add(BADD);
		
		Button BADD_1 = new Button("CLEAR      ");
		BADD_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				txtid.setText("");
				txtname.setText("");
				txtauthor.setText("");
				txtedition.setText("");
				txtprice.setText("");
				txtname.requestFocus();
			}
		});
		BADD_1.setForeground(new Color(0, 0, 0));
		BADD_1.setFont(new Font("Dialog", Font.BOLD, 20));
		BADD_1.setBackground(new Color(255, 69, 0));
		BADD_1.setBounds(331, 373, 132, 41);
		contentPane.add(BADD_1);
		
		//Calling AdminCrud() class methods
		Button BBACK = new Button("BACK      ");
		BBACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==BBACK)
				{
					AdminCrud a=new AdminCrud();
					a. AdminCrud();
					dispose(); //close the current window
				}
				
			}
		});
		BBACK.setForeground(new Color(0, 0, 0));
		BBACK.setFont(new Font("Dialog", Font.BOLD, 20));
		BBACK.setBackground(new Color(255, 69, 0));
		BBACK.setBounds(509, 373, 132, 41);
		contentPane.add(BBACK);
	}

}
