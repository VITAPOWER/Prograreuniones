/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Pojos.Participante;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Carolina
 */
public class Votacion extends ActionSupport{
    
    private Integer bloquear = null;
    private Integer evitar = null;
    private Integer apoyar = null;
    private String email = null;
    
    private Participante participante = new Participante();
    
    @Override
    public String execute() throws Exception {
        // do something here
        return SUCCESS;
    }
    
    public String dar(){
        
        return "";
    }
    
    public String getEmail(){
        return email;
    }
    
    
}
