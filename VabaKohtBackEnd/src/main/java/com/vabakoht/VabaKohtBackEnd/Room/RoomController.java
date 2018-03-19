package com.vabakoht.VabaKohtBackEnd.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
public class RoomController {

    @Autowired // needs dependency injection
    private RoomService roomService;

    @RequestMapping("/rooms")
    public List<Room> getAllEvents() {
        return roomService.getAllRooms();
    }

    @RequestMapping("/rooms/{name}")
    public Optional<Room> getEvent(@PathVariable String name) {
        return roomService.getRoom(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rooms")
    public void addEvent(@RequestBody Room room) {
        roomService.addRoom(room);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rooms/{name}")
    public void updateEvent(@RequestBody Room room, @PathVariable String name) {
        roomService.updateRoom(name,room);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/rooms/{name}")
    public void deleteEvent(@PathVariable String name) {
        roomService.deleteRoom(name);
    }


}
