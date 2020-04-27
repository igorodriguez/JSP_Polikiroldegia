package api;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import modelo.bean.Actividad;
import modelo.bean.Inscripcion;
import modelo.bean.Usuario;
import modelo.dao.ModeloActividad;
import modelo.dao.ModeloInscripcion;
import modelo.dao.ModeloUsuario;

/**
 * Servlet implementation class ApiCreateInscripciones
 */
@WebServlet("/ApiCreateInscripciones")
public class ApiCreateInscripciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiCreateInscripciones() {
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
		String jsonInscripciones= request.getParameter("inscripciones");
		String jsonUsuarios = request.getParameter("usuarios");
		String jsonActividades = request.getParameter("actividades");
		
		System.out.println(jsonInscripciones);
		
		JSONArray jsonArray = new JSONArray(jsonInscripciones);
		JSONArray jsonArray2 = new JSONArray(jsonUsuarios);
		JSONArray jsonArray3 = new JSONArray(jsonActividades);
		
		//modeloak sortu
		ModeloInscripcion mInscripcion = new ModeloInscripcion();
		ModeloUsuario mUsuario = new ModeloUsuario();
		ModeloActividad mActividad = new ModeloActividad();
		
		//Usuario objetua sortu eta errekorritu
		
		for(int i=0; i< jsonArray2.length(); i++) {
			JSONObject jsonObject2 = jsonArray2.getJSONObject(i);
			Usuario usuario = new Usuario();
			usuario.setNombreApellido(jsonObject2.getString("nombreApellido"));
			usuario.setCodigo(jsonObject2.getString("codigo"));
			usuario.setDni(jsonObject2.getString("dni"));
		}
		
		//Actividad objetua sortu eta errekorritu
		
		for(int i=0; i< jsonArray3.length(); i++) {
			JSONObject jsonObject3 = jsonArray3.getJSONObject(i);
			Actividad actividad = new Actividad();
			actividad.setDias(jsonObject3.getString("dias"));
			//actividad.setFecha_inicio((jsonObject.Date("fecha_inicio")));
			actividad.setHoras(jsonObject3.getInt("horas"));
			actividad.setId(jsonObject3.getInt("id"));
			actividad.setMaxParticipantes(jsonObject3.getInt("maxParticipantes"));
			actividad.setNombre(jsonObject3.getString("nombre"));
			actividad.setPrecio(jsonObject3.getDouble("precio"));
		}
		
		Usuario usuario = new Usuario();
		Actividad actividad = new Actividad();
		//Inscripcion objetua sortu eta errekorritu
		for(int i=0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Inscripcion inscripcion = new Inscripcion();
			inscripcion.setUsuario(usuario);
			inscripcion.setActividad(actividad);
			inscripcion.setId(jsonObject.getInt("id"));
			
			mInscripcion.inscribir(usuario, actividad);
		}
		
		try {
			mInscripcion.getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setHeader("Access-Control-Allow-Origin","*"); //json deia denean ez da behar
		response.setCharacterEncoding("UTF-8");
	}

}
