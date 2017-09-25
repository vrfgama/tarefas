package utils;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;
import model.Usuario;

public class JSONFacade {
	
	public static String JSON(HttpServletRequest request) throws IOException{
		BufferedReader r= request.getReader();
		StringBuilder sb= new StringBuilder();
		String l;
		while((l= r.readLine()) != null){
			sb.append(l);
		}
				
		return sb.toString();	
	}
	
	public static Usuario toUsuario(String json) throws IOException{
		try{
			JSONObject jObject= new JSONObject(json);	
			String id = jObject.getString("idUsuario");
			String senha = jObject.getString("senhaUsuario");
			String nome = jObject.getString("nomeUsuario");
			String cpf = jObject.getString("cpfUsuario");
			int funcao = jObject.getInt("funcaoUsuario");
			boolean configAr = jObject.getBoolean("tempUsuario");
			String hrIni = jObject.getString("hrInicialUsuario");
			String hrFim = jObject.getString("hrFinalUsuario");
			String cnpj = jObject.getString("EmpresaUsuario");
			Usuario usuario = new Usuario(id, nome, senha, cpf, hrIni, hrFim, configAr, funcao, cnpj);
			return usuario;
		}catch(JSONException e){
			throw new IOException(e);
		}		
	}
	
	public static String toJSON(Usuario u) throws IOException, JSONException{
 		try {
 			JSONObject jObject= new JSONObject();
 			jObject.put("ID", u.getId());
 			jObject.put("Nome", u.getNome());
 			jObject.put("foi cadastrado com sucesso", true);//**********

 			return jObject.toString();
 			
 		}catch(JSONException e) {
 			throw new IOException(e);
 		}
 	}

}
