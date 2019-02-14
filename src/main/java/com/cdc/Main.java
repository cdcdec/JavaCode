package com.cdc;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

    public static int sceneWidth;
    public static int sceneHeight;

    @Override
    public void init() throws Exception {
        super.init();
        if (screenWidth <= 800 && screenHeight <= 600) {
            sceneWidth = 600;
            sceneHeight = 350;
        } else if (screenWidth <= 1280 && screenHeight <= 768) {
            sceneWidth = 800;
            sceneHeight = 450;
        } else if (screenWidth <= 1920 && screenHeight <= 1080) {
            sceneWidth = 1000;
            sceneHeight = 650;
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Responsive Design
        int sceneWidth = 0;
        int sceneHeight = 0;
        if (screenWidth <= 800 && screenHeight <= 600) {
            sceneWidth = 600;
            sceneHeight = 350;
        } else if (screenWidth <= 1280 && screenHeight <= 768) {
            sceneWidth = 800;
            sceneHeight = 450;
        } else if (screenWidth <= 1920 && screenHeight <= 1080) {
            sceneWidth = 1000;
            sceneHeight = 650;
        }
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("/Main.fxml").openStream());
        MainController mainController =fxmlLoader.getController();
        root.setStyle("-fx-background-color:rgb(186,153,122,0.7);");
        Scene scene = new Scene(root,sceneWidth, sceneHeight);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);//窗体缩放（默认为true）
        primaryStage.show();

    }

    public static void backMain(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(Main.class.getResource("/Main.fxml"));
        Scene mainScene = new Scene(mainParent, Main.sceneWidth,Main.sceneHeight);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainParent.setStyle("-fx-background-color:rgb(186,153,122,0.7);");
        window.setTitle("Main");
        window.setScene(mainScene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
