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
 * Nombre de archivo: Logout.java
 * Fecha Ultima Modificacion: Abril, 30, 2012
 * 
 * 
 * Descripcion: clase para hacer hacer un logout.
 */

/*Paquete:
 * Nombrar paquete al que pertenece el archivo.
 */
package action;
/*
 * Librerias: Importar librerias utilizadas
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/*
 * Inicio de la clase: 
 * Descripcion: esta clase permite hacer logout.
 */
public class Logout extends ActionSupport{
    
    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        session.remove("context");
        session.remove("nombreusuario");
        session.remove("idusuario");
        session.clear();
        
        return SUCCESS;
    }
    
}
