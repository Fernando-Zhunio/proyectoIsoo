/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_iso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import proyecto_iso.Base.Conexion;

/**
 *
 * @author FZ1891
 */
public class BaseQuerys {
    
    String sqlNewtemaInsert;
    
    public String sqlNewSubjectInsert()
    {
        String sql="insert into ";
        return sql;
    }
    public void InsertBd(String sql){}
    
    public void UpdateBd(String sql){}
    
    public void DeleteBd(String sql){}
    
    public void SelectBd(String sql){} 
    
   public ResultSet recibir(String sql){
    try
    {
    Connection conex=Conexion.conexion();
    Statement st=conex.createStatement();
    ResultSet rs=st.executeQuery(sql);
    return rs;
    }
    catch(SQLException sex)
    {
    ResultSet rs=null;
    return rs;
    }
    }
}
