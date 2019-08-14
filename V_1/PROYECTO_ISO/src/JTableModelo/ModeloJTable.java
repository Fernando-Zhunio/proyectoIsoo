/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JTableModelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FZ1891
 */
public class ModeloJTable extends DefaultTableModel{
    	String[] titulos;
	Object[][] datos;
	
	/**
	 * Determina el modelo con el que se va a construir la tabla
	 * @param datos
	 * @param titulos
	 */
	public ModeloJTable(String[] titulos) {
		super();
		this.titulos=titulos;
//		this.datos=datos;
		//setDataVector(null,titulos);
                
	}
	
	public ModeloJTable() {
		// TODO Auto-generated constructor stub
	}

	public boolean isCellEditable (int row, int column)
	{
		//Definimos si una celda puede ser o no editable
//		if (column!=NameColumJTable.IDTEMA && column!=Utilidades.EVENTO && column!=Utilidades.NOTA1 && column!=Utilidades.NOTA2 && column!=NameColumJTable.PROBLEMAS){   
	    	   return false; 
//	       }else{
//	    	   return true;
//	       }
 
	}
}
