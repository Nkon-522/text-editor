package org.nkon.texteditor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class TextController implements Initializable {

    @FXML
    private TextArea textArea;

    private String fontType = "Arial";
    private int fontSize = 12;

    final KeyCombination keyCombCtrS = new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN);
    final KeyCombination keyCombAltF = new KeyCodeCombination(KeyCode.F, KeyCombination.ALT_DOWN);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textArea.setFont(Font.font(this.fontType, this.fontSize));
        textArea.setStyle("-fx-focus-color: -fx-control-inner-background ; -fx-faint-focus-color: -fx-control-inner-background ;");
        textArea.setOnKeyPressed(keyEvent -> {
            if (keyEvent.isShiftDown() && keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.S) {
                MenuTextControllerMediator.getInstance().handleSaveAs();
            } else if ( keyCombCtrS.match(keyEvent)) {
                MenuTextControllerMediator.getInstance().handleSave();
            } else if ( keyCombAltF.match(keyEvent)) {
                MenuTextControllerMediator.getInstance().handleOpenFileMenu();
            }
        });
    }

    public void setTextArea(String s) {
        if (s == null) {
            textArea.clear();
        } else {
            textArea.setText(s);
        }
    }

    public void undo() {
        textArea.undo();
    }

    public void redo() {
        textArea.redo();
    }

    public void updateWordWrap(boolean isWordWrapped) {
        textArea.setWrapText(isWordWrapped);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setFontType(String fontType) {
        this.fontType = fontType;
        textArea.setFont(Font.font(this.fontType, this.fontSize));
    }


    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
        textArea.setFont(Font.font(this.fontType, this.fontSize));
    }

    public void setColor(String color) {
        switch (color) {
            case "White" -> {
                textArea.lookup(".content").setStyle("-fx-background-color: white;");
                textArea.setStyle(
                        "-fx-control-inner-background: white;"+
                                "-fx-background-color: white;"+
                                "-fx-text-fill: black"
                );
            }
            case "Black" -> {
                textArea.lookup(".content").setStyle("-fx-background-color: black;");
                textArea.setStyle(
                        "-fx-control-inner-background: black;" +
                                "-fx-background-color: black;" +
                                "-fx-text-fill: white"
                );
            }
            case "Blue" -> {
                textArea.lookup(".content").setStyle("-fx-background-color: blue;");
                textArea.setStyle(
                        "-fx-control-inner-background: blue;" +
                                "-fx-background-color: blue;" +
                                "-fx-text-fill: red"
                );
            }
        }
    }
}