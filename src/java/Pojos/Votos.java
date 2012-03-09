/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.util.List;
import Daos.VotosDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Chain
 */
public class Votos extends ActionSupport {

    private Integer idvotos;
    private Integer idusuario;
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
    public static void borrarVotos(Integer idHorario) {
        Votos voto = new Votos();
        voto.setIdHorario(idHorario);
        VotosDAO VotosDAO = new VotosDAO();
        List<Votos> resultVotos = VotosDAO.findByExample(voto);

        //ciclo para borrar los votos dentro del listado resultVotos
       for (Votos votoTemp : resultVotos)
       {
        VotosDAO.delete(votoTemp);
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

    public void setIdUsuario(Integer idusuario) {
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

    public Integer getIdUsuario() {
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
