import java.io.IOException;
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
public class Cliente
{
  public static void main(String[] args) {
      final String HOST = "127.0.0.1";
      final int puerto = 5000;
      DataInputStream in;
      DataOutputStream out;
      
      try{
      Socket sc = new Socket(HOST,puerto);
      in = new DataInputStream(sc.getInputStream());
      out = new DataOutputStream(sc.getOutputStream());
      out.writeUTF("Hola mundo desde el cliente");
      String mensaje = in.readUTF();
      System.out.println(mensaje);
      sc.close();
    }catch(IOException ex){
        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null,ex);
    }
  }
}

