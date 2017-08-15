package com.example.view;

import javafx.scene.layout.Pane;

public class RootView {

    RaceCardView raceCardView = new RaceCardView();

    public Pane getView() {
        return raceCardView.getView();
    }
}
