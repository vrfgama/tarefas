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


public class Listar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		RequestDispatcher view= null;
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		UsuarioService service = new UsuarioService();
		lista = service.consultarTodos();
		
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("listar.jsp");
		view.forward(request, response);
		
	}

}
