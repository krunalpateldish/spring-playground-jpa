package com.example;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
/**
 * Created by trainer2 on 4/8/17.
 */
public class Flights {


    private Date departs;
    private Tickets ticket;
    //private List<Tickets> tickets;

  @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm", timezone="America/Denver")
    public Date getDeparts() { return departs; }

    public void setDeparts(Date dateTime) { this.departs = dateTime; }

    public Tickets getTicket() {
        return ticket;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }


    static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() { return firstName; }

        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }

        public void setLastName(String lastName) { this.lastName = lastName; }
    }
    static class Tickets {
        private List<Person> passengers;
        private double price;

        public List<Person> getPassengers() { return passengers; }

        public void setPassengers(List<Person> passengers) { this.passengers = passengers; }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

    }

}
