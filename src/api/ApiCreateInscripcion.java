package api;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import modelo.bean.Actividad;
import modelo.bean.Inscripcion;
import modelo.bean.Usuario;
import modelo.dao.ModeloInscripcion;

/**
 * Servlet implementation class ApiCreateInscripcion
 */
@WebServlet("/ApiCreateInscripcion")
public class ApiCreateInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiCreateInscripcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//datuak jaso
		request.setCharacterEncoding("UTF-8");
		String jsonInscripcion= request.getParameter("inscripcion");
		String jsonUsuario = request.getParameter("usuario");
		String jsonActividad = request.getParameter("actividad");
		System.out.println(jsonInscripcion);
		
		JSONObject jsonObject = new JSONObject(jsonInscripcion);
		JSONObject jsonObject2 = new JSONObject(jsonUsuario);
		JSONObject jsonObject3 = new JSONObject(jsonActividad);
		
		//Usuario objetua sortu		
		Usuario usuario = new Usuario();
		usuario.setNombreApellido(jsonObject2.getString("nombreApellido"));
		usuario.setCodigo(jsonObject2.getString("codigo"));
		usuario.setDni(jsonObject2.getString("dni"));
		
		//Actividad objetua sortu
		Actividad actividad = new Actividad();
		actividad.setDias(jsonObject3.getString("dias"));
		//actividad.setFecha_inicio((jsonObject.Date("fecha_inicio")));
		actividad.setHoras(jsonObject3.getInt("horas"));
		actividad.setId(jsonObject3.getInt("id"));
		actividad.setMaxParticipantes(jsonObject3.getInt("maxParticipantes"));
		actividad.setNombre(jsonObject3.getString("nombre"));
		actividad.setPrecio(jsonObject3.getDouble("precio"));
	
		//Inscripcion objetua sortu
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setId(jsonObject.getInt("id"));
		inscripcion.setUsuario(usuario);
		inscripcion.setActividad(actividad);
		
		ModeloInscripcion mInscripcion = new ModeloInscripcion();
		mInscripcion.inscribir(usuario, actividad);
		
		try {
			mInscripcion.getConexion().close();
		} catch (SQLException e) {
			System.out.println("Errorea conexioa ixtean");
			e.printStackTrace();
		}
		
		response.setHeader("Access-Control-Allow-Origin","*"); //jsonp deia denean ez da behar
		response.setCharacterEncoding("UTF-8");
			
	}

}
