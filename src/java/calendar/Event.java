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
 * Nombre de archivo: Event.java
 * Fecha Ultima Modificacion: Abril, 30, 2012
 * 
 * 
 * Descripcion: objeto evento dentro del calendario (javascript).
 */

/*Paquete:
 * Nombrar paquete al que pertenece el archivo.
 */
package calendar;

/*
 * El objeto evento dentro del calendario javascript
 *
 */
public class Event {

    //declarar variables globales
    private String allDay = "";
    private String title = "Event2";
    private int id = 222;
    private String end = "2012-04-22";
    private String start = "2012-04-20";
    private String color = "blue";

    public Event(int id, String title, String start, String end, String color) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
        this.color = color;
    }
}
