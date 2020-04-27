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
import modelo.dao.ModeloActividad;

/**
 * Servlet implementation class ApiCreateActividades
 */
@WebServlet("/ApiCreateActividades")
public class ApiCreateActividades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiCreateActividades() {
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
		String jsonActividades = request.getParameter("actividades");
		System.out.println(jsonActividades);
		
		JSONArray jsonArray = new JSONArray(jsonActividades);
		ModeloActividad mActividad = new ModeloActividad();
		
		for(int i=0; i<jsonArray.length(); i++) {
			
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Actividad actividad = new Actividad();
			actividad.setDias(jsonObject.getString("dias"));
			//actividad.setFecha_inicio((jsonObject.Date("fecha_inicio")));
			actividad.setHoras(jsonObject.getInt("horas"));
			actividad.setId(jsonObject.getInt("id"));
			actividad.setMaxParticipantes(jsonObject.getInt("maxParticipantes"));
			actividad.setNombre(jsonObject.getString("nombre"));
			actividad.setPrecio(jsonObject.getDouble("precio"));
			
			mActividad.insert(actividad);
		}
		
		try {
			mActividad.getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setHeader("Access-Control-Allow-Origin","*"); //json deia denean ez da behar
		response.setCharacterEncoding("UTF-8");
		
	}

}
