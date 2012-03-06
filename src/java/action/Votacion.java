/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Daos.ParticipanteDAO;
import Pojos.Participante;
import Daos.HorarioDAO;
import Pojos.Horario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Carolina
 */
public class Votacion extends ActionSupport {

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
        /**
         * Crear participante temporal participante*
         */
        participante.setEmail(email);
        participante.setIdreunion(idreunion);
        ParticipanteDAO participanteDAO = new ParticipanteDAO();
        /**
         * Crear horario temporal horario*
         */
        horario.setIdreunion(idreunion);
        //horario.setIdhorario(idhorario);
        HorarioDAO horarioDAO = new HorarioDAO();
        try {
            /**
             * Encontrar horario y participante*
             */
            /**
             * Se debe de hacer un ciclo para todos los horarios disponibles,
             * truena al no encontrar ningun horario, necesita validacion *
             */
            List<Participante> result = participanteDAO.findByExample(participante);
            List<Horario> resultHorario = horarioDAO.findByExample(horario);
            
            /**
             * Asignar valores*
             */
            
            bloquear = result.get(0).getBloquear();
            evitar = result.get(0).getEvitar();
            apoyar = result.get(0).getApoyar();
            idhorario = resultHorario.get(0).getIdhorario();
            horarioInicio = resultHorario.get(0).getFechainicio();
            horarioFin = resultHorario.get(0).getFechafin();
            
            return SUCCESS;
        
        } catch (Error e) {
            return "fail";
        }
        

    }

    /**
     * Modificar el estatus de apoyo, bloquo o evitar 0= bloqueo. 1= sumar una
     * unidad de tiempo. 2= restar una unidad de tiempo.
     *
     * @param resultado
     */
    public void ModigicarApoyo(Integer resultado) {
    }

    public void ModigicarBloqueo(Integer resultado) {
    }

    public void ModigicarEvitar(Integer resultado) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(Integer idreunion) {
        this.idreunion = idreunion;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public Date getHorarioFin() {
        return horarioFin;
    }
}
