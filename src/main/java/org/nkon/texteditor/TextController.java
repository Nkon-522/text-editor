package org.nkon.texteditor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class TextController implements Initializable {

    @FXML
    private TextArea textArea;

    private String fontType = "Arial";
    private int fontSize = 12;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.setFont(Font.font(this.fontType, this.fontSize));
        textArea.setStyle("-fx-focus-color: -fx-control-inner-background ; -fx-faint-focus-color: -fx-control-inner-background ;");
    }

    public void setTextArea(String s) {
        if (s == null) {
            textArea.clear();
        } else {
            textArea.setText(s);
        }
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
}