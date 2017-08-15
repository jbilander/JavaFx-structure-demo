package com.example.view;

import com.example.model.RaceCard;
import javafx.scene.layout.Pane;

import java.util.List;

public interface IRaceCardView {
    Pane getView();
    void showRaceCardButtons(List<Integer> ids);
    void showRaceCard(RaceCard raceCard);
}
