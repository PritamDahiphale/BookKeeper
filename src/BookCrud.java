import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class BookCrud extends JFrame {

	private JPanel txtcost;
	

	/**
	 * Launch the application.
	 */
	public static void BookCrud(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookCrud frame = new BookCrud();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookCrud()
	{
		initialize();
		con=DBConnection.getConnection();
		table_load();

	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtBookStore;
	private Panel panel_2_1;
	private JTextField txtname;
	private JTextField txtid;
	private JTextField txtauthor;
	private JTextField txtedition;
	private JTextField txtprice;
	private JTextField textbname;
	private JTable table1;



	public void table_load()
	{
		try
		{
			pst=con.prepareStatement("select * from bshop");
			rs=pst.executeQuery();
			table1.setModel(DbUtils.resultSetToTableModel(rs));
					

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
		setBounds(100, 100, 1217, 765);
		txtcost = new JPanel();
		txtcost.setBackground(new Color(153, 204, 0));
		txtcost.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(txtcost);
		txtcost.setLayout(null);

		Panel panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 69, 0));
		panel_2.setBounds(0, 0, 1203, 125);
		txtcost.add(panel_2);

		txtBookStore = new JTextField();
		txtBookStore.setForeground(new Color(255, 255, 255));
		txtBookStore.setText("      Book Store");
		txtBookStore.setFont(new Font("Monotype Corsiva", Font.BOLD, 54));
		txtBookStore.setColumns(10);
		txtBookStore.setBackground(new Color(255, 69, 0));
		txtBookStore.setBounds(402, 27, 364, 88);
		panel_2.add(txtBookStore);

		panel_2_1 = new Panel();
		panel_2_1.setBackground(new Color(255, 255, 255));
		panel_2_1.setBounds(174, 200, 772, 307);
		txtcost.add(panel_2_1);
		panel_2_1.setLayout(null);

		JLabel lblBookName = new JLabel("Edition");
		lblBookName.setForeground(new Color(0, 0, 0));
		lblBookName.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		lblBookName.setBounds(29, 182, 107, 47);
		panel_2_1.add(lblBookName);

		JLabel lblId_1 = new JLabel("Book Code");
		lblId_1.setForeground(new Color(0, 0, 0));
		lblId_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		lblId_1.setBounds(29, 11, 107, 47);
		panel_2_1.add(lblId_1);

		JLabel lblBookName_1 = new JLabel("Book Name");
		lblBookName_1.setForeground(new Color(0, 0, 0));
		lblBookName_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		lblBookName_1.setBounds(29, 68, 107, 47);
		panel_2_1.add(lblBookName_1);

		JLabel lblBookName_2 = new JLabel("Author");
		lblBookName_2.setBackground(new Color(255, 255, 255));
		lblBookName_2.setForeground(new Color(0, 0, 0));
		lblBookName_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		lblBookName_2.setBounds(29, 125, 107, 47);
		panel_2_1.add(lblBookName_2);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(0, 0, 0));
		lblPrice.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		lblPrice.setBounds(29, 239, 107, 47);
		panel_2_1.add(lblPrice);

		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(171, 78, 276, 31);
		panel_2_1.add(txtname);

		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(171, 27, 276, 31);
		panel_2_1.add(txtid);

		txtauthor = new JTextField();
		txtauthor.setColumns(10);
		txtauthor.setBounds(171, 141, 276, 31);
		panel_2_1.add(txtauthor);

		txtedition = new JTextField();
		txtedition.setColumns(10);
		txtedition.setBounds(171, 192, 276, 31);
		panel_2_1.add(txtedition);

		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(171, 249, 276, 31);
		panel_2_1.add(txtprice);

		Button BADD = new Button("ADD       ");
		BADD.setForeground(new Color(255, 255, 255));
		BADD.setBounds(583, 47, 107, 42);
		panel_2_1.add(BADD);
		BADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				String id,name,author,edition,price;

				id=txtid.getText();
				name= txtname.getText();
				author=txtauthor.getText();
				edition=txtedition.getText();
				price=txtprice.getText();


				try {
					pst=con.prepareStatement("insert into bshop(id,bname,author,edition,price) values(?,?,?,?,?)");
					pst.setString(1, id);
					pst.setString(2, name);
					pst.setString(3, author);
					pst.setString(4, edition);
					pst.setString(5, price);
					pst.executeUpdate();
					JOptionPane.showMessageDialog( null,"Record Inserted Successfully");
					table_load();

					txtid.setText("");
					txtname.setText("");
					txtauthor.setText("");
					txtedition.setText("");
					txtprice.setText("");
					txtname.requestFocus();

				} catch (SQLException e1) {

					e1.printStackTrace();

				}




			}

		});
		BADD.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		BADD.setBackground(new Color(255, 69, 0));
		
		Button BADD_1 = new Button("DELETE     ");
		BADD_1.setForeground(new Color(255, 255, 255));
		BADD_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bname;
				bname  = textbname.getText();

				try {
					pst = con.prepareStatement("delete from bshop where bname =?");

					pst.setString(1,bname);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
					table_load();

				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
			
		});
		BADD_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		BADD_1.setBackground(new Color(255, 69, 0));
		BADD_1.setBounds(583, 130, 107, 42);
		panel_2_1.add(BADD_1);
		
		Button BHOME = new Button("LOGOUT    ");
		BHOME.setForeground(new Color(255, 255, 255));
		BHOME.setBounds(583, 216, 103, 42);
		panel_2_1.add(BHOME);
		BHOME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Logged out successfully"); 
					
					HomeGUI.main(new String[]{});
					dispose();
			}
		});
		BHOME.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		BHOME.setBackground(new Color(255, 69, 0));

		JLabel lblBookName_1_1 = new JLabel("Book Name");
		lblBookName_1_1.setForeground(new Color(0, 0, 0));
		lblBookName_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
		lblBookName_1_1.setBounds(179, 147, 161, 47);
		txtcost.add(lblBookName_1_1);

		textbname = new JTextField();
		textbname.setColumns(10);
		textbname.setBounds(350, 158, 276, 31);
		txtcost.add(textbname);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 518, 1043, 200);
		txtcost.add(scrollPane);
		
				table1 = new JTable();
				scrollPane.setViewportView(table1);
				table1.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						
					}
				});

		Button BFIND = new Button(" FIND            ");
		BFIND.setForeground(new Color(255, 255, 255));
		BFIND.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{


				try {
					//String id,name,author,edition,price;
					String bname = textbname.getText();

					pst = con.prepareStatement("select id,bname,author,edition,price from books where bname = ?");
					pst.setString(1, bname);
					ResultSet rs = pst.executeQuery();

					if(rs.next()==true)
					{
						String id = rs.getString(1);
						String name = rs.getString(2);
						String author = rs.getString(3);
						String edition = rs.getString(4);
						String price = rs.getString(5);

						txtid.setText(id);
						txtname.setText(name);
						txtauthor.setText(author);
						txtedition.setText(edition);
						txtprice.setText(price);


					}   
					else
					{
						txtid.setText("");
						txtname.setText("");
						txtauthor.setText("");
						txtedition.setText("");
						txtprice.setText("");
						JOptionPane.showMessageDialog(null, "Invalid Bookname, book is not available");
					}



				} 

				catch (SQLException ex) {

				}


			}
		});
		BFIND.setBounds(757, 152, 111, 42);
		txtcost.add(BFIND);
		BFIND.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		BFIND.setBackground(new Color(255, 69, 0));
	}
}
