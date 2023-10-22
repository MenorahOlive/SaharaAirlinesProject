/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saharaairlines;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author User
 */
public class Data {
    
        private final SimpleStringProperty flight;
        private final SimpleStringProperty destination1;
        private final SimpleIntegerProperty time1;
        private final SimpleStringProperty date1;
        private final SimpleIntegerProperty seat1;

        Data(String Flight, String location, int tme, String dte, int ste) {
            this.flight = new SimpleStringProperty(Flight);
            this.destination1 = new SimpleStringProperty(location);
            this.time1 = new SimpleIntegerProperty(tme);
            this.date1 = new SimpleStringProperty(dte);
            this.seat1 = new SimpleIntegerProperty(ste);
            
        }


        public String getFlight() {
            return flight.get();
        }

        public void setFlight(String Flight) {
            flight.set(Flight);
        }

        public String getDestination1() {
            return destination1.get();
        }

        public void setDestination1(String location) {
            destination1.set(location);
        }
        
        public int getTime1() {
            return time1.get();
        }

        public void setTime1(int tme) {
            time1.set(tme);
        }
        public String getDate1() {
            return date1.get();
        }

        public void setDate1(String dte) {
            date1.set(dte);
        }
         public int getSeat1() {
            return seat1.get();
        }

        public void setSeat1(int ste) {
            seat1.set(ste);
        }
        
        @Override
        public String toString() {
            return "flight: " + flight + " - " + "destination: " + destination1 + " - " + "time: " + time1 + " - " + "date: " + date1 + " - " + "seat: " + seat1 + " - "  ;
        }

}