/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_iso;


import JTableModelo.ModeloJTable;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import proyecto_iso.Base.Conexion;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author FZ1891
 */
public class Modificacion 
{  
    
    JTable tbModificar;
    JTextField txtBuscar;
    JLabel lbBuscar;
    Validaciones validar=new Validaciones();
    JComboBox cbBusquedaPor;
    
    int idSubject;
    JTextField txtSubject;
    JTextField txtAplication;
    JTextField txtService;
    JTable tbProblem;
    JTable tbSolution;
    JPanel pnSubject;
    //JPanel pnProblemAndSolution;
    JPanel pnFather;
    JPanel pnCurrent;
    JLabel lbNewsubject;
    ModeloJTable dtmModify=new ModeloJTable();
    JButton btnModify;
    JTextField txtIndexModify;
    InsercionTablas classInserTAblas;
            
    public Modificacion(JTable tbModificar, JTextField txtBuscar,
            JLabel lbBuscar, JComboBox cbBusquedaPor, 
            JTextField txtSubject, JTextField txtAplication,
            JTextField txtService, JTable tbProblem, JTable tbSolution,
            JPanel pnSubject, JPanel pnFather,
            JPanel pnCurrent, JLabel lbNewsubject,
            JButton btnModicar, JTextField txtIndexModify ,InsercionTablas classInserTAblas) {
        this.tbModificar = tbModificar;
        this.txtBuscar = txtBuscar;
        this.lbBuscar = lbBuscar;
        this.cbBusquedaPor = cbBusquedaPor;
        this.txtSubject = txtSubject;
        this.txtAplication = txtAplication;
        this.txtService = txtService;
        this.tbProblem = tbProblem;
        this.tbSolution = tbSolution;
        this.pnSubject = pnSubject;
        this.txtIndexModify=txtIndexModify;
        this.classInserTAblas=classInserTAblas;
      //  this.pnProblemAndSolution = pnProblemAndSolution;
        this.pnFather = pnFather;
        this.pnCurrent = pnCurrent;
        this.lbNewsubject = lbNewsubject;      
        this.btnModify=btnModicar;
        dtmModify.addColumn("IdTema");
        dtmModify.addColumn("Tema");     
        
        this.tbModificar.setModel(dtmModify);
        this.tbModificar.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.tbModificar.getColumnModel().getColumn(1).setPreferredWidth(100);

        
        inicializarAcciones();
    }
    
    
   
    
    
    void inicializarAcciones()
    {
            lbBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
              OnClickLbBuscar();
            }
         });
            
              btnModify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
              cargarSeleccion();
            }
         });
              
              
            tbModificar.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent e) {                       
                 { 
                     String rowNum=dtmModify.getValueAt(tbModificar.getSelectedRow(),0).toString();
                     idSubject=Integer.parseInt(rowNum);
                     txtIndexModify.setText(rowNum);
                     
                 }
            }
         });     
    }
    void CleanTbModify()
    {
        int numrow=dtmModify.getRowCount();
        for (int i = numrow; i > 0; i--) {
            dtmModify.removeRow(i-1);
        }
    }
    void cleanTableSubject(ModeloJTable modeloTb)
    {
          int numrow=modeloTb.getRowCount();
        for (int i = numrow; i > 0; i--) {
            modeloTb.removeRow(i-1);
        }
    }
    
    void OnClickLbBuscar()
    {
        CleanTbModify();
        if(validar.validarTxtField(txtBuscar))
        {
            try
            {
              Connection conex=Conexion.conexion();       
              Statement st=conex.createStatement();           
              ResultSet rs=st.executeQuery(sqlBusqueda());
              ResultSetMetaData rsm=rs.getMetaData();
              if(rs.absolute(1))
              {
                  int columNum=rsm.getColumnCount();
                  Object[] addTable=new Object[columNum];
                  while(rs.next())
                  {                    
                      for (int i = 0; i < columNum; i++)
                      {
                          String addTb=rs.getString(i+1);
                          addTable[i]=addTb;                 
                      }
                      dtmModify.addRow(addTable); 
                  }
              }
               else JOptionPane.showMessageDialog(null, "No ahi datos con estos parametros");
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"Error mysql "+ ex);
            }
        }
