package com.example.view;

import com.example.mediator.RaceCardMediator;
import com.example.model.Race;
import com.example.model.RaceCard;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class RaceCardView implements IRaceCardView {

    private RaceCardMediator raceCardMediator = new RaceCardMediator(this);
    private RaceCardButtonClickHandler raceCardButtonClickHandler = new RaceCardButtonClickHandler();
    private Pane pane = new Pane();
    private VBox mainVBox = new VBox();
    private HBox buttonsHBox = new HBox();
    private Label eventLabel = new Label();
    private HBox racesHBox = new HBox();
    private final double spacing = 5;
    private final double fixedCellMinHeight = 25;
    private final double plwMinWidth = 205; //Min width for participant listview
    private DoubleProperty fixedCellHeight = new SimpleDoubleProperty(fixedCellMinHeight);
    private DoubleProperty plwPrefWidth = new SimpleDoubleProperty(plwMinWidth);

    public RaceCardView() {

        mainVBox.setLayoutX(spacing);
        mainVBox.setLayoutY(spacing);
        mainVBox.setSpacing(spacing);
        buttonsHBox.setSpacing(spacing);
        racesHBox.setSpacing(spacing);

        mainVBox.getChildren().addAll(buttonsHBox, eventLabel, racesHBox);
        pane.getChildren().add(mainVBox);

        pane.heightProperty().addListener((observable, oldValue, newValue) -> {
            double value = (double) newValue / 16;
            if (value >= fixedCellMinHeight) {
                fixedCellHeight.set(value);
            }
        });

        pane.widthProperty().addListener((observable, oldValue, newValue) -> {
            double value = (double) newValue / 4;
            if (value >= plwMinWidth) {
                plwPrefWidth.set(value);
            }
        });

    }

    public Pane getView() {

        raceCardMediator.fetchRaceCardIds();

        return pane;
    }

    @Override
    public void showRaceCardButtons(List<Integer> ids) {

        int counter = 1;

        for (int id : ids) {

            Button raceCardButton = new Button();
            raceCardButton.setMinHeight(25);
            raceCardButton.setMinWidth(90);
            raceCardButton.prefHeightProperty().bind(pane.heightProperty().divide(20));
            raceCardButton.prefWidthProperty().bind(pane.widthProperty().divide(8));
            raceCardButton.setUserData(id);
            raceCardButton.setText("RaceCard " + counter++);
            raceCardButton.setOnMouseClicked(raceCardButtonClickHandler);
            buttonsHBox.getChildren().add(raceCardButton);
        }
    }

    @Override
    public void showRaceCard(RaceCard raceCard) {

        racesHBox.getChildren().clear();

        for (Race race : raceCard.getRaces()) {

            RaceView raceView = new RaceView(race);
            VBox vbox = raceView.getView(plwMinWidth, plwPrefWidth, fixedCellHeight);
            racesHBox.getChildren().add(vbox);
        }

        eventLabel.setText(raceCard.getEventDesc());
        eventLabel.prefHeightProperty().bind(fixedCellHeight);
        eventLabel.prefWidthProperty().bind(plwPrefWidth.multiply(raceCard.getRaces().size()).add(spacing * (raceCard.getRaces().size() - 1)));
    }

    private class RaceCardButtonClickHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            int raceCardId = (int) ((Button) event.getSource()).getUserData();
            raceCardMediator.fetchRaceCard(raceCardId);
        }
    }
}
