package org.nkon.texteditor;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;
import java.util.stream.Collectors;

public class MenuController {
    private Stage stage;

    private FileChooser fileChooser;

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

    @FXML
    private void onNewMenuItemClick() {
        MenuTextControllerMediator.getInstance().setTitleAndText(null, null);
    }

    @FXML
    private void onOpenMenuItemClick() {
        File file = fileChooser.showOpenDialog(null);
        if (file == null) { return; }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));

            String title = file.getName();
            String text = br.lines().collect(Collectors.joining(System.lineSeparator()));
            MenuTextControllerMediator.getInstance().setTitleAndText(title, text);

            br.close();
        } catch (Exception e) {
            System.out.println("Could not open file!");
        }

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setTitle(String s) {
        stage.setTitle(Objects.requireNonNullElse(s, "New"));
    }

    public MenuController () {
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(filter);
    }

}
