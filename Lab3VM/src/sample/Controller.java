package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import static java.lang.Math.*;

public class Controller {
    @FXML
    private Button draw;
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
    private RadioButton sqrt;
    @FXML
    private RadioButton cos;
    @FXML
    private RadioButton growingSin;
    @FXML
    private RadioButton sqr;
    @FXML
    private TextField input;

    Function func;
    @FXML public void drawCos(){
        func = (double x)->cos(x);
    }
    @FXML public void drawPow2(){
        func = (double x)->pow(x,2);
    }
    @FXML public void drawGrowingSin(){
        func = (double x)->x*sin(x);
    }
    @FXML public void drawSqrt(){
        func= (double x) -> sqrt(x);
    }
    @FXML
    private NumberAxis xAxis = new NumberAxis();
    @FXML
    private NumberAxis yAxis = new NumberAxis();
    @FXML
    private LineChart<Number, Number> chart = new LineChart<Number, Number>(xAxis,yAxis);
    @FXML
    public void doCheck(){
        if(cos.isSelected()){
            drawCos();
        }else if(sqr.isSelected()){
            drawPow2();
        }else if(growingSin.isSelected()){
            drawGrowingSin();
        }else if(sqrt.isSelected()){
            drawSqrt();
        }else{
            first.setText("Выберите функцию");
            second.setText("Выберите функцию");
            third.setText("Выберите функцию");
            forth.setText("Выберите функцию");
            fifth.setText("Выберите функцию");
            return;
        }
        Interpolate inter = new Interpolate();
        try{
            first.setText(Double.toString(func.calculate(Double.parseDouble(input.getText()))));
            double[] x = {0,PI/2,PI,PI*3/2,PI*2};
            double[] y = {func.calculate(x[0]),func.calculate(x[1]),func.calculate(x[2]),func.calculate(x[3]),func.calculate(x[4])};
            second.setText(Double.toString(inter.polinomValue(x.length-1,x,inter.computeCoef(x.length-1,x,y),Double.parseDouble(input.getText()))));
            double[] x1 = {0,PI/4,PI/2,PI*3/4,PI,PI*5/4,PI*3/2,PI*7/4,PI*2};
            double[] y1 = {func.calculate(x1[0]),func.calculate(x1[1]),func.calculate(x1[2]),func.calculate(x1[3]),func.calculate(x1[4]),func.calculate(x1[5]),func.calculate(x1[6]),func.calculate(x1[7]),func.calculate(x1[8])};
            third.setText(Double.toString(inter.polinomValue(x1.length-1,x1,inter.computeCoef(x1.length-1,x1,y1),Double.parseDouble(input.getText()))));
            y1[3]=0;
            forth.setText(Double.toString(inter.polinomValue(x1.length-1,x1,inter.computeCoef(x1.length-1,x1,y1),Double.parseDouble(input.getText()))));
            double[] x2 = {0,PI/2,PI,PI*3/2,PI*2,PI*5/2,PI*3,PI*7/2,PI*4};
            double[] y2 = {func.calculate(x2[0]),func.calculate(x2[1]),func.calculate(x2[2]),func.calculate(x2[3]),func.calculate(x2[4]),func.calculate(x2[5]),func.calculate(x2[6]),func.calculate(x2[7]),func.calculate(x2[8])};
            fifth.setText(Double.toString(inter.polinomValue(x2.length-1,x2,inter.computeCoef(x2.length-1,x2,y2),Double.parseDouble(input.getText()))));
        }catch(NumberFormatException e){
            first.setText("Только числа");
            second.setText("Только числа");
            third.setText("Только числа");
            forth.setText("Только числа");
            fifth.setText("Только числа");
        }
    }
    @FXML
    public void drawGraphics(){
        if(cos.isSelected()){
            drawCos();
        }else if(sqr.isSelected()){
            drawPow2();
        }else if(growingSin.isSelected()){
            drawGrowingSin();
        }else if(sqrt.isSelected()){
            drawSqrt();
        }else{
            first.setText("Выберите функцию");
            second.setText("Выберите функцию");
            third.setText("Выберите функцию");
            forth.setText("Выберите функцию");
            fifth.setText("Выберите функцию");
        }
        draw();
    }
    public void draw(){
        chart.getData().clear();
        XYChart.Series dots1 = new XYChart.Series();
        ObservableList<XYChart.Data> datasDots1 = FXCollections.observableArrayList();
        for(double i=0;i<PI*9/2;i+=PI/2){
            datasDots1.add(new XYChart.Data(i,func.calculate(i)));
        }
        dots1.setData(datasDots1);
        chart.getData().add(dots1);
        if(graph1.isSelected()){
            XYChart.Series series1 = new XYChart.Series();
            ObservableList<XYChart.Data> datas1 = FXCollections.observableArrayList();
            for(double i=0; i<14; i+=0.1){
                datas1.add(new XYChart.Data(i,func.calculate(i)));
            }
            series1.setData(datas1);
            chart.getData().add(series1);
        }
        if(graph2.isSelected()){
            XYChart.Series series2 = new XYChart.Series();
            ObservableList<XYChart.Data> datas2 = FXCollections.observableArrayList();
            double[] x = {0,PI/2,PI,PI*3/2,PI*2};
            double[] y = {func.calculate(x[0]),func.calculate(x[1]),func.calculate(x[2]),func.calculate(x[3]),func.calculate(x[4])};
            Interpolate inter = new Interpolate();
            for(double i=0; i<7; i+=0.1){
                datas2.add(new XYChart.Data(i,inter.polinomValue(x.length-1,x,inter.computeCoef(x.length-1,x,y),i)));
            }
            series2.setData(datas2);
            chart.getData().add(series2);
        }
        if(graph3.isSelected()){
            XYChart.Series series3 = new XYChart.Series();
            ObservableList<XYChart.Data> datas3 = FXCollections.observableArrayList();
            double[] x = {0,PI/4,PI/2,PI*3/4,PI,PI*5/4,PI*3/2,PI*7/4,PI*2};
            double[] y = {func.calculate(x[0]),func.calculate(x[1]),func.calculate(x[2]),func.calculate(x[3]),func.calculate(x[4]),func.calculate(x[5]),func.calculate(x[6]),func.calculate(x[7]),func.calculate(x[8])};
            Interpolate inter = new Interpolate();
            for(double i=0; i<7; i+=0.1){
                datas3.add(new XYChart.Data(i,inter.polinomValue(x.length-1,x,inter.computeCoef(x.length-1,x,y),i)));
            }
            series3.setData(datas3);
            chart.getData().add(series3);
        }
        if(graph4.isSelected()){
            XYChart.Series series4 = new XYChart.Series();
            ObservableList<XYChart.Data> datas4 = FXCollections.observableArrayList();
            double[] x = {0,PI/4,PI/2,PI*3/4,PI,PI*5/4,PI*3/2,PI*7/4,PI*2};
            double[] y = {func.calculate(x[0]),func.calculate(x[1]),func.calculate(x[2]),0,func.calculate(x[4]),func.calculate(x[5]),func.calculate(x[6]),func.calculate(x[7]),func.calculate(x[8])};
            Interpolate inter = new Interpolate();
            for(double i=0; i<6; i+=0.1){
                datas4.add(new XYChart.Data(i,inter.polinomValue(x.length-1,x,inter.computeCoef(x.length-1,x,y),i)));
            }
            series4.setData(datas4);
            chart.getData().add(series4);
        }
        if(graph5.isSelected()){
            XYChart.Series series5 = new XYChart.Series();
            ObservableList<XYChart.Data> datas5 = FXCollections.observableArrayList();
            double[] x = {0,PI/2,PI,PI*3/2,PI*2,PI*5/2,PI*3,PI*7/2,PI*4};
            double[] y = {func.calculate(x[0]),func.calculate(x[1]),func.calculate(x[2]),func.calculate(x[3]),func.calculate(x[4]),func.calculate(x[5]),func.calculate(x[6]),func.calculate(x[7]),func.calculate(x[8])};
            Interpolate inter = new Interpolate();
            for(double i=0; i<13; i+=0.1){
                datas5.add(new XYChart.Data(i,inter.polinomValue(x.length-1,x,inter.computeCoef(x.length-1,x,y),i)));
            }
            series5.setData(datas5);
            chart.getData().add(series5);
        }
    }
}