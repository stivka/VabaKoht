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
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @RequestMapping("/rooms/{id}")
    public Optional<Room> getRoom(@PathVariable String id) {
        return roomService.getRoom(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rooms")
    public void addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rooms/{name}")
    public void updateRoom(@RequestBody Room room, @PathVariable String name) {
        roomService.updateRoom(name,room);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/rooms/{name}")
    public void deleteRoom(@PathVariable String name) {
        roomService.deleteRoom(name);
    }


}
