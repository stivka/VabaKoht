package com.vabakoht.VabaKohtBackEnd.Event;

import com.vabakoht.VabaKohtBackEnd.Room.Room;

import javax.persistence.*;

/**
 * Created by Vemka on 3/15/2018.
 */

@Entity // makes a table in database called event
public class Event {

    @Id //private key
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String title;
    private String start;
    private String end;
    @ManyToOne
    private Room room;

    public Event() {
    }

    public Event(String id, String title, String start, String end, String roomId) {
        super();
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
        this.room = new Room(roomId, "");
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Room getRoom() {
        return room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
