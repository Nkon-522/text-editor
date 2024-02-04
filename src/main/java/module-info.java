module org.nkon.texteditor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.nkon.texteditor to javafx.fxml;
    exports org.nkon.texteditor;
}