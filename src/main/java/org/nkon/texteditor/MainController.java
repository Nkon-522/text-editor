package org.nkon.texteditor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    @FXML
    private MenuBar menu;
    @FXML
    private MenuController menuController;

    @FXML
    private TextArea text;

    @FXML
    private TextController textController;

    public void setStage(Stage stage) {
        menuController.setStage(stage);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MenuTextControllerMediator.getInstance().registerMenuController(menuController);
        MenuTextControllerMediator.getInstance().registerTextController(textController);
    }
}
