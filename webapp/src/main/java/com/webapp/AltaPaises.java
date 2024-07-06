package com.webapp;

// traemos librerias
import java.sql.*;

public class AltaPaises {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String usuario = "root";
        String pass = "admin123";

        Connection connection = null;
        Statement statement = null;

        try {
            //Cargamos el controlador 
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establecemos la conexion
            connection = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexión exitosa");

            //Generamos la consulta SQL
            String insertarPaisesSQL = "INSERT INTO paises (nombrePais) VALUES "
                + "('Argentina'), "
                + "('Uruguay'), "
                + "('Chile'), "
                + "('Perú'), "
                + "('Bolivia'), "
                + "('Paraguay')";

            // Ejecutamos las clausulas SQL
            statement = connection.createStatement();
            statement.executeUpdate(insertarPaisesSQL);
            System.out.println("Datos cargados correctamente");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // Cerrar los recursos
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    

}
