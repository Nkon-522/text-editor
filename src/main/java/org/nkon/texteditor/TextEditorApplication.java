package org.nkon.texteditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TextEditorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TextEditorApplication.class.getResource("main-view.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent, 800, 600);
        stage.setTitle("Text-Editor");
        stage.setScene(scene);

        MainController mainController = fxmlLoader.getController();
        mainController.setStage(stage);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}