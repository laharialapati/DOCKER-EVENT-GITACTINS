package com.klef.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.klef.dev.entity.Event;
import com.klef.dev.service.EventService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eventapi")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Event Management System - Full Stack Deployment");
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEvent(@RequestBody Event event) {
        try {
            Event savedEvent = eventService.addEvent(event);
            return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding event: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getEventById(@PathVariable int id) {
        Event event = eventService.getEventById(id);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Event with ID " + id + " not found.");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEvent(@RequestBody Event event) {
        Event existing = eventService.getEventById(event.getId());
        if (existing != null) {
            Event updatedEvent = eventService.updateEvent(event);
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Cannot update. Event with ID " + event.getId() + " not found.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable int id) {
        Event existing = eventService.getEventById(id);
        if (existing != null) {
            eventService.deleteEvent(id);
            return ResponseEntity.ok("Event with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Cannot delete. Event with ID " + id + " not found.");
        }
    }
}
