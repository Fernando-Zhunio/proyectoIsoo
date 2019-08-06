/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_iso;


import java.awt.event.ActionEvent;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JTextField;






/**
 *
 * @author FZ1891
 */
public class Insercion 
{
    JTextField txtTema;
    JTextField txtAplicacion;
    JTextField txtServicio;
    JTextArea txtDescripcion;
    JLabel lbService;
    JLabel lbAplication;
    JLabel lbSubject;
    boolean isModify=false;
    JButton btOk;
    JPanel newSubjectFatherCard;
    JPanel newSubjectChildDatos;
    JPanel newSubjectChildProblem;
    Validaciones valida=new Validaciones();
    String strTema;
    String strAplicacion;
    String strServicio;
  public  Insercion(JTextField txtTema,JTextField txtAplicacion,JTextField txtServicio, 
          JTextArea txtDescripcion,JButton btOk,JPanel newSubjectFatherCard,
          JPanel newSubjectChildDatos,JPanel newSubjectChildProblem,JLabel lbService,JLabel lbAplication, JLabel lbSubject)
   {
     this.txtTema=txtTema;
     this.txtAplicacion=txtAplicacion;
     this.txtServicio=txtServicio;
     this.txtDescripcion=txtDescripcion;
     this.lbSubject=lbSubject;
     this.lbService=lbService;
     this.lbAplication=lbAplication;
     this.btOk=btOk; 
     this.newSubjectFatherCard=newSubjectFatherCard;
     this.newSubjectChildDatos=newSubjectChildDatos;
     this.newSubjectChildProblem=newSubjectChildProblem;  
    
     this.btOk.addActionListener((ActionEvent e) -> {
        // int locationpnProbleX= newSubjectChildProblem.getX();
      //   RSAnimation.setMoverDerecha(10, locationpnProbleX, 10, 10, newSubjectChildProblem);     
         OnclickbtOKAccion();
     });
     
           
   }
  
  
  void OnclickbtOKAccion()
  {
       okIngresarTema();
  }
  
  void lookPanelProblem()
  {
        newSubjectFatherCard.removeAll();
        newSubjectFatherCard.repaint();
        newSubjectFatherCard.revalidate();
        newSubjectFatherCard.add(newSubjectChildProblem);
        newSubjectFatherCard.repaint();
        newSubjectFatherCard.revalidate();
        lbSubject.setEnabled(true); 
  }
  
  void MostrarDatos()
  {
    lbService.setText(txtServicio.getText());
    lbAplication.setText(txtAplicacion.getText());
    lbSubject.setText(txtTema.getText());
  }
  
  public void okIngresarTema()
  {
      if( !txtTema.getText().isEmpty() && !txtAplicacion.getText().isEmpty()
          && !txtServicio.getText().isEmpty())
      {
        lookPanelProblem();
        MostrarDatos();
        
      }
      else
      {
          JOptionPane.showMessageDialog(null,"Debe llenar todos los campos");
      }
  }
  
  
  public void anadirProblema()
  {
  
  }

  
  public void validarDatos(){}
  
  public void borrarProblemaAntesDeGuardar(){}
  
  public void cancelar(){}
  
