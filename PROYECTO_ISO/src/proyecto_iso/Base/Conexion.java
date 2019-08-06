/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_iso.Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FZ1891
 */
public class Conexion {
    public static Connection conexion() throws SQLException{
String url = "jdbc:mysql://localhost/proyectoIsoo";
String url1 = "jdbc:mysql://localhost:3306/test1?zeroDateTimeBehavior=convertToNull [root on Default schema]";

String user = "root";
String pass = "fernando1991";
  Connection conectar=null;
  try{
      Class.forName("com.mysql.jdbc.Driver");//.newInstance();
      conectar=DriverManager.getConnection(url, user,pass);
     }
  catch(ClassNotFoundException ex) { }
  return conectar;
}
}
