/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Pojos.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import nl.justobjects.pushlet.core.Dispatcher;
import nl.justobjects.pushlet.core.Event;

/**
 *
 * @author snidE
 */
public class PushTest extends ActionSupport implements ModelDriven{

    private Usuario user = new Usuario();
    private String message;
    
    @Override
    public String execute() throws Exception {
        message = null;
        //Runtime runtime = Runtime.getRuntime();
        Event event = Event.createDataEvent("/calendar");
        event.setField("AreYouReady","");
        
 	//event.setField("totalMemory", "" + runtime.totalMemory());
 	//event.setField("freeMemory", "" + runtime.freeMemory());
 	//event.setField("maxMemory", "" + runtime.maxMemory());
 	//int activeCount = Thread.activeCount();
 	//event.setField("threads", "" + activeCount);
 	Dispatcher.getInstance().multicast(event);
        return SUCCESS;

    }
    
    @Override
    public Object getModel() {
        return null;
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
