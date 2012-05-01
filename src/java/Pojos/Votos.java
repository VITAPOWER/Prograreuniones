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
 * Nombre de archivo: Votos.java
 * Fecha Ultima Modificacion: Abril, 30, 2012
 * 
 * 
 * Descripcion: clase para hacer un voto en el calendario.
 */

/*Paquete:
 * Nombrar paquete al que pertenece el archivo.
 */
package Pojos;

//importar Daos
import Daos.VotosDAO;
//importar librerias
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class Votos extends ActionSupport {

    //declarar variables globales
    private Integer idvotos;
    private String idusuario;
    private Integer idhorario;
    private Integer idreunion;
    private Integer bloqueargastado;
    private Integer evitargastado;
    private Integer apoyargastado;
    //

    //metodos adicionales
    /*
     * resetea todos los votos que pertenecen a al horario por medio de borrar
     * fisico a todos los registros (votos) generados
     */
    public void borrarVotos(Integer idHorario) {
        Votos voto = new Votos();
        voto.setIdHorario(idHorario);
        VotosDAO VotosDAO = new VotosDAO();
        List<Votos> resultVotos = VotosDAO.findByExample(voto);

        //ciclo para borrar los votos dentro del listado resultVotos
       for (Votos votoTemp : resultVotos)
       {
        VotosDAO VotosDAO1 = new VotosDAO();
        VotosDAO1.delete(votoTemp);
       }       
    }

    //borrar fisico del registro individual
    public void borrarVoto(Integer idHorario, Integer idVoto) {
        Votos voto = new Votos();
        voto.setIdHorario(idHorario);
        voto.setIdVotos(idVoto);
        VotosDAO VotosDAO = new VotosDAO();
        List<Votos> resultVotos = VotosDAO.findByExample(voto);
        
        //borra el voto con el idVoto seleccionado
        voto = resultVotos.get(0);
        VotosDAO.delete(voto);
    }

    // metodos set
    public void setIdVotos(Integer idvotos) {
        this.idvotos = idvotos;
    }

    public void setIdUsuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public void setIdHorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public void setIdReunion(Integer idreunion) {
        this.idreunion = idreunion;
    }

    public void setBloquearGastado(Integer bloqueargastado) {
        this.bloqueargastado = bloqueargastado;
    }

    public void setEvitarGastado(Integer evitargastado) {
        this.evitargastado = evitargastado;
    }

    public void setApoyarGastado(Integer apoyargastado) {
        this.apoyargastado = apoyargastado;
    }

    // metodos get
    public Integer getIdVotos() {
        return idvotos;
    }

    public String getIdUsuario() {
        return idusuario;
    }

    public Integer getIdHorario() {
        return idhorario;
    }

    public Integer getIdReunion() {
        return idreunion;
    }

    public Integer getBloquearGastado() {
        return bloqueargastado;
    }

    public Integer getEvitarGastado() {
        return evitargastado;
    }

    public Integer getApoyarGastado() {
        return apoyargastado;
    }
}
