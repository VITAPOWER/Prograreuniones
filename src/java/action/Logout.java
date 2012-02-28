/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author Carolina
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
