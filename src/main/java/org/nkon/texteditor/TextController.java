package org.nkon.texteditor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class TextController implements Initializable {

    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.setStyle("-fx-focus-color: -fx-control-inner-background ; -fx-faint-focus-color: -fx-control-inner-background ;");
    }

    public void setTextArea(String s) {
        if (s == null) {
            textArea.clear();
        } else {
            textArea.setText(s);
        }
    }

    public String getText() {
        return textArea.getText();
    }
}