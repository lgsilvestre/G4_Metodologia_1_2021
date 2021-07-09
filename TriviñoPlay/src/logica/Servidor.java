/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Gama
 */
public class Servidor extends javax.swing.JFrame implements Runnable{


    public void run(){
        try{
            ServerSocket servidor = new ServerSocket(9999);              
            Socket misocket = servidor.accept();
            DataInputStream entrada = new DataInputStream(misocket.getInputStream());
            misocket.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error : " + e);
        }
    }
}