//        if(validar.validarTxtField(txtBuscar))
//        {
//          try
//           {
//            Connection conex=Conexion.conexion();       
//            Statement st=conex.createStatement();           
//            ResultSet rs=st.executeQuery(sqlBusqueda());
//            ResultSetMetaData rsm=rs.getMetaData();
//            if(rs.absolute(1))
//            {
//               int columnNum=rsm.getColumnCount();
//               Object[] llenar=new Object[columnNum];
//               while(rs.next())
//               {
//                for (int i = 0; i < columnNum; i++) 
//               {
//                 String dataCell=rs.getString(i+1);
//                 llenar[i]=dataCell;                 
//               }
//                 dtmModify.addRow(llenar);
//               }
//            }
//            else JOptionPane.showMessageDialog(null, "No ahi datos con estos parametros");
//           }
//          catch(SQLException ex)
//           {
//             JOptionPane.showMessageDialog(null, ex);
//           }
//        }
//        else JOptionPane.showMessageDialog(null, "No hay datos a buscar");
//      
    }
    String sqlBusqueda()
    {
//      String buscarPor=(String)cbBusquedaPor.getSelectedItem();
//      if(buscarPor.equals("Tema"))
//            return "select distinct a.idTemas , a.Tema , a.Aplicacion , a.Servicio , b.Solucion ,c.problema from Temas a\n"
//                  + " inner join soluciones b on(a.idTemas=b.idTema) "
//                  + " inner join problemas c on(a.idTemas=b.idTema)"
//                  + "where a.Tema like '"+txtBuscar.getText()+"%'";
//      else if(buscarPor.equals("Aplicacion"))
//      {
//            return "select distinct a.idTemas , a.Tema , a.Aplicacion , a.Servicio , b.Solucion , c.problema from Temas a\n"                    
//                +"inner join soluciones b on(a.idTemas=b.idTema)" +
//                 "inner join problemas c on(a.idTemas=b.idTema)" +
//                 "where a.aplicacion like '"+txtBuscar.getText()+"%';";
//      }
//      else if(buscarPor.equals("Servicio"))
//      {  return "select distinct a.idTemas , a.Tema , a.Aplicacion , a.Servicio , b.Solucion , c.problema from Temas a\n" +
//                  "inner join soluciones b on(a.idTemas=b.idTema)" +
//                 "inner join problemas c on(a.idTemas=b.idTema)" +
//                 "where a.servicio like '"+txtBuscar.getText()+"%';";}
//      else if(buscarPor.equals("Solucion"))
//      {  return "select distinct a.idTemas , a.Tema , a.Aplicacion , a.Servicio , b.Solucion , c.problema from Temas a\n" +
//                 "inner join soluciones b on(a.idTemas=b.idTema)" +
//                 "inner join problemas c on(a.idTemas=b.idTema)" +
//                 "where b.Solucion like '"+txtBuscar.getText()+"%';";}
//      else if(buscarPor.equals("Problema")){
//        return "select distinct a.idTemas , a.Tema , a.Aplicacion , a.Servicio , b.Solucion , c.problema from Temas a\n" +
//                 "inner join soluciones b on(a.idTemas=b.idTema)" +
//                 "inner join problemas c on(a.idTemas=b.idTema)" +
//                 "where c.problema like '"+txtBuscar.getText()+"%';";       
//      }
//     return "select distinct a.idTemas , a.Tema , a.Aplicacion , a.Servicio , b.Solucion ,c.problema from Temas a\n"
//                  + " inner join soluciones b on(a.idTemas=b.idTema) "
//                  + " inner join problemas c on(a.idTemas=b.idTema)"
//                  + "where a.Tema like '"+txtBuscar.getText()+"%'";
        
        String buscarPor=(String)cbBusquedaPor.getSelectedItem();
        if(buscarPor.equals("Tema"))
         {
            String sql="Select idTemas, Tema from Temas where  Tema like '"+txtBuscar.getText()+"%'";
            changeHeaderColumn();
            return sql;
           
         }
        else  if(buscarPor.equals("Aplicacion"))
        {
            String sql="Select idTemas, Aplicacion from Temas where  Aplicacion like '"+txtBuscar.getText()+"%'";
            changeHeaderColumn();
            return sql;
        }
           else  if(buscarPor.equals("Servicio"))
        {
            String sql="Select idTemas, Servicio from Temas where  servicio like '"+txtBuscar.getText()+"%'";
            changeHeaderColumn();
            return sql;
        }
           else  if(buscarPor.equals("Problema"))
        {
            String sql="Select idTema, Problema from problemas where  problema like '"+txtBuscar.getText()+"%' ";
            changeHeaderColumn();
            return sql;
        }
             else  if(buscarPor.equals("Solucion Varias"))
        {
            String sql="Select idTema, solucionAplicada from solucionesAplicadas where  solucionAplicada like '"+txtBuscar.getText()+"%' ";
            changeHeaderColumn();
            return sql;
        }
            else  if(buscarPor.equals("Solucion"))
        {
            String sql="Select idTema, solucion from soluciones where  solucion like '"+txtBuscar.getText()+"%' ";
            changeHeaderColumn();
            return sql;
        }
        else return null;             
    }
    
    
          void changeHeaderColumn()
         {
            JTableHeader head = tbModificar.getTableHeader();
            TableColumnModel tcm = head.getColumnModel();
            
            TableColumn tabCM = tcm.getColumn(1);
            tabCM.setHeaderValue(cbBusquedaPor.getSelectedItem().toString());
            tbModificar.repaint();
          }
    
    
    
    
    
    
    
    

    
    void LookPane()
    {
        pnFather.removeAll();
        pnFather.repaint();
        pnFather.revalidate();
        pnFather.add(pnSubject);
        pnFather.repaint();
        pnFather.revalidate();
        lbNewsubject.setEnabled(false);     
    }
    
    
    public void cargarSeleccion()
    {
        
     if(validar.validarTxtField(txtIndexModify))   
     {
     LookPane();
         cleanTableSubject(classInserTAblas.modelTableProblem);
         cleanTableSubject(classInserTAblas.modelTableSolucion);
         classInserTAblas.indexTema=idSubject;
         classInserTAblas.isModify=true;
      try
      {  
        Connection conex=Conexion.conexion();       
        Statement st=conex.createStatement();
        String sql="select Tema,Aplicacion,Servicio from Temas where idTemas='"+idSubject+"'";
        ResultSet rs=st.executeQuery(sql);
        rs.next();
        txtSubject.setText(rs.getString(1));
        txtAplication.setText(rs.getString(2));
        txtService.setText(rs.getString(3));
        String sqlProblem="select problema from problemas where idTema='"+idSubject+"'";
        ChangedTables(st, sqlProblem,classInserTAblas.modelTableProblem);
        String sqlSolution="select solucion from soluciones where idTema='"+idSubject+"'";
        ChangedTables(st, sqlSolution,classInserTAblas.modelTableSolucionPerfect);
        String sqlSolutionPerfect="select solucionAplicada from solucionesAplicadas where idTema='"+idSubject+"'";
        ChangedTables(st, sqlSolutionPerfect,classInserTAblas.modelTableSolucion);
    }
     catch(SQLException ex)
     {
         JOptionPane.showMessageDialog(null, ex);
     }
    }
    }
     
    private void ChangedTables(Statement st,String sql,ModeloJTable modeloTB)
    {
      try
       {                  
         ResultSet rs=st.executeQuery(sql);
         ResultSetMetaData rsm=rs.getMetaData();
         
           int columnNum=rsm.getColumnCount();
           Object[] llenar=new Object[columnNum];
           while(rs.next())
            {
             for (int i = 0; i < columnNum; i++) 
             {
              String dataCell=rs.getString(i+1);
              llenar[i]=dataCell;                 
             }
              modeloTB.addRow(llenar);
             }
          }     
          catch(SQLException ex)
           {
             JOptionPane.showMessageDialog(null, ex);
           }
    }
    
    private void modificarDatos() {}
    
    private void validarDatos() {}
    
    private void guardar() {}
    
    private void cancelar(){}
    
    
}
