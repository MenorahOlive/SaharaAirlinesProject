/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saharaairlines;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
/**
 *
 * @author User
 */
public class Flights extends Application {

    static Stage flightsStage = new Stage();
    private final TableView<Data> table = new TableView<>();
    private final ObservableList<Data> tvObservableList = FXCollections.observableArrayList(
            new Data("F24", "Nairobi", 1200, "02 Dec 2022", 0),
            new Data("D28", "Kisumu", 1300, "02 Dec 2022", 0),
            new Data("D29", "Mombasa", 0030, "02 Dec 2022", 2),
            new Data("D56", "Nakuru", 0730, "02 Dec 2022", 0),
            new Data("D79", "Eldoret", 1130, "02 Dec 2022", 0)
    );

    @Override
    public void start(Stage stage) {

        stage.setTitle("FLIGHT SCHEDULE");
        stage.setWidth(1000);
        stage.setHeight(600);

        setTableappearance();

        table.setItems(tvObservableList);

        TableColumn<Data, String> flightId = new TableColumn<>("Flight");
        flightId.setCellValueFactory(new PropertyValueFactory<>("flight"));

        TableColumn<Data, String> destination = new TableColumn<>("Destination");
        destination.setCellValueFactory(new PropertyValueFactory<>("destination1"));

        TableColumn<Data, String> time = new TableColumn<>("Time");
        time.setCellValueFactory(new PropertyValueFactory<>("time1"));

        TableColumn<Data, String> date = new TableColumn<>("Date");
        date.setCellValueFactory(new PropertyValueFactory<>("date1"));
        
        TableColumn<Data, String> seat = new TableColumn<>("Vacanct Seats");
        seat.setCellValueFactory(new PropertyValueFactory<>("seat1"));

        table.getColumns().addAll(flightId, destination, time, date, seat);
        
        //addButtonToTable();

        Text text1 = new Text("Pick a Flight");
        Button D29 = new Button("D29");
        Button D28 = new Button("D28");
        Button F24 = new Button("F24");
        Button D56 = new Button("D56");
        Button D79 = new Button("D79");
        
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1000,800);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        
        gridPane.add(table, 1, 1);
        gridPane.add(text1, 1, 2);
        /*gridPane.add(D29, 1, 3);
        gridPane.add(D28, 2, 3);
        gridPane.add(F24, 3, 3);
        gridPane.add(D56, 4, 3);
        gridPane.add(D79, 5, 3);*/
        HBox buttons = new HBox();
        buttons.setSpacing(10);
        buttons.getChildren().addAll(D29,D28,F24,D56,D79);
        gridPane.add(buttons, 1,3, 1,1);
        
                 D29.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                    FlightDetails fd = new FlightDetails();
                 try {            
                     fd.start(FlightDetails.flightDetailsStage);
                 } catch (Exception ex) {
                     Logger.getLogger(Flights.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
          }));
         
          D28.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                    Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Flight Vacancies Occupied");
                    al.show();         
             }
          }));
           F24.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                    Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Flight Vacancies Occupied");
                    al.show();          
             }
          }));
            D56.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                   Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Flight Vacancies Occupied");
                    al.show();          
             }
          }));
             D79.setOnMouseClicked((new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                    Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Flight Vacancies Occupied");
                    al.show();           
             }
          }));
       
        
        Scene scene = new Scene(gridPane);

        stage.setScene(scene);
        stage.show();

    }

    private void setTableappearance() {
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefWidth(600);
        table.setPrefHeight(400);
    }


    /*
    private void addButtonToTable() {
        TableColumn<Data, Void> colBtn = new TableColumn("Book Flight");

        Callback<TableColumn<Data, Void>, TableCell<Data, Void>> cellFactory = new Callback<TableColumn<Data, Void>, TableCell<Data, Void>>() {
            public TableCell<Data, Void> call(final TableColumn<Data, Void> param) {
                final TableCell<Data, Void> cell = new TableCell<Data, Void>() {

                    private final Button btn = new Button("Book");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Data data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data);

                            btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
                                public void handle(MouseEvent event) {
                                    Login login2 = new Login();
                                    try {
                                        login2.start(Login.loginStage);
                                    } catch (Exception ex) {
                                        Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }));

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);

        table.getColumns().add(colBtn);*/


    }