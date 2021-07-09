/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Gama
 */
public class Cliente{
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try{
            Socket socket = new Socket("192.168.0.2",9999);
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());           
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error : " + e + " No se pudo realizar la conexión . ");
        }
    } 
}
