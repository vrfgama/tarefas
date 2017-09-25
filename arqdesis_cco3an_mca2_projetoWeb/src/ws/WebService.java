package ws;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import model.Usuario;
import service.UsuarioService;
import utils.JSONFacade;

/**
 * Servlet implementation class WebService
 */
@WebServlet("/cadUsuario")
public class WebService extends HttpServlet  {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see Object#Object()
     */
    public WebService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("application/json");
    	
    	super.service(request, response);
    	
	}
	
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String json= JSONFacade.JSON(request);
		Usuario usuario= JSONFacade.toUsuario(json);
		UsuarioService service= new UsuarioService();

		if(service.cadastrar(usuario)){  
			try {
				response.getWriter().println(JSONFacade.toJSON(service.consultar(usuario.getId())));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}

}
