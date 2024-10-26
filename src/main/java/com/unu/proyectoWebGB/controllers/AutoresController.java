package com.unu.proyectoWebGB.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import com.unu.proyectoWebGB.beans.Autor;
import com.unu.proyectoWebGB.models.AutoresModel;

/**
 * Servlet implementation class AutoresController
 */
public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AutoresModel modelo = new AutoresModel();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutoresController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

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

		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException {
		request.setAttribute("listaAutores", modelo.listarAutores());
	    /*Iterator<Autor> it = modelo.listarAutores().iterator();
	    while(it.hasNext()) {
	    	System.out.println(a.getIdAutor()+" "
	    			+a.getNombre()+" "
	    			+a.getNacionalidad());
	    }*/
		request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);
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
