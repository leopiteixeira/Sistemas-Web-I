import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateCostumerServlet")
public class CreateCostumerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreateCostumerServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String grade=request.getParameter("grade");
		String salesman_id=request.getParameter("id_sal");

		Costumer e=new Costumer();
		e.setName(name);
		e.setCity(city);
		e.setGrade(Double.parseDouble(grade));
		e.setSalesman_id(Integer.parseInt(salesman_id));
		
		int status=CostumerDao.create(e);
		if(status>0){
		out.print("<p>Cliente salvo com sucesso!</p>");
		request.getRequestDispatcher("index.html").include(request, response);
		}else{
		out.println("Desculpa! não foi possivel realizar o cadastro");
		}

		out.close();
	}

}

//Leonardo Pinto Teixeira e Gabriel dos Santos Coutinho
