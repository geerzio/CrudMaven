package com.webapp;

import java.sql.*;

public class PruebaConexxion {


    public static void main(String[] args) {
        
        // incializacion de variables
        String url = "jdbc:mysql://localhost:3306/mis_usuarios_24250";
        String usuario = "root";
        String pass = "admin123";

        // objeto para conectar la bd 
        Connection conexion  = null;

        //establecemos la conexión dentro del try catch

        try{

            // cargamos drive jdbc
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(url, usuario, pass);

            System.out.println("Conexion establecida a la bd");

        } catch(ClassNotFoundException e){

            System.out.println(e);

        }catch(SQLException e ){
            System.out.println(e);
        }finally{
            try{
                if(conexion != null){
                    conexion.close();
                    System.out.println("Conexión cerrada");
                }
            }catch(SQLException e){
                System.out.println("Error" + e);
                e.printStackTrace();
            }
        }

    }

}
