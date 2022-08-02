import java.sql.*;
import java.util.Arrays;
import java.util.Comparator;
public class DBMS {
	Connection con;
	
	public DBMS() {
		 
		 
		try {
			
			
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/counselling","root","YourRootPasswo");
			
		}
			    catch (SQLException e) {
			System.out.println("Error while connecting to the database");
			}
	}
	
	
	
	
	public String[] college_Name() throws SQLException {
		Statement st=con.createStatement();
		String query = "SELECT College_Name FROM college";
		
		Statement st1=con.createStatement(); 
		String query1 = "SELECT count(College_Name) FROM college";
        
		ResultSet rs = st.executeQuery(query);
		ResultSet rs1 = st1.executeQuery(query1);
		rs1.next();
	     String name[] = new String[rs1.getInt(1)];
	     int i = 0;
 		     while(rs.next()){        
		    	name[i] = rs.getString(1);
		    	i++;
		} 
		return name;
		
	}
	
	
	
	public String[] college_Details(String college_Name) throws SQLException {
		String[] Details = new String[8];
		Statement st=con.createStatement(); 
		String query = "SELECT Type,Nirf_rank,Placement,Location,Website,seat_matrix,Semester_Fee FROM college where College_Name = \'"+college_Name+"\'";
		
		Statement st1=con.createStatement(); 
		String query1 = "SELECT count(DISTINCT  Course) FROM ranking where College_Name = \'"+college_Name+"\'";
		ResultSet rs1 = st.executeQuery(query1);
		rs1.next();
		Details[7] = rs1.getString(1);
		ResultSet rs = st.executeQuery(query);
		rs.next();
		Details[0] = rs.getString(1);
		Details[1] = rs.getString(2);
		Details[2] = rs.getString(3);
		Details[3] = rs.getString(4);
		Details[4] = rs.getString(5);
		Details[5] = rs.getString(6);
		Details[6] = rs.getString(7);
		return Details;
	}
	
	
	
	 public String[][] Table_branch(String college_Name,String gender,String category) throws SQLException {
		 Statement st=con.createStatement();
		String query = "SELECT Course,Opening_Rank,Closing_Rank FROM ranking where Category = \'"+category+"\'" + "AND Gender = \'"+gender+"\'"
					+ "AND College_Name = \'"+college_Name+"\'";
		ResultSet rs = st.executeQuery(query);
		
		Statement st1=con.createStatement();
		String query1 = "SELECT count(*) FROM ranking where Category = \'"+category+"\'" + "AND Gender = \'"+gender+"\'"
					+ "AND College_Name = \'"+college_Name+"\'";
		ResultSet rs1 = st1.executeQuery(query1);
		rs1.next();
		String Data[][] = new String[rs1.getInt(1)][3];
		int i = 0;
	     while(rs.next()){        
	    	Data[i][0] = rs.getString(1);
	    	Data[i][1] = rs.getString(2);
	    	Data[i][2] = rs.getString(3);
	    	i++;
	} 
	return Data;
		
	 }
	 
	 
	public String[] branch_Name() throws SQLException {
		Statement st=con.createStatement(); 
		String query = "SELECT Course FROM branch";
		
		Statement st1=con.createStatement(); 
		String query1 = "SELECT count(Course) FROM branch";
        
		ResultSet rs = st.executeQuery(query);
		ResultSet rs1 = st1.executeQuery(query1);
		rs1.next();
	     String name[] = new String[rs1.getInt(1)];
	     int i = 0;
 		     while(rs.next()){        
		    	name[i] = rs.getString(1);
		    	i++;
		} 
		return name;
		
	}
	
	
	
	public void Table(String rank,String exam,String gender,String cat,String branch[]) throws SQLException {
		Statement st=con.createStatement(); 
		Statement st1=con.createStatement(); 
		
		int i = 0;
		System.out.println(cat);
		
		String query1 = null;
		String query2 = null;
		String Course = "";
		int k = 0;
		while(true) {
			
			if(k==branch.length||branch[k]==null)
				break;
			else {
				Course = Course +"'"+branch[k] + "',";
			}
			k++;
		}
		Course = Course.substring(0,Course.length()-1);
		
		if(cat.equals("All")) {
			if(exam.equals("Jee Advance"))
			query1 = "SELECT * FROM ranking where Closing_Rank > "+rank+" AND Gender = \'"+gender+"\'"
					+ " AND College_Name IN (SELECT College_Name FROM college where Type = 'IIT') AND Course IN " + "(" + Course + ")";
			else
				query1 = "SELECT * FROM ranking where Closing_Rank > "+rank+" AND Gender = \'"+gender+"\'"
						+ " AND College_Name IN (SELECT College_Name FROM college where Type != 'IIT') AND Course IN " + "(" + Course + ")";
		}
		else {
			if(exam.equals("Jee Advance"))
		query1= "SELECT * FROM ranking where Closing_Rank > "+rank+" AND Gender = \'"+gender+"\'"+" AND Category = \'"+cat+"\'" +
			" AND College_Name IN (SELECT College_Name FROM college where Type = 'IIT') AND Course IN " + "(" + Course + ")";
			else
				query1= "SELECT * FROM ranking where Closing_Rank > "+rank+" AND Gender = \'"+gender+"\'"+" AND Category = \'"+cat+"\'" +
						" AND College_Name IN (SELECT College_Name FROM college where Type != 'IIT') AND Course IN " + "(" + Course + ")";
		}
		                                         
		query2 = query1.substring(0, 7)+"count("+query1.substring(7, 8)+")"+query1.substring(8, query1.length());
		
		 ResultSet rs = st.executeQuery(query1);
	 ResultSet rs2 = st1.executeQuery(query2);
	 rs2.next();
		
	     String data[][] = new String[rs2.getInt(1)][7];
		     while(rs.next()){        
		    	 data[i][1] = rs.getString(1);
		    	 data[i][2] = rs.getString(2);
		    	 data[i][3] = rs.getString(3);
		    	 data[i][4] = rs.getString(4);
		    	 data[i][5] = rs.getString(5);
		    	 data[i][6] = rs.getString(6);
		    	 
		    	 i++;
		   
		} 
		     Arrays.sort(data,new Comparator<String[]>()
		     {
		 			@Override
		 			public int compare(String[] e1 , String[] e2) 
		       {
		 				if(Integer.parseInt(e1[6]) > Integer.parseInt(e2[6]))
		 					return 1;
		 				else
		 					return -1;

		 			}
		 		});
		     for(int j = 0;j<data.length;j++) {
		    	 data[j][0] = Integer.toString(j+1);
		     }
		 
		new Table(data);
	}	
	
}
