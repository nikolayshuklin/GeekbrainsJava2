package Lesson4;

import javafx.*;
import java.awt.*;
import java.sql.SQLOutput;

public class Main<Stage> extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent Root = FXMLLoader.load(getClass().getResourse("./sample.fxml"));
        primaryStage.setTitle("Hello world");
        primaryStage.setScene(new Scene(root, 300, 275 ));
        primaryStage.show;

    }

    public static void main(String[] args) {
        launch(args);
    }
}
