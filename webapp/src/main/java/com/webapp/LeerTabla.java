package com.webapp;

import java.sql.*;

public class LeerTabla {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String usuario = "root";
        String pass = "admin123";

        // declaracion de los objetos

        Connection connection = null;
        Statement declaracion = null;
        ResultSet resultado = null;

        try {
            // Cargamos el controlador
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecemos la conexión
            connection = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexión a base de datos: EXITOSA");

            // Creamos una declaracion
            declaracion = connection.createStatement();

            // Creamos la consulta
            String sqlTabla = "SELECT * FROM usuarios";

            // Ejecutamos la sentencia
            resultado = declaracion.executeQuery(sqlTabla);

            // Procesamiento de los resultados mediante un bucle
            while (resultado.next()) {
                // Declaramos variables que nos ayudan con la lectura de la tabla
                int id = resultado.getInt("IdUsuario");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String email = resultado.getString("email");
                int fkPais = resultado.getInt("fkPais");

                // Impresion de los datos obtenidos
                System.out.print(" ID: " + id);
                System.out.print(" nombre: " + nombre);
                System.out.print(" apellido: " + apellido);
                System.out.print(" email: " + email);
                System.out.println(" fkPais: " + fkPais);
                System.out.println("-----------------------");

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (resultado != null)
                    resultado.close();
                if (declaracion != null)
                    declaracion.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
                e.printStackTrace();
            }
        }

    }
}
