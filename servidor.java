package practica1tet;

import java.io.*;
import java.net.*;

/**
 *
 * @author jcmju
 */
public class servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket servidor;
        //Puerto que el ServerSocket va a escuchar
        int puerto = 5000;
        // Socket del cliente
        Socket cliente;
        servidor = new ServerSocket(puerto);
        while (true) {
            System.out.println("Espernado por request del cliente");
            cliente = servidor.accept();
            // Hilo para atender la conexión de varios clientes simultáneos
            hiloServidor hilo = new hiloServidor(cliente);
            hilo.start();
        }
    }

}
