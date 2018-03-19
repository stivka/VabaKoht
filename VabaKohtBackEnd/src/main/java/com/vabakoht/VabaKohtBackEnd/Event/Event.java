package com.vabakoht.VabaKohtBackEnd.Event;

import com.vabakoht.VabaKohtBackEnd.Room.Room;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

/**
 * Created by Vemka on 3/15/2018.
 */

@Entity // makes a table in database called event
public class Event {

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

    public void setRoom(Room room) {
        this.room = room;
    }

    public Event() {}

    public Event(Integer id, String name, String start, String ending, String roomId) {

        this.name = name;
        this.start = start;
        this.ending = ending;
        this.room = new Room(roomId, "","");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id //private key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String start;
    private String ending;

    @ManyToOne
    private Room room;

}
