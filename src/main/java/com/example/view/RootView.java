package com.example.view;

import com.example.mediator.RootMediator;
import javafx.scene.layout.Pane;

public class RootView {

    private RootMediator rootMediator = new RootMediator();
    RaceCardView raceCardView = new RaceCardView();

    public RootView() {
        rootMediator.initDb();
    }

    public Pane getView() {
        return raceCardView.getView();
    }
}
