/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Daos.UsuarioDAO;
import Pojos.Usuario;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author snidE
 */
public class Alta extends ActionSupport {
    
    private String nombre;
    private String username;
    private String password;
    private String email;
    
    private String mensaje;

    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String dar() throws Exception {
        
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.create(usuario);
        
        nombre = null;
        username = null;
        password = null;
        email = null;
        
        return SUCCESS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
