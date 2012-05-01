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
 * Nombre de archivo: Votacion.java
 * Fecha Ultima Modificacion: Abril, 30, 2012
 * 
 * 
 * Descripcion: clase para hacer hacer un login.
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
import com.opensymphony.xwork2.ModelDriven;
import java.util.Date;
import java.util.List;
import java.util.Map;
//importar Daos
import Daos.UsuarioDAO;
//importar pojos
import Pojos.Usuario;

/*
 * Inicio de la clase: Descripcion: esta clase permite hacer login.
 */
public class Login extends ActionSupport implements ModelDriven {

    //declarar clases globales
    private Usuario user = new Usuario();
    //declarar variables globales
    private String message;

    @Override
    public String execute() throws Exception {
        message = null;

        return SUCCESS;

    }
    
    //metodo que hace el login
    public String login() {
        UsuarioDAO userDAO = new UsuarioDAO();
        message = "Usuario o Password invalido!";
        List<Usuario> result = userDAO.findByExample(user);
        /*Verificar usuario, si el usuario no existe regresa a la 
         * pantalla inicial.
         */
        if (result.isEmpty()) {

            return SUCCESS;
        }
        //Meter el usuario en sesion.
        Map session = ActionContext.getContext().getSession();
        session.put("context", new Date());
        session.put("nombreusuario", result.get(0).getNombre());
        session.put("idusuario", result.get(0).getIdusuario());
        return "successlogin";
    }

    //metodos get
    @Override
    public Object getModel() {
        return user;
    }

    public Usuario getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    //metodos set
    public void setUser(Usuario user) {
        this.user = user;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
