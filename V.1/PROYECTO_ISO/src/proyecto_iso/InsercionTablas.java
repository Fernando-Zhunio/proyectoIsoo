/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_iso;

import JTableModelo.GestionCeldas;
import JTableModelo.GestionEncabezadoTabla;
import JTableModelo.ModeloJTable;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.Button;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import proyecto_iso.Base.Conexion;
import proyecto_iso.View.ProblemDialog;


/**
 *
 * @author FZ1891
 */
public class InsercionTablas {
  
  boolean isOtherSubject=false;
  JLabel lbBtnPlusProblem;
  JLabel lbBtnPlusSolucion;
  JTable tbContentProblem; 
  JTable tbContentSolucion;
  JFrame Parent;
  public boolean isModify=false;
  public boolean isUpdate=false;
  public int indexTema;
  public int indextbSolution;
  public int indextbProblem;
  public int indextbSolutionPerfect;


  JLabel lbBtnGuardar;
  int codigoSubject;
  //DefaultTableModel dtm =new DefaultTableModel();
  public ModeloJTable modelTableProblem;
  public ModeloJTable modelTableSolucion;
  public ModeloJTable modelTableSolucionPerfect;
  private final JLabel lbService;
  private final JLabel lbAplication;
  private final JLabel lbSubject;
  JTable tbSolutionPerfect;
  JLabel lbBtnPlusSolutionPerfect;
  
