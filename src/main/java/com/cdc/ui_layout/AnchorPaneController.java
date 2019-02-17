package com.cdc.ui_layout;

import com.cdc.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnchorPaneController implements Initializable {
    @FXML
    private Label label;

    @FXML
    private VBox pnl_scroll;

    @FXML
    private void handleButtonAction(MouseEvent event) {
        refreshNodes();
    }

    @FXML
    protected void goToMain(ActionEvent event) throws IOException {
        Main.backMain(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        refreshNodes();
    }

    private void refreshNodes() {
        pnl_scroll.getChildren().clear();

        AnchorPane [] nodes = new AnchorPane[15];

        for(int i = 0; i<10; i++)
        {
            try {
                nodes[i] =  FXMLLoader.load(getClass().getResource("/ui_layout/AnchorPaneItem.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(AnchorPaneController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
