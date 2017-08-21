package com.example;

import com.example.common.Util;
import com.example.view.RootView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        if (!(Util.isWindows() || Util.isMac())) { //Load Arial font for all *nix platforms
            Font.loadFont(getClass().getResource(Util.FILE_SEPARATOR + "Arial.ttf").toExternalForm(), 12);
        }

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
