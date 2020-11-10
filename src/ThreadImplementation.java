import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import java.util.Map.Entry;

public class ThreadImplementation implements Runnable {


	String fruit;
	String vitamin;
	public ThreadImplementation(Entry<String, String> ent) {
		// TODO Auto-generated constructor stub
		this.fruit=ent.getKey();
		this.vitamin=ent.getValue();
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		Connection con;
		Statement st;


		try{
			//database connection
			con = DriverManager.getConnection("jdbc:mysql://localhost/telusko","root","raghu");
			st = con.createStatement();

			String sql = "INSERT INTO fruit " +
	                   "VALUES ('"+ fruit+ "', '" +vitamin +"')";
			st.execute(sql);
			st.close();

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
