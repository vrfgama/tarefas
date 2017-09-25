package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class Detalhar implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		RequestDispatcher view= null;
		
		Usuario usuario = new Usuario();
		UsuarioService service = new UsuarioService();
		String id2 = request.getParameter("id");
		
		usuario = service.consultar(id2);
		session.setAttribute("usuario", usuario);
		
		view = request.getRequestDispatcher("visualizar.jsp");
		view.forward(request, response);
		
	}

}
