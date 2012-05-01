/*
 *Proyecto: Programa Reuniones para Ramon Brena
 * 
 *Alumnos/Autores que participaron:
 *Adrián M Morales 615525                                                   
 *Eder Ramírez 796598
 *Daniel Sánchez 617763
 *Carolina Flores 617680
 * 
 *Materia: Proyecto Integrador 9nvo semestre
 *Profesor: Dr.Lorena Gomez y Dr.Juan Carlos Lavariega
 *
 * Nombre de archivo: PuchTest.java
 * Fecha Ultima Modificacion: Abril, 30, 2012
 */

/*Paquete:
 * Nombrar paquete al que pertenece el archivo.
 * 
 * Descripcion: clase para hacer un push.
 */
package action;
/*
 * Librerias: Importar librerias utilizadas
 */

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import nl.justobjects.pushlet.core.Dispatcher;
import nl.justobjects.pushlet.core.Event;

/*
 * importar pojos
 */
import Pojos.Usuario;
/*
 * Inicio de la clase: 
 * Descripcion: esta clase permite hacer un push
 */
public class PushTest extends ActionSupport implements ModelDriven {
    /*
     * Declaraciond e variables globales.
     */
    //decalraciond de clases

    private Usuario user = new Usuario();
    //Variables de tipo: String
    private String message;

    //Metodo principal de la clase.
    @Override
    public String execute() throws Exception {
        message = null;
        //Runtime runtime = Runtime.getRuntime();
        Event event = Event.createDataEvent("/calendar");
        event.setField("AreYouReady", "");

        //event.setField("totalMemory", "" + runtime.totalMemory());
        //event.setField("freeMemory", "" + runtime.freeMemory());
        //event.setField("maxMemory", "" + runtime.maxMemory());
        //int activeCount = Thread.activeCount();
        //event.setField("threads", "" + activeCount);
        Dispatcher.getInstance().multicast(event);
        return SUCCESS;

    }

    //Metodos get de la clase
    @Override
    public Object getModel() {
        return null;
    }

    public Usuario getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    //metodos set de la clase
    public void setUser(Usuario user) {
        this.user = user;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
