package com.vabakoht.VabaKohtBackEnd.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Vemka on 3/16/2018.
 */

@Service //spring business service
public class EventService {

    @Autowired
    private EventRepository eventRepository;


    public List<Event> getAllEvents(String roomId) {
        List<Event> events = new ArrayList<>();
        eventRepository.findByRoomId(roomId)
                .forEach(events::add);
        return events;
    }

    //optional Maybe breakpoint
    public Optional<Event> getEvent(String id) {
       // return events.stream().filter(e -> e.getId().equals(name)).findFirst().get();
        return eventRepository.findById(id);

    }

    public void addEvent(Event event) {
        eventRepository.save(event);
    }


    public void updateEvent(Event event) {
       /* for(int i =0; i < events.size(); i++) {
            Room e = events.get(i);
            if(e.getId().equals(name)){
                events.set(i, event);
                return;
            }
        }*/

        eventRepository.save(event);
    }

    public void deleteEvent(String id) {
        //events.removeIf(e -> e.getId().equals(name));
        eventRepository.deleteById(id);
    }
}
