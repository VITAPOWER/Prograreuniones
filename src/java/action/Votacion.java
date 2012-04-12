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
import Pojos.Votos;
import Daos.VotosDAO;
import calendar.Event;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import nl.justobjects.pushlet.core.Dispatcher;

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
    private Date fechaInicio;
    private Date fechaFin;
    private Integer operacion;
    private Votos ejemploVoto = new Votos();
    private String jason;

    @Override
    public String execute() throws Exception {
        if ((email != null) && (idreunion != null)) {
            //Sacamos cuantos votos puede realizar
            participante.setEmail(email);
            participante.setIdreunion(idreunion);
            ParticipanteDAO participanteDAO = new ParticipanteDAO();
            List<Participante> result = participanteDAO.findByExample(participante);
            if (!result.isEmpty()) {
                bloquear = result.get(0).getBloquear();
                evitar = result.get(0).getEvitar();
                apoyar = result.get(0).getApoyar();
            }
            //Cuantos votos ha gastado
            VotosDAO votosDaoEjemplo = new VotosDAO();
            ejemploVoto.setIdReunion(idreunion);
            ejemploVoto.setIdUsuario(email);
            List<Votos> resultVotos = votosDaoEjemplo.findByExample(ejemploVoto);
            for (Votos voto : resultVotos) {//Se le resta lo que gasto en cada horario
                bloquear -= voto.getBloquearGastado();
                evitar -= voto.getEvitarGastado();
                apoyar -= voto.getApoyarGastado();
            }
            return SUCCESS;
        } else {
            return "regresalogin";
        }
    }

    public String buildCalendar() throws Exception {
        if ((email != null) && (idreunion != null)) {
            horario.setIdreunion(idreunion);
            HorarioDAO horarioDAO = new HorarioDAO();
            List<Horario> resultHorario = horarioDAO.findByExample(horario);
            int id = 0;
            jason = "";
            for (Horario i : resultHorario) {
                String color = "blue";
                apoyar = 0;
                evitar = 0;
                bloquear = 0;
                jason += "\"" + id + "\",";
                id++;
                SimpleDateFormat formatter;
                formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                ejemploVoto = new Votos();
                ejemploVoto.setIdHorario(i.getIdhorario());
                ejemploVoto.setIdReunion(idreunion);
                VotosDAO votosDaoEjemplo = new VotosDAO();
                List<Votos> resultVotos = votosDaoEjemplo.findByExample(ejemploVoto);
                for (Votos voto : resultVotos) {
                    apoyar += voto.getApoyarGastado();
                    evitar += voto.getEvitarGastado();
                    bloquear += voto.getBloquearGastado();
                }
                if (evitar > apoyar) {
                    color = "gray";
                }
                if (bloquear > 0) {
                    color = "red";
                }
                Event newob = new Event(i.getIdhorario(),
                        "\n" + "Apoyando:" + apoyar + "\n" + "Evitando:" + evitar + "\n" + "Bloqueando:" + bloquear,
                        formatter.format(i.getFechainicio()),
                        formatter.format(i.getFechafin()),
                        color);
                jason += new Gson().toJson(newob) + ",";
            }
        }
        jason = jason.substring(0, jason.length() - 1);
        return "calendar";
    }

    public String votoApoyar() throws Exception {
        if ((email != null) && (idreunion != null)) {
            VotosDAO votosDaoEjemplo = new VotosDAO();
            ejemploVoto.setIdReunion(idreunion);
            ejemploVoto.setIdUsuario(email);
            ejemploVoto.setIdHorario(idhorario);
            List<Votos> resultVotos = votosDaoEjemplo.findByExample(ejemploVoto);
            if (resultVotos.isEmpty()) {
                ejemploVoto.setApoyarGastado(1);
                ejemploVoto.setEvitarGastado(0);
                ejemploVoto.setBloquearGastado(0);
                votosDaoEjemplo = new VotosDAO();
                votosDaoEjemplo.create(ejemploVoto);
            } else {
                for (Votos voto : resultVotos) {
                    votosDaoEjemplo = new VotosDAO();
                    voto.setApoyarGastado(voto.getApoyarGastado() + 1);
                    votosDaoEjemplo.update(voto);
                }
            }
            nl.justobjects.pushlet.core.Event event = nl.justobjects.pushlet.core.Event.createDataEvent("/calendar" + idreunion);
            Dispatcher.getInstance().multicast(event);
        }
        return SUCCESS;
    }

    public String votoEvitar() throws Exception {
        if ((email != null) && (idreunion != null)) {
            VotosDAO votosDaoEjemplo = new VotosDAO();
            ejemploVoto.setIdReunion(idreunion);
            ejemploVoto.setIdUsuario(email);
            ejemploVoto.setIdHorario(idhorario);
            List<Votos> resultVotos = votosDaoEjemplo.findByExample(ejemploVoto);
            if (resultVotos.isEmpty()) {
                ejemploVoto.setApoyarGastado(0);
                ejemploVoto.setEvitarGastado(1);
                ejemploVoto.setBloquearGastado(0);
                votosDaoEjemplo = new VotosDAO();
                votosDaoEjemplo.create(ejemploVoto);
            } else {
                for (Votos voto : resultVotos) {
                    votosDaoEjemplo = new VotosDAO();
                    voto.setEvitarGastado(voto.getEvitarGastado() + 1);
                    votosDaoEjemplo.update(voto);
                }
            }
            nl.justobjects.pushlet.core.Event event = nl.justobjects.pushlet.core.Event.createDataEvent("/calendar" + idreunion);
            Dispatcher.getInstance().multicast(event);
        }
        return SUCCESS;
    }

    public String votoBloquear() throws Exception {
        if ((email != null) && (idreunion != null)) {
            VotosDAO votosDaoEjemplo = new VotosDAO();
            ejemploVoto.setIdReunion(idreunion);
            ejemploVoto.setIdUsuario(email);
            ejemploVoto.setIdHorario(idhorario);
            List<Votos> resultVotos = votosDaoEjemplo.findByExample(ejemploVoto);
            if (resultVotos.isEmpty()) {
                ejemploVoto.setApoyarGastado(0);
                ejemploVoto.setEvitarGastado(0);
                ejemploVoto.setBloquearGastado(1);
                votosDaoEjemplo = new VotosDAO();
                votosDaoEjemplo.create(ejemploVoto);
            } else {
                for (Votos voto : resultVotos) {
                    votosDaoEjemplo = new VotosDAO();
                    voto.setBloquearGastado(voto.getBloquearGastado() + 1);
                    votosDaoEjemplo.update(voto);
                }
            }
            nl.justobjects.pushlet.core.Event event = nl.justobjects.pushlet.core.Event.createDataEvent("/calendar" + idreunion);
            Dispatcher.getInstance().multicast(event);
        }
        return SUCCESS;
    }

    public Integer getApoyar() {
        return apoyar;
    }

    public Integer getOperacion() {
        return operacion;
    }

    public void setOperacion(Integer operacion) {
        this.operacion = operacion;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getJason() {
        return jason;
    }

    public void setJason(String jason) {
        this.jason = jason;
    }
}
