package com.vabakoht.VabaKohtBackEnd.Room;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class RoomControllerTest {

    @Test
    public void getAllRooms() {
        RoomService roomService = Mockito.mock(RoomService.class);
        List room = Mockito.mock(List.class);
        Mockito.when(roomService.getAllRooms()).thenReturn(room);
        List result = roomService.getAllRooms();
        assertEquals(room, result);
    }

    @Test
    public void getRoom() {
        RoomService roomService = Mockito.mock(RoomService.class);
        Optional room = Optional.empty();
        Mockito.when(roomService.getRoom("1")).thenReturn(room);
        Optional result = roomService.getRoom("1");
        assertEquals(room, result);
    }

    @Test
    public void addRoom() {
        RoomService roomService = Mockito.mock(RoomService.class);
        Room room = new Room();
        Mockito.doNothing().when(roomService).addRoom(Mockito.any());
        roomService.addRoom(room);
        Mockito.verify(roomService, Mockito.atLeastOnce()).addRoom(Mockito.any());
    }

    @Test
    public void updateRoom() {
        RoomService roomService = Mockito.mock(RoomService.class);
        Room room = new Room();
        Mockito.doNothing().when(roomService).updateRoom("1",room);
        roomService.updateRoom("1", room);
        Mockito.verify(roomService, Mockito.atLeastOnce()).updateRoom("1", room);
    }

    @Test
    public void deleteRoom() {
        RoomService roomService = Mockito.mock(RoomService.class);
        Mockito.doNothing().when(roomService).deleteRoom("1");
        roomService.deleteRoom("1");
        Mockito.verify(roomService, Mockito.atLeastOnce()).deleteRoom("1");
    }
}