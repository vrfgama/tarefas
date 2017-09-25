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

public class Cadastrar implements Command{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view= null;
		HttpSession session = request.getSession();
		
		String id = request.getParameter("idUsuario");
		String senha = request.getParameter("senhaUsuario");
		String nome = request.getParameter("nomeUsuario");
		String cpf = request.getParameter("cpfUsuario");
		int funcao = Integer.parseInt(request.getParameter("funcaoUsuario"));
		boolean configAr = Boolean.parseBoolean(request.getParameter("tempUsuario"));
		String hrIni = request.getParameter("hrInicialUsuario");
		String hrFim = request.getParameter("hrFinalUsuario");
		String cnpj = request.getParameter("EmpresaUsuario");

		Usuario usuario = new Usuario(id, nome, senha, cpf, hrIni, hrFim, configAr, funcao, cnpj);
		UsuarioService service = new UsuarioService();		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		if (service.cadastrar(usuario)) {

			lista.add(usuario);
			lista= service.consultarTodos();
			
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("listar.jsp");
			view.forward(request, response);

		} else {

			request.setAttribute("usuario", usuario);

			RequestDispatcher dispatch = request.getRequestDispatcher("erro.jsp");
			dispatch.forward(request, response);
		}
		
	}

}
