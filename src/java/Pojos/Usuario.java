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
 * Nombre de archivo: Usuario.java
 * Fecha Ultima Modificacion: Abril, 30, 2012
 * 
 * 
 * Descripcion: Clase usuario.
 */

/*Paquete:
 * Nombrar paquete al que pertenece el archivo.
 */
package Pojos;


public class Usuario {
    //declarar variables globales.
    private Integer idusuario;
    private String nombre;
    private String username;
    private String password;
    private String email;

    //metodos get
    public String getEmail() {
        return email;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    
    //Metodos set
    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
