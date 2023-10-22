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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
public class Payment extends Application {
    
    static Stage paymentStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text visa = new Text("Pay via Visa");
        Text creditCard = new Text("Card Number");
        TextField cardNo = new TextField();
        Text securityCode = new Text("Security code(***)");
        PasswordField svcCode = new PasswordField();
        Button confirm = new Button("Confirm");
        Button viewReceipt = new Button("View Receipt");
        
        InputStream stream = new FileInputStream("C:\\Users\\olive\\Downloads\\airplane.png");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);

        confirm.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                   Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                    al.setContentText("Successful Transaction");
                    al.show(); 
             }
          }));
        
         viewReceipt.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                   Receipt sg = new Receipt();
                 try { 
                     sg.start(Receipt.receiptStage);
                 } catch (Exception ex) {
                     Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
          }));
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(700, 400);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(visa, 1, 1);
        gridPane.add(creditCard, 1, 2);
        gridPane.add(cardNo, 2, 2);
        gridPane.add(securityCode, 1, 3);
        gridPane.add(svcCode, 2, 3);
        gridPane.add(confirm, 1, 4);
        gridPane.add(viewReceipt, 2, 4);
        gridPane.getChildren().add(imageView);
        
        primaryStage.setTitle("CHECKOUT");
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
