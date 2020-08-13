package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import main.java.Client.Students;

import java.util.ResourceBundle;


public class Paint {

    private static Canvas canvas;
    static GraphicsContext context;

    public static void setCanvas(Canvas can) {
        canvas = can;
        context = canvas.getGraphicsContext2D();
    }

    public static void drawAxis() {
        context.setStroke(javafx.scene.paint.Color.BLACK);
        context.setLineWidth(2);
        double w = canvas.getWidth();
        double h = canvas.getHeight();
        context.strokeLine(w / 2, 0, w / 2, h);
        context.strokeLine(0, h / 2, w, h / 2);

        //y arrow
        context.strokeLine(w / 2, 0, w / 2 - 5, 5);
        context.strokeLine(w / 2, 0, w / 2 + 5, 5);
        //x arrow
        context.strokeLine(w, h / 2, w - 5, h / 2 + 5);
        context.strokeLine(w, h / 2, w - 5, h / 2 - 5);

        drawStepsX(50);
        drawStepsY(50);

    }

    public static void drawStepsX(int step) {
        double w = context.getCanvas().getWidth();
        double h = context.getCanvas().getHeight();

        for (int i = 0; i * step <= 350; i++) {
            int label = (i * step / 2);
            context.strokeLine(w / 2 + i * step, h / 2 - 5, w / 2 + i * step, h / 2 + 5);
            context.fillText(Integer.toString(label), w / 2 + i * step, h / 2 + 15);
            label = (-i * step / 2);
            context.strokeLine(w / 2 - i * step, h / 2 - 5, w / 2 - i * step, h / 2 + 5);
            context.fillText(Integer.toString(label), w / 2 - i * step, h / 2 + 15);
        }


    }

    public static void drawStepsY(int step) {
        double w = context.getCanvas().getWidth();
        double h = context.getCanvas().getHeight();

        for (int i = 1; i * step <= 350; i++) {
            int label = (-i * step / 2);
            context.strokeLine(w / 2 - 5, h / 2 + i * step, w / 2 + 5, h / 2 + i * step);
            context.fillText(Integer.toString(label), w / 2 + 15, h / 2 + i * step);
            label = (i * step / 2);
            context.strokeLine(w / 2 - 5, h / 2 - i * step, w / 2 + 5, h / 2 - i * step);
            context.fillText(Integer.toString(label), w / 2 + 15, h / 2 - i * step);
        }
    }

    public static void DrawElement(TableView<Students> table) {
        table.getItems().stream().forEach((element) -> {
            DrawCircle(element.getX(), element.getY(), element.getWeight(), element.getHeight(), element.getUserColor());
        });
    }

    public static void DrawCircle(String strX, String strY, String strWight, String strHeight, String color) {
        double wight = Double.parseDouble(strWight) / 2;
        double height = Double.parseDouble(strHeight) / 4;
        double x = Double.parseDouble(strX)*2;
        double y = Double.parseDouble(strY)*2;
        //double x = Double.parseDouble(strX)*2-wight/2;
        //double y = Double.parseDouble(strY)*2+height/2;

        //context.setFill(javafx.scene.paint.Paint.valueOf(color));
        //context.fillOval(context.getCanvas().getWidth() / 2 + x, context.getCanvas().getHeight() / 2 - y, wight, height);
        Circle circle=new Circle();
        circle.setFill(javafx.scene.paint.Paint.valueOf(color));
        circle.setCenterX(context.getCanvas().getWidth() / 2 + x);
        circle.setCenterY(context.getCanvas().getHeight() / 2 - y);
        circle.setRadius(height/wight);
        TranslateTransition tt = new TranslateTransition(Duration.millis(2000), circle);
        tt.setByX(200f);
        tt.setCycleCount((int) 4f);
        tt.setAutoReverse(true);
        tt.play();
    }
    public static void CheckFigure(double x,double y,TableView<Students> table){
        double finalX =(x-canvas.getWidth()/2)/2;
        double finalY=(-y+canvas.getHeight()/2)/2 ;
        System.out.println("координаты:"+ finalX+" "+finalY);
        table.getItems().stream().forEach(element->{
            double elementX= Double.parseDouble(element.getX());
            double elementY= Double.parseDouble(element.getY());
            double height= Double.parseDouble(element.getHeight())/4;
            double wight= Double.parseDouble(element.getWeight())/2;
            if ((((Math.pow(finalX-elementX,2)/Math.pow(wight/4,2))+((Math.pow(finalY-elementY,2))/Math.pow(height/4,2)))<=1)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("info");
                //alert.setHeaderText();
                alert.setContentText(element.getStudents(element));
                alert.showAndWait();
            }
        });
    }
}
