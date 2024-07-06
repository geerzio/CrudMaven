package com.webapp;

// traemos librerias
import java.sql.*;

public class CrearDByTabla {

    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/";
        String usuario = "root";
        String pass = "admin123";

        Connection connection = null;
        Statement statement = null;

        try{
            // cargamos el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, usuario, pass);

            statement = connection.createStatement(); 

            // creamos la bd si no existe
            String sql = "CREATE DATABASE IF NOT EXISTS mis_usuarios";
            // ejecutamos la sentencia
            statement.executeUpdate(sql);
            System.out.println("La base de datos mis_usuarios fue creda o existe");
            
            // Nos conectamos a la bd mis_usuarios
            connection = DriverManager.getConnection(url+"mis_usuarios", usuario, pass);
            statement = connection.createStatement(); 

            // creamos la tabla paises
            String crearTablaSql = "CREATE TABLE IF NOT EXISTS paises (" 
                                    + "idPais int auto_increment primary key, "
                                    + "nombrePais varchar(150) not null"
                                    +")";
            statement.executeUpdate(crearTablaSql);

            //aviso de tabla creada
            System.out.println("Tabla creada o existente");     
            
            // creamos tabla usuarios 

            String crearTablaSQL2 = "CREATE TABLE IF NOT EXISTS usuarios ("
                    + "idUsuario INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(255) NOT NULL, "
                    + "apellido VARCHAR(255) NOT NULL, "
                    + "email VARCHAR(100) NOT NULL, "
                    + "fkPais INT, "
                    + "FOREIGN KEY (fkPais) REFERENCES paises(idPais)"
                    + ")";

            //Ejecutamos la sentencia SQL
            statement.executeUpdate(crearTablaSQL2);
            //Aviso de todo ok
            System.out.println("Tabla usuarios creada o existente");

        }catch(ClassNotFoundException e){
            System.out.println(e);

        }catch(SQLException e){
            System.out.println(e);
        }finally {
            // Cerrar los recursos
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
