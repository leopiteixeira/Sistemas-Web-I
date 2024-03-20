import java.util.*;
import java.sql.*;
public class EmpDao {
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
public static int save(Emp e){
int status=0;
try{
Connection con=EmpDao.getConnection();
PreparedStatement ps=con.prepareStatement("insert into user905(nome,pass,email,country) values (?,?,?,?)");
ps.setString(1,e.getNome());
ps.setString(2,e.getPassword());
ps.setString(3,e.getEmail());
ps.setString(4,e.getCountry());

status=ps.executeUpdate();

con.close();
}catch(Exception ex){ex.printStackTrace();}

return status;
}
public static int update(Emp e){
int status=0;
try{
Connection con=EmpDao.getConnection();
PreparedStatement ps=con.prepareStatement("UPDATE user905 SET nome=?, pass=?, email=?, country=? WHERE id=?");
ps.setString(1,e.getNome());
ps.setString(2,e.getPassword());
ps.setString(3,e.getEmail());
ps.setString(4,e.getCountry());
ps.setInt(5,e.getId());

status=ps.executeUpdate();

con.close();
}catch(Exception ex){ex.printStackTrace();}

return status;
}
public static int delete(int id){
int status=0;
try{
Connection con=EmpDao.getConnection();
PreparedStatement ps=con.prepareStatement("delete from user905 where id=?");
ps.setInt(1,id);
status=ps.executeUpdate();

con.close();
}catch(Exception e){e.printStackTrace();}

return status;
}
public static Emp getEmployeeById(int id){
Emp e=new Emp();

try{
Connection con=EmpDao.getConnection();
PreparedStatement ps=con.prepareStatement("select * from user905where id=?");
ps.setInt(1,id);
ResultSet rs=ps.executeQuery();
if(rs.next()){
e.setId(rs.getInt(1));
e.setNome(rs.getString(2));
e.setPassword(rs.getString(3));
e.setEmail(rs.getString(4));
e.setCountry(rs.getString(5));
}
con.close();
}catch(Exception ex){ex.printStackTrace();}

return e;
}
public static List<Emp> getAllEmployees(){
List<Emp> list=new ArrayList<Emp>();

try{
Connection con=EmpDao.getConnection();
PreparedStatement ps=con.prepareStatement("select * from user905");
ResultSet rs=ps.executeQuery();
while(rs.next()){
Emp e=new Emp();
e.setId(rs.getInt(1));
e.setNome(rs.getString(2));
e.setPassword(rs.getString(3));
e.setEmail(rs.getString(4));
e.setCountry(rs.getString(5));
list.add(e);
}
con.close();
}catch(Exception e){e.printStackTrace();}

return list;
}
}

//Leonardo Pinto Teixeira e Gabriel dos Santos Coutinho