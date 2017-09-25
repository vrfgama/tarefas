package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class Consultar implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		RequestDispatcher view= null;
		
		String chave = request.getParameter("data[search]");
		UsuarioService service = new UsuarioService();
		Usuario usuario = new Usuario();
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		if (chave != null && chave.length() > 0) {

			usuario = service.consultar(chave);

			if(usuario.getNome()==null){
				RequestDispatcher dispatch = request.getRequestDispatcher("erro.jsp");
				dispatch.forward(request, response);
			}else{
				lista.add(usuario);
			}
		} else { 
			lista = service.consultarTodos();
		}

		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("listar.jsp");
		view.forward(request, response);
	}

}
