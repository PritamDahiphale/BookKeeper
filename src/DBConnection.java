//database connection class
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnection {
   
    static Connection con = null;
    
    public static Connection getConnection(){
        
            try {
				Class.forName("oracle.jdbc.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"SQL Unique Constraint");
			}    
        return con;
    }
}
