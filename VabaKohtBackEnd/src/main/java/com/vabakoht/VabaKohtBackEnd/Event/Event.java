package com.vabakoht.VabaKohtBackEnd.Event;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vabakoht.VabaKohtBackEnd.Room.Room;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnding() {
        return ending;
    }

    public void setEnding(Date ending) {
        this.ending = ending;
    }

    public String getRoom() {
        return roomId;
    }

    public void setRoom(String roomId) {
        this.roomId = roomId;
    }

    public Event() {
    }

    public Event(String name, Date start, Date ending, String roomId) {

        this.name = name;
        this.start = start;
        this.ending = ending;
        this.roomId = roomId;
    }

    public Integer getId() {
        return id;
    }


    @Id //private key
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date ending;
    private String roomId;

}
