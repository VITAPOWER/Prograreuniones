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

    private Integer idvoto;
    private Integer idusuario;
    private Integer idhorario;
    private Integer idreunion;
    private Integer bloqueargastado;
    private Integer evitargastado;
    private Integer apoyargastado;
    private Votos voto = new Votos();

    //metodos adicionales
    /*
     * resetea todos los votos que pertenecen a al horario por medio de borrar
     * fisico a todos los registros (votos) generados
     */
    public void borrarVotos(Integer idHorario) {
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
        voto.setIdHorario(idHorario);
        voto.setIdVoto(idVoto);
        VotosDAO VotosDAO = new VotosDAO();
        List<Votos> resultVotos = VotosDAO.findByExample(voto);
        
        //borra el voto con el idVoto seleccionado
        voto = resultVotos.get(0);
        VotosDAO.delete(voto);
    }

    // metodos get
    public void setIdVoto(Integer idvoto) {
        this.idvoto = idvoto;
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

    // metodos set
    public Integer getIdVoto() {
        return idvoto;
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
