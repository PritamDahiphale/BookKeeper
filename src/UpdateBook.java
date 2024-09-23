import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class UpdateBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtprice;
	private JTextField txtedition;
	private JTextField txtauthor;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void  UpdateBook()  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBook frame = new UpdateBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateBook() 
	{
		initialize();
		con=DBConnection.getConnection();
		table_load();
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtbid;


	public void table_load()
	{
		try
		{
			pst=con.prepareStatement("select * from books");
			rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1051, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Book Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(57, 106, 518, 258);
		contentPane.add(panel);
		
		JLabel Author = new JLabel("Author");
		Author.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		Author.setBounds(20, 97, 107, 47);
		panel.add(Author);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price");
		lblNewLabel_1_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(20, 200, 107, 52);
		panel.add(lblNewLabel_1_1);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(196, 41, 301, 31);
		panel.add(txtname);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(196, 213, 301, 31);
		panel.add(txtprice);
		
		txtedition = new JTextField();
		txtedition.setColumns(10);
		txtedition.setBounds(196, 153, 301, 31);
		panel.add(txtedition);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblNewLabel_1.setBounds(20, 30, 138, 47);
		panel.add(lblNewLabel_1);
		
		JLabel lblEdition_1 = new JLabel("Edition");
		lblEdition_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblEdition_1.setBounds(20, 153, 107, 47);
		panel.add(lblEdition_1);
		
		txtauthor = new JTextField();
		txtauthor.setColumns(10);
		txtauthor.setBounds(196, 96, 301, 31);
		panel.add(txtauthor);
		
		
		
		Button BUPDATE = new Button("UPDATE   ");
		BUPDATE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bname,author,edition,price,bid;

				//id=txtid.getText();
				bname = txtname.getText();
				author=txtauthor.getText();
				edition = txtedition.getText();
				price = txtprice.getText();
				bid  = txtbid.getText();


				try {
					pst = con.prepareStatement("update books set bname= ?,author= ?,edition=?,price=? where id=? ");
					//pst.setString(1, id);
					pst.setString(1, bname);
					pst.setString(2, author);
					pst.setString(3, edition);
					pst.setString(4, price);
					pst.setString(5, bid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Update!!!!!");
					table_load();

					//txtid.setText("");
					txtname.setText("");
					txtauthor.setText("");
					txtedition.setText("");
					txtprice.setText("");
					txtname.requestFocus();

				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		BUPDATE.setForeground(Color.BLACK);
		BUPDATE.setFont(new Font("Dialog", Font.BOLD, 20));
		BUPDATE.setBackground(new Color(255, 102, 0));
		BUPDATE.setBounds(670, 134, 163, 33);
		contentPane.add(BUPDATE);
		
		Button BCLEAR = new Button("CLEAR      ");
		BCLEAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtid.setText("");
				txtname.setText("");
				txtauthor.setText("");
				txtedition.setText("");
				txtprice.setText("");
				txtname.requestFocus();
				
			}
		});
		BCLEAR.setForeground(Color.BLACK);
		BCLEAR.setFont(new Font("Dialog", Font.BOLD, 20));
		BCLEAR.setBackground(new Color(255, 102, 51));
		BCLEAR.setBounds(670, 223, 163, 33);
		contentPane.add(BCLEAR);
		
		Button BBACK = new Button("BACK      ");
		BBACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==BBACK)
				{
					AdminCrud a=new AdminCrud();
					a. AdminCrud();
					dispose();
				}
				
			}
		});
		BBACK.setForeground(Color.BLACK);
		BBACK.setFont(new Font("Dialog", Font.BOLD, 20));
		BBACK.setBackground(new Color(255, 102, 51));
		BBACK.setBounds(670, 307, 163, 33);
		contentPane.add(BBACK);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 374, 870, 342);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		table.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Book ID");
		lblNewLabel_1_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		lblNewLabel_1_2_1.setBounds(80, 27, 138, 47);
		contentPane.add(lblNewLabel_1_2_1);
		
		txtbid = new JTextField();
		txtbid.setColumns(10);
		txtbid.setBounds(250, 38, 301, 31);
		contentPane.add(txtbid);
		txtbid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				try {

					String bid = txtbid.getText();

					pst = con.prepareStatement("select bname,author,edition,price from books where id = ?");
					pst.setString(1, bid);
					ResultSet rs = pst.executeQuery();

					if(rs.next()==true)
					{
                       // String id=rs.getString(1);
						String bname = rs.getString(1);
						String author = rs.getString(2);
						String edition = rs.getString(3);
						String price = rs.getString(4);

						//txtid.setText(id);
						txtname.setText(bname);
						txtauthor.setText(author);
						txtedition.setText(edition);
						txtprice.setText(price);


					}   
					else
					{
						//txtid.setText("");
						txtname.setText("");
						txtauthor.setText("");
						txtedition.setText("");
						txtprice.setText("");

					}



				} 

				catch (SQLException ex) {

				}





			}
		});
	}
}
