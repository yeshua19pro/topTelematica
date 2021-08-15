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
public class hiloServidor extends Thread{
    BufferedReader entrada;                         // Buffer de entrada
    PrintWriter salida;                             // Buffer de salida
    Socket socket = null;                           // Socket del cliente
    public hiloServidor(Socket s){
        socket = s;
        try{
            salida = new PrintWriter(socket.getOutputStream(),true);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(hiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run(){
        String cadena = "";
        while(!cadena.trim().equals("CLOSE")){
            System.out.println("Concetado al cliente "+socket.toString());
            try{
                cadena = entrada.readLine();
                if (cadena != null) {
                    salida.println(cadena.trim().toUpperCase());
                }
            } catch (IOException ex) {
                Logger.getLogger(hiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Fin de la conexión con el cliente "+socket.toString());
        try {
            entrada.close();
            salida.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(hiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
