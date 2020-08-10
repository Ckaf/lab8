package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;
import main.java.Client.Students;
import sample.Paint;

import java.awt.*;
import java.util.LinkedList;

import static sample.Paint.CheckFigure;
import static sample.SendCommand.getColor;
import static sample.SendCommand.login;


public class WorkController {
    @FXML
    private Button help;

    @FXML
    private Button show;

    @FXML
    private Button info;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button remove_by_id;

    @FXML
    private Button clear;

    @FXML
    private Button head;

    @FXML
    private Button remove_head;

    @FXML
    private Button remove_lower;

    @FXML
    private Button remove_any_by_form_education;

    @FXML
    private Button filter_strats_with_name;

    @FXML
    private Button filter_greater_than_students_count;

    @FXML
    private Button exit;

    @FXML
    public TableView<Students> table;

    @FXML
    public TableColumn<Students, String> id_column;

    @FXML
    public TableColumn<Students, String> name_column;

    @FXML
    public TableColumn<Students, String> count_column;

    @FXML
    public TableColumn<Students, String> exp_column;

    @FXML
    public TableColumn<Students, String> form_column;

    @FXML
    public TableColumn<Students, String> semester_column;

    @FXML
    public TableColumn<Students, String> admin_name_column;

    @FXML
    public TableColumn<Students, String> height_column;

    @FXML
    public TableColumn<Students, String> weight_column;

    @FXML
    public TableColumn<Students, String> eye_color_column;

    @FXML
    public TableColumn<Students, String> x_column;

    @FXML
    public TableColumn<Students, String> y_column;

    @FXML
    private Canvas canvas;

    @FXML
    private Label UserLabel;

    @FXML
    private Rectangle ColorRect;

    @FXML
    private TableColumn<Students, String> login_column;

    @FXML
    void initialize() {
        UserLabel.setText(login);
        Runnable task=()->{
            Synchronization.synchronization(table);
        };
        Thread thread=new Thread(task);
        thread.start();

        getColor(ColorRect);
        CanvasWork();
        canvas.setOnMouseClicked(event -> {
            double x=event.getX();
            double y=event.getY();
            CheckFigure(x,y,table);
        });
        columnSettings();

        UserLabel.setText(login);
        help.setOnAction(event -> {
            SendCommand.help();
        });
        info.setOnAction(event -> {
            SendCommand.info();
        });
        show.setOnAction(event -> {
            SendCommand.show(table);
        });
        add.setOnAction(event -> {
            SendCommand.add(table);
        });
        update.setOnAction(event -> {
        SendCommand.update(table);
        });
        remove_by_id.setOnAction(event -> {
            SendCommand.remove_by_id(table);
        });
        clear.setOnAction(event -> {
            SendCommand.clear(table);
        });
        head.setOnAction(event -> {
            SendCommand.head();
        });
        remove_head.setOnAction(event -> {
            SendCommand.remove_head(table);
        });
        remove_lower.setOnAction(event -> {
            SendCommand.remove_lower(table);
        });
        remove_any_by_form_education.setOnAction(event -> {
            SendCommand.remove_any_by_form_education(table);
        });
        filter_strats_with_name.setOnAction(event -> {
            SendCommand.filter_strats_with_name(table);
        });
        filter_greater_than_students_count.setOnAction(event -> {
            SendCommand.filter_greater_than_students_count(table);
        });
        exit.setOnAction(event -> {
            System.exit(0);
        });
    }


    public void FillTable(LinkedList list, TableView<Students> table) {
        table.setItems(getStudents(list));
        Paint.DrawElement(table);
    }

    public static ObservableList<Students> getStudents(LinkedList<String> list) {
        ObservableList<Students> students = FXCollections.observableArrayList();
        list.stream().forEach(element -> {
            String[] str = element.split(",");
            students.add(new Students(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7],
                    str[8], str[9], str[10], str[11],str[12],str[13]));
        });

        return students;
    }

    public void columnSettings() {
        id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        count_column.setCellValueFactory(new PropertyValueFactory<>("count"));
        exp_column.setCellValueFactory(new PropertyValueFactory<>("exp"));
        form_column.setCellValueFactory(new PropertyValueFactory<>("form"));
        semester_column.setCellValueFactory(new PropertyValueFactory<>("semester"));
        admin_name_column.setCellValueFactory(new PropertyValueFactory<>("admin_name"));
        height_column.setCellValueFactory(new PropertyValueFactory<>("height"));
        weight_column.setCellValueFactory(new PropertyValueFactory<>("weight"));
        eye_color_column.setCellValueFactory(new PropertyValueFactory<>("eyeColor"));
        x_column.setCellValueFactory(new PropertyValueFactory<>("x"));
        y_column.setCellValueFactory(new PropertyValueFactory<>("y"));
        login_column.setCellValueFactory(new PropertyValueFactory<>("User"));
    }

    public void CanvasWork() {
        Paint.setCanvas(canvas);
        Paint.drawAxis();
    }

    public void setColor(String color,Rectangle ColorRect){
    ColorRect.setFill(javafx.scene.paint.Paint.valueOf(color));
    }
}
