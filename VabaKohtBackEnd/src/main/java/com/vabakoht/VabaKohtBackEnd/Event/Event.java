package com.vabakoht.VabaKohtBackEnd.Event;

import com.vabakoht.VabaKohtBackEnd.Room.Room;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

/**
 * Created by Vemka on 3/15/2018.
 */

@Entity // makes a table in database called event
public class Event {

    @Id //private key
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String start;
    private String ending;

    @ManyToOne
    private Room room;

    public Event() {
    }

    public Event(String id, String name, String start, String ending, String roomId) {
        super();
        this.id = id;
        this.name = name;
        this.start = start;
        this.ending = ending;
        this.room = new Room(roomId, "", "");
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnding() {
        return ending;
    }

    public void setEnding(String ending) {
        this.ending = ending;
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
