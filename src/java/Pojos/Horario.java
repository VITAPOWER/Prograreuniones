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
 * Nombre de archivo: Horario.java
 * Fecha Ultima Modificacion: Abril, 30, 2012
 * 
 * 
 * Descripcion: clase horario.
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

public class Horario {
    //declarar variables globales
    private Integer idhorario;
    private Integer idreunion;
    private Date fechainicio;
    private Date fechafin;

    //metodos get
    public Date getFechafin() {
        return fechafin;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public Integer getIdreunion() {
        return idreunion;
    }

    //metodos set
    public void setIdreunion(Integer idreunion) {
        this.idreunion = idreunion;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }
    
    public void setFechainicio(Date fechainicio) throws ParseException {
        /*Cambio: originalmente se tinia la fecha de entrada 
         * como string, se cambio a date
         */
        /*DateFormat formatter;
        *formatter = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
        *this.fechainicio = (Date) formatter.parse(fechainicio);
        */
        this.fechainicio=fechainicio;
    }

    public void setFechafin(Date fechafin) throws ParseException {
        /*Cambio: originalmente se tinia la fecha de entrada 
         * como string, se cambio a date
         */
        /*DateFormat formatter;
        *formatter = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
        *this.fechafin = (Date) formatter.parse(fechafin);*
        */
        this.fechafin = fechafin;
    }   
}