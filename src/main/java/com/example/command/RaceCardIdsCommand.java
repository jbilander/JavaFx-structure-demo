package com.example.command;

import com.example.service.IRaceCardService;
import com.example.service.RaceCardService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

public class RaceCardIdsCommand extends Service<List<Integer>> {

    private IRaceCardService raceCardService = RaceCardService.getInstance();

    @Override
    protected Task<List<Integer>> createTask() {
        return new Task<>() {
            @Override
            protected List<Integer> call() throws Exception {
                return raceCardService.getRaceCardIds();
            }
        };
    }
}
