package com.vabakoht.VabaKohtBackEnd.Event;


import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class EventControllerTest {

    @Test
    public void getAllEvents() throws NullPointerException{
        EventService eventService = Mockito.mock(EventService.class);
        List event = Mockito.mock(List.class);
        Mockito.when(eventService.getAllEvents("12")).thenReturn(event);
        List result = eventService.getAllEvents("12");
        assertEquals(event, result);

    }

    @Test
    public void getEvent() {
        EventService eventService = Mockito.mock(EventService.class);
        Optional event = Mockito.mock(Optional.class);
        Mockito.when(eventService.getEvent("13")).thenReturn(event);
        Optional result = eventService.getEvent("13");
        assertEquals(event, result);
    }

    @Test
    public void addEvent() throws IOException {
        EventService eventService = Mockito.mock(EventService.class);
        Event event = new Event();
        Mockito.doThrow(new IOException()).when(eventService).addEvent(event);
        eventService.addEvent(event);
    }

    @Test
    public void updateEvent() {
    }

    @Test
    public void deleteEvent() {
    }

}