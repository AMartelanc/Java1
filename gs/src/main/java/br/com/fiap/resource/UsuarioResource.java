package br.com.fiap.resource;


import java.util.ArrayList;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.bean.Usuario;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;




	@Path("/usuario")
	public class UsuarioResource {
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response listarTodos() {
			ArrayList<Usuario> resposta = UsuarioDAO.listarTodos();
			ResponseBuilder response = Response.ok();
			response.entity(resposta);
			return response.build();
		}
		
/**
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response inserir(Usuario usuario, @Context UriInfo uri) throws ClassNotFoundException, SQLException, BadInfoException {
			try {
				Usuario resposta = UsuarioDAO.inserir(usuario);
				ResponseBuilder response = null;
				if (resposta != null) {
					response = Response.created(null); //201 - Created
				} else {
					response = Response.status(400); // 400 - Bad Request
				}
				response.entity(resposta);
				return response.build(); 
			}
		}
**/
}	

