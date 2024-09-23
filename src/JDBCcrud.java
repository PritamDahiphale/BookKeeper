//importing packages
import javax.sql.*;

import java.sql.*;
import java.util.Scanner;

public class JDBCcrud{  


        static Connection con;
        static PreparedStatement pstmt1,pstmt2,pstmt3,pstmt4,pstmt5,pstmt6,pstmt7;
	
        static ResultSet rs;
        static ResultSet r;
        
        static int ch;
        static int choice;
        static String name,location;
        static int salary;
        static int rn;
        static Scanner sc=new Scanner(System.in);


       
      public static void main(String[] args) throws SQLException{

         String Insertquery = "INSERT INTO emp3(Name, Salary, Location) VALUES (?, ?, ?)";
         String searchquery = "SELECT name,salary,location FROM emp3 where name=? ";
         String sql = "select * from emp3";
	 String displayquery = "select * from emp3";
	String updatesql = "UPDATE emp3 SET salary=? WHERE name=? ";
        String Displaysql="select * from emp3";
	String delsql = "Delete from emp3 WHERE name=? ";
    

        
     try{
			//establish the connection
			Class.forName("oracle.jdbc.OracleDriver");

			//make a connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");

			 //create prepare statement
			pstmt1=con.prepareStatement(Insertquery);

			//create prepare statement
			pstmt2=con.prepareStatement(searchquery);

				
			//create prepare statement
			pstmt3=con.prepareStatement(displayquery);
                        
			//create prepare statement
			pstmt4=con.prepareStatement(updatesql);

			//create prepare statement
			pstmt5=con.prepareStatement(delsql);

			
                        //Get Resultset
                      //  rs=pstmt6.executeQuery(searchquery);
                        
			// rs=pstmt7.executeQuery(displayquery);
			//pstmt8=con.prepareStatement(Displaysql);
        
        do
        {
        System.out.println("1-Insert Record\n2-Search Record\n3-Display record\n4-Update Record\n5-Delete Record");
        System.out.println("\nEnter your choice:");
        ch=sc.nextInt();
        
        switch(ch)
        {
           case 1:
                  
	          System.out.print("Enter your Name: ");
	          name = sc.next();
	          System.out.print("Enter salary: ");
	          salary = sc.nextInt(); 
                  System.out.print("Enter the location: ");
	          location = sc.next();
                  InsertRecord();
           break;  
           
           case 2:
                  System.out.print("Enter name  to search record: ");
	          name = sc.next();
                  searchRecord();
                  
           break;
              
           case 3:
                 DisplayRecord();
           break;
            
           case 4:
                 System.out.print("Enter Name of emp: ");
	         name = sc.next();
                
	         System.out.print("Enter updated salary: ");
	         salary = sc.nextInt();
                 
                 EditRecord();
           break;
           case 5:
                 System.out.print("Enter Name of emp to delete from database: ");
	         name = sc.next();
                 DeleteRecord();
           break;
           default:

          }//end of swich 

    System.out.println("Do you want to continue press 1:");
     choice=sc.nextInt();
   }while(choice==1);

        rs.close(); 
        con.close();          
             
   } catch (SQLException e) {
         		e.printStackTrace();
                       } //end of catch block   

    catch (ClassNotFoundException el) {
				
	el.printStackTrace();
	} 
}//end of main
public static void InsertRecord() throws SQLException{
                        System.out.println("");
                   
                        //insert SQL statement
                        pstmt1.setString(1, name);
                        pstmt1.setInt(2, salary);
                        pstmt1.setString(3, location);
                        
                       pstmt1.executeUpdate();
                       System.out.println("Inserted records into the table...");  	
                       
   
}   // end InsertRecord method



public static void searchRecord() throws SQLException
{
                        pstmt2.setString(1, name);
                        ResultSet rs = pstmt2.executeQuery();			
			
                        //Display Registration table records 
                        System.out.println("Display specific record...");          
         		 
                        System.out.println("Name\tsalary\tlocation");
                        if(rs.next()==true)
			{
				System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getString(3));
                        }
                        else
                        {
                                System.out.println("Invalid employee name");
                        }
  
                       
}  //end of searchRecord method
       

public static void DisplayRecord() throws SQLException
{

                        //Display Registration table records 
                        System.out.println("Display records into the employee table...");          
         		

                        //Get Resultset
                        rs=pstmt3.executeQuery();
                        System.out.println("FirstName\tSalary\tLocation");
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3));
                        }
   
                       
         }    //end of DisplayRecord method

public static void EditRecord() throws SQLException
{
                        
                        pstmt4.setInt(1,salary);
                        pstmt4.setString(2,name);
                        
                         rn=pstmt4.executeUpdate();
                         
                         System.out.println("Record Updateded");

                       //Display Registration table records 
                        System.out.println("After updation"); 

                        
                        //Get Resultset
                         rs=pstmt4.executeQuery();
                        System.out.println("FirstName\tSalary\tLocation");
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getInt(2)+"\t\t"+rs.getString(3));
                        }

}// end of editRecord method

public static void DeleteRecord() throws SQLException
{     
			
                        pstmt5.setString(1,name);
                        
                         rn=pstmt5.executeUpdate();
                         
                         System.out.println("Record Deleted from dataset");

                       //Display Registration table records 
                        System.out.println("After Deletion"); 

                        //Get Resultset
                         rs=pstmt5.executeQuery();
                        System.out.println("FirstName\tSalary\tLocation");
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getInt(2)+"\t\t"+rs.getString(3));
                        }

}//end of DeleteRecord method


}//end of main class


