package com.example.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Race {

    private int heatNumber;
    private ObservableList<Participant> participants = FXCollections.observableArrayList();

    public Race(int heatNumber) {
        this.heatNumber = heatNumber;
    }

    public int getHeatNumber() {
        return heatNumber;
    }

    public ObservableList<Participant> getParticipants() {
        return participants;
    }
}
