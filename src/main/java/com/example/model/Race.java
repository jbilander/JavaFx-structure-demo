package com.example.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Race {

    private int id;
    private int heatNumber;
    private ObservableList<Participant> participants = FXCollections.observableArrayList();

    public Race(int id, int heatNumber) {
        this.id = id;
        this.heatNumber = heatNumber;
    }

    public int getHeatNumber() {
        return heatNumber;
    }

    public int getId() {
        return id;
    }

    public ObservableList<Participant> getParticipants() {
        return participants;
    }
}