 public InsercionTablas(JFrame Parent, JLabel lbBtnPlusProblem, JLabel lbBtnPlusSolucion,
           JTable tbContentProblem, JTable tbContentSolucion,JTable tbSolutionPerfect,
           JLabel lbBtnGuardar,JLabel lbService,JLabel lbAplication,JLabel lbSubject,JLabel lbBtnPlusSolutionPerfect )
   {
       this.lbService=lbService;
       this.lbAplication=lbAplication;
       this.lbSubject=lbSubject;
       this.Parent=Parent;
       this.lbBtnPlusProblem=lbBtnPlusProblem;
       this.lbBtnPlusSolucion=lbBtnPlusSolucion;
       this.lbBtnGuardar=lbBtnGuardar;
       this.lbBtnPlusSolutionPerfect=lbBtnPlusSolutionPerfect;
     //////////// Configurando tabla moodelo ////////////////////////// 
        this.tbSolutionPerfect=tbSolutionPerfect;
         modelTableSolucionPerfect=new ModeloJTable();
         modelTableSolucionPerfect.addColumn("Soluciones"); 
         this.tbSolutionPerfect.setModel(modelTableSolucionPerfect);
         construirTabla(this.tbSolutionPerfect);
      //**********FIN de Configurando tabla moodelo *********// 
        
    //////////// Configurando tabla moodelo ////////////////////////// 
       this.tbContentProblem=tbContentProblem;
         modelTableProblem=new ModeloJTable();
         modelTableProblem.addColumn("Problemas"); 
         this.tbContentProblem.setModel(modelTableProblem);
         construirTabla(this.tbContentProblem);
      //**********FIN de Configurando tabla moodelo *********//   
         
    //////////// Configurando tabla moodelo //////////////////////////    
         // igualando la tabla solucion para poder usarla en toda la clase
       this.tbContentSolucion=tbContentSolucion;
       // creando un modelo de la tabla solucion
         modelTableSolucion=new ModeloJTable();
         // añadiendo una columna a la tabla solucion
         modelTableSolucion.addColumn("Soluciónes Aplicadas"); 
         // asignando el modelo a la tabla solucion
         this.tbContentSolucion.setModel(modelTableSolucion);
         construirTabla(this.tbContentSolucion);
     //**********FIN de Configurando tabla moodelo *********//    
         
//       pd=new ProblemaDescription(this.tbContentProblem,modelTableProblem
//                              ,this.tbContentSolucion,modelTableSolucion);
       Inicialitation();
   }
   
   
   void Inicialitation()
   {
         lbBtnPlusProblem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               OnclickLbBtnPlusProblem();             
            }
         });
         lbBtnPlusProblem.addKeyListener(new KeyListener() {
             @Override
             public void keyTyped(KeyEvent e) {
                 JOptionPane.showMessageDialog(null,"Hola keytyped");
             }

             @Override
             public void keyPressed(KeyEvent e) {
                
                                   JOptionPane.showMessageDialog(null,"Hola keyPressed");
  
             }

             @Override
             public void keyReleased(KeyEvent e) {
                                 JOptionPane.showMessageDialog(null,"Hola keyRealeased");

         }} );
         
         
         lbBtnPlusSolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               OnclickLbBtnPlusSolucion();
            }
         });
           lbBtnPlusSolutionPerfect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               OnclickLbBtnPlusSolucionAplicada();
            }
         });
         
        tbContentProblem.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent e) {           
             if(e.getClickCount()==2){
                 int rowNum=tbContentProblem.getSelectedRow();
             System.out.println("Se ha hecho doble click");
             System.out.println("Sen la fila numero"+rowNum);
              OnDobleClickTbProblem();
                 }
         }
        });
        
          tbContentSolucion.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent e) {           
             if(e.getClickCount()==2){
                 int rowNum=tbContentProblem.getSelectedRow();
            // System.out.println("Se ha hecho doble click");
            // System.out.println("Sen la fila numero"+rowNum);
             OnDobleClickTbSolution();
                 }
         }
        });
          
             tbSolutionPerfect.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent e) {           
             if(e.getClickCount()==2){
                 int rowNum=tbContentProblem.getSelectedRow();
            // System.out.println("Se ha hecho doble click");
            // System.out.println("Sen la fila numero"+rowNum);
             OnDobleClickTbSolutionAplicadas();
                 }
         }
        });
          
         lbBtnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
              saveInDataBase();
              isUpdate=true;
            }
         });                
   }
   
   
   
   
   
    ArrayList<String> listDataSalution=new ArrayList<>();
    ArrayList<String> listDataProblem=new ArrayList<>();
    ArrayList<String> listDataSolutionPerfect=new ArrayList<>(); 
    
   void saveInDataBase() 
   {
    try
    {   
     Connection conex=Conexion.conexion(); 
     Statement st=conex.createStatement();
     if(!isUpdate)
     {
      if(isModify==false)
       {
         String sql="SELECT MAX(idTemas) FROM temas"; 
         indexTema=capturarIndex(st, sql, conex);
         saveSubject(conex);
       }
      else 
       {
         deleteDataBase();
         saveSubjectModify(conex);        
       }
     }
     else
     {
         deleteDataBase();                    
         saveSubjectModify(conex);
     }
     //----------- GuardarTablaProblemas---------//
     String indexProblem="SELECT MAX(idProblemas) FROM problemas";
     indextbProblem= capturarIndex(st, indexProblem, conex);
     String sqlProblem="{Call insertProblem(?,?,?)}";
     saveTables(conex, listDataProblem, tbContentProblem, sqlProblem,indexTema,indextbProblem);
     //--------------------------------------------------------------//
     
       //----------- GuardarTablaProblemas---------//
     String indexSolucion="SELECT MAX(idSolucionesAplicadas) FROM solucionesAplicadas";
     indextbSolution =  capturarIndex( st, indexSolucion, conex);
     String sqlSolution="{Call insertSolucionesAplicadas(?,?,?)}";
     saveTables(conex, listDataSalution, tbContentSolucion, sqlSolution,indexTema,indextbSolution);
     
           //----------- GuardarTablaProblemas---------//
     String indexSolucionPerfetc="SELECT MAX(idSolucion) FROM soluciones";
      indextbSolutionPerfect =  capturarIndex( st, indexSolucionPerfetc, conex);
     String sqlSolutionPerfect="{Call insertSoluciones(?,?,?)}";
     saveTables(conex, listDataSolutionPerfect, tbSolutionPerfect, sqlSolutionPerfect,indexTema,indextbSolutionPerfect);      
     JOptionPane.showMessageDialog(null,"Guardado Correctamente en base de datos");
    }
    catch(SQLException ex)
    {
       JOptionPane.showMessageDialog(null,ex.toString());
    }    
   }
   
   int capturarIndex(Statement st, String sql,Connection conex)
   {
       
      try {
          ResultSet rs=st.executeQuery(sql);
          rs.next();
        int  index=rs.getInt(1);
          index++;
          return index;
                  
      } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, ex);
          return 0;
      }
   }

    

 
   
   
   void deleteDataBase() throws SQLException
   {
//     try
//      { 
       Connection conex=Conexion.conexion();
       Statement st=conex.createStatement();
       String sql2="delete from problemas where idTema='"+indexTema+"'";
       st.execute(sql2);
       
       String sql1="delete from solucionesAplicadas where idTema='"+indexTema+"'";
       st.execute(sql1);      
       //clave primaria es la ultima en borrar  
       String sql="delete from Soluciones where idTema='"+indexTema+"'";     
       st.execute(sql);
    
      
//      }
//     catch(SQLException ex)
//      {
//       JOptionPane.showMessageDialog(null, ex);
//      }
   }
   
    void saveSubjectModify(Connection conex) throws SQLException
   {     
     try
      {
       String sqlTemas="{Call insertTemasModify(?,?,?,?)}";
       CallableStatement cs=conex.prepareCall(sqlTemas);
       cs.setInt(1, indexTema);
       cs.setString(2,lbSubject.getText());
       cs.setString(3,lbAplication.getText());
       cs.setString(4,lbService.getText());
       cs.execute();  
      }
     catch(SQLException ex)
      {
          JOptionPane.showMessageDialog(null, ex);
      }
   }
   
