package com.webapp;

import java.sql.*;

public class Actualizar {

    public static void main(String[] args) {

        // informacion de conexion

        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String usuario = "root";
        String pass = "admin123";

        // declaramos las inteerfaces que nos ayudan con extenciones
        Connection conexion = null;
        PreparedStatement declaracion = null;

        try {
            // cargamos el controlador
            Class.forName("com.mysql.cj.jdbc.Driver");

            // establecemos la conexion
            conexion = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexion a la base de datos exitosa -");

            String sqlActualizar = "UPDATE usuarios SET nombre = ?, apellido = ?," +
                    "email = ?, fkPais = ?, WHERE idUsuario = ?";
            
            // preparams la interfaz para pasar la consulta 
            declaracion = conexion.prepareStatement(sqlActualizar);

            // seteo campos
            declaracion.setString(1,"NuevoNombre -1");
            declaracion.setString(2,"NuevoApellido -2");
            declaracion.setString(3, "NuevoEmail@gmail.com");
            declaracion.setInt(4,3 );

            // pasamos el id del usuario que queremos actualizar
            declaracion.setInt(5,1);

            // ejecutamos actualizacion
            int filaActualizada =declaracion.executeUpdate();

            // estructura if que avisa si se actualizo 
            if(filaActualizada >0){
                System.out.println("Actualizacion de la tabla exitosa");

            }else{
                System.out.println("No se encontro algun registro para el id solicitado");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // cerramos coneexion
            try {
                if (declaracion != null) declaracion.close();
                if (conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
