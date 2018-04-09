package com.vabakoht.VabaKohtBackEnd.Event;

import com.vabakoht.VabaKohtBackEnd.Room.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;



@RestController
public class EventController {

   // @Autowired // needs dependency injection
   @Resource(name = "eventService")
    private EventService eventService;

    @RequestMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @RequestMapping("/events/{name}")
    public Optional<Event> getEvent(@PathVariable String name) {
        return eventService.getEvent(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/events")
    public void addEvent(@RequestBody Event event) {
       // event.setRoom(new Room(id,"",""));
        eventService.addEvent(event);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/events/{name}")
    public void updateEvent(@RequestBody Event event, @PathVariable String name) {
        //event.setRoom(new Room(id,"",""));
        eventService.updateEvent(event);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/events/{name}")
    public void deleteEvent(@PathVariable String name) {
        eventService.deleteEvent(name);
    }


}