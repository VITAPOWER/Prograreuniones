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
public class CheckLogin extends ActionSupport{
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    /*public String CheckLogin(){
        
        Map session = ActionContext.getContext().getSession();
         Integer idusuario = Integer.parseInt(session.get("idusuario"));
        }
        return SUCCESS;
    }*/
}
