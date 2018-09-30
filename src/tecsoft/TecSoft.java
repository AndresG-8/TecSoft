/**
 * Esta es la clase principal del proyecto.
 * Desde acá se invoca a el frame inicial del login
 * el cual nos permitira acceder a la base de datos 
 * y consultar si se tiene o no acceso al sistema
 */
package tecsoft;

//Se importa el paquete o libreria que se requiere usar. 
//en eset caso porque se usara una clase contenida en dicho paquete
import Login2.Login;

/**
 *
 * @author Gomez
 */
public class TecSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //se crea el objeto log, de la clase Login
        Login log = new Login();
        //se le dice que muestre el ojeto creado
        log.setVisible(true);
        //dirigirse a la clase Login.java del paquete Login2
    }
}
