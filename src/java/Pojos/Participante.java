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
 * Nombre de archivo: Participante.java
 * Fecha Ultima Modificacion: Abril, 30, 2012
 * 
 * 
 * Descripcion: clase participante.
 */

/*Paquete:
 * Nombrar paquete al que pertenece el archivo.
 */
package Pojos;

public class Participante {
    //declarar variables globales
    private Integer idparticipantes;
    private String email;
    private Integer idreunion;
    private Integer bloquear;
    private Integer evitar;
    private Integer apoyar;
    
    //metodos get
    public Integer getIdparticipantes() {
        return idparticipantes;
    }
    
    public Integer getApoyar() {
        return apoyar;
    }

    public Integer getBloquear() {
        return bloquear;
    }

    public Integer getEvitar() {
        return evitar;
    }

    public Integer getIdreunion() {
        return idreunion;
    }

    public String getEmail() {
        return email;
    }
    
    //metodos set
    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdreunion(Integer idreunion) {
        this.idreunion = idreunion;
    }

    public void setEvitar(Integer evitar) {
        this.evitar = evitar;
    }

    public void setBloquear(Integer bloquear) {
        this.bloquear = bloquear;
    }

    public void setApoyar(Integer apoyar) {
        this.apoyar = apoyar;
    }

    public void setIdparticipantes(Integer idparticipantes) {
        this.idparticipantes = idparticipantes;
    }
    
}
