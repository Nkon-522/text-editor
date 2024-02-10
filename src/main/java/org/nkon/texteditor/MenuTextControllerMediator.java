package org.nkon.texteditor;

public class MenuTextControllerMediator {
    boolean isWordWrapped = false;

    private MenuController menuController;
    private TextController textController;

    void registerMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    void registerTextController(TextController textController) {
        this.textController = textController;
    }

    public void setTitleAndText(String title, String text) {
        menuController.setTitle(title);
        textController.setTextArea(text);
    }

    public String getText() {
        return textController.getText();
    }

    public void handleWordWrap() {
        isWordWrapped = !isWordWrapped;
        menuController.updateWordWrap(isWordWrapped);
        textController.updateWordWrap(isWordWrapped);
    }

    public void handleSetFont(String fontType) {
        textController.setFontType(fontType);
    }

    public void handleSetFontSize(int fontSize) {
        textController.setFontSize(fontSize);
    }

    public void handleSetColor(String color) {
        textController.setColor(color);
    }

    public void handleUndo() {
        textController.undo();
    }

    public void handleRedo() {
        textController.redo();
    }

    public void handleSaveAs() {
        menuController.saveAs();
    }

    public void handleSave() {
        menuController.save();
    }

    public void handleOpenFileMenu() {
        menuController.openFileMenu();
    }

    private MenuTextControllerMediator() {}

    public static MenuTextControllerMediator getInstance() {
        return MenuTextControllerMediatorHolder.instance;
    }




    private static class MenuTextControllerMediatorHolder {
        private static final MenuTextControllerMediator instance = new MenuTextControllerMediator();
    }
}
