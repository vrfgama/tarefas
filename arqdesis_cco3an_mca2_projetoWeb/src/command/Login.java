package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class Login implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("username");
		String senha = request.getParameter("passwd");
		
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setSenha(senha);
		UsuarioService service = new UsuarioService();
		
		if(service.validar(usuario)){  
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
		
		
		
	}

}
