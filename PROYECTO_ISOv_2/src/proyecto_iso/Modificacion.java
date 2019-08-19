/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_iso;


import JTableModelo.ModeloJTable;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import proyecto_iso.View.LookTema;

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
    JLabel lbNamePanel;
    ModeloJTable dtmModify=new ModeloJTable();
    JButton btnModify;
    JTextField txtIndexModify;
    InsercionTablas classInserTAblas;    
    JLabel lbSubject, lbAplication, lbService, lbIsModify;
    JPanel pnsubjectCard, pnSubjectList, pnSubjectInsert;
    boolean  isElimination=false;
    boolean  isConsulta=false;
    boolean isModify=false;
    JButton btnVer;
    JFrame mainFrame;
    MouseListener mo;
    MouseListener con;
    MouseListener eli;
    JButton btnGeneratePdf;
    public Modificacion(JTable tbModificar, JTextField txtBuscar,
            JLabel lbBuscar, JComboBox cbBusquedaPor, 
            JTextField txtSubject, JTextField txtAplication,
            JTextField txtService, JTable tbProblem, JTable tbSolution,
            JPanel pnSubject, JPanel pnFather,
            JPanel pnCurrent, JLabel lbNewsubject,
            JButton btnModicar, JTextField txtIndexModify ,InsercionTablas classInserTAblas,
            JLabel lbSubject, JLabel lbAplication, JLabel lbService,JPanel pnsubjectCard,
            JPanel pnSubjectList,JPanel pnSubjectInsert,JLabel lbIsModify,
            JLabel lbNamePanel,JButton btnVer, JFrame mainFrame,JButton btnGeneratePdf)
    {
        
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
        this.lbSubject=lbSubject;
        this.lbAplication=lbAplication;
        this.lbService=lbService;
        this.lbIsModify=lbIsModify;
        
        
        this.pnsubjectCard=pnsubjectCard;
        this.pnSubjectList=pnSubjectList;
        this.pnSubjectInsert=pnSubjectInsert;
        this.classInserTAblas=classInserTAblas;
      //  this.pnProblemAndSolution = pnProblemAndSolution;
        this.pnFather = pnFather;
        this.pnCurrent = pnCurrent;
        this.lbNewsubject = lbNewsubject;      
        this.btnModify=btnModicar;
        this.lbNamePanel=lbNamePanel;
        this.btnVer=btnVer;
        this.mainFrame=mainFrame;
        this.btnGeneratePdf=btnGeneratePdf;
        dtmModify.addColumn("IdTema");
        dtmModify.addColumn("Tema");     
        
        this.tbModificar.setModel(dtmModify);
        this.tbModificar.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.tbModificar.getColumnModel().getColumn(1).setPreferredWidth(100);
           
        validar.ValidarsoloNUmeros(txtIndexModify);
        inicializarAcciones();
        accionBtn();
        txtIndexModify.setEnabled(false);
    }
    
    
    void accionBtn()
    {              
        mo = new MouseAdapter() {
       public void mouseClicked(java.awt.event.MouseEvent evt) {          
                 cargarSeleccion();
            }
         };
        con = new MouseAdapter() {
       public void mouseClicked(java.awt.event.MouseEvent evt) {          
                 cargarSeleccion();
            }
         };
          eli = new MouseAdapter() {
       public void mouseClicked(java.awt.event.MouseEvent evt) {          
                 OnclickBtnEliminar();
            }
         };
    }


    

    void inicializarAcciones()
    {
            lbBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
              OnClickLbBuscar();
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
            
        btnVer.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent e) {                       
                 { 
                   OnclickBtnVer();
                 }
            }
         });
        
         btnGeneratePdf.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent e) {                       
                 { 
                     try {
                         OnclickBtnGeneratePdf();
                     } catch (DocumentException ex) {
                         Logger.getLogger(Modificacion.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (SQLException ex) {
                         Logger.getLogger(Modificacion.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
            }

              
         });
    }
    
    //metodo para limpiar tabla modify
  public void CleanTbModify()
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
              String sqls=sqlBusqueda();            
              ResultSet rs=st.executeQuery(sqls);
              ResultSetMetaData rsm=rs.getMetaData();             
              if(rs.next())
              {
                 rs.beforeFirst();
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
        else JOptionPane.showMessageDialog(null, "debe ingresar parametros a buscar");
    }
    String sqlBusqueda()
    {
        
        String buscarPor=(String)cbBusquedaPor.getSelectedItem();
        if(buscarPor.equals("Tema"))
         {
            String sql="Select idTema, Tema from Temas where  Tema like '"+txtBuscar.getText()+"%'";
            changeHeaderColumn();
            return sql;        
         }
        else  if(buscarPor.equals("Aplicacion"))
        {
            String sql="Select idTema, Aplicacion from Temas where  Aplicacion like '"+txtBuscar.getText()+"%'";
            changeHeaderColumn();
            return sql;
        }
           else  if(buscarPor.equals("Servicio"))
        {
            String sql="Select idTema, Servicio from Temas where  servicio like '"+txtBuscar.getText()+"%'";
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
        pnsubjectCard.remove(pnSubjectInsert);
        pnsubjectCard.add(pnSubjectList);
    }
    
    
    public void cargarSeleccion()
    {
        
     if(validar.validarTxtField(txtIndexModify))   
     {
     LookPane();
         cleanTableSubject(classInserTAblas.modelTableProblem);
         cleanTableSubject(classInserTAblas.modelTableSolucion);
         cleanTableSubject(classInserTAblas.modelTableSolucionPerfect);
         classInserTAblas.indexTema=idSubject;
         classInserTAblas.isModify=true;
         lbIsModify.setText("N° Modificación: "+idSubject);
      try
      {  
        Connection conex=Conexion.conexion();       
        Statement st=conex.createStatement();
        String sql="select Tema,Aplicacion,Servicio from Temas where idTema='"+idSubject+"'";
        ResultSet rs=st.executeQuery(sql);
        rs.next();
        txtSubject.setText(rs.getString(1));
        txtAplication.setText(rs.getString(2));
        txtService.setText(rs.getString(3));
        lbSubject.setText(txtSubject.getText());
        lbAplication.setText(txtAplication.getText());
        lbService.setText(txtService.getText());
        String sqlProblem="select problema from problemas where idTema='"+idSubject+"'";
        ChangedTables(st, sqlProblem,classInserTAblas.modelTableProblem);
        String sqlSolutionPerfect="select solucion from soluciones where idTema='"+idSubject+"'";
        ChangedTables(st, sqlSolutionPerfect,classInserTAblas.modelTableSolucionPerfect);
        String sqlSolutionAplicada="select solucionAplicada from solucionesAplicadas where idTema='"+idSubject+"'";
        ChangedTables(st, sqlSolutionAplicada,classInserTAblas.modelTableSolucion);
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
     List lSubjuect=new ArrayList();
     List lProblem=new ArrayList();
     List lSolutionAplicadas=new ArrayList();
     List lSolutionPerfect=new ArrayList();
    void OnclickBtnVer()
    {
      if(!txtIndexModify.getText().equals(""))
      { 
       try{
           lSubjuect.clear();
           lProblem.clear();
           lSolutionPerfect.clear();
           lSolutionAplicadas.clear();
        InformeForSubject();
        LookTema lt=new LookTema(mainFrame,true,lSubjuect,lProblem,lSolutionAplicadas,lSolutionPerfect);
        lt.setLocationRelativeTo(null);
        lt.setVisible(true);
        }
        catch(SQLException ex)
        {
         JOptionPane.showMessageDialog(null, ex);
        }
      }
      else JOptionPane.showMessageDialog(null, "No se encuentrar parametros para ver");        
    }
   

          
          
        
   
    
  
    
  ////-------------- Transforma el panel a diferentes funciones 
      
      public void asEliminacion()
      {   
       btnModify.setText("ELIMINAR");
       lbNamePanel.setText("Eliminaciones");
       btnGeneratePdf.setVisible(false);
       if(btnModify.getMouseListeners()!=null)
       {
         MouseListener[] mouseListeners = btnModify.getMouseListeners();
         for(MouseListener ac: mouseListeners)
          {
           btnModify.removeMouseListener(ac);       
          }
         btnModify.addMouseListener(eli);
        }
       else
         btnModify.addMouseListener(eli);
       }
       
      public void asModify()
   {     
       btnModify.setText("MODIFICAR");
       lbNamePanel.setText("MODIFICACIONES");
       btnGeneratePdf.setVisible(true);
       if(btnModify.getMouseListeners()!=null)
       {
         MouseListener[] mouseListeners = btnModify.getMouseListeners();
         for(MouseListener ac: mouseListeners)
          {
           btnModify.removeMouseListener(ac);       
          }
         btnModify.addMouseListener(mo);
        }
       else
         btnModify.addMouseListener(mo);
   }
      public void asConsultar()
   {
       btnModify.setText("CONSULTAR");
       lbNamePanel.setText("CONSULTAS");
       if(btnModify.getMouseListeners()!=null)
       {
         MouseListener[] mouseListeners = btnModify.getMouseListeners();
         for(MouseListener ac: mouseListeners)
          {
           btnModify.removeMouseListener(ac);       
          }
         btnModify.addMouseListener(con);
        }
       else
         btnModify.addMouseListener(con);
   } 
       
   //////////////////////////////////////////////////////////////Fin-----------------
  
      
      
 
    //----------Eliminar Control
    
      
    void OnclickBtnEliminar()
    { 
     if(!txtIndexModify.getText().equals("")) 
     {
      int  opc=JOptionPane.showConfirmDialog(null, "Realmente quiere eliminar este tema?", "Confirmar salida", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
       if(opc==0)
       {
          try
          {
              DeleteForSubject();
          }
          catch(SQLException ex)
          {
              JOptionPane.showMessageDialog(null, ex);
          }
       }
     }
     else
         JOptionPane.showMessageDialog(null,"Para eliminar tiene que leccionar una fila");
    }
    
    void DeleteForSubject() throws SQLException
    {
        Connection conex= Conexion.conexion();
        Statement st =conex.createStatement();
        String[] nameTables={"Problemas","Soluciones","SolucionesAplicadas","Temas"};
        
        for(int i=0;i<4;i++)
        {       
           String sql="delete from "+nameTables[i]+" where idTema="+txtIndexModify.getText()+"";
           st.execute(sql);
        }
        int row=tbModificar.getSelectedRow();
       dtmModify.removeRow(row);
       txtIndexModify.setText("");
    }
    
      void InformeForSubject() throws SQLException
      {
        Connection conex= Conexion.conexion();
        Statement st =conex.createStatement();
        String[] nameTables={"Temas","Problemas","SolucionesAplicadas","Soluciones"};
        for(int i=0;i<4;i++)
        { 
          String sql;       
          if(i==0)
          { 
          sql="select * from "+nameTables[i]+" where idTema="+txtIndexModify.getText()+"";
          ResultSet rs = st.executeQuery(sql);
          captureInforme(lSubjuect, rs);
          }
          else if(i==1)
          { 
          sql="select Problema from "+nameTables[i]+" where idTema="+txtIndexModify.getText()+"";                        
          ResultSet rs = st.executeQuery(sql);
          captureInforme(lProblem, rs);
          }   
      
          else if(i==2)
          { 
          sql="select solucionAplicada from "+nameTables[i]+" where idTema="+txtIndexModify.getText()+"";                        
          ResultSet rs = st.executeQuery(sql);
          captureInforme(lSolutionAplicadas, rs);
          }
          else if(i==3)
          {  
           sql="select solucion from "+nameTables[i]+" where idTema="+txtIndexModify.getText()+"";                        
           ResultSet rs = st.executeQuery(sql);
           captureInforme(lSolutionPerfect, rs);
          }
        } 
    }
        void captureInforme(List lt,ResultSet rs) throws SQLException
        {
          ResultSetMetaData rsm=rs.getMetaData();
          int columnNum=rsm.getColumnCount();
            while(rs.next())
           {
            for (int i = 0; i < columnNum; i++)
             {
                String resul=rs.getString(i+1);
                lt.add(resul);  
             }            
           } 
        }
    
        
     void OnclickBtnGeneratePdf() throws DocumentException, SQLException 
     {
     if(!txtIndexModify.getText().equals("")) 
     {
       try {
         JFileChooser jfc= new JFileChooser();
         int opc=jfc.showSaveDialog(mainFrame);
         String path;
         if(opc==JFileChooser.APPROVE_OPTION)
         {
          path=jfc.getSelectedFile().getAbsolutePath();
          Document dc=new Document();
          FileOutputStream fos = new FileOutputStream(path+".pdf"); 
          try 
           {
            PdfWriter.getInstance(dc, fos);
           }
           catch (DocumentException ex)
           {
             Logger.getLogger(Modificacion.class.getName()).log(Level.SEVERE, null, ex);
           }
          dc.open();
          InformeForSubject();
          generateLook();
          generateProblem();
          generateSolucionesAplicadas();
          generatePerfectas();        
          dc.add(new Paragraph(superParagrap));
          dc.close();
          }
        
      
         }
         catch (FileNotFoundException ex)
         {
            Logger.getLogger(Modificacion.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
      else
         JOptionPane.showMessageDialog(null,"Para eliminar tiene que leccionar una fila");
     }
     
    
    //------------------ fin delete
    
    
//  ------------------------  other methods
 String superParagrap="";
 
   void generateLook()
    {
        
          superParagrap="Tema : "+lSubjuect.get(1).toString()+"\n"
           +"Aplicacion : "+lSubjuect.get(2).toString()+"\n"+"Servicio : "+lSubjuect.get(3).toString()
          +"\n"+"Codigo : "+lSubjuect.get(0).toString()+"\n"+"\n";      
    }
   void generateProblem()
    {
        superParagrap+="\n\t\tPROBLEMAS\n";
        for (int i = 0; i < lProblem.size(); i++) 
        {
          superParagrap+=lProblem.get(i)+"\n";
        }
        
    }
     void generateSolucionesAplicadas()
    {
        superParagrap+="\n\n\t\tSOLUCIONES APLICADAS\n";
        for (int i = 0; i < lSolutionAplicadas.size(); i++) 
        {
          superParagrap+=lSolutionAplicadas.get(i)+"\n";
        }
       
    }
      void generatePerfectas()
    {
       superParagrap+="\n\n\t\tSOLUCIONES PERFECTAS\n";
        for (int i = 0; i < lSolutionPerfect.size(); i++) 
        {
          superParagrap+=lSolutionPerfect.get(i)+"\n";
        }
       
    }
}

