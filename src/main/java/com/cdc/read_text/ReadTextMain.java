package com.cdc.read_text;

import com.cdc.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ReadTextMain{
    FileListView fileList = new FileListView();
    TabPane tabPane = new TabPane();

    public void initFileList() throws URISyntaxException {

        fileList.setPrefWidth(200);

        // 左侧加载小仙女目录下的文件
        URL url=getClass().getResource("/note");
        File dir=new File(url.toURI());
        File[] files = dir.listFiles();
        for(File f : files) {
            FileItem fitem = new FileItem(f);

            // 添加到左侧列表中
            fileList.data().add(fitem);
        }

        // 列表是鼠标事件响应
        fileList.setOnMouseClicked((MouseEvent event)->{
            // 如果左键单击的话
            if(event.getClickCount() == 1 && event.getButton() == MouseButton.PRIMARY) {
                oneClicked();
            }
        });

    }


    // 单击处理
    public void oneClicked() {

        // 获取列表选中模块，获取索引
        int index = fileList.getSelectionModel().getSelectedIndex();
        FileItem fitem = fileList.data().get(index);

        try {
            openFile(fitem);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // 打开左侧文件
    public void openFile(FileItem fitem) throws Exception{

        // 查看选项卡是否打开
        Tab tab = findTab(fitem);

        if(tab != null) {

            // 设置为选中的选项卡
            // int pos = tabPane.getTabs().indexOf(tab);  // 获取id
            tabPane.getSelectionModel().select(tab);
            return;
        }

        // 打开一个新的选项卡并选中

        Node currentView = null;

        if(fitem.type == FileItem.TEXT) {
            // 文本文件处理
            String str = TextFileUtils.read(fitem.file, "UTF-8");
            TextArea t = new TextArea();
            t.setText(str);
            currentView = t;

        }else if(fitem.type == FileItem.IMAGE) {
            // 图片文件处理

            // 获取文件的本地路径
            Image image = new Image(fitem.file.toURI().toString());
            MyImagePane t = new MyImagePane();
            t.showImage(image);
            currentView = t;

        }else throw new Exception("不支持打开该格式");

        // 创建新的选项卡并选中
        tab = new Tab();
        tab.setText(fitem.firstName);
        tab.setContent(currentView);
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
    }


    // 查看在右侧选项卡是否打开
    public Tab findTab(FileItem fitem) {

        ObservableList<Tab> tabs = tabPane.getTabs();
        for(Tab tab : tabs) {
            if(tab.getText().equals(fitem.firstName)) {
                return tab;
            }
        }

        return null;

    }

    public Scene getReadTextScene(){
        try {
            // 加载左侧文件列表
            initFileList();
            BorderPane root = new BorderPane();
            root.setLeft(fileList);
            root.setCenter(tabPane);
            AnchorPane anchorPane=new AnchorPane();
            Button button=new Button();
            button.setText("返回Main");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        Main.backMain(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            anchorPane.getChildren().add(button);
            AnchorPane.setBottomAnchor(button, 10.0);
            AnchorPane.setTopAnchor(button, 10.0);
            AnchorPane.setRightAnchor(button, 10.0);
            root.setBottom(anchorPane);
            Scene scene = new Scene(root,Main.sceneWidth,Main.sceneHeight);
            return scene;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
