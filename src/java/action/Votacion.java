/*
 *Proyecto: Programa Reuniones para Ramon Brena
 * 
 *Alumnos/Autores que participaron:
 *Adrián M Morales 615525                                                   
 *Eder Ramírez 796598
 *Daniel Sánchez 617763
 *Carolina Flores 617680
 * 
 *Materia: Proyecto Integrador 9nvo semestre
 *Profesor: Dr.Lorena Gomez y Dr.Juan Carlos Lavariega
 *
 * Nombre de archivo: Votacion.java
 * Fecha Ultima Modificacion: Abril, 30, 2012
 */

/*Paquete:
 * Nombrar paquete al que pertenece el archivo.
 */
package action;
/*
 * Librerias: Importar librerias utilizadas
 */

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import calendar.Event;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import nl.justobjects.pushlet.core.Dispatcher;
/*
 * Daos: Importar Daos utilizados.
 */
import Daos.HorarioDAO;
import Daos.ParticipanteDAO;
import Daos.ReunionDAO;
import Daos.VotosDAO;
/*
 * Pojos: Importar Pojos utilizados.
 */
import Pojos.Horario;
import Pojos.Participante;
import Pojos.Votos;
import Pojos.Reunion;

/*
 * Inicio de la clase: Descripcion: esta clase permite la votacion de horarios
 * por parte de los participantes.
 */
public class Votacion extends ActionSupport {

    /*
     * Declaraciond e variables globales.
     */
    //Variables de tipo: Integer
    private Integer bloquear;
    private Integer evitar;
    private Integer apoyar;
    private Integer resetBloquear;
    private Integer resetEvitar;
    private Integer resetApoyar;
    private Integer idreunion;
    private Integer operacion;
    private Integer idhorario;
    //Variables de tipo: String
    private String email;
    private String fechaFin;
    private String jason;
    //Declaracion de clases utilizadas.
    private Votos ejemploVoto = new Votos();
    private Participante participante = new Participante();
    private Horario horario = new Horario();

    //Metodo principal de la clase.
    @Override
    public String execute() throws Exception {
        /*
         * Se revisa que la direccion tenga un correo elctronico y un
         * identificador para la reunion. En caso de no contener se regresa a la
         * pantalla de login/inicio
         */
        if ((email != null) && (idreunion != null)) {
            /*
             * Buscamos el participante indicado y sacamos cuantos votos puede
             * realizar.
             */
            participante.setEmail(email);
            participante.setIdreunion(idreunion);
            ParticipanteDAO participanteDAO = new ParticipanteDAO();
            List<Participante> result = participanteDAO.findByExample(participante);
            //Se revisa la existencia del participante.
            if (!result.isEmpty()) {
                //Se le asigna los votos que tiene.
                bloquear = result.get(0).getBloquear();
                evitar = result.get(0).getEvitar();
                apoyar = result.get(0).getApoyar();
                resetBloquear = result.get(0).getBloquear();
                resetEvitar = result.get(0).getEvitar();
                resetApoyar = result.get(0).getApoyar();
            }
            //Cuantos votos ha gastado
            VotosDAO votosDaoEjemplo = new VotosDAO();
            ejemploVoto.setIdReunion(idreunion);
            ejemploVoto.setIdUsuario(email);
            List<Votos> resultVotos = votosDaoEjemplo.findByExample(ejemploVoto);
            for (Votos voto : resultVotos) {
                //Se le resta lo que gasto en cada horario
                bloquear -= voto.getBloquearGastado();
                evitar -= voto.getEvitarGastado();
                apoyar -= voto.getApoyarGastado();
            }
            //Se obtiene el hora del horario seleccionado.
            ReunionDAO reunionDAO = new ReunionDAO();
            Reunion reunionHora = reunionDAO.findById(idreunion);
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
            fechaFin = formatter.format(reunionHora.getTiemporestante());
            return SUCCESS;
        } else {
            return "regresalogin";
        }
    }

