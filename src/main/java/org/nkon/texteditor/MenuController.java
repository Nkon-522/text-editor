package org.nkon.texteditor;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuController {
    private Stage stage;

    @FXML
    private MenuItem newMenuItem;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    private MenuItem saveMenuItem;

    @FXML
    private MenuItem saveAsMenuItem;

    @FXML
    private MenuItem exitMenuItem;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void onNewMenuItemClick() {
        ((Stage) newMenuItem.getParentPopup().getOwnerWindow()).setTitle("New");
        this.stage.setTitle("New");
    }


}
