package sample;
import GeneralTools.Information;
import javafx.scene.control.TableView;
import main.java.Client.Client;
import main.java.Client.Students;

public class SendCommand {
    static String password;
    static String login;
  static Information information=new Information();
  static Client client=new Client();
    public static void Autorizaton(String pass,String log){
        information.cmdtype="connect";
        information.regtype="aut";
        information.login=log;
        information.pass=pass;
        client.run(information);
        password=pass;
        login=log;
    }
    public static void Registration(String pass, String log){
        information.cmdtype="connect";
        information.regtype="reg";
        information.login=log;
        information.pass=pass;
        client.run(information);
        password=pass;
        login=log;
    }

    public static void help(){
        information.cmdtype = "help";
        information.login=login;
        information.pass=password;
        client.run(information);
    }
    public static void info(){
        information.cmdtype = "info";
        information.login=login;
        information.pass=password;
        client.run(information);
    }
    public static void show(TableView<Students> table){
        information.cmdtype="show";
        information.login=login;
        information.pass=password;
        client.run(information,table);
    }
}
