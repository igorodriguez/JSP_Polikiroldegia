package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Usuario;
import modelo.dao.ModeloUsuario;

/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//datuak jaso
		int idUsuario = Integer.parseInt(request.getParameter("id"));
		String nombreApellido = request.getParameter("nombreApellido");
		String dni = request.getParameter("dni");
		String codigo = request.getParameter("codigo");
				
		//sortu usuario objetu bat
		Usuario usuario = new Usuario();
		//jasotako datuekin setak egin
		usuario.setId(idUsuario);
		usuario.setNombreApellido(nombreApellido);
		usuario.setDni(dni);
		usuario.setCodigo(codigo);
		
		ModeloUsuario mUsuario = new ModeloUsuario();
		mUsuario.update(usuario);
		
		response.sendRedirect("VerUsuario?id=" + idUsuario);
		//response.sendRedirect("VerUsuarios");
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
