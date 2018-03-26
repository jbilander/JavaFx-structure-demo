package com.example.mediator;

import com.example.command.RaceCardCommand;
import com.example.command.RaceCardIdsCommand;
import com.example.model.RaceCard;
import com.example.view.IRaceCardView;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import java.util.List;

public class RaceCardMediator implements IRaceCardMediator {

    private final RaceCardIdsCommand raceCardIdsCommand = new RaceCardIdsCommand();
    private final RaceCardCommand raceCardCommand = new RaceCardCommand();
    private final IRaceCardView raceCardView;

    public RaceCardMediator(IRaceCardView raceCardView) {
        this.raceCardView = raceCardView;
    }

    @Override
    public void fetchRaceCardIds() {
        raceCardIdsCommand.reset();
        raceCardIdsCommand.setOnSucceeded(new FetchRaceCardIdsSucceedHandler());
        raceCardIdsCommand.start();
    }

    @Override
    public void fetchRaceCard(int raceCardId) {
        raceCardCommand.reset();
        raceCardCommand.setRaceCardId(raceCardId);
        raceCardCommand.setOnSucceeded(new LoadRaceCardSucceedHandler());
        raceCardCommand.start();
    }

    private class LoadRaceCardSucceedHandler implements EventHandler<WorkerStateEvent> {

        @Override
        public void handle(WorkerStateEvent event) {
            raceCardView.showRaceCard((RaceCard) event.getSource().getValue());
        }
    }

    private class FetchRaceCardIdsSucceedHandler implements EventHandler<WorkerStateEvent> {
        @Override
        public void handle(WorkerStateEvent event) {
            raceCardView.showRaceCardButtons((List<Integer>) event.getSource().getValue());
        }
    }
}
