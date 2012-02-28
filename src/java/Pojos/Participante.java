/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

/**
 *
 * @author Carolina
 */
public class Participante {
    
    private Integer idparticipantes;
    private Integer idusuario;
    private Integer idreunion;
    private Integer bloquear;
    private Integer evitar;
    private Integer apoyar;
    
    public Integer getIdparticipantes() {
        return idparticipantes;
    }

    public void setIdparticipantes(Integer idparticipantes) {
        this.idparticipantes = idparticipantes;
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

    public Integer getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(Integer idreunion) {
        this.idreunion = idreunion;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
    
    
}
