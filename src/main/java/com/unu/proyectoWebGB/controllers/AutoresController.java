package com.unu.proyectoWebGB.controllers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.unu.proyectoWebGB.beans.Autor;
import com.unu.proyectoWebGB.models.AutoresModel;

/**
 * Servlet implementation class AutoresController
 */
public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AutoresModel modelo = new AutoresModel();

	/**
	 * @return 
	 * @see HttpServlet#HttpServlet()
	 */
	public AutoresController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException, SQLException {

		if (request.getParameter("op") == null) {
			listar(request, response);
			return;
		}
		String operacion = request.getParameter("op");
		switch (operacion) {

		case "listar":
			listar(request, response);
			break;

		case "nuevo":
			request .getRequestDispatcher("/autores/nuevoAutores.jsp").forward(request, response);
			break;
		case "insertar":
			insertar(request, response);
			break;
		case "obtener":
			obtener(request, response);
			break;
		case "modificar":
			modificar(request, response);
			break;
		case "eliminar":
			eliminar(request, response);
			break;

		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException,SQLException {
		request.setAttribute("listaAutores", modelo.listarAutores());
	    Iterator<Autor> it = modelo.listarAutores().iterator();
	    while(it.hasNext()) {
	    	Autor a = it.next();
	    	System.out.println(a.getIdAutor()+" "
	    			+a.getNombre()+" "
	    			+a.getNacionalidad());
	    }
		request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);
	}
	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		try {

			Autor miAutor = new Autor();
			//miAutor.setIdAutor(request.getParameter("codigo"));
			miAutor.setNombre(request.getParameter("nombre"));
			miAutor.setNacionalidad(request.getParameter("nacionalidad"));
		

			if (modelo.insertarAutor(miAutor) > 0) {
				request.getSession().setAttribute("exito", "autor registrado exitosamente");
				response.sendRedirect(request.getContextPath() + "/AutoresController?op=listar");
			} else {
				request.getSession().setAttribute("fracaso",
						"El autor no ha sido ingresado" + "ya hay un autor con este codigo");
				response.sendRedirect(request.getContextPath() + "/AutoresController?op=listar");
			}

		} catch (IOException | SQLException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	private void modificar(HttpServletRequest request, HttpServletResponse response) {
		try {

			Autor miAutor = new Autor();
			miAutor.setIdAutor(Integer.parseInt(request.getParameter("idautor")));
			miAutor.setNombre(request.getParameter("nombre"));
			miAutor.setNacionalidad(request.getParameter("nacionalidad"));
			request.setAttribute("autor", miAutor);
			//request.getRequestDispatcher("AutoresController?op=obtener").forward(request, response);

			if (modelo.modificarAutor(miAutor) > 0) {
				request.getSession().setAttribute("exito", "autor modificado exitosamente");
				response.sendRedirect(request.getContextPath() + "/AutoresController?op=listar");
			} else {
				request.getSession().setAttribute("fracaso",
						"El autor no ha sido modificado" + "ya hay un autor con este codigo");
				response.sendRedirect(request.getContextPath() + "/AutoresController?op=listar");
			}

		} catch (IOException | SQLException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
private void obtener(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
IOException,SQLException {
		try {
			String id = request.getParameter("id").trim();
			Autor miAutor = modelo.obtenerAutor(Integer.parseInt(id));

			
			System.out.println(miAutor.getIdAutor());
			System.out.println(miAutor.getNombre());
			
			if (miAutor != null) {
				request.setAttribute("autor", miAutor);
				request.getRequestDispatcher("/autores/editarAutores.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/error404.jsp");
			}
		} catch ( IOException | ServletException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

private void eliminar(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException, SQLException {
    try {
        int idautor = Integer.parseInt(request.getParameter("id").trim());
        if (modelo.eliminarAutor(idautor) > 0) {
            request.getSession().setAttribute("exito", "Autor eliminado exitosamente");
        } else {
            request.getSession().setAttribute("fracaso", "No se puede eliminar este autor");
        }
        response.sendRedirect(request.getContextPath() + "/AutoresController?op=listar");
    } catch (SQLException | IOException | NumberFormatException ex) {
        Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, ex);
        response.sendRedirect(request.getContextPath() + "/error500.jsp");
    }
}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
