/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Daos.HorarioDAO;
import Daos.ReunionDAO;
import Daos.ParticipanteDAO;
import Pojos.Reunion;
import Pojos.Horario;
import Pojos.Participante;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author Carolina/Eder
 */
public class CrearGrupo extends ActionSupport implements ModelDriven {

    //objetos
    private Reunion reunion = new Reunion();
    private Horario horario = new Horario();
    private Participante participante = new Participante();
    //variables para horario
    private String[] fechainicio;
    private String[] fechafin;
    //variables para participantes
    private String[] email;
    private Integer[] bloquear;
    private Integer[] evitar;
    private Integer[] apoyar;
    Map errorMap = new HashMap();

    //private String mensaje;
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String dar() throws Exception {
        Map session = ActionContext.getContext().getSession();

        reunion.setIdusuariocreador((Integer) session.get("idusuario"));
        reunion.setStatus(5);

        ReunionDAO reunionDAO = new ReunionDAO();
        reunionDAO.create(reunion);

        //reparar, los gets y set de horario fechas se cambiaron a dates en lugar de strings
        int i = 0;
        for (String hr1 : fechainicio) {
            Date hrinicio;
            Date hrfin;
            SimpleDateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            HorarioDAO horarioDAO = new HorarioDAO();
            horario.setIdreunion(reunion.getIdreuniones());
            
            hrinicio = (Date)formatter.parse(hr1);
            horario.setFechainicio(hrinicio);
            
            hrfin = (Date) formatter.parse(fechafin[i]);
            horario.setFechafin(hrfin);
            horarioDAO.create(horario);
            i++;
        }


        //Usuario usuario = new Usuario();
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        int j = 0;
        for (String m : email) {
            //usuario.setEmail(m);
            //List<Usuario> resultUsuarios = usuarioDAO.findByExample(usuario);

            ParticipanteDAO participanteDAO = new ParticipanteDAO();
            participante.setIdreunion(reunion.getIdreuniones());
            participante.setBloquear(bloquear[j]);
            participante.setApoyar(apoyar[j]);
            participante.setEvitar(evitar[j]);
            participante.setEmail(m);
            //participante.setIdparticipantes(resultUsuarios.get(0).getIdusuario());
            
            participanteDAO.create(participante);
            j++;
        }
        return "successekis";

    }

    // Define error messages
    public void jspInit() {
        errorMap.put(CrearGrupo.ERR_NOMBREGRUPO_ENTER, "Introduzca el nombre del grupo");
        errorMap.put(CrearGrupo.ERR_NOMBREGRUPO_INVALID, "Nombre de grupo invalido, no exceda mas de 20 caracteres o escriba caracteres especiales");
        errorMap.put(CrearGrupo.ERR_HORAAPERTURA_ENTER, "Introduzca la hora de apertura de la votacion");
        errorMap.put(CrearGrupo.ERR_HORAAPERTURA_INVALID, "Hora de apertura invalida: La hora de apertuda debe ser menor al tiempo limite de votacion");
        errorMap.put(CrearGrupo.ERR_HORATIEMPOLIMITE_ENTER, "Introduzca el tiempo limite para la votacion");
        errorMap.put(CrearGrupo.ERR_HORATIEMPOLIMITE_INVALID, "Tiempo limite de la votacion invalido: El tiempo limite de votacion debe ser mayor a la hora de apertuda.");
        errorMap.put(CrearGrupo.ERR_AGREGAHORARIO_ENTER, "Agregar horario de inicio de la junta tanto como el de salida");
        errorMap.put(CrearGrupo.ERR_AGREGAHORARIO_INVALID, "Horario invalido: la junta no puede terminar antes de empezar, escriba caracteres especiales");
        errorMap.put(CrearGrupo.ERR_AGREGAHORARIO_MASDEUNO, "Debe haber mas de un horario para realizar la votacion");
    }
    /*
     * Errores
     */
    public static final Integer ERR_NOMBREGRUPO_ENTER = new Integer(1);
    public static final Integer ERR_NOMBREGRUPO_INVALID = new Integer(2);
    public static final Integer ERR_HORAAPERTURA_ENTER = new Integer(3);
    public static final Integer ERR_HORAAPERTURA_INVALID = new Integer(4);
    public static final Integer ERR_HORATIEMPOLIMITE_ENTER = new Integer(5);
    public static final Integer ERR_HORATIEMPOLIMITE_INVALID = new Integer(6);
    public static final Integer ERR_AGREGAHORARIO_ENTER = new Integer(7);
    public static final Integer ERR_AGREGAHORARIO_INVALID = new Integer(8);
    public static final Integer ERR_AGREGAHORARIO_MASDEUNO = new Integer(9);
    // Holds error messages for the properties
    Map errorCodes = new HashMap();
    // Maps error codes to textual messages.
    // This map must be supplied by the object that instantiated this bean.
    Map msgMap;

