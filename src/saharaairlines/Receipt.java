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
public class Receipt extends Application {
    
    static Stage receiptStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
       Text text1 = new Text("FLIGHT:   **********  #D29");
       Text text2 = new Text("Route:    **********  Nairobi-Mombasa");
       Text seat = new Text("Seat:  **********  #13");
       Text classType = new Text("Class:    **********  Economy Class");
       Text time = new Text("Time:  **********  0030h");
       Text  date= new Text("Date:  **********  02-DEC-22");
       
       Text total = new Text("Total:    **********  $440");
       
       Button logout = new Button("Logout");
       
       InputStream stream = new FileInputStream("C:\\Users\\olive\\Downloads\\airplane.png");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
       
       logout.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                   SaharaAirlines sg = new SaharaAirlines();
                 try {  
                     sg.start(SaharaAirlines.saharaAirlinesStage);
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
          }));
       
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(700, 400);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
       
        gridPane.add(text1, 1, 1);
        gridPane.add(text2, 1, 2);
        gridPane.add(seat, 1, 3);
        gridPane.add(classType, 1, 4);
        gridPane.add(time, 1, 5);
        gridPane.add(date, 1, 6);
        gridPane.add(total, 1, 7);
        gridPane.add(logout, 1, 9);
        
        gridPane.getChildren().add(imageView);
        
        primaryStage.setTitle("RECEIPT");
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

       
    }
    
}
