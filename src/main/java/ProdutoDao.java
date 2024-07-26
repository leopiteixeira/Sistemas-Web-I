import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDao {
	public static Connection getConnection(){
		Connection con=null;
		try{

			String dbDriver = "com.mysql.cj.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/";
			// Database name to access
			String dbName ="SistemasWeb?useTimezone=true&serverTimezone=America/Sao_Paulo";
			String dbUsername = "root";
			String dbPassword = "Tomcat.1";
			Class.forName(dbDriver);
	
			con = DriverManager.getConnection(dbURL + dbName,
			dbUsername, dbPassword); }catch(Exception e){System.out.println(e);}
		return con;
		}
		public static int create(Produto e){
			int status=0;
			try{
				Connection con=ProdutoDao.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into tp02(nome,unidadeCompra,descricao,qtdPrevistoMes,precoMaxComprado) values (?,?,?,?,?)");
				ps.setString(1,e.getNome());
				ps.setString(2,e.getUnidadeCompra() + "");
				ps.setString(3,e.getDescricao());
				ps.setString(4,e.getQtdPrevistoMes() + "");
				ps.setString(5,e.getPrecoMaxComprado() + "");
		
				status=ps.executeUpdate();
		
				con.close();
			}catch(Exception ex){ex.printStackTrace();}
	
			return status;
		}
		
		public static List<Produto> getAllEmployees(){
			
			List<Produto> list=new ArrayList<Produto>();

			try{
				Connection con=ProdutoDao.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from tp02");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Produto e=new Produto();
					e.setId(rs.getInt(1));
					e.setNome(rs.getString(2));
					e.setUnidadeCompra(rs.getInt(3));
					e.setDescricao(rs.getString(4));
					e.setQtdPrevistoMes(rs.getDouble(5));
					e.setPrecoMaxComprado(rs.getDouble(6));
					list.add(e);
				}
				con.close();
			}catch(Exception e){e.printStackTrace();}

			return list;
			}
		
		public static Produto getProdutoById(int id){
			Produto e=new Produto();

			try{
				Connection con=ProdutoDao.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from tp02 where id=?");
				ps.setInt(1,id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					e.setId(rs.getInt(1));
					e.setNome(rs.getString(2));
					e.setUnidadeCompra(rs.getInt(3));
					e.setDescricao(rs.getString(4));
					e.setQtdPrevistoMes(rs.getDouble(5));
					e.setPrecoMaxComprado(rs.getDouble(6));
				}
				con.close();
			}catch(Exception ex){ex.printStackTrace();}

			return e;
			}
		
		public static int update(Produto e){
			int status=0;
			try{
				Connection con=ProdutoDao.getConnection();
				PreparedStatement ps=con.prepareStatement("UPDATE tp02 SET nome=?, unidadeCompra=?, descricao=?, qtdPrevistoMes=?, precoMaxComprado=? WHERE id=?");
				ps.setString(1,e.getNome());
				ps.setInt(2,e.getUnidadeCompra());
				ps.setString(3,e.getDescricao());
				ps.setDouble(4,e.getQtdPrevistoMes());
				ps.setDouble(5,e.getPrecoMaxComprado());
				ps.setInt(6,e.getId());
	
				status=ps.executeUpdate();
	
				con.close();
			}catch(Exception ex){ex.printStackTrace();}

			return status;
			}
		
		public static int delete(int id){
			int status=0;
			try{
				Connection con=ProdutoDao.getConnection();
				PreparedStatement ps=con.prepareStatement("delete from tp02 where id=?");
				ps.setInt(1,id);
				status=ps.executeUpdate();
	
				con.close();
			}catch(Exception e){e.printStackTrace();}

			return status;
			}
}


//Leonardo Pinto Teixeira e Gabriel dos Santos Coutinho