/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author Carolina
 */
public class Horario {
    
    private Integer idhorario;
    private Integer idreunion;
    private Date fechainicio;
    private Date fechafin;

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) throws ParseException {
        /**DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
        this.fechafin = (Date) formatter.parse(fechafin);**/
        this.fechafin = fechafin;
    }

    public Date getFechainicio() {
        return fechainicio;
    }
    
    public void setFechainicio(Date fechainicio) throws ParseException {
        /**DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
        this.fechainicio = (Date) formatter.parse(fechainicio);**/
        this.fechainicio=fechainicio;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public Integer getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(Integer idreunion) {
        this.idreunion = idreunion;
    }   
}