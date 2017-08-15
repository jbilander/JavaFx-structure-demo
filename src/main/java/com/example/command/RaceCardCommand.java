package com.example.command;

import com.example.model.RaceCard;
import com.example.service.IRaceCardService;
import com.example.service.RaceCardServiceStub;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class RaceCardCommand extends Service<RaceCard> {

    private int raceCardId;
    private IRaceCardService raceCardService = RaceCardServiceStub.getInstance();

    public void setRaceCardId(int raceCardId) {
        this.raceCardId = raceCardId;
    }

    @Override
    protected Task<RaceCard> createTask() {
        return new Task<>() {
            @Override
            protected RaceCard call() throws Exception {
                return raceCardService.getRaceCard(raceCardId);
            }
        };
    }
}
