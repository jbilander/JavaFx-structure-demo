package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class RaceCard {

    private int id;
    private int sortOrder;
    private String eventDesc;
    private List<Race> races = new ArrayList<>();

    public RaceCard(int id, int sortOrder, String eventDesc) {
        this.id = id;
        this.sortOrder = sortOrder;
        this.eventDesc = eventDesc;
    }

    public int getId() {
        return id;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public List<Race> getRaces() {
        return races;
    }
}
