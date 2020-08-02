package main.java.Client;

import GeneralTools.Answer;

import javafx.scene.control.TableView;
import sample.WorkController;
import sample.tools.MessageAlert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnswerHandling {
    public static void CheckCmd(Answer answer) {
        String cmd = answer.cmd;
        try {
            if (cmd.equalsIgnoreCase("help")) {
                MessageAlert.showMessage(answer.answer);
            }
            if (cmd.equalsIgnoreCase("info")) {
                MessageAlert.showMessage(answer.answer);
            }

            if (cmd.equalsIgnoreCase("add")) {

            }
            if (cmd.equalsIgnoreCase("update")) {
                MessageAlert.showMessage(answer.answer);
            }
            if (cmd.equalsIgnoreCase("remove_by_id")) {
                MessageAlert.showMessage(answer.answer);
            }
            if (cmd.equalsIgnoreCase("clear")) {

            }
            if (cmd.equalsIgnoreCase("head")) {
                MessageAlert.showMessage("Верхний элемент таблицы:" + answer.answer);
            }
            if (cmd.equalsIgnoreCase("remove_head")) {

            }
            if (cmd.equalsIgnoreCase("remove_lower")) {

            }
            if (cmd.equalsIgnoreCase("remove_any_by_form_of_education")) {

            }
            if (cmd.equalsIgnoreCase("filter_starts_with_name")) {
                MessageAlert.showMessage("Полученыне элементы:"+answer.answer);
            }
            if (cmd.equalsIgnoreCase("filter_greater_than_students_count")) {
                MessageAlert.showMessage("Полученыне элементы:"+answer.answer);
            }
        } catch (NullPointerException e) {
        }
    }

    public static void CheckCmd(Answer answer, TableView<Students> table) {
        String cmd = answer.cmd;
        if (cmd.equalsIgnoreCase("show")) {
            WorkController workController = new WorkController();
            workController.FillTable(answer.list, table);
        }
    }
}

