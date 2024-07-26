import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/readServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = -6447797218270991273L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.jsp'>Adicionar novo produto</a>");
		out.println("<h1>Lista de Produtos</h1>");
		
		List<Produto> list=ProdutoDao.getAllEmployees();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Nome</th><th>Unidade Compra</th><th>Descricão</th><th>Qtd Prevista Mes</th><th>Preco Max Comprado</th><th>edit</th><th>delete</th></tr>");
		for(Produto e:list){
		out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+"</td><td>"+e.getUnidadeCompra()+"</td><td>"+e.getDescricao()+"</td><td>"+e.getQtdPrevistoMes()+"</td><td>"+e.getPrecoMaxComprado()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='deleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}


//Leonardo Pinto Teixeira e Gabriel dos Santos Coutinho
