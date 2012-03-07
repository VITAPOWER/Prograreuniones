/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Daos.HorarioDAO;
import Daos.ParticipanteDAO;
import Pojos.Horario;
import Pojos.Participante;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
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
    private Horario horario = new Horario();
    private Integer idhorario;
    private Date horarioInicio;
    private Date horarioFin;
    
    
    @Override
    public String execute() throws Exception {
        if((email != null)&&(idreunion != null)){
            participante.setEmail(email);
            participante.setIdreunion(idreunion);
            ParticipanteDAO participanteDAO = new ParticipanteDAO();
            List<Participante> result = participanteDAO.findByExample(participante);
            bloquear = result.get(0).getBloquear();
            evitar = result.get(0).getEvitar();
            apoyar = result.get(0).getApoyar();
            
            horario.setIdreunion(idreunion);
            //horario.setIdhorario(idhorario);
            HorarioDAO horarioDAO = new HorarioDAO();
            List<Horario> resultHorario = horarioDAO.findByExample(horario);
            idhorario = resultHorario.get(0).getIdhorario();
            horarioInicio = resultHorario.get(0).getFechainicio();
            horarioFin = resultHorario.get(0).getFechafin();
            
            return SUCCESS;
        }else{
            return "regresalogin";
        }
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
