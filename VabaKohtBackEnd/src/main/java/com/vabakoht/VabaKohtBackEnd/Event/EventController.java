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

    @RequestMapping("/rooms/{roomId}/events")
    public List<Event> getAllEvents(@PathVariable String roomId) {
        return eventService.getAllEvents(roomId);
    }

    @RequestMapping("/rooms/{roomId}/events/{id}")
    public Optional<Event> getEvent(@PathVariable String id) {
        return eventService.getEvent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rooms/{roomId}/events")
    public void addEvent(@RequestBody Event event, @PathVariable String roomId) {
        event.setRoom(new Room(roomId, ""));
        eventService.addEvent(event);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rooms/{roomId}/events/{id}")
    public void updateEvent(@RequestBody Event event, @PathVariable String id, @PathVariable String roomId) {
        event.setRoom(new Room(roomId, ""));
        eventService.updateEvent(event);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/rooms/{roomId}/events/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }
}