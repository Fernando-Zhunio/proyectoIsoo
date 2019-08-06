/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_iso;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author FZ1891
 */
public class LlenarFrameModicicacion {
    
    
    ArrayList<String> problemas=new ArrayList<String>();
    ArrayList<String> soluciones=new ArrayList<String>();
    

    JTextArea txtaTema;
    JTextArea txtaServicio;
    JTextArea txtaAplicacion;
    int positionyProblem=0;
    int positionySolucion=0;

    JPanel pnProblemas;
    JPanel pnSoluciones;
    int pnWidthSolucion=0;
    int pnWidthProblema=0;
    public LlenarFrameModicicacion(ArrayList<String> soluciones,
            ArrayList<String> problemas,  JTextArea txtaTema,
            JTextArea txtaServicio, JTextArea txtaAplicacion,
            JPanel pnProblemas, JPanel pnSoluciones
            )
    {
        this.txtaTema = txtaTema;
        this.txtaServicio = txtaServicio;
        this.txtaAplicacion = txtaAplicacion;
        this.pnProblemas = pnProblemas;
        this.pnSoluciones = pnSoluciones;
        this.problemas=problemas;
        this.soluciones=soluciones;
        pnWidthProblema=pnProblemas.getWidth();
        pnWidthSolucion=pnSoluciones.getWidth();
        positionyProblem-=(pnWidthProblema/2)+5;
        positionySolucion-=(pnWidthSolucion/2)+5;
        Inicialitations();
    }
    
    JTextArea modelotxtAreaProblema(String texto)
    {
        
        JTextArea newTxtArea=new JTextArea();
        newTxtArea.setSize(pnWidthProblema-5,pnWidthProblema/2); 
        newTxtArea.setText(texto);
        positionyProblem+=newTxtArea.getHeight()+5;
        return newTxtArea;
    }
      JTextArea modelotxtAreaSolucion(String texto)
    {
        
        JTextArea newTxtArea=new JTextArea();
        newTxtArea.setSize(pnWidthSolucion-5,pnWidthSolucion/2); 
        newTxtArea.setText(texto);
        positionySolucion+=newTxtArea.getHeight()+5;
        return newTxtArea;
       
    }
    
    void Inicialitations()
    {
        for (int i = 0; i < problemas.size(); i++)
        {        
            pnProblemas.add(modelotxtAreaProblema(problemas.get(i)),new org.netbeans.lib.awtextra.AbsoluteConstraints(5, positionyProblem));
        }
        
        for (int i = 0; i < soluciones.size(); i++)
        {
             pnSoluciones.add(modelotxtAreaSolucion(soluciones.get(i)),new org.netbeans.lib.awtextra.AbsoluteConstraints(5, positionySolucion));
        }    
    }

   
    
    
    
    
    
}
