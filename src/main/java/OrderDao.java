import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OrderDao {
	public static Connection getConnection(){
		Connection con=null;
		try{

			String dbDriver = "com.mysql.cj.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/";
			// Database name to access
			String dbName ="prova2?useTimezone=true&serverTimezone=America/Sao_Paulo";
			String dbUsername = "root";
			String dbPassword = "Tomcat.1";
			Class.forName(dbDriver);
	
			con = DriverManager.getConnection(dbURL + dbName,
			dbUsername, dbPassword); }catch(Exception e){System.out.println(e);}
		return con;
		}
		public static int create(Order e){
			int status=0;
			try{
				Connection con=OrderDao.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into orders(purch_amt,ord_date,fk_or_customer_id,fk_or_salesman_id) values (?,CURDATE(),?,?)");
				ps.setString(1,e.getPurch_amt() + "");
				ps.setString(2,e.getCostumer_id() + "");
				ps.setString(3,e.getSalesman_id() + "");
		
				status=ps.executeUpdate();
		
				con.close();
			}catch(Exception ex){ex.printStackTrace();}
	
			return status;
		}
}

