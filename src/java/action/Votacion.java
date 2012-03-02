/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Daos.ParticipanteDAO;
import Pojos.Participante;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Carolina
 */
public class Votacion extends ActionSupport{
    
    private Integer bloquear;
    private Integer evitar;
    private Integer apoyar;
    private Integer idreunion;
    private String email;
    
    private Participante participante = new Participante();
    
    @Override
    public String execute() throws Exception {
        participante.setEmail(email);
        participante.setIdreunion(idreunion);
        ParticipanteDAO participanteDAO = new ParticipanteDAO();
        List<Participante> result = participanteDAO.findByExample(participante);
        bloquear = result.get(0).getBloquear();
        evitar = result.get(0).getEvitar();
        apoyar = result.get(0).getApoyar();
        return SUCCESS;
    }
    
    public Integer getApoyar() {
        return apoyar;
    }

    public void setApoyar(Integer apoyar) {
        this.apoyar = apoyar;
    }

    public Integer getBloquear() {
        return bloquear;
    }

    public void setBloquear(Integer bloquear) {
        this.bloquear = bloquear;
    }
    
    public Integer getEvitar() {
        return evitar;
    }

    public void setEvitar(Integer evitar) {
        this.evitar = evitar;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public Integer getIdreunion(){
        return idreunion;
    }
    
    public void setIdreunion(Integer idreunion){
        this.idreunion = idreunion;
    }
}