//     void saveTablesModify(Connection conex, ArrayList<String> array,JTable tabla, String sqlProcedure, int temaNum)
//   {
//       try
//       {
//          CallableStatement cs= conex.prepareCall(sqlProcedure);
//          CapturarDatosTabla(array, tabla);
//          for (int i = 1; i <= array.size(); i++)
//          {
//          cs.setString(1,array.get(i-1));
//          cs.setInt(2,temaNum);
//          cs.execute();
//          }
//     
//       }
//       catch(SQLException ex)
//       {
//        JOptionPane.showMessageDialog(null,ex);
//       }      
//   }
    
   void saveSubject(Connection conex ) throws SQLException
   {     
     try
      {
       String sqlTemas="{Call insertTemas(?,?,?,?)}";
       CallableStatement cs=conex.prepareCall(sqlTemas);
       cs.setInt(1, indexTema);
       cs.setString(2,lbSubject.getText());
       cs.setString(3,lbAplication.getText());
       cs.setString(4,lbService.getText());
       cs.execute();  
      }
     catch(SQLException ex)
      {
          JOptionPane.showMessageDialog(null, ex);
      }
   }
  
   
   void saveTables(Connection conex, ArrayList<String> array,JTable tabla, String sqlProcedure, int temaNum,int index)
   {
       try
       {
           CallableStatement cs= conex.prepareCall(sqlProcedure);
           CapturarDatosTabla(array, tabla);
           for (int i = 1; i <= array.size(); i++)
          {
           cs.setInt(1,index);
           cs.setString(2,array.get(i-1));
           cs.setInt(3,temaNum);
           cs.execute();
           index++;
          }
     
       }
       catch(SQLException ex)
       {
        JOptionPane.showMessageDialog(null,ex);
       } 
   }
   
   void CapturarDatosTabla(ArrayList<String> listData, JTable table)
   {
     // listData=new ArrayList<>();
       listData.clear();
       int canRow=table.getRowCount();
       for (int i = 0; i < canRow; i++)
        {
           String dataTable=table.getValueAt(i,0).toString();
           listData.add(dataTable);
        }
   }
   
  
  
  

   
                 
 //-------------- EVENTOS DE LOS COMPONENTES ---------------------  
 
   
    private void OnclickLbBtnPlusProblem()
    {
      int rowNum=modelTableProblem.getRowCount()+1;  
      ProblemDialog pd= new ProblemDialog(Parent,true,this.tbContentProblem,modelTableProblem
                              ,this.tbContentSolucion,modelTableSolucion,modelTableSolucionPerfect);
      pd.iniciarFrameProblem(rowNum);
      
    }
    
    private void OnclickLbBtnPlusSolucion()
    {
       int rowNum=modelTableSolucion.getRowCount()+1;
       ProblemDialog pd= new ProblemDialog(Parent,true,this.tbContentProblem,modelTableProblem
                              ,this.tbContentSolucion,modelTableSolucion,modelTableSolucionPerfect);
       pd.iniciarFrameSolucion(rowNum);
        
    }
      private void OnclickLbBtnPlusSolucionAplicada()
    {
       int rowNum=modelTableSolucionPerfect.getRowCount()+1;
       ProblemDialog pd= new ProblemDialog(Parent,true,this.tbContentProblem,modelTableProblem
                              ,this.tbContentSolucion,modelTableSolucion,modelTableSolucionPerfect);
       pd.iniciarFrameSolucionPerfect(rowNum);
        
    }
    private void OnDobleClickTbProblem()
    {
        int dato=tbContentProblem.getSelectedRow();
        ProblemDialog pd= new ProblemDialog(Parent,true,this.tbContentProblem,modelTableProblem
                              ,this.tbContentSolucion,modelTableSolucion,modelTableSolucionPerfect);
        String valueCell=tbContentProblem.getValueAt(dato,0).toString();
        pd.modifyProblem(dato,valueCell);
        
    }
    
     private void OnDobleClickTbSolution()
    {
        int dato=tbContentSolucion.getSelectedRow();
        ProblemDialog pd= new ProblemDialog(Parent,true,this.tbContentProblem,modelTableProblem
                              ,this.tbContentSolucion,modelTableSolucion,modelTableSolucionPerfect);
        String valueCell=tbContentSolucion.getValueAt(dato,0).toString();
      pd.modifySolution(dato,valueCell);      
    }
     
       private void OnDobleClickTbSolutionAplicadas()
    {
        int dato=tbSolutionPerfect.getSelectedRow();
        ProblemDialog pd= new ProblemDialog(Parent,true,this.tbContentProblem,modelTableProblem
                              ,this.tbContentSolucion,modelTableSolucion, modelTableSolucionPerfect);
        String valueCell=tbSolutionPerfect.getValueAt(dato,0).toString();
      pd.modifySolutionPerfect(dato,valueCell);      
    }
    

  
   
    
    
  //---------------- otros metodos-------------  
  
  
    
    
    
    private void construirTabla(JTable tbModel )
    {
        
        tbModel.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
       // tbModel.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
          
        tbModel.getTableHeader().setReorderingAllowed(false);
        tbModel.getRowHeight(25);//tamaño de las celdas
        tbModel.setGridColor(new  java.awt.Color(0,0,0));
        
        // se define el tamaño del largo para cada columna y su contenido
      tbModel.getColumnModel().getColumn(0).setPreferredWidth(300);
    //  tbModel.getColumnModel().getColumn(1).setPreferredWidth(300);
     
                
       //Personalizar el encabezado
       JTableHeader jtableHeader=tbModel.getTableHeader();
       jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
       tbModel.setTableHeader(jtableHeader);
    }
    
    public void cleanTableSubjectTbProblem()
    {
          int numrow=modelTableProblem.getRowCount();
        for (int i = numrow; i > 0; i--) {
            modelTableProblem.removeRow(i-1);
        }
    }
     public void cleanTableSubjectTbSolution()
    {
          int numrow=modelTableSolucion.getRowCount();
        for (int i = numrow; i > 0; i--) {
            modelTableSolucion.removeRow(i-1);
        }
    }
    
  
  
  
}




   




