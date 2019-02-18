package com.cdc;
import com.cdc.multiple_scene.one.ScreensFramework;
import com.cdc.read_text.ReadTextMain;
import com.cdc.ui_layout.GridPaneUi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    protected  void goToMultipleSceneTwo(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/multiple_scene_two/FXMLDocument.fxml"));
        Scene tableViewScene = new Scene(tableViewParent, Main.sceneWidth,Main.sceneHeight);
        //This line gets the Stage information
        Stage window = (Stage)mainRoot.getScene().getWindow();
        window.setTitle("multiple_scene_two");
        window.setScene(tableViewScene);
        window.show();
    }
    @FXML
    protected  void goToLayoutHBox(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/ui_layout/HBox.fxml"));
        Scene tableViewScene = new Scene(tableViewParent, Main.sceneWidth,Main.sceneHeight);
        //This line gets the Stage information
        Stage window = (Stage)mainRoot.getScene().getWindow();
        window.setTitle("HBox");
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    protected  void goToReadText(ActionEvent event) throws IOException {
        //This line gets the Stage information
        Stage window = (Stage)mainRoot.getScene().getWindow();
        window.setTitle("Read Text");
        window.setScene(new ReadTextMain().getReadTextScene());
        window.show();
    }

    @FXML
    protected  void goToLayoutAnchorPane(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/ui_layout/AnchorPane.fxml"));
        Scene scene = new Scene(parent, Main.sceneWidth,Main.sceneHeight);
        Stage window = (Stage)mainRoot.getScene().getWindow();
        window.setTitle("AnchorPane");
        window.setScene(scene);
        window.show();
    }





    @FXML
    protected  void goToMultipleSceneOne(ActionEvent event) throws IOException {
        Group root = new Group();
        root.getChildren().addAll(new ScreensFramework().start());
        Scene rootScene = new Scene(root, Main.sceneWidth,Main.sceneHeight);
        //This line gets the Stage information
        Stage window = (Stage)mainRoot.getScene().getWindow();
        window.setTitle("multiple_scene_one");
        window.setScene(rootScene);
        window.show();
    }

    @FXML
    protected  void goToLayoutGridPane(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/ui_layout/GridPane.fxml"));
        Scene rootScene = new Scene(parent, Main.sceneWidth,Main.sceneHeight);
        //This line gets the Stage information
        Stage window = (Stage)mainRoot.getScene().getWindow();
        window.setTitle("GridPane");
        window.setScene(rootScene);
        window.show();
    }




    @FXML
    private MenuBar menuBar;
    @FXML
    private BorderPane mainRoot;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuBar.prefWidthProperty().bind(mainRoot.widthProperty());
    }


}
