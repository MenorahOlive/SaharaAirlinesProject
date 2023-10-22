/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saharaairlines;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class Login extends Application {

    static Stage loginStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text userName = new Text("Username");
        TextField userNameField = new TextField();
        Text pass = new Text("Password");
        PasswordField passwordFld = new PasswordField();
        Button loginBtn = new Button("Login");

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

        gridPane.add(userName, 1, 1);
        gridPane.add(userNameField, 2, 1);
        gridPane.add(pass, 1, 2);
        gridPane.add(passwordFld, 2, 2);
        gridPane.add(loginBtn, 2, 3);
        gridPane.getChildren().add(imageView);

        primaryStage.setTitle("LOGIN");
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        loginBtn.setOnMouseClicked((new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent event) {
             
                String username = userNameField.getText();
                String passwrd = passwordFld.getText();
             
             
             try
             {
                 //Step One - Register the driver
                Class.forName("com.mysql.cj.jdbc.Driver");
               
                //Step Two - Creating the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/saharadb?","root","");
               
                //Step Three - Create the statement object
                Statement st= con.createStatement();                
               
                //Step Four
                String query = "SELECT * FROM saharadb.users Where username = '"+username+"' AND passwrd = '"+passwrd+"' ";
                //step five- execute query
                ResultSet rs = st.executeQuery(query);
               
                if(rs.next())
                {
                    //successful login opens to home page
                    Flights flight =new Flights();
                    flight.start(Flights.flightsStage);
                }
               
                else
                {
                    Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Invalid Credentials");
                    al.show();
               
                }
               
                //Step five - Closing the connection
                con.close();
             
             }
            catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
            {
            }
         }
        }));

    }

}
