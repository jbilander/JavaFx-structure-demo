package com.example;

import com.example.common.Util;
import com.example.view.RootView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        RootView rootView = new RootView();
        Pane root = rootView.getView();
        Scene scene = new Scene(root, Util.APP_WIDTH, Util.APP_HEIGHT);
        scene.getStylesheets().add(getClass().getResource(Util.FILE_SEPARATOR + "app.css").toExternalForm());
        stage.setTitle(Util.TITLE);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
