import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = -1283028498012220846L;

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out=response.getWriter();

String sid=request.getParameter("id");
int id=Integer.parseInt(sid);
String nome=request.getParameter("nome");
String password=request.getParameter("pass");
String email=request.getParameter("email");
String country=request.getParameter("country");

Emp e=new Emp();
e.setId(id);
e.setNome(nome);
e.setPassword(password);
e.setEmail(email);
e.setCountry(country);

int status=EmpDao.update(e);
if(status>0){
response.sendRedirect("ViewServlet");
}else{
out.println("Sorry! unable to update record");
}

out.close();
}

}

//Leonardo Pinto Teixeira e Gabriel dos Santos Coutinho