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
public class cliente {

    public static void main(String[] args) {
        String host = "localhost";                                                  // sambiar por endpoint de la instancia EC2
        int puerto = 5000;
        DataInputStream entrada;
        DataOutputStream salida;

        Socket cliente;
        try {
            cliente = new Socket(host, puerto);                                     // socket del cliente
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());

            System.out.println("Escriba algo");
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String mensaje = br.readLine();

            salida.writeUTF(mensaje);                                 // escribe un mensaje al servidor

            while (!mensaje.toString().toUpperCase().equals("CLOSE")) {
                String respuesta = entrada.readUTF();                               // lee la respuesta del servidor
                System.out.println("Servidor dice: " + respuesta);

                System.out.println("Escriba algo");
                mensaje = br.readLine();
                salida.writeUTF(mensaje);                             // escribe un mensaje al servidor
            }

            System.out.println("Fin del envío");
            cliente.close();

        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
}
