package com.example.view.listview;

import com.example.model.Participant;
import javafx.scene.control.ListCell;

public class ParticipantCell extends ListCell<Participant> {

    @Override
    protected void updateItem(Participant item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
        } else {
            setText(item.getLane() + " " + item.getFirstname() + " " + item.getLastname());
        }
    }
}
