package com.example.view;

import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.VBox;

public interface IRaceView {
    VBox getView(double minWidth, DoubleProperty plwPrefWidth, DoubleProperty fixedCellSize);
}
