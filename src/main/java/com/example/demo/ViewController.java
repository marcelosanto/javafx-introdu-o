package com.example.demo;

import com.example.demo.gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ViewController {

    @FXML
    private Button btTest;

    @FXML
    private Label lbTest;

    @FXML
    public void onBtTestAction(){
        Alerts.showAlert("Alert Title", "Alert Header", "Hello", Alert.AlertType.INFORMATION);
    }

}
