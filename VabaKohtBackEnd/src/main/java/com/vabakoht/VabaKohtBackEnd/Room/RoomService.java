package com.vabakoht.VabaKohtBackEnd.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Vemka on 3/16/2018.
 */

@Service //spring business service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    public Optional<Room> getRoom(String id) {
        // return rooms.stream().filter(e -> e.getId().equals(name)).findFirst().get();
        return roomRepository.findById(id);

    }

    public void addRoom(Room room) {
        roomRepository.save(room);
    }


    public void updateRoom(String id, Room room) {
       /* for(int i =0; i < rooms.size(); i++) {
            Room e = rooms.get(i);
            if(e.getId().equals(name)){
                rooms.set(i, room);
                return;
            }
        }*/

        roomRepository.save(room);
    }

    public void deleteRoom(String name) {
        //rooms.removeIf(e -> e.getId().equals(name));
        roomRepository.deleteById(name);
    }
}
