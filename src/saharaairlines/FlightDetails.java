/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saharaairlines;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author olive
 */
public class FlightDetails extends Application {
    
    static Stage flightDetailsStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        //To change body of generated methods, choose Tools | Templates.

        Text seatsAvailable = new Text("Seats Available");
        Button button1 = new Button("12");
        Button button2 = new Button("13");

        Text classType = new Text("Travel Class");
        Button button3 = new Button("first class");
        Button button4 = new Button("business");
        Button button5 = new Button("economy");
        
        Text seat =new Text("Seat Choice");
        Text seatChoice =new Text("***");
        Text travelClass =new Text("Travel Class");
        Text travelClassChoice =new Text("***");
        
        Button button6 = new Button("Proceed");
        
       
        
        InputStream stream = new FileInputStream("C:\\Users\\olive\\Downloads\\airplane.png");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        
        button1.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                   Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Already Booked");
                    al.show();
             }
          }));
        button2.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                   seatChoice.setText("13");
             }
          }));
        button3.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                   Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Seat #13 not compatible");
                    al.show();
             }
          }));
        button4.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                    Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Seat #13 not compatible");
                    al.show();
             }
          }));
        button5.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                   travelClassChoice.setText("economy");
             }
          }));
        button6.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                   GrandTotal gt = new GrandTotal();
                 try {  
                     gt.start(GrandTotal.grandTotalStage);
                 } catch (Exception ex) {
                     Logger.getLogger(FlightDetails.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
          }));

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(700, 400);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        
         HBox seatNo = new HBox();
        seatNo.setSpacing(10);
        seatNo.getChildren().addAll(button1, button2);
        gridPane.add(seatNo, 1,2, 1,1);
        
        HBox seatSelect = new HBox();
        seatSelect.setSpacing(10);
        seatSelect.getChildren().addAll(button3, button4, button5);
        gridPane.add(seatSelect, 1,5, 1,1);

        gridPane.add(seatsAvailable, 1, 1);
        //gridPane.add(button1, 1, 2);
        //gridPane.add(button2, 2, 2);
        gridPane.add(classType, 1, 4);
        //gridPane.add(button3, 1, 4);
        //gridPane.add(button4, 2, 4);
        //gridPane.add(button5, 3, 4);
        gridPane.add(seat, 1, 8);
        gridPane.add(seatChoice, 2, 8);
        gridPane.add(travelClass, 1, 10);
        gridPane.add(travelClassChoice, 2, 10);
        gridPane.add(button6, 1, 11);
        gridPane.getChildren().add(imageView);

        primaryStage.setTitle("Flight D29");
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
