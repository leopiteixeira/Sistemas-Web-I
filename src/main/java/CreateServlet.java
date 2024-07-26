import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novoProduto")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreateServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String name=request.getParameter("nome");
		String unidadeCompra=request.getParameter("unidadeCompra");
		String descricao=request.getParameter("descricao");
		String qtdPrevistoMes=request.getParameter("qtdPrevistoMes");
		String precoMaxComprado=request.getParameter("precoMaxComprado");

		Produto e=new Produto();
		e.setNome(name);
		e.setUnidadeCompra(Integer.parseInt(unidadeCompra));
		e.setDescricao(descricao);
		e.setQtdPrevistoMes(Double.parseDouble(qtdPrevistoMes));
		e.setPrecoMaxComprado(Double.parseDouble(precoMaxComprado));

		int status=ProdutoDao.create(e);
		if(status>0){
		out.print("<p>Record saved successfully!</p>");
		request.getRequestDispatcher("index.jsp").include(request, response);
		}else{
		out.println("Sorry! unable to save record");
		}

		out.close();
	}

}

//Leonardo Pinto Teixeira e Gabriel dos Santos Coutinho
