package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class CrudUsuarioServlet
 */
@WebServlet("/crudUsuario")
public class CrudUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrudUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		Usuario usuario = new Usuario();
		UsuarioService service = new UsuarioService();
		String acao = request.getParameter("acao");
		String id2 = request.getParameter("id");

		if (acao.equals("reiniciar")) {
			
			session.setAttribute("lista", null);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
			dispatcher.forward(request, response);

		} else if (acao.equals("Detalhar")) {

			usuario = service.consultar(id2);
			session.setAttribute("usuario", usuario);

			RequestDispatcher dispatcher = request.getRequestDispatcher("visualizar.jsp");
			dispatcher.forward(request, response);

		} else if (acao.equals("Editar")) {

			usuario = service.consultar(id2);
			session.setAttribute("usuario", usuario);
			RequestDispatcher dispatcher = request.getRequestDispatcher("alterar.jsp");
			dispatcher.forward(request, response);

		}else if(acao.equals("listar")){
			ArrayList<Usuario> lista = new ArrayList<Usuario>();
			lista = service.consultarTodos();
			session.setAttribute("lista", lista);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String acao = request.getParameter("acao");
		String id2 = request.getParameter("id");

		switch (acao) {
		case "Cadastrar": {
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

			if (service.cadastrar(usuario)) {

				lista.add(usuario);
				lista= service.consultarTodos();
				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("listar.jsp");

			} else {

				request.setAttribute("usuario", usuario);

				RequestDispatcher dispatch = request.getRequestDispatcher("erro.jsp");
				dispatch.forward(request, response);
			}
		}
		break;
		case "Consultar": {
			String chave = request.getParameter("data[search]");
			UsuarioService service = new UsuarioService();
			Usuario usuario = new Usuario();

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

		}
		break;
		case "Remover": {
			Usuario usuario = new Usuario();
			UsuarioService service = new UsuarioService();

			usuario = service.consultar(id2);

			if (service.excluir(id2)) {

				lista = (ArrayList<Usuario>) session.getAttribute("lista");
				lista.remove(busca(usuario, lista));

				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("listar.jsp");

			} else {
				request.setAttribute("usuario", usuario);

				RequestDispatcher dispatch = request.getRequestDispatcher("erro.jsp");
				dispatch.forward(request, response);

			}
		}
		break;
		case "Atualizar": {

			String senha = request.getParameter("senhaUsuario");
			String nome = request.getParameter("nomeUsuario");
			String cpf = request.getParameter("cpfUsuario");
			int funcao = Integer.parseInt(request.getParameter("funcaoUsuario"));
			boolean configAr = Boolean.parseBoolean(request.getParameter("tempUsuario"));
			String hrIni = request.getParameter("hrInicialUsuario");
			String hrFim = request.getParameter("hrFinalUsuario");
			String cnpj = request.getParameter("EmpresaUsuario");

			Usuario usuario = new Usuario(id2, nome, senha, cpf, hrIni, hrFim, configAr, funcao, cnpj);

			UsuarioService service = new UsuarioService();

			if (service.alterar(usuario)) {

				usuario = service.consultar(usuario.getId());

				session.setAttribute("usuario", usuario);
				view = request.getRequestDispatcher("visualizar.jsp");

			} else {

				request.setAttribute("usuario", usuario);

				RequestDispatcher dispatch = request.getRequestDispatcher("erro.jsp");
				dispatch.forward(request, response);
			}
		}
		break;

		}

		view.forward(request, response);

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
