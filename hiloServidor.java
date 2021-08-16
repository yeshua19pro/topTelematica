package practica1tet;

import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 *
 * @author jcmju
 */
public class hiloServidor extends Thread {

    DataInputStream entrada;
    DataOutputStream salida;
    // Socket del cliente
    Socket socket = null;

    public hiloServidor(Socket s) {
        socket = s;
        try {
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(hiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            String cadena;
            while (true) {
                cadena = entrada.readUTF();
                // Se mantiene escuchando hasta que lea el comando "close"
                System.out.println("Mensaje recibido: " + cadena + " (" + socket.getLocalAddress().toString() + ")");
                // Responde al cliente
                salida.writeUTF("Servidor: recibido, cliente " + socket.getLocalAddress().toString());
                if (cadena.equalsIgnoreCase("close")) {
                    // Cierre de conexión con el cliente
                    System.out.println("Fin de la conexión con " + socket.getLocalAddress().toString());
                    socket.close();
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(hiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
