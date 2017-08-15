package com.example.service;

import com.example.model.RaceCard;

import java.util.List;

public interface IRaceCardService {
    List<Integer> getRaceCardIds();
    RaceCard getRaceCard(int raceCardId);
}
