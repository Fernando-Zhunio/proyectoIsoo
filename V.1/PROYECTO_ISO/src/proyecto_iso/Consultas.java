/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_iso;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_iso.Base.Conexion;

/**
 *
 * @author FZ1891
 */
public class Consultas 
{
    DefaultTableModel dtmNewTema;

    public Consultas(DefaultTableModel dtmNewTema) {
        this.dtmNewTema = dtmNewTema;
    }
    
     
  void mostrarDatos() {}
  
  public void consultaBase(DefaultTableModel dtmNewTema)
  {
           try
        {
          Connection conex=Conexion.conexion();
          Statement st=conex.createStatement();
      //   ResultSet rs=st.executeQuery(sql);
//          ResultSetMetaData rsmt =rs.getMetaData();
//          int CantCol=rsmt.getColumnCount();
          String sql="insert into ";
          st.executeQuery(sql);
//         Object[] llenar=new Object[CantCol+2];        
           // while(rs.next())
            {             
           
               //   llenar[i]=rs.getObject(i+1);
                                             
            }
         //     dtm.addRow(llenar);  
                 
        }
        catch(SQLException sex)
        {
            JOptionPane.showMessageDialog(null,sex.toString());
        }
  }
  
  
  void cargarSeleccion() {}
  
    
}
