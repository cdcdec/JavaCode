package com.cdc.ui_controller;

import com.cdc.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListViewCon {
    private List<String> stringList     = new ArrayList<>(5);
    private         ObservableList      observableList = FXCollections.observableArrayList();

    public void setListView(){

        stringList.add("String 1");
        stringList.add("String 2");
        stringList.add("String 3");
        stringList.add("String 4");

        observableList.setAll(stringList);

        listView.setItems(observableList);

//        listView.setCellFactory(
//                new Callback<ListView<String>, ListCell<String>>() {
//                    @Override
//                    public ListCell<String> call(ListView<String> listView) {
//                        return new ListCell();
//                    }
//                });
    }

    @FXML
    protected void goToMain(ActionEvent event) throws IOException {
        Main.backMain(event);
    }

    @FXML
    void initialize() {
        setListView();
    }
    @FXML
    private ListView listView;

    public FlowPane getPane(){
        // 创建根节点
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
        rootNode.setAlignment(Pos.CENTER);
        // 创建控件
        Label response = new Label("请选择电脑类型");

        // 创建 ListView
        ObservableList<String> computerTypes = FXCollections.observableArrayList("Smartphone", "Tablet", "Notebook", "Desktop");
        ListView<String> lvComputers = new ListView<>(computerTypes);
        lvComputers.setPrefSize(700, 170);

        // ListView 事件处理
        MultipleSelectionModel<String> lvSelModel = lvComputers.getSelectionModel();
        lvSelModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                response.setText("Computer selected is " + newValue);
            }
        });

        // 添加控件到根结点
        rootNode.getChildren().addAll(lvComputers, response);

        return rootNode;
    }
}
