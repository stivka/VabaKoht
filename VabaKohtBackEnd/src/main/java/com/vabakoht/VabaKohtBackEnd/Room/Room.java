package com.vabakoht.VabaKohtBackEnd.Room;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Vemka on 3/15/2018.
 */

@Entity // makes a table in database called event
public class Room {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Room() {}

    public Room(String id, String roomName, String companyName) {

        this.id = id;
        this.roomName = roomName;
        this.companyName = companyName;
    }

    @Id //private key
    private String id;
    private String roomName;
    private String companyName;


}
