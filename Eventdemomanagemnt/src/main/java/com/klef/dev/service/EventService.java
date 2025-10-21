package com.klef.dev.service;

import java.util.List;
import com.klef.dev.entity.Event;

public interface EventService {
    Event addEvent(Event event);
    List<Event> getAllEvents();
    Event getEventById(int id);
    Event updateEvent(Event event);
    void deleteEvent(int id);
}
