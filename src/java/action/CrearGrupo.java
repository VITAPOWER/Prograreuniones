/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Daos.ReunionDAO;
import Pojos.Reunion;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Date;
import java.util.Map;
/**
 *
 * @author Carolina
 */
public class CrearGrupo extends ActionSupport implements ModelDriven{
    
    private Reunion reunion = new Reunion();
    //private String mensaje;
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String dar() throws Exception {
        Map session = ActionContext.getContext().getSession();
        
        reunion.setIdusuariocreador((Integer)session.get("idusuario"));
        reunion.setStatus(5);
        
        ReunionDAO reunionDAO = new ReunionDAO();
        reunionDAO.create(reunion);
        
        return "successekis";
    }
    
    @Override
    public Object getModel() {
        return reunion;
    }
}
