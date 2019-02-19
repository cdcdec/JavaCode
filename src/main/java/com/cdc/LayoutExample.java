package com.cdc;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class LayoutExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        int numRows = 4 ;
        for (int i = 0 ; i < numRows ; i++) {
            RowConstraints rc = new RowConstraints();
            rc.setPercentHeight(100.0/numRows);
            rc.setValignment(VPos.BOTTOM);
            root.getRowConstraints().add(rc);
        }
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHalignment(HPos.CENTER);
        cc.setPercentWidth(100);
        root.getColumnConstraints().add(cc);

        for (int row = 0; row < 3 ; row++) {
            Label label = new Label("Label "+(row+1));
            label.setStyle("-fx-background-color: #9AFF9A;");
            root.add(label, 0, row);
        }

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
