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
 * Nombre de archivo: Alta.java
 * Fecha Ultima Modificacion: Abril, 30, 2012
 * 
 * 
 * Descripcion: clase para dar a un usuario de alta.
 */

/*Paquete:
 * Nombrar paquete al que pertenece el archivo.
 */
package action;
//importar Daos
import Daos.UsuarioDAO;
//importar pojos
import Pojos.Usuario;
//importar librerias
import com.opensymphony.xwork2.ActionSupport;

/*
 * Inicio de la clase: 
 * Descripcion: esta clase permite dar de alta a un usuario.
 */
public class Alta extends ActionSupport {
    
    //declarar variables globales
    private String nombre;
    private String username;
    private String password;
    private String email;
    private String mensaje;

    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String dar() throws Exception {
        //Crear a un nuevo usuario con los atributos requeridos.
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.create(usuario);
        
        //limpiar variables
        nombre = null;
        username = null;
        password = null;
        email = null;
        
        return SUCCESS;
    }

    //metodos get
    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
    //metodos set
    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
