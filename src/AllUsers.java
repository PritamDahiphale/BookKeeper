import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JList;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AllUsers extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void AllUsers()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllUsers frame = new AllUsers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 public AllUsers() {
		initialize();
		con=DBConnection.getConnection();
		table_load();
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JScrollPane scrollPane;
	

	public void table_load()
	{
		try
		{
			pst=con.prepareStatement("select * from signup");
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
		setBounds(100, 100, 948, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 0));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 92, 774, 489);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBackground(new Color(255, 255, 255));
		table.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		
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
		BBACK.setBackground(new Color(255, 69, 0));
		BBACK.setBounds(25, 22, 132, 41);
		contentPane.add(BBACK);
	}
}
