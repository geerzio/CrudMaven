package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BorrarRegistro {

    public static void main(String[] args) {
        

          // informacion de conexion

        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String usuario = "root";
        String pass = "admin123";

        // declaramos las inteerfaces que nos ayudan con extenciones
        Connection conexion = null;
        PreparedStatement declaracion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // establecemos la conexion
            conexion = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexion a la base de datos exitosa -");

            String sqlBorrar = "delete from usuarios where idUsuario = ? ";

            declaracion = conexion.prepareStatement(sqlBorrar);

            declaracion.setInt(1,1);

            int filaBorrada = declaracion.executeUpdate();

            if(filaBorrada>0){
                System.out.println("Fila eliminada con exito ");
            }else{
                System.out.println("Fila no elimida no se encontro id ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (declaracion != null) declaracion.close();
                if (conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