    //Metodo para construir el calendario.
    public String buildCalendar() throws Exception {
        /*
         * Se revisa que la direccion tenga un correo elctronico y un
         * identificador para la reunion.
         */
        if ((email != null) && (idreunion != null)) {
            //localizamos el horario.
            horario.setIdreunion(idreunion);
            HorarioDAO horarioDAO = new HorarioDAO();
            List<Horario> resultHorario = horarioDAO.findByExample(horario);
            int id = 0;
            jason = "";
            //creamos todos los horarios disponibles con los votos que tiene.
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
                //cambiamos de color si esta ecitar es mayor que apoyar.
                if (evitar > apoyar) {
                    color = "gray";
                }
                //cambiamos de color si esta bloqueado.
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

    //metodo para insertar un voto de estilo apoyar.
    public String votoApoyar() throws Exception {
        /*
         * Se revisa que la direccion tenga un correo elctronico y un
         * identificador para la reunion.
         */
        if ((email != null) && (idreunion != null)) {
            VotosDAO votosDaoEjemplo = new VotosDAO();
            ejemploVoto.setIdReunion(idreunion);
            ejemploVoto.setIdUsuario(email);
            ejemploVoto.setIdHorario(idhorario);
            List<Votos> resultVotos = votosDaoEjemplo.findByExample(ejemploVoto);
            /*Si la lista esta vacia se genera un nuevo voto,
             *si la lista ya contiene votos se incrementa el apoyar en 1.
             */
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

    //metodo para insertar un voto de estilo Evitar.
    public String votoEvitar() throws Exception {
        /*
         * Se revisa que la direccion tenga un correo elctronico y un
         * identificador para la reunion.
         */
        if ((email != null) && (idreunion != null)) {
            VotosDAO votosDaoEjemplo = new VotosDAO();
            ejemploVoto.setIdReunion(idreunion);
            ejemploVoto.setIdUsuario(email);
            ejemploVoto.setIdHorario(idhorario);
            List<Votos> resultVotos = votosDaoEjemplo.findByExample(ejemploVoto);
            /*Si la lista esta vacia se genera un nuevo voto,
             *si la lista ya contiene votos se incrementa el Evitar en 1.
             */
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

    //metodo para insertar un voto de estilo Bloquear.
    public String votoBloquear() throws Exception {
        /*
         * Se revisa que la direccion tenga un correo elctronico y un
         * identificador para la reunion.
         */
        if ((email != null) && (idreunion != null)) {
            VotosDAO votosDaoEjemplo = new VotosDAO();
            ejemploVoto.setIdReunion(idreunion);
            ejemploVoto.setIdUsuario(email);
            ejemploVoto.setIdHorario(idhorario);
            List<Votos> resultVotos = votosDaoEjemplo.findByExample(ejemploVoto);
            /*Si la lista esta vacia se genera un nuevo voto,
             *si la lista ya contiene votos se incrementa el Bloquear en 1.
             */
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

    //metodo para generar un reset en todos los votos del participante.
    public String resetMyVotes() {
        if ((email != null) && (idreunion != null)) {
            //obtenermos votos de la reunion.
            VotosDAO votosDaoEjemplo = new VotosDAO();
            ejemploVoto.setIdReunion(idreunion);
            ejemploVoto.setIdUsuario(email);
            List<Votos> resultVotos = votosDaoEjemplo.findByExample(ejemploVoto);
            //Hacemos el reset.
            for (Votos voto : resultVotos) {
                votosDaoEjemplo = new VotosDAO();
                voto.setApoyarGastado(0);
                voto.setEvitarGastado(0);
                voto.setBloquearGastado(0);
                votosDaoEjemplo.update(voto);
            }
            nl.justobjects.pushlet.core.Event event = nl.justobjects.pushlet.core.Event.createDataEvent("/calendar" + idreunion);
            Dispatcher.getInstance().multicast(event);
        }
        return SUCCESS;
    }

    //metodos get
    public Integer getApoyar() {
        return apoyar;
    }

    public Integer getOperacion() {
        return operacion;
    }

    public Integer getBloquear() {
        return bloquear;
    }

    public Integer getEvitar() {
        return evitar;
    }

    public String getEmail() {
        return email;
    }

    public Integer getIdreunion() {
        return idreunion;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getJason() {
        return jason;
    }

    public Integer getResetApoyar() {
        return resetApoyar;
    }

    public Integer getResetBloquear() {
        return resetBloquear;
    }

    public Integer getResetEvitar() {
        return resetEvitar;
    }

    //metodos set
    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public void setOperacion(Integer operacion) {
        this.operacion = operacion;
    }

    public void setApoyar(Integer apoyar) {
        this.apoyar = apoyar;
    }

    public void setBloquear(Integer bloquear) {
        this.bloquear = bloquear;
    }

    public void setEvitar(Integer evitar) {
        this.evitar = evitar;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdreunion(Integer idreunion) {
        this.idreunion = idreunion;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setJason(String jason) {
        this.jason = jason;
    }

    public void setResetApoyar(Integer resetApoyar) {
        this.resetApoyar = resetApoyar;
    }

    public void setResetBloquear(Integer resetBloquear) {
        this.resetBloquear = resetBloquear;
    }

    public void setResetEvitar(Integer resetEvitar) {
        this.resetEvitar = resetEvitar;
    }
}
