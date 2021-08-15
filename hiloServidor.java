/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1tet;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcmju
 */
public class hiloServidor extends Thread {

    DataInputStream entrada;
    DataOutputStream salida;
    Socket socket = null;                                                           // Socket del cliente

    public hiloServidor(Socket s) {
        socket = s;
        try {
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(hiloServidor.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    @Override
    public void run() {
        String cadena = "";
        
        while (!cadena.toUpperCase().trim().equals("CLOSE")) {
            try {
                if (cadena != null) {
                    cadena = entrada.readUTF();                                     // lee el mensaje del cliente   
                    System.out.println(socket.toString() + " dice: " + cadena);     // muestra el mensaje del cliente
                    salida.writeUTF("recibido - "+cadena);                           // responde al cliente
                }
            } catch (IOException ex) {
                Logger.getLogger(hiloServidor.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
        
        System.out.println("Fin de la conexión con " + socket.toString());
        
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(hiloServidor.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
    }
}
