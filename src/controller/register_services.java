package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Servicio;
import util.JPAUtil;

/**
 * Servlet implementation class register_alumn
 */
@WebServlet("/register_services")
public class register_services extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register_services() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register_services.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		int tienda = Integer.parseInt(request.getParameter("tienda"));
		Servicio objServicio = new Servicio();
		objServicio.setDescripcion(descripcion);
		objServicio.setNombre(nombre);
		objServicio.setTienda(tienda);
		
		EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		entity.getTransaction().begin();
		entity.persist(objServicio);
		entity.getTransaction().commit();
		System.out.println("Servicio registrado.."+objServicio.toString());
		request.getRequestDispatcher("select_registro.jsp").forward(request, response);
		
		
		
	}

}
