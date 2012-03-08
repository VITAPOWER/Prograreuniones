/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

/**
 *
 * @author Chain
 */
public class Votos {
    private Integer idusuario;
    private Integer idhorario;
    private Integer idreunion;
    private Integer bloqueargastado;
    private Integer evitargastado;
    private Integer apoyargastado;
    
    //metodos adicionales
    
    /*resetea todos los votos que pertenecen a al horario
     * por medio de borrar todos los registros (votos) 
     * generados
     */
    
    public void borrarVotos(Integer idHorario)
    {
    
    }
    
    //borrar registro individual
    public void borrarVoto()
    {
        
    }
    
    // metodos get
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
