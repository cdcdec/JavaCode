package com.cdc.ui_layout;

import com.cdc.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class HBoxController {
    @FXML
    protected void goToMain(ActionEvent event) throws IOException {
        Main.backMain(event);
    }
}
