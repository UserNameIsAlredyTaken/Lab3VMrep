package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button check;
    @FXML
    private Label first;
    @FXML
    private Label second;
    @FXML
    private Label third;
    @FXML
    private Label forth;
    @FXML
    private Label fifth;
    @FXML
    private CheckBox graph1;
    @FXML
    private CheckBox graph2;
    @FXML
    private CheckBox graph3;
    @FXML
    private CheckBox graph4;
    @FXML
    private CheckBox graph5;
    @FXML
    private TextField y;
    @FXML
    private LineChart chart;
    @FXML
    public void doCheck(){
        first.setText(y.getText());
        second.setText(y.getText());
        third.setText(y.getText());
        forth.setText(y.getText());
        fifth.setText(y.getText());
    }
    public void drawGraphics(){

    }
}