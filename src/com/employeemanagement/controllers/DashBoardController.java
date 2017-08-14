package com.employeemanagement.controllers;

import com.jfoenix.controls.JFXButton;
import com.test.ControlledScreen;
import com.test.ScreenController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gayashan on 8/13/2017.
 */
public class DashBoardController implements Initializable,ControlledScreen {

    ScreenController controller;


    @FXML
    private JFXButton dashBoardBtn;

    @FXML
    private JFXButton addEmployeeBtn;

    @Override
    public void setScreenParent(ScreenController screenParent) {
            controller = screenParent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void changeScene(MouseEvent event) {
        if(addEmployeeBtn == (JFXButton)event.getSource()){
            controller.loadScreen(MyScreens.ADDEMPLOYEE_SCREEN,MyScreens.ADDEMPLOYEE_SCREEN_FXML );
            controller.setScreen(MyScreens.ADDEMPLOYEE_SCREEN);
            controller.unloadScreen(MyScreens.DASHBOARD_SCREEN);
        }
    }
}
