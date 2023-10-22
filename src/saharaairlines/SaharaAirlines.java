/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saharaairlines;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author olive
 */
public class SaharaAirlines extends Application {
    
    static Stage saharaAirlinesStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Text text = new Text("Welcome to Sahara Airlines!");
        Button login = new Button("Login");
        Button register = new Button("Register");

        InputStream stream = new FileInputStream("C:\\Users\\olive\\Downloads\\airplane.png");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600, 300);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);

        // gridPane.add(imageView,1 , 1);
        gridPane.add(text, 1, 2);
        gridPane.add(login, 1, 3);
        gridPane.add(register, 2, 3);
        gridPane.getChildren().add(imageView);

        login.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Login login = new Login();
                try {
                    login.start(Login.loginStage);
                } catch (Exception ex) {
                    Logger.getLogger(SaharaAirlines.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }));

        register.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 Registration registration = new Registration();
                try {
                    registration.start(Registration.registrationStage);
                } catch (Exception ex) {
                    Logger.getLogger(SaharaAirlines.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }));

        primaryStage.setTitle("HOME PAGE");
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
