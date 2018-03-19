package com.vabakoht.VabaKohtBackEnd.Event;

import com.vabakoht.VabaKohtBackEnd.Room.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
public class EventController {

    @Autowired // needs dependency injection
    private EventService eventService;

    @RequestMapping("/rooms/{id}/events")
    public List<Event> getAllEvents(@PathVariable String id) {
        return eventService.getAllEvents(id);
    }

    @RequestMapping("/rooms/{id}/events/{name}")
    public Optional<Event> getEvent(@PathVariable String name) {
        return eventService.getEvent(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rooms/{id}/events/")
    public void addEvent(@RequestBody Event event, @PathVariable String id) {
        event.setRoom(new Room(id,"",""));
        eventService.addEvent(event);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rooms/{id}/events/{name}")
    public void updateEvent(@RequestBody Event event, @PathVariable String name, @PathVariable String id) {
        event.setRoom(new Room(id,"",""));
        eventService.updateEvent(event);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/rooms/{id}/events/{name}")
    public void deleteEvent(@PathVariable String name) {
        eventService.deleteEvent(name);
    }


}