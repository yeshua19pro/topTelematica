/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1tet;

import java.io.*;
import java.net.*;

/**
 *
 * @author jcmju
 */
public class cliente {
    public static void main(String[] args) throws IOException{
        String host = "localhost";
        int puerto = 5000;
        Socket cliente = new Socket(host,puerto);
        PrintWriter salida = new PrintWriter(cliente.getOutputStream(),true);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cadena,eco = "";
        System.out.println("Escriba algo");
        cadena = in.readLine();
        while(!cadena.equals("CLOSE")){
            salida.print(cadena);
            eco = entrada.readLine();
            System.out.println("Escriba algo");
            cadena = in.readLine();
        }
        salida.close();
        entrada.close();
        System.out.println("Fin del envío");
        in.close();
        cliente.close();
    }
}
