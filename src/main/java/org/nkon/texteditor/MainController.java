package org.nkon.texteditor;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private MenuBar menu;
    @FXML
    private MenuController menuController;

    public void setStage(Stage stage) {
        menuController.setStage(stage);
    }
}
