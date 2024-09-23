import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class DeleteBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtbid;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void DeleteBook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBook frame = new DeleteBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteBook() {
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
		setBounds(100, 100, 1085, 744);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(153, 204, 0));
		contentPane_1.setBounds(38, 10, 965, 689);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Book Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBackground(new Color(153, 204, 0));
		panel.setBounds(183, 34, 539, 102);
		contentPane_1.add(panel);
		
		txtbid = new JTextField();
		txtbid.setColumns(10);
		txtbid.setBounds(191, 36, 301, 31);
		panel.add(txtbid);
		
		JLabel lblNewLabel_1_2 = new JLabel("Book ID");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(20, 25, 138, 47);
		panel.add(lblNewLabel_1_2);
		
		Button BDELETE = new Button("DELETE   ");
		BDELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id;
				id  = txtbid.getText();

				try {
					pst = con.prepareStatement("delete from books where id =?");

					pst.setString(1, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
					table_load();

				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		BDELETE.setForeground(Color.BLACK);
		BDELETE.setFont(new Font("Dialog", Font.BOLD, 20));
		BDELETE.setBackground(new Color(255, 102, 0));
		BDELETE.setBounds(273, 173, 132, 41);
		contentPane_1.add(BDELETE);
		
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
		BBACK.setBounds(477, 173, 132, 41);
		contentPane_1.add(BBACK);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 237, 864, 429);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		table.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
	}

}
