package com.example;

import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by trainer2 on 4/8/17.
 */

@RestController
public class FlightController {

    @GetMapping("/flights/flight")
    public @ResponseBody
    List<Flights> getFlightsJSON() throws ParseException {
        Flights flight1 = new Flights();
        Flights.Tickets tickets = new Flights.Tickets();
        List<Flights.Person> personList = new ArrayList<Flights.Person>();
        Flights.Person person1 = new Flights.Person();

        person1.setFirstName("Will");
        person1.setLastName("Arthur");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = df.parse("2017-04-21 14:34");

        flight1.setDeparts(date);
        personList.add(person1);
        tickets.setPassengers(personList);
        tickets.setPrice(200);
        flight1.setTicket(tickets);
        return Arrays.asList(flight1);
    }

    @GetMapping("/flights")
    public @ResponseBody
    List<Flights> getMultipleFlightsJSON() throws ParseException {
        Flights flight1 = new Flights();
        Flights flight2 = new Flights();
        Flights.Tickets tickets1 = new Flights.Tickets();
        Flights.Tickets tickets2 = new Flights.Tickets();
        List<Flights.Person> personList1 = new ArrayList<Flights.Person>();
        List<Flights.Person> personList2 = new ArrayList<Flights.Person>();
        Flights.Person person1 = new Flights.Person();
        Flights.Person person2 = new Flights.Person();

        person1.setFirstName("Will");
        person1.setLastName("Arthur");

        person2.setFirstName("Kimi");
        person2.setLastName("Raikkonen");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = df.parse("2017-04-21 14:34");

        flight1.setDeparts(date);
        flight2.setDeparts(date);
        personList1.add(person1);
        personList2.add(person2);
        tickets1.setPassengers(personList1);
        tickets2.setPassengers(personList2);
        tickets1.setPrice(200);
        tickets2.setPrice(400);
        flight1.setTicket(tickets1);
        flight2.setTicket(tickets2);



        return Arrays.asList(flight1,flight2);

    }




}