/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Daos.UsuarioDAO;
import Pojos.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author snidE
 */
public class Login extends ActionSupport implements ModelDriven{

    private Usuario user = new Usuario();
    private String message;
    
    @Override
    public String execute() throws Exception {
        message = null;
       
        return SUCCESS;

    }
    
    public String login() {
        UsuarioDAO userDAO = new UsuarioDAO();
        message = "Usuario o Password invalido!";
        List<Usuario> result = userDAO.findByExample(user);
        if(result.isEmpty()) {
            
            return SUCCESS;
        }
        Map session = ActionContext.getContext().getSession();
            session.put("context", new Date());
            session.put("nombreusuario", result.get(0).getNombre());
            session.put("idusuario", result.get(0).getIdusuario());
        return "successlogin";
    }
    
    @Override
    public Object getModel() {
        return user;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