    public void setErrorMessages(Map msgMap) {
        this.msgMap = msgMap;
    }

    public String getErrorMessage(String propName) {
        Integer code = (Integer) (errorCodes.get(propName));
        if (code == null) {
            return "";
        } else if (msgMap != null) {
            String msg = (String) msgMap.get(code);
            if (msg != null) {
                return msg;
            }
        }
        return "Error";
    }

    /*
     * Form validation and processing
     */
    public boolean isValid() {
        // Clear all errors
        errorCodes.clear();

        //Entero para comparar fechas entre el tiempo en votacion de reunion
        int comparacion = reunion.getTiempocreacion().compareTo(reunion.getTiemporestante());

        //Validacion al crear el nombre del grupo VACIO
        if (reunion.getNombrereunion() == "") {
            errorCodes.put("NombreGrupo", ERR_NOMBREGRUPO_ENTER);
        } else if (reunion.getNombrereunion().matches(".+@.+\\..+") || reunion.getNombrereunion().length() > 20 || reunion.getNombrereunion().length() < 5) {
            errorCodes.put("NombreGrupo", ERR_NOMBREGRUPO_INVALID);
        }

        //Validacion al crear la hora de apertura de la votacion 
        if (reunion.getTiempocreacion() == null) {
            errorCodes.put("HoraApertura", ERR_HORAAPERTURA_ENTER);
        } else if (reunion.getTiempocreacion() != reunion.getTiempocreacion() || comparacion > 0) {//dunno what to do...
            errorCodes.put("HoraApertura", ERR_HORAAPERTURA_INVALID);
        }

        //Validacion al crear la hora del tiempo limite de la votacion
        if (reunion.getTiemporestante() == null) {
            errorCodes.put("TiempoLimite", ERR_HORATIEMPOLIMITE_ENTER);
        } else if (reunion.getTiemporestante() != reunion.getTiemporestante() || comparacion > 0) {//dunno what to do...
            errorCodes.put("TiempoLimite", ERR_HORATIEMPOLIMITE_INVALID);
        }

        //Entero para comparar fechas entre el tiempo en votacion de reunion
        int comparacion2 = horario.getFechainicio().compareTo(horario.getFechafin());

        //Validacion al agregar los diferentes horarios.
        if (horario.getFechainicio() == null || horario.getFechafin() == null) {
            errorCodes.put("AgregaHorario", ERR_AGREGAHORARIO_ENTER);
        } else if (comparacion2 > 0) {
            errorCodes.put("AgregaHorario", ERR_AGREGAHORARIO_INVALID);
        }

        //Falta comparacion para verificar que exista mas de una propuesta de horario de junta.


        // If no errors, form is valid
        return errorCodes.size() == 0;
    }

    @Override
    public Object getModel() {
        return reunion;
    }

    //metodos para obtener el array de horarios
    //cantidad de horarios debe ser > 1 para que funcione
    public String[] getFechafin() {
        return fechafin;
    }

    public void setFechafin(String[] fechafin) {
        this.fechafin = fechafin;
    }

    public String[] getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String[] fechainicio) {
        this.fechainicio = fechainicio;
    }

    //metodos que obtienen los arrays de invitados
    //
    public Integer[] getApoyar() {
        return apoyar;
    }

    public void setApoyar(Integer[] apoyar) {
        this.apoyar = apoyar;
    }

    public Integer[] getBloquear() {
        return bloquear;
    }

    public void setBloquear(Integer[] bloquear) {
        this.bloquear = bloquear;
    }

    public Integer[] getEvitar() {
        return evitar;
    }

    public void setEvitar(Integer[] evitar) {
        this.evitar = evitar;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }
}
