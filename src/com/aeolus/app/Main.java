package com.aeolus.app;

import com.aeolus.view.MainMenuView;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        MainMenuView mainMenuView = new MainMenuView();
        if (mainMenuView.isInputSuccess()) {
            System.out.println("input: " + mainMenuView.getSearchText());
        }
    }
}
