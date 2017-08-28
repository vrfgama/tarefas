package control;

import java.io.IOException;
//import java.util.ArrayList;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import command.Command;


/**
 * Servlet implementation class CrudUsuarioServlet
 */
@WebServlet("/crudUsuario")
public class CrudUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		try {  
			request.setCharacterEncoding("UTF-8");
			Command comando = (Command)Class.forName("command."+request.getParameter("command")).newInstance();
			comando.executar(request, response);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		
		doExecute(request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doExecute(request,response);
	}

}
