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
public class GrandTotal extends Application{
    
    static Stage grandTotalStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text text1 = new Text("FLIGHT #D29");
        Text text2 = new Text("Nairobi-Mombasa");
        
        Text text3 = new Text("Cost:    **********  $400");
        Text text5= new Text("Tax Rate: ******  10%");
        
        Text text6 = new Text("Click to display total amount") ;
        Button calculateRate = new Button("Calculate") ;
        
        Text text7 = new Text("Total:   **************      $");
        Text text8 = new Text("***");
        
        Button payment = new Button("Proceed to Checkout");
        
        InputStream stream = new FileInputStream("C:\\Users\\olive\\Downloads\\airplane.png");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        
        calculateRate.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                   
                   double rate = (400*10)/100;
                   double total =(400 + rate );
                   text8.setText(Double.toString(total));
             }
          }));
        
        payment.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                   Payment sg = new Payment();
                 try {
                     sg.start(Payment.paymentStage);
                 } catch (Exception ex) {
                     Logger.getLogger(GrandTotal.class.getName()).log(Level.SEVERE, null, ex);
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
        gridPane.add(text3, 1, 4);
     
        gridPane.add(text5, 1, 5);
        gridPane.add(text6, 1, 7);
        gridPane.add(calculateRate, 2, 7);
        gridPane.add(text7, 1, 9);
        gridPane.add(text8, 2, 9);
        gridPane.add(payment, 1, 11);
        gridPane.getChildren().add(imageView);
        
        primaryStage.setTitle("COST CHARGES");
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
   
    
    
    }
    
}
