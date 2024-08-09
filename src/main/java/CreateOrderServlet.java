import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreateOrderServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String purch_amt=request.getParameter("purch_amt");
		String id_cus=request.getParameter("id_cus");
		String id_sal=request.getParameter("id_sal");

		Order e=new Order();
		e.setPurch_amt(Double.parseDouble(purch_amt));
		e.setCostumer_id(Integer.parseInt(id_cus));
		e.setSalesman_id(Integer.parseInt(id_sal));
		
		int status=OrderDao.create(e);
		if(status>0){
		out.print("<p>Ordem de Venda salva com sucesso!</p>");
		request.getRequestDispatcher("index.html").include(request, response);
		}else{
		out.println("Desculpa! não foi possivel realizar o cadastro");
		}

		out.close();
	}

}

//Leonardo Pinto Teixeira e Gabriel dos Santos Coutinho
