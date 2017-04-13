package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer2 on 4/9/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTest {


    @Autowired
    private MockMvc mvc;

    @Test
    public void getFlightsJSONTest() throws Exception {

        this.mvc.perform(
                get("/flights/flight")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"departs\":\"2017-04-21 02:34\",\"ticket\":{\"passengers\":[{\"firstName\":\"Will\",\"lastName\":\"Arthur\"}],\"price\":200.0}}]"));
    }

    @Test
    public void getMultipleFlightsJSONTest() throws Exception {

        this.mvc.perform(
                get("/flights")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"departs\":\"2017-04-21 02:34\",\"ticket\":{\"passengers\":[{\"firstName\":\"Will\",\"lastName\":\"Arthur\"}],\"price\":200.0}},{\"departs\":\"2017-04-21 02:34\",\"ticket\":{\"passengers\":[{\"firstName\":\"Kimi\",\"lastName\":\"Raikkonen\"}],\"price\":400.0}}]"));
    }
}

