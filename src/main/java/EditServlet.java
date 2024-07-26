import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = 4904916521801565996L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Edite o Produto</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Produto e=ProdutoDao.getProdutoById(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>Nome:</td><td><input type='text' name='nome' value='"+e.getNome()+"'/></td></tr>");
		out.print("<tr><td>Unidade Compra:</td><td><input type='number' name='unidadeCompra' value='"+e.getUnidadeCompra()+"'/></td></tr>");
		out.print("<tr><td>Descricao:</td><td><input type='text' name='descricao' value='"+e.getDescricao()+"'/></td></tr>");
		out.print("<tr><td>Quantidade Previsto Mes:</td><td><input type='number' name='qtdPrevistoMes' value='"+e.getQtdPrevistoMes()+"'/></td></tr>");
		out.print("<tr><td>Preco Maximo Comprado:</td><td><input type='number' name='precoMaxComprado' value='"+e.getPrecoMaxComprado()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}

}


//Leonardo Pinto Teixeira e Gabriel dos Santos Coutinho
