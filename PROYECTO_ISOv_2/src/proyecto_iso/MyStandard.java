/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_iso;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author FZ1891
 */
public class MyStandard {
    
    
    public void textFieldStandar(JTextField txtStandar)
    {
        txtStandar.setFont(new Font("Agency FB", Font.BOLD, 18));
    }
    public void textAreaStandard(JTextArea txtAreaStandard)
    {
       txtAreaStandard.setLineWrap(true);
       txtAreaStandard.setFont(new Font("Agency FB", Font.BOLD, 18));
    }
}
