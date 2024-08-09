import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CostumerDao {
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
		public static int create(Costumer e){
			int status=0;
			try{
				Connection con=CostumerDao.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into customer(cust_name,cust_city,grade,fk_cus_salesman_id) values (?,?,?,?)");
				ps.setString(1,e.getName());
				ps.setString(2,e.getCity());
				ps.setString(3,e.getGrade() + "");
				ps.setString(4,e.getSalesman_id() + "");
		
				status=ps.executeUpdate();
		
				con.close();
			}catch(Exception ex){ex.printStackTrace();}
	
			return status;
		}
}

//Leonardo Pinto Teixeira e Gabriel dos Santos Coutinho
