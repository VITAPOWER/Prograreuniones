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
public class Reunion {

    private Integer idreuniones;
    private String nombrereunion;
    private Date tiempocreacion;
    private Integer tiemporestante;
    private Integer idusuariocreador;
    private Integer status;

    public Integer getIdreuniones() {
        return idreuniones;
    }

    public void setIdreuniones(Integer idreuniones) {
        this.idreuniones = idreuniones;
    }

    public String getNombrereunion() {
        return nombrereunion;
    }

    public void setNombrereunion(String nombrereunion) {
        this.nombrereunion = nombrereunion;
    }

    public Date getTiempocreacion() {
        return tiempocreacion;
    }

    public void setTiempocreacion(String tiempocreacion) throws ParseException {
        DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.tiempocreacion = (Date) formatter.parse(tiempocreacion);
    }

    public Integer getTiemporestante() {
        return tiemporestante;
    }

    public void setTiemporestante(Integer tiemporestante) {
        this.tiemporestante = tiemporestante;
    }

    public Integer getIdusuariocreador() {
        return idusuariocreador;
    }

    public void setIdusuariocreador(Integer idusuariocreador) {
        this.idusuariocreador = idusuariocreador;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
