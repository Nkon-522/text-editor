package org.nkon.texteditor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Objects;
import java.util.stream.Collectors;

public class MenuController {

    @FXML
    private Menu fileMenu;
    private Stage stage;

    private final FileChooser fileChooser;

    String fileName = null;
    String filePath = null;


    @FXML
    private MenuItem wordWrap;

    @FXML
    private void onNewMenuItemClick() {
        MenuTextControllerMediator.getInstance().setTitleAndText(null, null);
        fileName = null;
        filePath = null;
    }

    @FXML
    private void onOpenMenuItemClick() {
        File file = fileChooser.showOpenDialog(null);
        if (file == null) { return; }

        fileName = file.getName();
        filePath = file.getAbsolutePath();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String title = fileName;
            String text = br.lines().collect(Collectors.joining(System.lineSeparator()));
            MenuTextControllerMediator.getInstance().setTitleAndText(title, text);

            br.close();
        } catch (Exception e) {
            System.out.println("Could not open file!");
        }
    }

    @FXML
    private void onSaveMenuItemClick() {
        if (fileName == null) {
            onSaveAsMenuItemClick();
            return;
        }

        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write(MenuTextControllerMediator.getInstance().getText());
            setTitle(fileName);

            fw.close();
        } catch (Exception e) {
            System.out.println("Could not save the file!");
        }
    }

    @FXML
    private void onSaveAsMenuItemClick() {
        File file = fileChooser.showSaveDialog(null);
        if (file == null) { return; }

        fileName = file.getName();
        filePath = file.getAbsolutePath();

        try {
            FileWriter fw = new FileWriter(filePath);

            setTitle(fileName);
            fw.write(MenuTextControllerMediator.getInstance().getText());

            fw.close();

        } catch (Exception e) {
            System.out.println("Could not save file!");
        }
    }

    @FXML
    private void onExitMenuItemClick() {
        Platform.exit();
    }

    @FXML
    private void onUndoItemClick() {
        MenuTextControllerMediator.getInstance().handleUndo();
    }

    @FXML
    private void onRedoItemClick() {
        MenuTextControllerMediator.getInstance().handleRedo();
    }

    @FXML
    private void onWordWrapClick() {
        MenuTextControllerMediator.getInstance().handleWordWrap();
    }

    @FXML
    private void onFontTypeClick(ActionEvent actionEvent) {
        MenuTextControllerMediator.getInstance().handleSetFont( ((MenuItem) actionEvent.getSource()).getText() );
    }

    @FXML
    private void onFontSizeClick(ActionEvent actionEvent) {
        MenuTextControllerMediator.getInstance().handleSetFontSize( Integer.parseInt ( ((MenuItem) actionEvent.getSource()).getText() ));
    }

    @FXML
    private void onColorClick(ActionEvent actionEvent) {
        MenuTextControllerMediator.getInstance().handleSetColor( ((MenuItem) actionEvent.getSource()).getText() );
    }

    public void updateWordWrap(boolean isWordWrapped){
        if (isWordWrapped) {
            wordWrap.setText("Word Wrap: On");
        } else {
            wordWrap.setText("Word Wrap: Off");
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setTitle(String s) {
        stage.setTitle(Objects.requireNonNullElse(s, "New"));
    }

    public void saveAs(){
        onSaveAsMenuItemClick();
    }

    public void save() {
        onSaveMenuItemClick();
    }

    public void openFileMenu() {
        fileMenu.show();
    }

    public MenuController () {
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(filter);
    }


}
