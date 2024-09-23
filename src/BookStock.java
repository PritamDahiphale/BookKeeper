import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import net.proteanit.sql.DbUtils;
public class BookStock extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void BookStock()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookStock frame = new BookStock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public BookStock()
	{
		initialize();
		con=DBConnection.getConnection();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtid;
	private JLabel lblNewLabel;
	private Button BHOME;
	private JTable table;
	private JScrollPane scrollPane;
	

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
	 * Create the frame.
	 */
	
	
	private void initialize() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1269, 767);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Check Book Details Here");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(429, 41, 408, 42);
		contentPane.add(lblNewLabel);
		
		BHOME = new Button("HOME     ");
		BHOME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				HomeGUI.main(new String[]{});
				dispose();
			}
		});
		BHOME.setBackground(new Color(255, 99, 71));
		BHOME.setFont(new Font("Dubai", Font.BOLD, 20));
		BHOME.setBounds(29, 26, 164, 57);
		contentPane.add(BHOME);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 532, 616);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		table.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		table.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\WhatsApp Image 2021-10-15 at 2.54.32 PM.jpeg"));
		lblNewLabel_1.setBounds(552, 93, 703, 616);
		contentPane.add(lblNewLabel_1);
	}
}
