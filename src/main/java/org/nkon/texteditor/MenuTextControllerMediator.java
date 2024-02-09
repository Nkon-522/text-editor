package org.nkon.texteditor;

public class MenuTextControllerMediator {
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

    private MenuTextControllerMediator() {}

    public static MenuTextControllerMediator getInstance() {
        return MenuTextControllerMediatorHolder.instance;
    }

    private static class MenuTextControllerMediatorHolder {
        private static final MenuTextControllerMediator instance = new MenuTextControllerMediator();
    }
}
