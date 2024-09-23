import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SerachRecord extends JFrame {
	private JPanel contentPane;
	private JTextField bookname;
	private JTextField txtbname;
	private JTextField txtname;
	private JTextField txtprice;
	private JTextField txtedition;
	private JTextField txtauthor;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void  SerachRecord()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SerachRecord frame = new SerachRecord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SerachRecord()
	{
		initialize();
		con=DBConnection.getConnection();

	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField textbname;


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 593);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		bookname = new JTextField();
		bookname.setForeground(new Color(255, 255, 255));
		bookname.setBackground(new Color(153, 204, 0));
		bookname.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		bookname.setText("    Enter  Book Name  ");
		bookname.setBounds(102, 128, 191, 31);
		contentPane.add(bookname);
		bookname.setColumns(10);

		textbname = new JTextField();
		textbname.setForeground(new Color(0, 0, 0));
		textbname.setBackground(new Color(255, 255, 255));
		textbname.setBounds(315, 131, 278, 31);
		contentPane.add(textbname);
		textbname.setColumns(10);


		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Book Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(102, 209, 567, 267);
		contentPane.add(panel);

		JLabel Author = new JLabel("Author");
		Author.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		Author.setBounds(20, 101, 107, 47);
		panel.add(Author);

		JLabel lblNewLabel_1_1 = new JLabel("Price");
		lblNewLabel_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
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
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		lblNewLabel_1.setBounds(20, 57, 138, 47);
		panel.add(lblNewLabel_1);

		JLabel lblEdition_1 = new JLabel("Edition");
		lblEdition_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		lblEdition_1.setBounds(20, 154, 107, 47);
		panel.add(lblEdition_1);

		txtauthor = new JTextField();
		txtauthor.setColumns(10);
		txtauthor.setBounds(196, 117, 301, 31);
		panel.add(txtauthor);

		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(196, 20, 301, 31);
		panel.add(txtid);

		JLabel lblNewLabel_1_2 = new JLabel("Book ID");
		lblNewLabel_1_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(20, 9, 138, 47);
		panel.add(lblNewLabel_1_2);

		Button BSEARCH = new Button("Search      ");
		BSEARCH.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {



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


		BSEARCH.setBackground(new Color(255, 69, 0));
		BSEARCH.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		BSEARCH.setBounds(629, 131, 92, 31);
		contentPane.add(BSEARCH);

		Button BBACK = new Button("Back      ");
		BBACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==BBACK)
				{
					AdminCrud b=new AdminCrud();
					b.AdminCrud();
					dispose();
				}
			}
		});
		BBACK.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		BBACK.setBackground(new Color(255, 69, 0));
		BBACK.setBounds(42, 32, 92, 31);
		contentPane.add(BBACK);
	}
}
