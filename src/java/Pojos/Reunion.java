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
 * Nombre de archivo: Reunion.java
 * Fecha Ultima Modificacion: Abril, 30, 2012
 * 
 * 
 * Descripcion: clase reunion.
 */

/*Paquete:
 * Nombrar paquete al que pertenece el archivo.
 */
package Pojos;

//importar librerias
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reunion {
    //declarar variables globales
    private Integer idreuniones;
    private String nombrereunion;
    private Date tiempocreacion;
    private Date tiemporestante;
    private Integer idusuariocreador;
    private Integer status;

    //Metodos get
    public Integer getIdreuniones() {
        return idreuniones;
    }

    public String getNombrereunion() {
        return nombrereunion;
    }

    public Date getTiempocreacion() {
        return tiempocreacion;
    }

    public Date getTiemporestante() {
        return tiemporestante;
    }

    public Integer getIdusuariocreador() {
        return idusuariocreador;
    }

    public Integer getStatus() {
        return status;
    }
    
    //Metodos set
    public void setIdreuniones(Integer idreuniones) {
        this.idreuniones = idreuniones;
    }

    public void setNombrereunion(String nombrereunion) {
        this.nombrereunion = nombrereunion;
    }

    public void setTiempocreacion(Date tiempocreacion) throws ParseException {
        this.tiempocreacion = tiempocreacion;
    }

    public void setTiemporestante(Date tiemporestante) throws ParseException {
        this.tiemporestante = tiemporestante;
    }

    public void setIdusuariocreador(Integer idusuariocreador) {
        this.idusuariocreador = idusuariocreador;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
