import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateSalesmanServlet")
public class CreateSalesmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreateSalesmanServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String comission=request.getParameter("comission");

		Salesman e=new Salesman();
		e.setName(name);
		e.setCity(city);
		e.setComission(Double.parseDouble(comission));
		
		int status=SalesmanDao.create(e);
		if(status>0){
		out.print("<p>Vendedor salvo com sucesso!</p>");
		request.getRequestDispatcher("index.html").include(request, response);
		}else{
		out.println("Desculpa! não foi possivel realizar o cadastro");
		}

		out.close();
	}

}

//Leonardo Pinto Teixeira e Gabriel dos Santos Coutinho
