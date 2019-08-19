/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_iso;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author FZ1891
 */
public class Validaciones {
    
    public boolean validarTxtField(JTextField txtAprobar)
    {
        return !txtAprobar.getText().trim().equals("");
        
    }
    
    public void ValidarsoloNUmeros(JTextField txtAprobar){
    txtAprobar.addKeyListener(new KeyAdapter()
     {
      public void keyTyped(KeyEvent e)
      {
      char caracter = e.getKeyChar();
      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         e.consume();  // ignorar el evento de teclado
      }
   }
});
    }
    
    
    public boolean ValidarTxtAreadNotNull(JTextArea txtAprobar){
       return !txtAprobar.getText().trim().equals("");
    }
}
