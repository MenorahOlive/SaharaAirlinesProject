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
import java.sql.Statement;
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
public class Registration extends Application {

    static Stage registrationStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text firstName = new Text("First Name");
        TextField fnameField = new TextField();
        Text lastName = new Text("Last Name");
        TextField lnameField = new TextField();
        Text email = new Text("Email");
        TextField emailField = new TextField();
        Text phoneNo = new Text("Phone Number");
        TextField phoneNoField = new TextField();
        Text userName = new Text("User Name");
        TextField userNameField = new TextField();
        Text password = new Text("Password");
        PasswordField passwordField = new PasswordField();
        Button loginBtn = new Button("Login");
        Text alreadyRegistered = new Text("Already have an account?");
        Button registerBtn = new Button("Register");

        InputStream stream = new FileInputStream("C:\\Users\\olive\\Downloads\\airplane.png");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(700, 400);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(firstName, 1, 1);
        gridPane.add(fnameField, 2, 1);
        gridPane.add(lastName, 1, 2);
        gridPane.add(lnameField, 2, 2);
        gridPane.add(email, 1, 3);
        gridPane.add(emailField, 2, 3);
        gridPane.add(phoneNo, 1, 4);
        gridPane.add(phoneNoField, 2, 4);
        gridPane.add(userName, 1, 5);
        gridPane.add(userNameField, 2, 5);
        gridPane.add(password, 1, 6);
        gridPane.add(passwordField, 2, 6);
        gridPane.add(registerBtn, 2, 7);
        gridPane.add(alreadyRegistered, 3, 7);
        gridPane.add(loginBtn, 4, 7);
        gridPane.getChildren().add(imageView);

        primaryStage.setTitle("REGISTER");
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        registerBtn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                String firstNameField = fnameField.getText();
                String surName = lnameField.getText();
                String emailFld = emailField.getText();
                String telFld = phoneNoField.getText();
                String username = userNameField.getText();
                String passwrd = passwordField.getText();

                try {
                    //Step One - Register the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    //Step Two - Creating the connection
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/saharadb?", "root", "");

                    //Step Three - Create the statement object
                    Statement st = con.createStatement();

                    //Step Four
                    String query = "INSERT INTO users VALUES('" + firstNameField + "','" + surName + "','" + emailFld + "','" + telFld + "','" + username + "','" + passwrd + "')";
                    int rs = st.executeUpdate(query);

                    Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                    al.setContentText("Successful Registration");
                    al.show();

                    //Step five - Closing the connection
                    con.close();

                } catch (Exception ee) {
                    System.out.println(ee);
                    System.out.println("Connection error");
                }
                {
                }
            }
        }));
        
        loginBtn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Login login2 = new Login();
                try {
                    login2.start(Login.loginStage);
                } catch (Exception ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }));
        

    }

}
