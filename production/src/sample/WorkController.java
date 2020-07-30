package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import main.java.Client.Students;


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
    void initialize() {
        CanvasWork();
        columnSettings();
        help.setOnAction(event -> {
            SendCommand.help();
        });
        info.setOnAction(event -> {
            SendCommand.info();
        });
        show.setOnAction(event -> {
            SendCommand.show(table);
        });

    }

    //todo
    public void FillTable(String[] string, TableView<Students> table) {
        System.out.println(table);
        table.setItems(getStudents(string));
    }

    public static ObservableList<Students> getStudents(String[] str) {
        ObservableList<Students> students = FXCollections.observableArrayList();
        students.add(new Students(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7],
                str[8], str[9], str[10], str[11]));
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
        eye_color_column.setCellValueFactory(new PropertyValueFactory<>("eye_color"));
        x_column.setCellValueFactory(new PropertyValueFactory<>("x"));
        y_column.setCellValueFactory(new PropertyValueFactory<>("y"));
    }

    public void CanvasWork(){

        GraphicsContext context=canvas.getGraphicsContext2D();
        context.setFill(Color.BLACK);

    }

}
