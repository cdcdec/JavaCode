package com.cdc.ui_layout;
import com.cdc.Main;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import java.io.IOException;
public class GridPaneUi{
    @FXML
    protected void gtoToMain(ActionEvent event) throws IOException {
        Main.backMain(event);
    }
    public GridPane getGridPane( ){
        //GridPaneUi with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Username:");
        grid.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField("Bucky");
        grid.setConstraints(nameInput, 1, 0);

        //Password Label
        Label passLabel = new Label("Password:");
        grid.setConstraints(passLabel, 0, 1);

        //Password Input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        grid.setConstraints(passInput, 1, 1);

        //Login
        Button loginButton = new Button("Log In");
        grid.setConstraints(loginButton, 1, 2);

        //Add everything to grid
        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
        return grid;
    }

}
