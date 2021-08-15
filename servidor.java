/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1tet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcmju
 */
public class servidor {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket servidor = null;                   // Socket del servidor
        servidor = new ServerSocket(5000);
        System.out.println("Iniciando servidor...");
        while(true){
            Socket cliente = new Socket();              // Socket del cliente
            cliente = servidor.accept();                // Espera la conexión con algún cliente
            hiloServidor hilo = new hiloServidor(cliente);
            hilo.start();
            System.out.println("Hilo iniciado");
        }
    }
    
}
