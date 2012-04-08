package calendar;

/**
 * El objeto evento dentro del calendario javascript
 *
 * @author snidE
 */
public class Event {

    private String allDay = "";
    private String title = "Event2";
    private int id = 222;
    private String end = "2012-04-22";
    private String start = "2012-04-20";

    public Event(int id, String title, String start, String end) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
    }
}
