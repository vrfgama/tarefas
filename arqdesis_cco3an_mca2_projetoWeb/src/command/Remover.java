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

public class Remover implements Command{


	@SuppressWarnings("unchecked")
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher view= null;
		HttpSession session = request.getSession();
		
		Usuario usuario = new Usuario();
		UsuarioService service = new UsuarioService();
		String id2 = request.getParameter("id");
		usuario = service.consultar(id2);		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		if (service.excluir(id2)) {


			lista = (ArrayList<Usuario>) session.getAttribute("lista");
			lista.remove(busca(usuario, lista));

			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("listar.jsp");
			view.forward(request, response);

		} else {
			request.setAttribute("usuario", usuario);

			RequestDispatcher dispatch = request.getRequestDispatcher("erro.jsp");
			dispatch.forward(request, response);
		}
	}
		
		public int busca(Usuario usuario, ArrayList<Usuario> lista) {
			Usuario u;
			for (int i = 0; i < lista.size(); i++) {
				u = lista.get(i);
				if (u.getId().equals(usuario.getId())) {
					return i;
				}
			}
			return -1;

		}	

}
