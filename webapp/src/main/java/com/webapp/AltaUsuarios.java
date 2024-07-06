package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AltaUsuarios {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String usuario = "root";
        String pass = "admin123";

        // declaracion de los objetos 

        Connection connection = null;
        PreparedStatement declaracion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexión a la base de datos exitosa");

            String sqlUsuarios = "INSERT INTO usuarios (nombre, apellido,email,fkPais)"+
            "VALUES (?, ?, ?, ?)";
            declaracion = connection.prepareStatement(sqlUsuarios);
            declaracion.setString(1, "Nombre 2");
            declaracion.setString(2, "Apellido 2");
            declaracion.setString(3, "email@gmail2.com");
            declaracion.setInt(4,3); // 1 es el codigo de arg

            // ejecutamoas la insercion
            int filasInsertadas = declaracion.executeUpdate();

            // mediante un if vemos si la insercion es exitosa
            if(filasInsertadas > 0){
                System.out.println("Insercion exitosa");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if (declaracion != null) declaracion.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
