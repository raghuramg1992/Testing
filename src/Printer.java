import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Printer {

	static void print() {
		// TODO Auto-generated method stub
		Connection con;
		Statement st;
		ResultSet rs;
		try{
			//database connection
			con = DriverManager.getConnection("jdbc:mysql://localhost/telusko","root","raghu");
			st = con.createStatement();
			rs = st.executeQuery("select * from fruit");
			while(rs.next()){
				System.out.println(rs.getString(1)+","+rs.getString(2));
			}
			st.close();
			rs.close();
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Printer.print();
	}

}
