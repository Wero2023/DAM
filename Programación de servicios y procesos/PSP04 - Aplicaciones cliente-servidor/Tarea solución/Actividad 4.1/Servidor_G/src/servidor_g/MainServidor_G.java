
package servidor_g;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainServidor_G {
    
    // Puerto por el que se va a conectar al servidor
    static final int PUERTO = 5000;
    
    public static void main(String[] args) {
       
        try{
            //Inicio el servidor en el puerto
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escuchando en el puerto " + PUERTO + " ...");
            
            //Se mantiene el servidor encendido, escuchando las peticiones por
            //parte de los clientes
            while(true){
                //Se conecta un cliente
                Socket skCliente = skServidor.accept();
                System.out.println("Cliente conectado ...");
                
                //Se atiende al cliente mediante un Thread
                new Servidor_G (skCliente).start();   
            }
          }catch(IOException ex){
              System.out.println("Error en la creación del socket del servidor");
              Logger.getLogger(Servidor_G.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
}
