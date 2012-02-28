/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Daos.HorarioDAO;
import Daos.ReunionDAO;
import Pojos.Reunion;
import Pojos.Horario;
import Pojos.Participante;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Carolina/Eder
 */
public class CrearGrupo extends ActionSupport implements ModelDriven{
    
    //objetos
    private Reunion reunion = new Reunion();
    private Horario horario = new Horario();
    private Participante participante = new Participante();
    
    //variables para horario
    private String[] fechainicio;
    private String[] fechafin;
    
    //variables para participantes
    private String[] mail;
    private String[] bloquear;
    private String[] evitar;
    private String[] apoyar;
    
    Map errorMap = new HashMap();
    
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
        
        int i = 0;
        for(String hr : fechainicio){
            HorarioDAO horarioDAO = new HorarioDAO();
            horario.setIdreunion(reunion.getIdreuniones());
            horario.setFechainicio(hr);
            horario.setFechafin(fechafin[i]);
            horarioDAO.create(horario);
            i++;
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
    
      /* Errores */
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
        Integer code = (Integer)(errorCodes.get(propName));
        if (code == null) {
            return "";
        } else if (msgMap != null) {
            String msg = (String)msgMap.get(code);
            if (msg != null) {
                return msg;
            }
        }
        return "Error";
    }

    /* Form validation and processing */
    public boolean isValid() {
        // Clear all errors
        errorCodes.clear();

        //Entero para comparar fechas entre el tiempo en votacion de reunion
        int comparacion = reunion.getTiempocreacion().compareTo(reunion.getTiemporestante()); 
        
        //Validacion al crear el nombre del grupo VACIO
        if(reunion.getNombrereunion() == ""){
            errorCodes.put("NombreGrupo", ERR_NOMBREGRUPO_ENTER);
        } else if (reunion.getNombrereunion().matches(".+@.+\\..+") || reunion.getNombrereunion().length() > 20 || reunion.getNombrereunion().length() < 5 ){
            errorCodes.put("NombreGrupo", ERR_NOMBREGRUPO_INVALID);
        }
        
            //Validacion al crear la hora de apertura de la votacion 
        if(reunion.getTiempocreacion() == null){
            errorCodes.put("HoraApertura", ERR_HORAAPERTURA_ENTER);
        } else if (reunion.getTiempocreacion() != reunion.getTiempocreacion() || comparacion > 0){//dunno what to do...
            errorCodes.put("HoraApertura", ERR_HORAAPERTURA_INVALID);
        }
        
            //Validacion al crear la hora del tiempo limite de la votacion
        if(reunion.getTiemporestante() == null){
            errorCodes.put("TiempoLimite", ERR_HORATIEMPOLIMITE_ENTER);
        } else if (reunion.getTiemporestante() != reunion.getTiemporestante() || comparacion > 0){//dunno what to do...
            errorCodes.put("TiempoLimite", ERR_HORATIEMPOLIMITE_INVALID);
        }

        //Entero para comparar fechas entre el tiempo en votacion de reunion
        int comparacion2 = horario.getFechainicio().compareTo(horario.getFechafin()); 
        
         //Validacion al agregar los diferentes horarios.
        if(horario.getFechainicio() == null || horario.getFechafin() == null){
            errorCodes.put("AgregaHorario", ERR_AGREGAHORARIO_ENTER);
        } else if (comparacion2 > 0){
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

    public void setFechafin(String fechafin) {
        this.fechafin = new String[1];
        this.fechafin[0] = fechafin;
    }

    public String[] getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String[] fechainicio) {
        this.fechainicio = fechainicio;
    }
    
    public void setFechainicio(String fechainicio) {
        this.fechainicio = new String[1];
        this.fechainicio[0] = fechainicio;
    }
    //metodos que obtienen los arrays de invitados
    //
    public String[] getApoyar() {
        return apoyar;
    }

    public void setApoyar(String[] apoyar) {
        this.apoyar = apoyar;
    }

    public String[] getBloquear() {
        return bloquear;
    }

    public void setBloquear(String[] bloquear) {
        this.bloquear = bloquear;
    }

    public String[] getEvitar() {
        return evitar;
    }

    public void setEvitar(String[] evitar) {
        this.evitar = evitar;
    }

    public String[] getMail() {
        return mail;
    }

    public void setMail(String[] mail) {
        this.mail = mail;
    }
}