  public void guardar() {}
  
  
  //-----------------------------------pnProblemas y solucion add-------------------------------
//  JButton btAgregarModificar;
//  JButton btCargarModify;
//  JTextArea txtproblem;
//  JTextArea txtSolucion;
//  JTextField txtNumColumModify;
// // DefaultTableModel dtmProblem;
//  JLabel lbProblemNum;
//  JTable tbProblema;
//  boolean isModify=false;
//  JLabel btnGuardar;
  

  
//  
//  
//  JLabel lbBtnPlusProblem;
//  JLabel lbBtnPlusSolucion;
//  JTable tbContentProblem; 
//  JTable tbContentSolucion;
//  
//  JFrame Parent;
//  ProblemaDescription pd;
//  JLabel lbBtnGuardar;
//  //DefaultTableModel dtm =new DefaultTableModel();
//  ModeloJTable modelTableProblem;
//  ModeloJTable modelTableSolucion;
//   public Insercion(JFrame Parent, JLabel lbBtnPlusProblem, JLabel lbBtnPlusSolucion,
//           JTable tbContentProblem, JTable tbContentSolucion, JLabel lbBtnGuardar,JLabel lbService,JLabel lbAplication,JLabel lbSubject )
//   {
//       this.lbService=lbService;
//       this.lbAplication=lbAplication;
//       this.lbSubject=lbSubject;
//       this.Parent=Parent;
//       this.lbBtnPlusProblem=lbBtnPlusProblem;
//       this.lbBtnPlusSolucion=lbBtnPlusSolucion;
//        this.lbBtnGuardar=lbBtnGuardar;
//    //////////// Configurando tabla moodelo ////////////////////////// 
//       this.tbContentProblem=tbContentProblem;
//         modelTableProblem=new ModeloJTable();
//         modelTableProblem.addColumn("Problemas"); 
//         this.tbContentProblem.setModel(modelTableProblem);
//         construirTabla(this.tbContentProblem);
//      //**********FIN de Configurando tabla moodelo *********//   
//         
//    //////////// Configurando tabla moodelo //////////////////////////    
//         // igualando la tabla solucion para poder usarla en toda la clase
//       this.tbContentSolucion=tbContentSolucion;
//       // creando un modelo de la tabla solucion
//         modelTableSolucion=new ModeloJTable();
//         // añadiendo una columna a la tabla solucion
//         modelTableSolucion.addColumn("Solución"); 
//         // asignando el modelo a la tabla solucion
//         this.tbContentSolucion.setModel(modelTableSolucion);
//         construirTabla(this.tbContentSolucion);
//     //**********FIN de Configurando tabla moodelo *********//    
//         
////       pd=new ProblemaDescription(this.tbContentProblem,modelTableProblem
////                              ,this.tbContentSolucion,modelTableSolucion);
//       Inicialitation();
//   }
//   
//   void Inicialitation()
//   {
//         lbBtnPlusProblem.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//               OnclickLbBtnPlusProblem();
//               
//            }
//         });
//         
//         lbBtnPlusSolucion.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//               OnclickLbBtnPlusSolucion();
//            }
//         });
//         
//        tbContentProblem.addMouseListener(new java.awt.event.MouseAdapter() {
//             public void mouseClicked(java.awt.event.MouseEvent e) {           
//             if(e.getClickCount()==2){
//                 int rowNum=tbContentProblem.getSelectedRow();
//             System.out.println("Se ha hecho doble click");
//             System.out.println("Sen la fila numero"+rowNum);
//              OnDobleClickTbProblem();
//                 }
//         }
//        });
//        
//          tbContentSolucion.addMouseListener(new java.awt.event.MouseAdapter() {
//             public void mouseClicked(java.awt.event.MouseEvent e) {           
//             if(e.getClickCount()==2){
//                 int rowNum=tbContentProblem.getSelectedRow();
//            // System.out.println("Se ha hecho doble click");
//            // System.out.println("Sen la fila numero"+rowNum);
//             OnDobleClickTbSolution();
//                 }
//         }
//        });
//          
//         lbBtnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//              saveInDataBase();
//            }
//         });  
//          
//        
//   }
//    ArrayList<String> listDataSalution;
//    ArrayList<String> listDataProblem;
//    
//   void saveInDataBase() 
//   {
//    try
//    {
//     Connection conex=Conexion.conexion();   
//     saveSubject(conex);
//     Statement st=conex.createStatement();
//     ResultSet rs=st.executeQuery("SELECT MAX(idTemas) as idTemas FROM temas");
//     int numTema=rs.getInt(1);
//     String sqlProblem="{Call insertProblem(?,?)}";
//     saveTables(conex, listDataProblem, tbContentProblem, sqlProblem,numTema);
//    }
//    catch(SQLException ex)
//    {
//       JOptionPane.showMessageDialog(null,ex.toString());
//    }    
//   }
//   void saveSubject(Connection conex) throws SQLException
//   {
//      
//      try
//      {
//       String sqlTemas="{Call insertTemas(?,?,?)}";
//       CallableStatement cs=conex.prepareCall(sqlTemas);
//       cs.setString(1,lbSubject.getText());
//       cs.setString(2,lbAplication.getText());
//       cs.setString(3,lbService.getText());
//       cs.execute();
//      
//      }
//      catch(SQLException ex)
//      {
//          JOptionPane.showMessageDialog(null, ex);
//      }
//   }
//   
//   void saveTables(Connection conex, ArrayList<String> array,JTable tabla, String sqlProcedure, int temaNum)
//   {
//       try
//       {
//          CallableStatement cs= conex.prepareCall(sqlProcedure);
//          CapturarDatosTabla(array, tabla);
//          for (int i = 1; i <= array.size(); i++)
//          {
//          cs.setString(1,array.get(i));
//          cs.setInt(2,temaNum);
//          cs.execute();
//          }
//     
//       }
//       catch(SQLException ex)
//       {
//        JOptionPane.showMessageDialog(null,ex);
//       }
//      
//   }
//   
//   
//   
//   
//   void CapturarDatosTabla(ArrayList<String> listData, JTable table)
//   {
//      listData=new ArrayList<>();
//       int canRow=table.getRowCount();
//       for (int i = 0; i < canRow; i++)
//        {
//            String dataTable=table.getValueAt(i,0).toString();
//           listData.add(dataTable);
//        }
//   }
//   
//  
//  
//  
//
//   
//                 
// //-------------- EVENTOS DE LOS COMPONENTES ---------------------  
// 
//   
//    private void OnclickLbBtnPlusProblem()
//    {
//      int rowNum=modelTableProblem.getRowCount()+1;  
//      ProblemDialog pd= new ProblemDialog(Parent,true,this.tbContentProblem,modelTableProblem
//                              ,this.tbContentSolucion,modelTableSolucion);
//      pd.iniciarFrameProblem(rowNum);
//      
//    }
//    
//    private void OnclickLbBtnPlusSolucion()
//    {
//       int rowNum=modelTableSolucion.getRowCount()+1;
//       ProblemDialog pd= new ProblemDialog(Parent,true,this.tbContentProblem,modelTableProblem
//                              ,this.tbContentSolucion,modelTableSolucion);
//       pd.iniciarFrameSolucion(rowNum);
//        
//    }
//    private void OnDobleClickTbProblem()
//    {
//        int dato=tbContentProblem.getSelectedRow();
//        ProblemDialog pd= new ProblemDialog(Parent,true,this.tbContentProblem,modelTableProblem
//                              ,this.tbContentSolucion,modelTableSolucion);
//        String valueCell=tbContentProblem.getValueAt(dato,0).toString();
//        pd.modifyProblem(dato,valueCell);
//        
//    }
//    
//     private void OnDobleClickTbSolution()
//    {
//        int dato=tbContentSolucion.getSelectedRow();
//        ProblemDialog pd= new ProblemDialog(Parent,true,this.tbContentProblem,modelTableProblem
//                              ,this.tbContentSolucion,modelTableSolucion);
//        String valueCell=tbContentSolucion.getValueAt(dato,0).toString();
//      pd.modifySolution(dato,valueCell);      
//    }
//    
//
//  
//   
//    
//    
//  //---------------- otros metodos-------------  
//  
//  
//    
//    
//    
//    private void construirTabla(JTable tbModel ){
//        
//        tbModel.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
//       // tbModel.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
//          
//        tbModel.getTableHeader().setReorderingAllowed(false);
//        tbModel.getRowHeight(25);//tamaño de las celdas
//        tbModel.setGridColor(new  java.awt.Color(0,0,0));
//        
//        // se define el tamaño del largo para cada columna y su contenido
//      tbModel.getColumnModel().getColumn(0).setPreferredWidth(300);
//    //  tbModel.getColumnModel().getColumn(1).setPreferredWidth(300);
//     
//                
//       //Personalizar el encabezado
//       JTableHeader jtableHeader=tbModel.getTableHeader();
//       jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
//       tbModel.setTableHeader(jtableHeader);
//
//
//    }
//    
  
  
  
}




   


