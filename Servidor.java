import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Chat desarrollado en java que conecta dos clientes y un servidor, usando Socket e implementando protocolo TCP.
 * 
 * @author (Mario Alejandro Muñetón Durango) 
 * @version (11/08/2021)
 * Profesor: Juan Carlos Montoya Mendoza
 * Asignatura: Topicos especiales de telemática
 * Universiad EAFIT
 * Medellín
 * 2021
 */

public class Servidor
{
   public static void main(String[] args)
   {
       ServerSocket servidor =  null;
       Socket sc = null;
       final int puerto = 5000;
       DataInputStream in;
       DataOutputStream out;
       
       try{
           servidor = new ServerSocket(puerto);
           System.out.println("Servidor iniciando");
           
           while(true){
               sc = servidor.accept();
               System.out.println("Cliente conectado");
               in = new DataInputStream(sc.getInputStream());
               out = new DataOutputStream(sc.getOutputStream());
               String mensaje = in.readUTF();
               System.out.println(mensaje);
               out.writeUTF("Hola mundo, desde el servidor");
               sc.close();
               System.out.println("Cliente desconectado");
        }
       }catch(IOException ex){
           Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);
       }
   }
}
