package com.unu.proyectoWebGB.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String url = "jdbc:mysql://localhost:3306/bibliotecapoo2"; // URL de la base de datos
    private String usuario = "root"; // Usuario de la base de datos
    private String contrasena = "admin"; // Contraseña de la base de datos
    protected Connection conexion;

    // Método para abrir la conexión
    public void abrirConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver de MySQL
            conexion = DriverManager.getConnection(url, usuario, contrasena); // Establecer la conexión
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close(); // Cierra la conexión
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
