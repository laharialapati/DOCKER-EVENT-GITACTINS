package com.klef.dev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "event_table")
public class Event {

    @Id
    private int id;
    private String name;
    private String date;
    private String location;
    private String organizer;

    public Event() {}

    public Event(int id, String name, String date, String location, String organizer) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.organizer = organizer;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getOrganizer() { return organizer; }
    public void setOrganizer(String organizer) { this.organizer = organizer; }
}
