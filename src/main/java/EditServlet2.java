import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {

	private static final long serialVersionUID = -1283028498012220846L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String nome=request.getParameter("nome");
		String unidadeCompra=request.getParameter("unidadeCompra");
		String descricao=request.getParameter("descricao");
		String qtdPrevistoMes=request.getParameter("qtdPrevistoMes");
		String precoMaxComprado=request.getParameter("precoMaxComprado");
		
		Produto e=new Produto();
		e.setId(id);
		e.setNome(nome);
		e.setUnidadeCompra(Integer.parseInt(unidadeCompra));
		e.setDescricao(descricao);
		e.setQtdPrevistoMes(Double.parseDouble(qtdPrevistoMes));
		e.setPrecoMaxComprado(Double.parseDouble(precoMaxComprado));
		
		int status=ProdutoDao.update(e);
		if(status>0){
		response.sendRedirect("readServlet");
		}else{
		out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}


//Leonardo Pinto Teixeira e Gabriel dos Santos Coutinho