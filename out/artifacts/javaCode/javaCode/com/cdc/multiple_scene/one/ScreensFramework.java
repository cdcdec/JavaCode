package com.cdc.multiple_scene.one;
/**
 * https://github.com/acaicedo/JFX-MultiScreen
 * @author Angie
 */
public class ScreensFramework{
    
    public static String screen1ID = "main";
    public static String screen1File = "/multiple_scene_one/Screen1.fxml";
    public static String screen2ID = "screen2";
    public static String screen2File = "/multiple_scene_one/Screen2.fxml";
    public static String screen3ID = "screen3";
    public static String screen3File = "/multiple_scene_one/Screen3.fxml";

    public ScreensController start() {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
        mainContainer.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
        mainContainer.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);
        mainContainer.setScreen(ScreensFramework.screen1ID);
       return mainContainer;
    }
}
