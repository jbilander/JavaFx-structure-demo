package com.example.view;

import com.example.model.Participant;
import com.example.model.Race;
import com.example.view.listview.ParticipantCell;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class RaceView implements IRaceView {

    private ListView<Participant> plw = new ListView<>();
    private VBox headerAndListViewVBox = new VBox();
    private Label header = new Label();

    public RaceView(Race race) {
        header.setText("Heat " + race.getHeatNumber());
        plw.setItems(race.getParticipants());
        plw.setCellFactory(param -> new ParticipantCell());
    }

    public VBox getView(double minWidth, DoubleProperty plwPrefWidth, DoubleProperty fixedCellSize) {

        plw.fixedCellSizeProperty().bind(fixedCellSize);
        plw.prefHeightProperty().bind(plw.fixedCellSizeProperty().multiply(plw.getItems().size()).add(3)); //add 3 px to remove scrollbar
        plw.prefWidthProperty().bind(plwPrefWidth);
        plw.setMinWidth(minWidth);

        header.setMinWidth(minWidth);
        header.prefHeightProperty().bind(plw.fixedCellSizeProperty());
        header.prefWidthProperty().bind(plw.prefWidthProperty());

        headerAndListViewVBox.setMinWidth(minWidth);
        headerAndListViewVBox.prefHeightProperty().bind(plw.prefHeightProperty().add(plw.fixedCellSizeProperty()));
        headerAndListViewVBox.prefWidthProperty().bind(plw.prefWidthProperty());
        headerAndListViewVBox.getChildren().addAll(header, plw);

        return headerAndListViewVBox;
    }
}
