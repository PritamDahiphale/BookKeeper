 import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Panel;
import java.awt.Color;

public class JavaCrud {

	private JFrame frame;
	private JTextField txtBookShop;
	private JTextField txtname;
	private JTextField txtprice;
	private JTextField txtedition;
	private JTable table;
	private JTextField txtbid;

	/**
	 * Launch the application.
	 */
	public static void JavaCrud() 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCrud window = new JavaCrud();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JavaCrud() {
		initialize();
		con=DBConnection.getConnection();
		table_load();
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtid;

	public void table_load()
	{
		try
		{
			pst=con.prepareStatement("select * from book");
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
		frame = new JFrame();
		frame.setBounds(100, 100, 1251, 790);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 157, 468, 199);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEdition.setBounds(20, 98, 107, 47);
		panel.add(lblEdition);

		JLabel lblNewLabel_1_1 = new JLabel("Price");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(20, 136, 107, 52);
		panel.add(lblNewLabel_1_1);

		txtname = new JTextField();
		txtname.setBounds(150, 67, 276, 31);
		panel.add(txtname);
		txtname.setColumns(10);

		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(150, 149, 276, 31);
		panel.add(txtprice);

		txtedition = new JTextField();
		txtedition.setColumns(10);
		txtedition.setBounds(150, 108, 276, 31);
		panel.add(txtedition);

		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 57, 107, 47);
		panel.add(lblNewLabel_1);

		JLabel lblId = new JLabel("Book Code");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(20, 10, 107, 47);
		panel.add(lblId);

		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(146, 20, 276, 31);
		panel.add(txtid);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id,name,edition,price;

				id=txtid.getText();
				name= txtname.getText();
				edition=txtedition.getText();
				price=txtprice.getText();


				try {
					pst=con.prepareStatement("insert into book(id,name,edition,price) values(?,?,?,?)");
					pst.setString(1, id);
					pst.setString(2, name);
					pst.setString(3, edition);
					pst.setString(4, price);
					pst.executeUpdate();
					JOptionPane.showMessageDialog( null,"Record Inserted Successfully");
					table_load();

					txtid.setText("");
					txtname.setText("");
					txtedition.setText("");
					txtprice.setText("");
					txtname.requestFocus();

				} catch (SQLException e1) {

					e1.printStackTrace();

				}




			}
		});
		btnNewButton.setBounds(30, 383, 123, 57);
		frame.getContentPane().add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setBounds(193, 383, 136, 57);
		frame.getContentPane().add(btnExit);

		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				String id,name,edition,price;

				id=txtid.getText();
				name = txtname.getText();
				edition = txtedition.getText();
				price = txtprice.getText();


				try {
					pst = con.prepareStatement("update book set name= ?,edition=?,price=? where id =?");
					pst.setString(1, id);
					pst.setString(2, name);
					pst.setString(3, edition);
					pst.setString(4, price);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Update!!!!!");
					table_load();

					txtid.setText("");
					txtname.setText("");
					txtedition.setText("");
					txtprice.setText("");
					txtname.requestFocus();

				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}

			}





		});
		btnNewButton_1_1.setBounds(642, 523, 123, 57);
		frame.getContentPane().add(btnNewButton_1_1);

		table = new JTable();
		table.setBounds(535, 153, 650, 287);
		frame.getContentPane().add(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(21, 489, 509, 125);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(22, 43, 74, 28);
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblBookId);

		txtbid = new JTextField();
		txtbid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				try {

					String id = txtbid.getText();

					pst = con.prepareStatement("select name,edition,price from book where id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();

					if(rs.next()==true)
					{

						String name = rs.getString(1);
						String edition = rs.getString(2);
						String price = rs.getString(3);

						txtname.setText(name);
						txtedition.setText(edition);
						txtprice.setText(price);


					}   
					else
					{
						txtname.setText("");
						txtedition.setText("");
						txtprice.setText("");

					}



				} 

				catch (SQLException ex) {

				}





			}
		});
		txtbid.setColumns(10);
		txtbid.setBounds(106, 43, 316, 31);
		panel_1.add(txtbid);

		JButton btnNewButton_1_1_1 = new JButton("Clear");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtid.setText("");
				txtname.setText("");
				txtedition.setText("");
				txtprice.setText("");
				txtname.requestFocus();
			}
		});
		btnNewButton_1_1_1.setBounds(377, 383, 123, 57);
		frame.getContentPane().add(btnNewButton_1_1_1);

		JButton btnNewButton_1_1_1_1 = new JButton("Delete");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				String id;
				id  = txtbid.getText();

				try {
					pst = con.prepareStatement("delete from book where id =?");

					pst.setString(1, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
					table_load();

					txtname.setText("");
					txtedition.setText("");
					txtprice.setText("");
					txtname.requestFocus();
				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1_1.setBounds(816, 523, 123, 57);
		frame.getContentPane().add(btnNewButton_1_1_1_1);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.CYAN);
		panel_2.setBounds(0, 0, 1196, 125);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
				txtBookShop = new JTextField();
				txtBookShop.setBackground(Color.CYAN);
				txtBookShop.setBounds(402, 29, 188, 69);
				panel_2.add(txtBookShop);
				txtBookShop.setFont(new Font("Tahoma", Font.BOLD, 30));
				txtBookShop.setText("Book Shop");
				txtBookShop.setColumns(10);
	}
}
