package com.vabakoht.VabaKohtBackEnd.Event;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Vemka on 3/18/2018.
 */
public interface EventRepository extends CrudRepository<Event,String>{

    /*public List<Event> findByStart(String start);
    public List<Event> findByEnding(String ending);*/
    /*public List<Event> findByRoomId(String roomId);*/
    public Optional<Event> findByName(String name);
}
